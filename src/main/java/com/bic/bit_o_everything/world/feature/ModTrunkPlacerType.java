package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.world.feature.custom.BranchingTrunkPlacer;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModTrunkPlacerType<P extends TrunkPlacer> {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS =
            DeferredRegister.create(Registry.TRUNK_PLACER_TYPE_REGISTRY, BitOEverything.MOD_ID);
    
    //static final Constructor<TrunkPlacerType<? extends TrunkPlacer>> constructor= (Constructor<TrunkPlacerType<? extends TrunkPlacer>>) TrunkPlacerType.class.getDeclaredConstructors()[0];
    
    
    public static final RegistryObject<? extends TrunkPlacerType<? extends TrunkPlacer>> BRANCHING_TRUNK_PLACER = register("branching_trunk_placer",
            BranchingTrunkPlacer.CODEC);
    
    
    private static RegistryObject<? extends TrunkPlacerType<? extends TrunkPlacer>> register(String name, Codec<? extends TrunkPlacer> codec) {
        return register(name, () -> new TrunkPlacerType<>(codec));
        /*
        return register(name, () -> {
            try {
                return constructor.newInstance(codec);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        });
        */
        
    }
    
    public static RegistryObject<? extends TrunkPlacerType<? extends TrunkPlacer>> register(final String name, final Supplier<? extends TrunkPlacerType<? extends TrunkPlacer>> sup) {
        return TRUNK_PLACERS.register(name, sup);
    }
    
    public static void register(IEventBus eventBus) {
        TRUNK_PLACERS.register(eventBus);
    }
}
