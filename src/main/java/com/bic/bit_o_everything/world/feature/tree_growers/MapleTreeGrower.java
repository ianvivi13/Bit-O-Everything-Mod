package com.bic.bit_o_everything.world.feature.tree_growers;

import com.bic.bit_o_everything.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class MapleTreeGrower extends AbstractTreeGrower {
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean withBees) {
        if (randomSource.nextInt(10) == 0) {
            // RED
            if (randomSource.nextBoolean()) {
                // SPRUCE
                return ModConfiguredFeatures.MAPLE_TREE_SPRUCE_RED.getHolder().get();
            }
            // PINE
            return ModConfiguredFeatures.MAPLE_TREE_PINE_RED.getHolder().get();
        }
        // ORANGE
        if (randomSource.nextBoolean()) {
            // SPRUCE
            return ModConfiguredFeatures.MAPLE_TREE_SPRUCE_ORANGE.getHolder().get();
        }
        // PINE
        return ModConfiguredFeatures.MAPLE_TREE_PINE_ORANGE.getHolder().get();
    }




}
