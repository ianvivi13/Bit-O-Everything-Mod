package com.bic.bit_o_everything.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.ticks.TickPriority;

public class LogicGateBlock extends DiodeBlock {
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");
    public static final BooleanProperty BACK = BooleanProperty.create("back");

    protected LogicGateBlock(Properties p_52499_) {
        super(p_52499_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LEFT, Boolean.valueOf(false)).setValue(RIGHT, Boolean.valueOf(false)).setValue(BACK, Boolean.valueOf(false)).setValue(POWERED, Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LEFT, RIGHT, BACK, POWERED);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandomSource) {
        boolean flag = pState.getValue(POWERED);
        boolean flag1 = this.shouldTurnOn(pLevel, pPos, pState);
        boolean flag2 = this.isLeftPowered(pLevel, pPos, pState);
        boolean flag3 = pState.getValue(RIGHT);
        boolean flag4 = pState.getValue(BACK);
        if (flag && !flag1) {
            pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.FALSE), 2);
        } else if (!flag) {
            pLevel.setBlock(pPos, pState.setValue(POWERED, Boolean.TRUE), 2);
            if (!flag1) {
                pLevel.scheduleTick(pPos, this, this.getDelay(pState), TickPriority.VERY_HIGH);
            }
        }

        if (flag2) {
            pLevel.setBlock(pPos, pState.setValue(LEFT, Boolean.TRUE), 2);
        } else {
            pLevel.setBlock(pPos, pState.setValue(LEFT, Boolean.FALSE), 2);
        }
        if (flag3) {
            pLevel.setBlock(pPos, pState.setValue(RIGHT, Boolean.TRUE), 2);
        } else {
            pLevel.setBlock(pPos, pState.setValue(LEFT, Boolean.FALSE), 2);
        }
        if (flag4) {
            pLevel.setBlock(pPos, pState.setValue(BACK, Boolean.TRUE), 2);
        } else {
            pLevel.setBlock(pPos, pState.setValue(LEFT, Boolean.FALSE), 2);
        }
    }

    public boolean isLeftPowered(Level pLevel, BlockPos pPos, BlockState pState) {
        if(getAlternateSignal(pLevel, pPos, pState)) {

        }
    }

    @Override
    protected int getDelay(BlockState pState) {
        return 0;
    }
}
