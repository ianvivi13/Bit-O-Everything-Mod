package com.bic.bit_o_everything;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.entity.ModBlockEntities;
import com.bic.bit_o_everything.block.entity.ModWoodTypes;
import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.entity.projectile.*;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.network.ModPacketHandler;
import com.bic.bit_o_everything.particle.ModParticles;
import com.bic.bit_o_everything.potion.ModPotions;
import com.bic.bit_o_everything.sound.ModSounds;
import com.bic.bit_o_everything.util.BetterBrewingRecipe;
import com.bic.bit_o_everything.world.feature.*;
import com.google.common.collect.Maps;
import com.mojang.logging.LogUtils;
import net.minecraft.Util;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.Map;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BitOEverything.MOD_ID)
public class BitOEverything  {
    public static final String MOD_ID = "bit_o_everything";

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Map<RegistryObject<Block>, RegistryObject<Block>> POTTED_PLANTS = Maps.newHashMap();

    public static void addPottedPlant(RegistryObject<Block> plant, RegistryObject<Block> flowerPot) {
        POTTED_PLANTS.put(plant, flowerPot);
    }

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
        
        ModTrunkPlacerType.register(eventBus);
        ModFoliagePlacerType.register(eventBus);
        ModTreeDecoratorType.register(eventBus);
        ModFeatures.register(eventBus);
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
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OLIVE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OLIVE_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEACH_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEACH_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.INFECTED_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.INFECTED_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORRUPT_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORRUPT_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHARRED_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHARRED_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEAR_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEAR_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WISTERIA_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WISTERIA_TRAPDOOR.get(), RenderType.cutout());
        
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_DOOR.get(), RenderType.translucent());
        
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_TRAPDOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_DOOR.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_FENCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_FENCE_GATE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_LOG.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_WOOD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_PLANKS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRIPPED_ICE_LOG.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STRIPPED_ICE_WOOD.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_STAIRS.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_SLAB.get(), RenderType.translucent());
        
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_BUTTON.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_PRESSURE_PLATE.get(), RenderType.translucent());
        
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHERRY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CHERRY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_LEAVES_RED.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_LEAVES_ORANGE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MAPLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_MAPLE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DOGWOOD_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DOGWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_DOGWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.REDWOOD_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_REDWOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OLIVE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OLIVE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_OLIVE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEACH_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEACH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PEACH_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EBONY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_EBONY_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PLUM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PLUM_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ORANGE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ORANGE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.INFECTED_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.INFECTED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_INFECTED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORRUPT_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORRUPT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CORRUPT_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEAR_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PEAR_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WISTERIA_LEAVES_BLUE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WISTERIA_LEAVES_PURPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WISTERIA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_WISTERIA_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHARRED_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHARRED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CHARRED_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_LEAVES.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.ICE_SAPLING.get(), RenderType.cutout()); // ICE
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_ICE_SAPLING.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DEAD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_DEAD_SAPLING.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CELESTITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TANZANITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CITRINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RHODOCHROSITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.AQUAMARINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MOLDAVITE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRYSTALLINE_BLOCK.get(), RenderType.translucent());
        
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TREE_TAP.get(), RenderType.cutout());
        
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILDBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLUEBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOOSEBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RASPBERRY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACKBERRY_BUSH.get(), RenderType.cutout());
        
        WoodType.register(ModWoodTypes.CHERRY);
        WoodType.register(ModWoodTypes.MAPLE);
        WoodType.register(ModWoodTypes.DOGWOOD);
        WoodType.register(ModWoodTypes.REDWOOD);
        WoodType.register(ModWoodTypes.OLIVE);
        WoodType.register(ModWoodTypes.PEACH);
        WoodType.register(ModWoodTypes.EBONY);
        WoodType.register(ModWoodTypes.PLUM);
        WoodType.register(ModWoodTypes.ORANGE);
        WoodType.register(ModWoodTypes.INFECTED);
        WoodType.register(ModWoodTypes.CORRUPT);
        WoodType.register(ModWoodTypes.PEAR);
        WoodType.register(ModWoodTypes.WISTERIA);
        WoodType.register(ModWoodTypes.CHARRED);
        WoodType.register(ModWoodTypes.ICE);
        WoodType.register(ModWoodTypes.DEAD);
        
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTER.get(), RenderType.cutout());

        for (Map.Entry<RegistryObject<Block>, RegistryObject<Block>> entry : POTTED_PLANTS.entrySet()) {
            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(entry.getKey().getId(), entry.getValue());
        }


    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            //region Add Wood Types

            Sheets.addWoodType(ModWoodTypes.CHERRY);
            Sheets.addWoodType(ModWoodTypes.MAPLE);
            Sheets.addWoodType(ModWoodTypes.DOGWOOD);
            Sheets.addWoodType(ModWoodTypes.REDWOOD);
            Sheets.addWoodType(ModWoodTypes.OLIVE);
            Sheets.addWoodType(ModWoodTypes.PEACH);
            Sheets.addWoodType(ModWoodTypes.EBONY);
            Sheets.addWoodType(ModWoodTypes.PLUM);
            Sheets.addWoodType(ModWoodTypes.ORANGE);
            Sheets.addWoodType(ModWoodTypes.INFECTED);
            Sheets.addWoodType(ModWoodTypes.CORRUPT);
            Sheets.addWoodType(ModWoodTypes.PEAR);
            Sheets.addWoodType(ModWoodTypes.WISTERIA);
            Sheets.addWoodType(ModWoodTypes.CHARRED);
            Sheets.addWoodType(ModWoodTypes.ICE);
            Sheets.addWoodType(ModWoodTypes.DEAD);

            //endregion

            //region Potion Recipes

            BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                    Items.POISONOUS_POTATO, Potions.LUCK));

            //endregion

            //region Dispenser Behavior

            DispenserBlock.registerBehavior(ModItems.EXPLOSIVE_ARROW.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    ExplosiveArrow arrow = new ExplosiveArrow(ModEntityTypes.EXPLOSIVE_ARROW.get(), pos.x(), pos.y(), pos.z(), level);
                    arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                    return arrow;
                }
            });

            DispenserBlock.registerBehavior(ModItems.TIMED_ARROW_ONE.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    TimedArrow arrow = new TimedArrow(ModEntityTypes.TIMED_ARROW.get(), pos.x(), pos.y(), pos.z(), level, 0.5);
                    arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                    return arrow;
                }
            });

            DispenserBlock.registerBehavior(ModItems.TIMED_ARROW_TWO.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    TimedArrow arrow = new TimedArrow(ModEntityTypes.TIMED_ARROW.get(), pos.x(), pos.y(), pos.z(), level, 1);
                    arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                    return arrow;
                }
            });

            DispenserBlock.registerBehavior(ModItems.TIMED_ARROW_THREE.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    TimedArrow arrow = new TimedArrow(ModEntityTypes.TIMED_ARROW.get(), pos.x(), pos.y(), pos.z(), level, 1.5);
                    arrow.pickup = AbstractArrow.Pickup.DISALLOWED;
                    return arrow;
                }
            });

            DispenserBlock.registerBehavior(ModItems.SILVER_ARROW.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    SilverArrow arrow = new SilverArrow(ModEntityTypes.SILVER_ARROW.get(), pos.x(), pos.y(), pos.z(), level);
                    arrow.pickup = AbstractArrow.Pickup.ALLOWED;
                    return arrow;
                }
            });

            DispenserBlock.registerBehavior(ModItems.GRENADE.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    return Util.make(new Grenade(ModEntityTypes.GRENADE.get(), pos.x(), pos.y(), pos.z(), level), (grenade) -> {
                        grenade.setItem(item);
                    });
                }
            });

            DispenserBlock.registerBehavior(ModItems.STICKY_GRENADE.get(), new AbstractProjectileDispenseBehavior() {
                protected Projectile getProjectile(Level level, Position pos, ItemStack item) {
                    return Util.make(new StickyGrenade(ModEntityTypes.STICKY_GRENADE.get(), pos.x(), pos.y(), pos.z(), level), (stickyGrenade) -> {
                        stickyGrenade.setItem(item);
                    });
                }
            });

            //endregion
        });
        event.enqueueWork(ModPacketHandler::init);

    }



}
