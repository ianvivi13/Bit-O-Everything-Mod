package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.world.feature.custom.CrystalClusterConfiguration;
import com.bic.bit_o_everything.world.feature.custom.CrystalClusterFeature;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFeatures<FC extends FeatureConfiguration> {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registry.FEATURE_REGISTRY, BitOEverything.MOD_ID);

    public static final RegistryObject<CrystalClusterFeature> CRYSTAL_CLUSTER = register("crystal_cluster", () -> new CrystalClusterFeature(CrystalClusterConfiguration.CODEC));

    private static <C extends FeatureConfiguration, F extends Feature<C>> RegistryObject<F> register(String pKey, Supplier<F> pValue) {
        return FEATURES.register(pKey, pValue);
    }

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
