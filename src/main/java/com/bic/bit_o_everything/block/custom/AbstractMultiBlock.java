package com.bic.bit_o_everything.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;

public class AbstractMultiBlock extends Block {

    private final Supplier<BlockPattern> blockPattern;
    private boolean isActivated;

    public AbstractMultiBlock(BlockBehaviour.Properties properties, Supplier<BlockPattern> blockPattern) {
        super(properties);
        this.blockPattern = blockPattern;
        isActivated = false;
    }

    public BlockPattern getBlockPattern() {
        return this.blockPattern.get();
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getBlockPattern().find(pLevel, pPos);
        if(!isActivated) {
            if (!pLevel.isClientSide && itemStack.is(Items.WOODEN_HOE)) {
                Block block = pLevel.getBlockState(pPos).getBlock();
                if (blockPatternMatch != null && block.equals(blockPatternMatch.getBlock(0, 0, 0).getState().getBlock())) {
                    tryBuildBlock(pLevel, pPos);
                }
            }
        }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    public void tryBuildBlock(Level pLevel, BlockPos pPos) {
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getBlockPattern().find(pLevel, pPos);
        if(blockPatternMatch != null) {
            isActivated = true;
            System.out.println("activated");
        }
    }

    public void deactivate(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        System.out.println("deactivated");
        BlockPattern.BlockPatternMatch blockPatternMatch = this.getBlockPattern().find(level, pos);
        if(isActivated && blockPatternMatch == null) {
            isActivated = false;

        }
    }
}
