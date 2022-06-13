package com.bic.bit_o_everything;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.entity.ModBlockEntities;
import com.bic.bit_o_everything.block.entity.ModWoodTypes;
import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.potion.ModPotions;
import com.bic.bit_o_everything.util.BetterBrewingRecipe;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
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

    public BitOEverything()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register shit here
        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModPotions.register(eventBus);

        ModBlockEntities.register(eventBus);
        ModEntityTypes.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_TRAPDOOR.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_SAPLING.get(), RenderType.cutout());

        WoodType.register(ModWoodTypes.CHERRY);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Sheets.addWoodType(ModWoodTypes.CHERRY);

            //Add potion recipes here

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.POISONOUS_POTATO, Potions.LUCK));
        });

    }



}
