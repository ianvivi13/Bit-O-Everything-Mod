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

import java.util.List;

public class CrystalClusterFeature extends Feature<CrystalClusterConfiguration> {
    public CrystalClusterFeature(Codec<CrystalClusterConfiguration> pCodec) {
        super(pCodec);
    }

    /*
    // called once by placed feature
    @Override
    public boolean place(FeaturePlaceContext<CrystalClusterConfiguration> pContext) {
        WorldGenLevel worldGenLevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource randomSource = pContext.random();
        CrystalClusterConfiguration crystalClusterConfiguration = pContext.config();
        int quantityToPlace = crystalClusterConfiguration.quantityToPlace(randomSource);

        if (!isAirOrWater(worldGenLevel.getBlockState(blockpos))) {
            return false;
        }
        boolean markPlaced = false;
        for (int i = 0; i < quantityToPlace; i++) {
            List<Direction> allDirections = getDirections(randomSource);
            if (placeGrowthIfPossible(worldGenLevel, blockpos, worldGenLevel.getBlockState(blockpos), crystalClusterConfiguration, randomSource, allDirections)) {
                markPlaced = true;
                continue;
            }

            BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();

            center:
            for(Direction direction : allDirections) {
                blockpos$mutableblockpos.set(blockpos);

                List<Direction> list1 = getDirectionsWithout(randomSource, direction.getOpposite());

                for (int j = 0; j < crystalClusterConfiguration.attempts; ++j) {
                    blockpos$mutableblockpos.setWithOffset(blockpos, direction);
                    BlockState blockstate = worldGenLevel.getBlockState(blockpos$mutableblockpos);
                    if (!isAirOrWater(blockstate)) {
                        break;
                    }

                    if (placeGrowthIfPossible(worldGenLevel, blockpos$mutableblockpos, blockstate, crystalClusterConfiguration, randomSource, list1)) {
                        markPlaced = true;
                        break center;
                    }
                }
            }
        }

        return markPlaced;
    }
    */

    /*
    public static boolean placeGrowthIfPossible(WorldGenLevel worldGenLevel, BlockPos blockPos, BlockState blockState, CrystalClusterConfiguration crystalClusterConfiguration, RandomSource randomSource, List<Direction> directions) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = blockPos.mutable();

        for(Direction direction : directions) {
            BlockState selectedBlock = worldGenLevel.getBlockState(blockpos$mutableblockpos.setWithOffset(blockPos, direction));
            if (canSupportCrystal(selectedBlock, crystalClusterConfiguration)) {
                BlockState crystalPlaceState = crystalClusterConfiguration.getCrystal(randomSource).getStateForPlacement(worldGenLevel, blockPos, direction);
                if (crystalPlaceState == null) {
                    return false;
                }
                placeCrystal(worldGenLevel, blockPos, crystalPlaceState);
                return true;
            }
        }

        return false;
    }
    */

    @Override
    public boolean place(FeaturePlaceContext<CrystalClusterConfiguration> pContext) {
        WorldGenLevel worldGenLevel = pContext.level();
        BlockPos origin = pContext.origin();
        RandomSource randomSource = pContext.random();
        CrystalClusterConfiguration crystalClusterConfiguration = pContext.config();
        int quantityToPlace = crystalClusterConfiguration.quantityToPlace(randomSource);

        return attemptCrystalPlacement(worldGenLevel, randomSource, crystalClusterConfiguration, origin);

        //return false;
    }

    //returns if crystal was placed at this block, attempts are made for each direction
    private static boolean attemptCrystalPlacement(WorldGenLevel worldGenLevel, RandomSource randomSource, CrystalClusterConfiguration crystalClusterConfiguration, BlockPos crystalPos) {
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
