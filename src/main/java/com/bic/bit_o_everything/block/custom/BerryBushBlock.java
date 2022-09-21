package com.bic.bit_o_everything.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class BerryBushBlock extends Block implements BonemealableBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static final BooleanProperty WAXED = BlockStateProperties.LOCKED;
    public Supplier<ItemLike> plant;
    
    public BerryBushBlock(Properties properties, Supplier<ItemLike> drop) {
        super(properties);
        this.plant = drop;
        this.registerDefaultState(this.stateDefinition.any().setValue(this.getAgeProperty(), 0).setValue(this.getWaxedProperty(), false));
    }
    
    public IntegerProperty getAgeProperty() {
        return AGE;
    }
    
    public BooleanProperty getWaxedProperty() {
        return WAXED;
    }
    
    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return ! getWaxed(blockState);
    }
    
    public boolean getWaxed(BlockState blockState) {
        return blockState.getValue(this.getWaxedProperty());
    }
    
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(AGE);
        blockBlockStateBuilder.add(WAXED);
    }
    
    public int growChance(BlockState blockState) {
        int age = this.getAge(blockState);
        int slow = 40;
        int medium = 30;
        int fast = 20;
        return switch (age) {
            case 0, 4 -> medium;
            case 1, 2 -> slow;
            default -> fast;
        };
        
    }
    
    public boolean shouldGrow(BlockState blockState, RandomSource randomSource) {
        return randomSource.nextInt(this.growChance(blockState)) == 0;
    }
    
    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        // If [waxed or (has bonemeal and is bonemealable)] : return PASS - this will skip if waxed, or bonemeal if has bonemeal
        if (this.getWaxed(blockState) || (player.getItemInHand(interactionHand).is(Items.BONE_MEAL) && this.isValidBonemealTarget(level, blockPos, blockState, level.isClientSide()))) {
            return InteractionResult.PASS;
        }
        
        BlockState newState;
        if (player.getItemInHand(interactionHand).is(Items.HONEYCOMB)) {
            player.getItemInHand(interactionHand).shrink(1);
            newState = this.setWaxed(blockState);
        } else {
            int age = this.getAge(blockState);
            switch (age) {
                case 0:
                    return InteractionResult.PASS;
                case 1, 3:
                    this.createDrops(level, blockPos, 1 + (level.getRandom().nextDouble() <= 0.25D ? 1 : 0)); // 1 + 25% 1
                    break;
                case 2:
                    this.createDrops(level, blockPos, 2 + (level.getRandom().nextDouble() <= 0.70D ? 1 : 0)); // 2 + 70% 1
                    break;
            }
            newState = this.resetAge(blockState);
        }
        level.setBlock(blockPos, newState, 2);
        level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(player, newState));
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
    
    @Override
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource randomSource) {
        if (! level.isAreaLoaded(blockPos, 1))
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (shouldGrow(blockState, randomSource)) {
            BlockState newState = this.increaseAge(blockState);
            level.setBlock(blockPos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(newState));
        }
    }
    
    public void createDrops(Level level, BlockPos blockPos, int quantity) {
        level.playSound(null, blockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
        popResource(level, blockPos, new ItemStack(this.getDrop(), quantity));
    }
    
    public Item getDrop() {
        return this.plant.get().asItem();
    }
    
    public int getMaxAge() {
        return MAX_AGE;
    }
    
    public BlockState resetAge(BlockState pState) {
        return this.setAge(pState, 0);
    }
    
    public BlockState setAge(BlockState blockState, int age) {
        return blockState.setValue(this.getAgeProperty(), age);
    }
    
    public BlockState increaseAge(BlockState blockState) {
        if (this.getAge(blockState) >= this.getMaxAge()) {
            return this.resetAge(blockState);
        } else {
            return this.setAge(blockState, this.getAge(blockState) + 1);
        }
    }
    
    public BlockState setWaxed(BlockState blockState) {
        return blockState.setValue(this.getWaxedProperty(), true);
    }
    
    protected int getAge(BlockState blockState) {
        return blockState.getValue(this.getAgeProperty());
    }
    
    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, boolean pIsClient) {
        return ! (this.getAge(blockState) == 2 || this.getWaxed(blockState));
    }
    
    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }
    
    @Override
    public void performBonemeal(ServerLevel level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        level.setBlock(blockPos, this.increaseAge(blockState), 2);
    }
    
    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }
    
    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }
    
    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }
}
