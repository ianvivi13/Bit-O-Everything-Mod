package com.bic.bit_o_everything.block.custom;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TreeTapBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final IntegerProperty SYRUP_LEVEL = BlockStateProperties.AGE_2;
    
    private static final VoxelShape NORTH_AABB = Block.box(6,6,12,10,13,16);
    private static final VoxelShape EAST_AABB = Block.box(0,6,6,4,13,10);
    private static final VoxelShape SOUTH_AABB = Block.box(6,6,0,10,13,4);
    private static final VoxelShape WEST_AABB = Block.box(12,6,6,16,13,10);
    
    // TODO : replace cherry with maple
    
    public TreeTapBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SYRUP_LEVEL, 0).setValue(FACING, Direction.NORTH));
    }
    
    @Override
    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return true;
    }
    
    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (this.getAge(blockState) >= 2 && randomSource.nextDouble() < 0.05) {
            this.spawnParticle(level, blockPos, blockState.getCollisionShape(level, blockPos), blockPos.getY() + 4/16D);
        }
    }

    private void spawnParticle(Level pLevel, BlockPos pPos, VoxelShape pShape, double pY) {
        this.spawnFluidParticle(pLevel, (double)pPos.getX() + pShape.min(Direction.Axis.X), (double)pPos.getX() + pShape.max(Direction.Axis.X), (double)pPos.getZ() + pShape.min(Direction.Axis.Z), (double)pPos.getZ() + pShape.max(Direction.Axis.Z), pY);
    }

    private void spawnFluidParticle(Level pParticleData, double pX1, double pX2, double pZ1, double pZ2, double pY) {
        pParticleData.addParticle(ParticleTypes.DRIPPING_HONEY, Mth.lerp(pParticleData.random.nextDouble(), pX1, pX2), pY, Mth.lerp(pParticleData.random.nextDouble(), pZ1, pZ2), 0.0D, -0.3D, 0.0D);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.is(Items.GLASS_BOTTLE) && this.getAge(pState) >= 2) {
            itemstack.shrink(1);
            pLevel.playSound(pPlayer, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            if (itemstack.isEmpty()) {
                pPlayer.setItemInHand(pHand, new ItemStack(ModItems.SAP_BOTTLE.get()));
            } else if (!pPlayer.getInventory().add(new ItemStack(ModItems.SAP_BOTTLE.get()))) {
                pPlayer.drop(new ItemStack(ModItems.SAP_BOTTLE.get()), false);
            }

            BlockState newState = this.resetAge(pState);
            pLevel.setBlock(pPos, newState, 2);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, newState));
            
            pLevel.gameEvent(pPlayer, GameEvent.FLUID_PICKUP, pPos);
            
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }
    
    
    public BlockState resetAge(BlockState pState) {
        return this.setAge(pState, 0);
    }
    
    public BlockState setAge(BlockState blockState, int age) {
        return blockState.setValue(SYRUP_LEVEL, age);
    }
    
    public BlockState increaseAge(BlockState blockState) {
        if (this.getAge(blockState) >= 2) {
            return blockState;
        } else {
            return this.setAge(blockState, this.getAge(blockState) + 1);
        }
    }
    
    public boolean isOnValidBlock(BlockState blockState, BlockPos blockPos, ServerLevel level) {
        Direction direction = blockState.getValue(FACING);
        BlockPos blockpos = blockPos.relative(direction.getOpposite());
        Block blockOn = level.getBlockState(blockpos).getBlock();
        return (blockOn == ModBlocks.MAPLE_LOG.get() || blockOn == ModBlocks.STRIPPED_MAPLE_LOG.get());
    }
    
    @Override
    public void randomTick(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextDouble() <= 0.04 && this.isOnValidBlock(blockState, blockPos, level)) {
            BlockState newState = this.increaseAge(blockState);
            level.setBlock(blockPos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(newState));
        }
    }
    
    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return this.getAge(pState) < 2;
    }
    
    
    @Override
    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        Direction direction = p_154346_.getValue(FACING);
        return switch (direction) {
            case SOUTH -> SOUTH_AABB;
            case EAST -> EAST_AABB;
            case WEST -> WEST_AABB;
            default -> NORTH_AABB;
        };
    }
    
    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockPos blockpos = pPos.relative(direction.getOpposite());
        return pLevel.getBlockState(blockpos).isFaceSturdy(pLevel, blockpos, direction);
    }
    
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }
    
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SYRUP_LEVEL, FACING);
    }
    
    protected int getAge(BlockState blockState) {
        return blockState.getValue(SYRUP_LEVEL);
    }
    
    
}
