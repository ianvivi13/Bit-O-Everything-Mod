package com.bic.bit_o_everything.world.feature.custom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.Iterator;
import java.util.List;

public class CrystalClusterFeature extends Feature<CrystalClusterConfiguration> {
    public CrystalClusterFeature(Codec<CrystalClusterConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<CrystalClusterConfiguration> pContext) {
        WorldGenLevel worldGenLevel = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource randomSource = pContext.random();
        CrystalClusterConfiguration crystalClusterConfiguration = pContext.config();

        int quantityLeft = crystalClusterConfiguration.quantityToPlace(randomSource);
        int attemptsLeft = crystalClusterConfiguration.attempts * quantityLeft; // consider #attempts, quantityLeft, len(#extraChances), radius
        boolean didPlace = false;
        Iterator<BlockPos> blocks = BlockPos.randomInCube(randomSource, attemptsLeft, origin, crystalClusterConfiguration.extraRadius).iterator();

        while (blocks.hasNext() && quantityLeft > 0) {
            if (didPlace) {
                if (attemptSingleCrystalPlacement(worldGenLevel, randomSource, crystalClusterConfiguration, chooseClosest(blocks.next(), blocks.next(), origin))) {
                    quantityLeft--;

                }
            } else {
                BlockPos placing = blocks.next();
                if (attemptSingleCrystalPlacement(worldGenLevel, randomSource, crystalClusterConfiguration, placing)) {
                    quantityLeft--;
                    didPlace = true;
                    origin = placing;
                    blocks = BlockPos.randomInCube(randomSource, attemptsLeft * 2, origin, crystalClusterConfiguration.extraRadius).iterator();
                }
            }
        }

        return didPlace;
    }

    private static BlockPos chooseClosest(BlockPos a, BlockPos b, BlockPos origin) {
        if (a.distSqr(origin) <= b.distSqr(origin)) {
            return a;
        }
        return b;
    }

    //returns if crystal was placed at this block, attempts are made for each direction
    private static boolean attemptSingleCrystalPlacement(WorldGenLevel worldGenLevel, RandomSource randomSource, CrystalClusterConfiguration crystalClusterConfiguration, BlockPos crystalPos) {
        BlockState crystalPosState = worldGenLevel.getBlockState(crystalPos);
        if (isAirOrWater(crystalPosState)) { // if spot is air or water
            List<Direction> allDirections = getDirections(randomSource);
            for(Direction direction : allDirections) { // check each direction randomly for ability to place crystal
                BlockState crystalStateOnPos = worldGenLevel.getBlockState(crystalPos.relative(direction));
                if (canSupportCrystal(crystalStateOnPos, crystalClusterConfiguration)) { // determine if the block can support a crystal
                    BlockState crystalPlaceState = getCrystalState(crystalClusterConfiguration, worldGenLevel, randomSource, crystalPos, direction);
                    if (crystalPlaceState != null) {
                        placeCrystal(worldGenLevel, crystalPos, crystalPlaceState);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //get crystal place state at specific block - also generates random crystal
    private static BlockState getCrystalState(CrystalClusterConfiguration crystalClusterConfiguration, WorldGenLevel worldGenLevel, RandomSource randomSource, BlockPos crystalPos, Direction direction) {
        return crystalClusterConfiguration.getCrystal(randomSource).getStateForPlacement(worldGenLevel, crystalPos, direction);
    }

    //definitively places a crystal with specific blockstate
    private static void placeCrystal(WorldGenLevel worldGenLevel,BlockPos crystalPlacePos, BlockState crystalPlaceState) {
        worldGenLevel.setBlock(crystalPlacePos, crystalPlaceState, 3);
        worldGenLevel.getChunk(crystalPlacePos).markPosForPostprocessing(crystalPlacePos);
    }

    //returns all randomized directions in a list
    private static List<Direction> getDirections(RandomSource randomSource) {
        return (List<Direction>) Direction.allShuffled(randomSource);
    }

    //returns all randomized directions other than a specific direction
    private static List<Direction> getDirectionsWithout(RandomSource randomSource, Direction direction) {
        List<Direction> d = getDirections(randomSource);
        d.remove(direction);
        return d;
    }

    //returns whether the current block can support crystal growth
    private static boolean canSupportCrystal(BlockState fullBlockState, CrystalClusterConfiguration crystalClusterConfiguration) {
        return fullBlockState.is(crystalClusterConfiguration.canBePlacedOn);
    }

    //returns whether the current block is air or water
    private static boolean isAirOrWater(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER);
    }
}
