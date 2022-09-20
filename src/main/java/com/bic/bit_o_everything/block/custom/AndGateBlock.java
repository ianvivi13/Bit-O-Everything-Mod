package com.bic.bit_o_everything.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class AndGateBlock extends LogicGateBlock {

    protected AndGateBlock(Properties p_52499_) {
        super(p_52499_);
    }

    @Override
    protected boolean shouldTurnOn(Level pLevel, BlockPos pPos, BlockState pState) {
        return super.shouldTurnOn(pLevel, pPos, pState);
    }
}
