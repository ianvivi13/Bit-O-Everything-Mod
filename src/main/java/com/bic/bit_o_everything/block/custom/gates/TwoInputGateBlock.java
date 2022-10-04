package com.bic.bit_o_everything.block.custom.gates;

import com.bic.bit_o_everything.block.ModBlocks;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;
import java.util.function.BiFunction;

public class TwoInputGateBlock extends DiodeBlock {
    public static final BooleanProperty LEFT = BooleanProperty.create("left");
    public static final BooleanProperty RIGHT = BooleanProperty.create("right");

    private final BiFunction<Boolean, Boolean, Boolean> gateFunction;

    public static final BiFunction<Boolean, Boolean, Boolean> AND = (x, y) -> x && y;
    public static final BiFunction<Boolean, Boolean, Boolean> NAND = (x, y) -> !(x && y);
    public static final BiFunction<Boolean, Boolean, Boolean> OR = (x, y) -> x || y;
    public static final BiFunction<Boolean, Boolean, Boolean> NOR = (x, y) -> !(x || y);

    public TwoInputGateBlock(Properties p_52499_, BiFunction<Boolean, Boolean, Boolean> gateFunction) {
        super(p_52499_);
        this.gateFunction = gateFunction;
        boolean powerVal;
        powerVal = gateFunction != AND && gateFunction != OR;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LEFT, false).setValue(RIGHT, false).setValue(POWERED, powerVal));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, LEFT, RIGHT, POWERED);
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, @Nullable Direction side) {
        return side == state.getValue(FACING) || side == state.getValue(FACING).getClockWise() || side == state.getValue(FACING).getCounterClockWise();
    }

    public void setProperty(Level pLevel, BlockPos pPos, BlockState pState, BooleanProperty pProp, boolean pBool) {
        pLevel.setBlock(pPos, pState.setValue(pProp, pBool), 3);
    }

    @Override
    protected boolean shouldTurnOn(Level pLevel, BlockPos pPos, BlockState pState) {
        return(gateFunction.apply(isLeftPowered(pLevel, pPos, pState), isRightPowered(pLevel, pPos, pState.setValue(LEFT, isLeftPowered(pLevel, pPos, pState)))));
    }

    public boolean isLeftPowered(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction cw = pState.getValue(FACING).getClockWise();
        BlockPos blockposcw = pPos.relative(cw);

        if(pLevel.hasSignal(blockposcw, cw)) {
            setProperty(pLevel, pPos, pState, LEFT, true);
            return true;
        }
        setProperty(pLevel, pPos, pState, LEFT, false);
        return false;
    }

    public boolean isRightPowered(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction cw = pState.getValue(FACING).getCounterClockWise();
        BlockPos blockposcw = pPos.relative(cw);

        if(pLevel.hasSignal(blockposcw, cw)) {
            setProperty(pLevel, pPos, pState, RIGHT, true);
            return true;
        }
        setProperty(pLevel, pPos, pState, RIGHT, false);
        return false;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if(!pLevel.isClientSide() && pDirection.getAxis() != pState.getValue(FACING).getAxis()) {
            pLevel.setBlock(pCurrentPos, pState.setValue(RIGHT, isRightPowered((Level)pLevel, pCurrentPos, pState.setValue(LEFT, isLeftPowered((Level)pLevel, pCurrentPos, pState)))), 3);
        }
        return pState;
    }

    @Override
    protected int getDelay(BlockState pState) {
        return 1;
    }
}
