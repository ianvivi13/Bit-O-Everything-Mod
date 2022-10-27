package com.bic.bit_o_everything.world.feature.tree_growers;

import com.bic.bit_o_everything.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class DeadTreeGrower extends AbstractTreeGrower {
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean withBees) {
        if (randomSource.nextInt(10) == 0) {
            return ModConfiguredFeatures.DEAD_TREE_FANCY.getHolder().get();
        } else {
            return ModConfiguredFeatures.DEAD_TREE.getHolder().get();
        }
    }




}
