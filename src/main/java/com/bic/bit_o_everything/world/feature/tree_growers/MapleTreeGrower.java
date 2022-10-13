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
            return withBees ? ModConfiguredFeatures.CHERRY_TREE_FANCY_BEES_005.getHolder().get() : ModConfiguredFeatures.CHERRY_TREE_STANDARD.getHolder().get();
        } else {
            return withBees ? ModConfiguredFeatures.CHERRY_TREE_STANDARD_BEES_005.getHolder().get() : ModConfiguredFeatures.CHERRY_TREE_FANCY.getHolder().get();
        }
    }




}
