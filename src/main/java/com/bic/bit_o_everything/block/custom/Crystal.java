package com.bic.bit_o_everything.block.custom;

import com.bic.bit_o_everything.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Crystal extends RodBlock implements SimpleWaterloggedBlock{
    private static final VoxelShape NORTH_AABB = Block.box(5,5,4,11,11,16);
    private static final VoxelShape EAST_AABB = Block.box(0,5,5,12,11,11);
    private static final VoxelShape SOUTH_AABB = Block.box(5,5,0,11,11,12);
    private static final VoxelShape WEST_AABB = Block.box(4,5,5,16,11,11);
    private static final VoxelShape UP_AABB = Block.box(5,0,5,11,12,11);
    private static final VoxelShape DOWN_AABB = Block.box(5,4,5,11,16,11);

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public Crystal(BlockBehaviour.Properties prop) {
        super(prop);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.UP));
    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 10;
    }

    @Override
    public void animateTick(BlockState p_221107_, Level p_221108_, BlockPos p_221109_, RandomSource p_221110_) {
        Direction direction = p_221107_.getValue(FACING);
        double d0 = (double)p_221109_.getX() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
        double d1 = (double)p_221109_.getY() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
        double d2 = (double)p_221109_.getZ() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
        double d3 = 0.45F - (p_221110_.nextFloat() + p_221110_.nextFloat()) * 0.4F;
        if (p_221110_.nextInt(10) == 0) {
            p_221108_.addParticle(ModParticles.CRYSTAL_PARTICLES.get(), d0 + (double)direction.getStepX() * d3, d1 + (double)direction.getStepY() * d3, d2 + (double)direction.getStepZ() * d3, p_221110_.nextGaussian() * 0.005D, p_221110_.nextGaussian() * 0.005D, p_221110_.nextGaussian() * 0.005D);
        }

    }

    @Override
    public VoxelShape getShape(BlockState p_154346_, BlockGetter p_154347_, BlockPos p_154348_, CollisionContext p_154349_) {
        Direction direction = p_154346_.getValue(FACING);
        switch (direction) {
            case NORTH:
                return NORTH_AABB;
            case SOUTH:
                return SOUTH_AABB;
            case EAST:
                return EAST_AABB;
            case WEST:
                return WEST_AABB;
            case DOWN:
                return DOWN_AABB;
            case UP:
            default:
                return UP_AABB;
        }
    }
    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return pDirection == pState.getValue(FACING).getOpposite() && !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor levelaccessor = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(FACING, pContext.getClickedFace());
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockPos blockpos = pPos.relative(direction.getOpposite());
        return pLevel.getBlockState(blockpos).isFaceSturdy(pLevel, blockpos, direction);
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, FACING);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.DESTROY;
    }

    public BlockState getStateForPlacement(WorldGenLevel worldGenLevel, BlockPos blockPos, Direction direction) {
        return this.defaultBlockState().setValue(WATERLOGGED, worldGenLevel.getFluidState(blockPos).getType() == Fluids.WATER).setValue(FACING, direction.getOpposite());
    }
}
