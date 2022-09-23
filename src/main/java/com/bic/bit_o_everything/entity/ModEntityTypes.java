package com.bic.bit_o_everything.entity;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.entity.custom.ModBoatEntity;
import com.bic.bit_o_everything.entity.custom.ModChestBoatEntity;
import com.bic.bit_o_everything.entity.projectile.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BitOEverything.MOD_ID);
    
    public static final RegistryObject<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("boat",
                    () -> EntityType.Builder.<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F).clientTrackingRange(10)
                            .build("boat"));

    public static final RegistryObject<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("chest_boat",
                    () -> EntityType.Builder.<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                            .sized(1.375F, 0.5625F).clientTrackingRange(10)
                            .build("chest_boat"));

    public static final RegistryObject<EntityType<ExplosiveArrow>> EXPLOSIVE_ARROW = ENTITY_TYPES.register("explosive_arrow", () -> EntityType.Builder.<ExplosiveArrow>of(ExplosiveArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BitOEverything.MOD_ID, "explosive_arrow").toString()));
    public static final RegistryObject<EntityType<TimedArrow>> TIMED_ARROW = ENTITY_TYPES.register("timed_arrow", () -> EntityType.Builder.<TimedArrow>of(TimedArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BitOEverything.MOD_ID, "timed_arrow").toString()));
    public static final RegistryObject<EntityType<SilverArrow>> SILVER_ARROW = ENTITY_TYPES.register("silver_arrow", () -> EntityType.Builder.<SilverArrow>of(SilverArrow::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BitOEverything.MOD_ID, "silver_arrow").toString()));

    public static final RegistryObject<EntityType<Grenade>> GRENADE = ENTITY_TYPES.register("grenade", () -> EntityType.Builder.<Grenade>of(Grenade::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BitOEverything.MOD_ID, "grenade").toString()));
    public static final RegistryObject<EntityType<StickyGrenade>> STICKY_GRENADE = ENTITY_TYPES.register("sticky_grenade", () -> EntityType.Builder.<StickyGrenade>of(StickyGrenade::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).build(new ResourceLocation(BitOEverything.MOD_ID, "sticky_grenade").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
