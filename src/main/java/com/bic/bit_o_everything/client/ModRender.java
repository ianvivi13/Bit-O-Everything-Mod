package com.bic.bit_o_everything.client;


import com.bic.bit_o_everything.block.entity.ModBlockEntities;
import com.bic.bit_o_everything.client.render.block.PotterBlockEntityRenderer;
import com.bic.bit_o_everything.client.render.entity.*;
import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.entity.custom.ModBoatEntity;
import com.bic.bit_o_everything.entity.custom.ModChestBoatEntity;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "bit_o_everything", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModRender {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.MOD_CHEST_BOAT.get(), ModChestBoatEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.MOD_BOAT.get(), ModBoatEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.EXPLOSIVE_ARROW.get(), ModExplosiveArrowEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.TIMED_ARROW.get(), ModTimedArrowEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.SILVER_ARROW.get(), ModSilverArrowEntityRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.STICKY_GRENADE.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntityTypes.GRENADE.get(), ThrownItemRenderer::new);
        
        event.registerBlockEntityRenderer(ModBlockEntities.POTTER.get(), PotterBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerEntityLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

        for(ModChestBoatEntity.Type boatType : ModChestBoatEntity.Type.values()) {
            event.registerLayerDefinition(ModChestBoatEntityRenderer.boatLayer(boatType),
                    () -> BoatModel.createBodyModel(true));
        }
        
        for(ModBoatEntity.Type boatType : ModBoatEntity.Type.values()) {
            event.registerLayerDefinition(ModBoatEntityRenderer.boatLayer(boatType),
                    () -> BoatModel.createBodyModel(false));
        }
    }
    
    
}
