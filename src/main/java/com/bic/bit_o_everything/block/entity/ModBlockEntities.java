package com.bic.bit_o_everything.block.entity;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.entity.custom.ModSignBlockEntity;
import com.bic.bit_o_everything.block.entity.custom.PotterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BitOEverything.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.CHERRY_WALL_SIGN.get(),
                            ModBlocks.CHERRY_SIGN.get(),
                            ModBlocks.MAPLE_WALL_SIGN.get(),
                            ModBlocks.MAPLE_SIGN.get(),
                            ModBlocks.DOGWOOD_WALL_SIGN.get(),
                            ModBlocks.DOGWOOD_SIGN.get(),
                            ModBlocks.REDWOOD_WALL_SIGN.get(),
                            ModBlocks.REDWOOD_SIGN.get(),
                            ModBlocks.OLIVE_WALL_SIGN.get(),
                            ModBlocks.OLIVE_SIGN.get(),
                            ModBlocks.PEACH_WALL_SIGN.get(),
                            ModBlocks.PEACH_SIGN.get(),
                            ModBlocks.EBONY_WALL_SIGN.get(),
                            ModBlocks.EBONY_SIGN.get(),
                            ModBlocks.PLUM_WALL_SIGN.get(),
                            ModBlocks.PLUM_SIGN.get(),
                            ModBlocks.ORANGE_WALL_SIGN.get(),
                            ModBlocks.ORANGE_SIGN.get(),
                            ModBlocks.INFECTED_WALL_SIGN.get(),
                            ModBlocks.INFECTED_SIGN.get(),
                            ModBlocks.CORRUPT_WALL_SIGN.get(),
                            ModBlocks.CORRUPT_SIGN.get(),
                            ModBlocks.PEAR_WALL_SIGN.get(),
                            ModBlocks.PEAR_SIGN.get(),
                            ModBlocks.WISTERIA_WALL_SIGN.get(),
                            ModBlocks.WISTERIA_SIGN.get(),
                            ModBlocks.CHARRED_WALL_SIGN.get(),
                            ModBlocks.CHARRED_SIGN.get(),
                            ModBlocks.ICE_WALL_SIGN.get(),
                            ModBlocks.ICE_SIGN.get(),
                            ModBlocks.DEAD_WALL_SIGN.get(),
                            ModBlocks.DEAD_SIGN.get()
                    ).build(null));
    
    public static final RegistryObject<BlockEntityType<PotterBlockEntity>> POTTER =
            BLOCK_ENTITIES.register("potter", () ->
                    BlockEntityType.Builder.of(PotterBlockEntity::new,
                            ModBlocks.POTTER.get(), ModBlocks.CONCRETE_POTTER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
