package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.world.feature.custom.MetaballFoliagePlacer;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModFoliagePlacerType<P extends FoliagePlacer> {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registry.FOLIAGE_PLACER_TYPE_REGISTRY, BitOEverything.MOD_ID);
    
    
    public static final RegistryObject<? extends FoliagePlacerType<? extends FoliagePlacer>> METABALL_FOLIAGE_PLACER = register("metaball_foliage_placer",
            MetaballFoliagePlacer.CODEC);
    
    
    private static RegistryObject<? extends FoliagePlacerType<? extends FoliagePlacer>> register(String name, Codec<? extends FoliagePlacer> codec) {
        return register(name, () -> new FoliagePlacerType<>(codec));
    }
    
    public static RegistryObject<? extends FoliagePlacerType<? extends FoliagePlacer>> register(final String name, final Supplier<? extends FoliagePlacerType<? extends FoliagePlacer>> sup) {
        return FOLIAGE_PLACERS.register(name, sup);
    }
    
    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
