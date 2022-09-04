package com.bic.bit_o_everything;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.entity.ModBlockEntities;
import com.bic.bit_o_everything.block.entity.ModWoodTypes;
import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.network.ModPacketHandler;
import com.bic.bit_o_everything.particle.ModParticles;
import com.bic.bit_o_everything.potion.ModPotions;
import com.bic.bit_o_everything.sound.ModSounds;
import com.bic.bit_o_everything.spells.AbstractSpell;
import com.bic.bit_o_everything.spells.FireballSpell;
import com.bic.bit_o_everything.util.BetterBrewingRecipe;
import com.bic.bit_o_everything.world.feature.ModConfiguredFeatures;
import com.bic.bit_o_everything.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BitOEverything.MOD_ID)
public class BitOEverything  {
    public static final String MOD_ID = "bit_o_everything";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public BitOEverything() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register shit here
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModPotions.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModEntityTypes.register(eventBus);
        ModSounds.register(eventBus);

        ModParticles.register(eventBus);

        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_TRAPDOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CELESTITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANZANITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CITRINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RHODOCHROSITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AQUAMARINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOLDAVITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRYSTALLINE_BLOCK.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_LEAVES.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_SAPLING.get(), RenderType.cutout());
        //ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CHERRY_SAPLING.get(), RenderType.cutout());
        WoodType.register(ModWoodTypes.CHERRY);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTER.get(), RenderType.cutout());

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.CHERRY);

            //Add potion recipes here

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.POISONOUS_POTATO, Potions.LUCK));
        });
        event.enqueueWork(ModPacketHandler::init);

    }



}
