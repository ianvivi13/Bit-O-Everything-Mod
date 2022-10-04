package com.bic.bit_o_everything.block.custom.gates;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class NotGateBlock extends OneInputGateBlock {

    public NotGateBlock(Properties p_52499_) {
        super(p_52499_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(POWERED, true));
    }

    @Override
    protected boolean shouldTurnOn(Level pLevel, BlockPos pPos, BlockState pState) {
        return !(getInputSignal(pLevel, pPos, pState) > 0);
    }
}
