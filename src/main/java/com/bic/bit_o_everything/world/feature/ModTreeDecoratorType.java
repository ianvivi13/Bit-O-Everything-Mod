package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.world.feature.custom.TreeTapDecorator;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModTreeDecoratorType<P extends TreeDecorator> {
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS =
            DeferredRegister.create(Registry.TREE_DECORATOR_TYPE_REGISTRY, BitOEverything.MOD_ID);
    
    
    public static final RegistryObject<? extends TreeDecoratorType<? extends TreeDecorator>> TREE_TAP_DECORATOR = register("tree_tap_decorator",
            TreeTapDecorator.CODEC);
    
    
    private static RegistryObject<? extends TreeDecoratorType<? extends TreeDecorator>> register(String name, Codec<? extends TreeDecorator> codec) {
        return register(name, () -> new TreeDecoratorType<>(codec));
    }
    
    public static RegistryObject<? extends TreeDecoratorType<? extends TreeDecorator>> register(final String name, final Supplier<? extends TreeDecoratorType<? extends TreeDecorator>> sup) {
        return TREE_DECORATORS.register(name, sup);
    }
    
    public static void register(IEventBus eventBus) {
        TREE_DECORATORS.register(eventBus);
    }
}
