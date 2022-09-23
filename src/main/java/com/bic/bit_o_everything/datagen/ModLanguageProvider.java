package com.bic.bit_o_everything.datagen;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModCreativeModeTab;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.sound.ModSounds;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;

import java.util.function.Supplier;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.addItem(ModItems.RAW_PYRITE);
        this.addItem(ModItems.PYRITE, "Pyrite Ingot");
        this.addItem(ModItems.MOD_BOOK);
        this.addItem(ModItems.SLAG);
        this.addItem(ModItems.FRIED_EGG);
        this.addItem(ModItems.UNREFINED_SILICON);
        this.addItem(ModItems.RED_UNREFINED_SILICON);
        this.addItem(ModItems.SILICON);
        this.addItem(ModItems.RAW_ZINC);
        this.addItem(ModItems.ZINC_INGOT);
        this.addItem(ModItems.RAW_MAGNESIUM);
        this.addItem(ModItems.RAW_SILVER);
        this.addItem(ModItems.SILVER_INGOT);
        this.addItem(ModItems.RAW_TIN);
        this.addItem(ModItems.TIN_INGOT);
        this.addItem(ModItems.RAW_LEAD);
        this.addItem(ModItems.LEAD_INGOT);
        this.addItem(ModItems.RAW_TITANIUM);
        this.addItem(ModItems.TITANIUM_INGOT);
        this.addItem(ModItems.RUBY);
        this.addItem(ModItems.SAPPHIRE);
        this.addItem(ModItems.CHERRY_BOAT);
        this.addItem(ModItems.CHERRY_CHEST_BOAT, "Cherry Boat with Chest");
        this.addItem(ModItems.EXPLOSIVE_ARROW);
        this.addItem(ModItems.TIMED_ARROW_ONE, "Timed Arrow 0.5s");
        this.addItem(ModItems.TIMED_ARROW_TWO, "Timed Arrow 1.0s");
        this.addItem(ModItems.TIMED_ARROW_THREE, "Timed Arrow 1.5s");
        this.addItem(ModItems.SILVER_ARROW);
        this.addItem(ModItems.RAINBOW_DYE);
        this.addItem(ModItems.GRENADE);
        this.addItem(ModItems.STICKY_GRENADE);
        this.addItem(ModItems.STICKY_DETONATOR, "Detonator");

        this.addBlock(ModBlocks.CELESTITE_BLOCK);
        this.addBlock(ModBlocks.CITRINE_BLOCK);
        this.addBlock(ModBlocks.RHODOCHROSITE_BLOCK);
        this.addBlock(ModBlocks.MOLDAVITE_BLOCK);
        this.addBlock(ModBlocks.AQUAMARINE_BLOCK);
        this.addBlock(ModBlocks.TANZANITE_BLOCK);

        this.addBlock(ModBlocks.UNOBTAINIUM_ORE);
        this.addItem(ModItems.UNOBTAINIUM_DUST);

        this.addItem(ModItems.WILDBERRIES);
        this.addItem(ModItems.BLUEBERRIES);
        this.addItem(ModItems.GOOSEBERRIES);
        this.addItem(ModItems.RASPBERRIES);
        this.addItem(ModItems.BLACKBERRIES);
        this.addBlock(ModBlocks.WILDBERRY_BUSH);
        this.addBlock(ModBlocks.BLUEBERRY_BUSH);
        this.addBlock(ModBlocks.GOOSEBERRY_BUSH);
        this.addBlock(ModBlocks.RASPBERRY_BUSH);
        this.addBlock(ModBlocks.BLACKBERRY_BUSH);

        this.addItem(ModItems.SAP_BOTTLE);
        this.addBlock(ModBlocks.TREE_TAP);

        this.addBlock(ModBlocks.PYRITE_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_PYRITE_ORE);
        this.addBlock(ModBlocks.PYRITE_BLOCK);
        this.addBlock(ModBlocks.RAW_PYRITE_BLOCK);
        this.addBlock(ModBlocks.ZINC_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_ZINC_ORE);
        this.addBlock(ModBlocks.ZINC_BLOCK);
        this.addBlock(ModBlocks.RAW_ZINC_BLOCK);
        this.addBlock(ModBlocks.MAGNESIUM_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_MAGNESIUM_ORE);
        this.addBlock(ModBlocks.MAGNESIUM_BLOCK);
        this.addBlock(ModBlocks.RAW_MAGNESIUM_BLOCK);
        this.addBlock(ModBlocks.SILVER_ORE);
        this.addBlock(ModBlocks.RAW_SILVER_BLOCK);
        this.addBlock(ModBlocks.TIN_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_TIN_ORE);
        this.addBlock(ModBlocks.TIN_BLOCK);
        this.addBlock(ModBlocks.RAW_TIN_BLOCK);
        this.addBlock(ModBlocks.LEAD_BLOCK);
        this.addBlock(ModBlocks.RAW_LEAD_BLOCK);
        this.addBlock(ModBlocks.LEAD_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_LEAD_ORE);
        this.addBlock(ModBlocks.SILICON_ORE);
        this.addBlock(ModBlocks.RED_SILICON_ORE);
        this.addBlock(ModBlocks.SILICON_BLOCK);
        this.addBlock(ModBlocks.TITANIUM_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_TITANIUM_ORE);
        this.addBlock(ModBlocks.TITANIUM_BLOCK);
        this.addBlock(ModBlocks.RAW_TITANIUM_BLOCK);

        this.addBlock(ModBlocks.RUBY_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_RUBY_ORE);
        this.addBlock(ModBlocks.RUBY_BLOCK);
        this.addBlock(ModBlocks.SAPPHIRE_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        this.addBlock(ModBlocks.SAPPHIRE_BLOCK);
        this.addBlock(ModBlocks.ASPHALT);
        this.addBlock(ModBlocks.JUMP_BLOCK);
        this.addBlock(ModBlocks.CHERRY_LOG);
        this.addBlock(ModBlocks.CHERRY_PLANKS);
        this.addBlock(ModBlocks.CHERRY_WOOD);
        this.addBlock(ModBlocks.STRIPPED_CHERRY_LOG);
        this.addBlock(ModBlocks.STRIPPED_CHERRY_WOOD);
        this.addBlock(ModBlocks.CHERRY_STAIRS);
        this.addBlock(ModBlocks.CHERRY_SLAB);
        this.addBlock(ModBlocks.CHERRY_FENCE);
        this.addBlock(ModBlocks.CHERRY_FENCE_GATE);
        this.addBlock(ModBlocks.CHERRY_BUTTON);
        this.addBlock(ModBlocks.CHERRY_PRESSURE_PLATE);
        this.addBlock(ModBlocks.CHERRY_DOOR);
        this.addBlock(ModBlocks.CHERRY_TRAPDOOR);
        this.addBlock(ModBlocks.CHERRY_SIGN);
        this.addBlock(ModBlocks.CHERRY_LEAVES);
        this.addBlock(ModBlocks.CHERRY_SAPLING);

        this.addBlock(ModBlocks.WHITE_CONCRETE_SLAB);
        this.addBlock(ModBlocks.ORANGE_CONCRETE_SLAB);
        this.addBlock(ModBlocks.MAGENTA_CONCRETE_SLAB);
        this.addBlock(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        this.addBlock(ModBlocks.YELLOW_CONCRETE_SLAB);
        this.addBlock(ModBlocks.LIME_CONCRETE_SLAB);
        this.addBlock(ModBlocks.PINK_CONCRETE_SLAB);
        this.addBlock(ModBlocks.GRAY_CONCRETE_SLAB);
        this.addBlock(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        this.addBlock(ModBlocks.CYAN_CONCRETE_SLAB);
        this.addBlock(ModBlocks.PURPLE_CONCRETE_SLAB);
        this.addBlock(ModBlocks.BLUE_CONCRETE_SLAB);
        this.addBlock(ModBlocks.BROWN_CONCRETE_SLAB);
        this.addBlock(ModBlocks.GREEN_CONCRETE_SLAB);
        this.addBlock(ModBlocks.RED_CONCRETE_SLAB);
        this.addBlock(ModBlocks.BLACK_CONCRETE_SLAB);
        this.addBlock(ModBlocks.WHITE_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.ORANGE_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.MAGENTA_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.YELLOW_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.LIME_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.PINK_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.GRAY_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.CYAN_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.PURPLE_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.BLUE_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.BROWN_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.GREEN_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.RED_CONCRETE_STAIRS);
        this.addBlock(ModBlocks.BLACK_CONCRETE_STAIRS);

        this.addBlock(ModBlocks.TERRACOTTA_WALL);
        this.addBlock(ModBlocks.WHITE_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.ORANGE_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.MAGENTA_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.YELLOW_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.LIME_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.PINK_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.GRAY_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.CYAN_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.PURPLE_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.BLUE_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.BROWN_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.GREEN_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.RED_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.BLACK_TERRACOTTA_WALL);
        this.addBlock(ModBlocks.WHITE_CONCRETE_WALL);
        this.addBlock(ModBlocks.ORANGE_CONCRETE_WALL);
        this.addBlock(ModBlocks.MAGENTA_CONCRETE_WALL);
        this.addBlock(ModBlocks.LIGHT_BLUE_CONCRETE_WALL);
        this.addBlock(ModBlocks.YELLOW_CONCRETE_WALL);
        this.addBlock(ModBlocks.LIME_CONCRETE_WALL);
        this.addBlock(ModBlocks.PINK_CONCRETE_WALL);
        this.addBlock(ModBlocks.GRAY_CONCRETE_WALL);
        this.addBlock(ModBlocks.LIGHT_GRAY_CONCRETE_WALL);
        this.addBlock(ModBlocks.CYAN_CONCRETE_WALL);
        this.addBlock(ModBlocks.PURPLE_CONCRETE_WALL);
        this.addBlock(ModBlocks.BLUE_CONCRETE_WALL);
        this.addBlock(ModBlocks.BROWN_CONCRETE_WALL);
        this.addBlock(ModBlocks.GREEN_CONCRETE_WALL);
        this.addBlock(ModBlocks.RED_CONCRETE_WALL);
        this.addBlock(ModBlocks.BLACK_CONCRETE_WALL);

        this.addBlock(ModBlocks.RAINBOW_BRICKS);
        this.addBlock(ModBlocks.WHITE_BRICKS);
        this.addBlock(ModBlocks.BLACK_BRICKS);
        this.addBlock(ModBlocks.RAINBOW_BRICK_SLAB);
        this.addBlock(ModBlocks.WHITE_BRICK_SLAB);
        this.addBlock(ModBlocks.BLACK_BRICK_SLAB);
        this.addBlock(ModBlocks.RAINBOW_BRICK_STAIRS);
        this.addBlock(ModBlocks.WHITE_BRICK_STAIRS);
        this.addBlock(ModBlocks.BLACK_BRICK_STAIRS);
        this.addBlock(ModBlocks.RAINBOW_BRICK_WALL);
        this.addBlock(ModBlocks.WHITE_BRICK_WALL);
        this.addBlock(ModBlocks.BLACK_BRICK_WALL);
        this.addBlock(ModBlocks.INDICATOR_LEVER);

        this.addBlock(ModBlocks.TANZANITE);
        this.addBlock(ModBlocks.RHODOCHROSITE);
        this.addBlock(ModBlocks.MOLDAVITE);
        this.addBlock(ModBlocks.CITRINE);
        this.addBlock(ModBlocks.CELESTITE);
        this.addBlock(ModBlocks.AQUAMARINE);
        this.addItem(ModItems.TANZANITE_SHARD);
        this.addItem(ModItems.RHODOCHROSITE_SHARD);
        this.addItem(ModItems.MOLDAVITE_SHARD);
        this.addItem(ModItems.CITRINE_SHARD);
        this.addItem(ModItems.CELESTITE_SHARD);
        this.addItem(ModItems.AQUAMARINE_SHARD);

        this.addItem(ModItems.CRYSTALLINE_SHARD);
        this.addItem(ModItems.CRYSTALLINE_INGOT);
        this.addItem(ModItems.ALUMINUM_INGOT);
        this.addItem(ModItems.ALUMINUM_NUGGET);
        this.addItem(ModItems.BRASS_INGOT);
        this.addItem(ModItems.BRASS_NUGGET);
        this.addItem(ModItems.STEEL_INGOT);
        this.addItem(ModItems.STEEL_NUGGET);
        this.addItem(ModItems.BRONZE_INGOT);
        this.addItem(ModItems.BRONZE_NUGGET);
        this.addItem(ModItems.ELECTRUM_INGOT);
        this.addItem(ModItems.ELECTRUM_NUGGET);
        this.addItem(ModItems.DRACONIUM_INGOT);
        this.addItem(ModItems.DRACONIUM_NUGGET);

        this.addItem(ModItems.ZINC_NUGGET);
        this.addItem(ModItems.TITANIUM_NUGGET);
        this.addItem(ModItems.TIN_NUGGET);
        this.addItem(ModItems.SILVER_NUGGET);
        this.addItem(ModItems.SAPPHIRE_SHARD);
        this.addItem(ModItems.RUBY_SHARD);
        this.addItem(ModItems.PYRITE_NUGGET);
        this.addItem(ModItems.MAGNESIUM_NUGGET);
        this.addItem(ModItems.LEAD_NUGGET);
        this.addItem(ModItems.EMERALD_SHARD);
        this.addItem(ModItems.DIAMOND_SHARD);
        this.addItem(ModItems.COPPER_NUGGET);

        this.addItem(ModItems.ROSALITE);
        this.addItem(ModItems.ROSALITE_SHARD);
        this.addBlock(ModBlocks.BASALT_ROSALITE_ORE);
        this.addBlock(ModBlocks.ROSALITE_BLOCK);

        this.addItem(ModItems.BISMUTH);
        this.addItem(ModItems.BISMUTH_INGOT);
        this.addItem(ModItems.BISMUTH_NUGGET);
        this.addBlock(ModBlocks.BISMUTH_BLOCK);
        this.addBlock(ModBlocks.BISMUTH_ORE);
        this.addBlock(ModBlocks.DEEPSLATE_BISMUTH_ORE);
        this.addBlock(ModBlocks.TUFF_BISMUTH_ORE);
        this.addBlock(ModBlocks.ANDESITE_BISMUTH_ORE);
        this.addBlock(ModBlocks.GRANITE_BISMUTH_ORE);
        this.addBlock(ModBlocks.DIORITE_BISMUTH_ORE);

        this.addItem(ModItems.SMOKY_QUARTZ);
        this.addBlock(ModBlocks.SMOKY_QUARTZ_ORE);
        this.addBlock(ModBlocks.BLOCK_OF_SMOKY_QUARTZ);
        this.addBlock(ModBlocks.SMOKY_QUARTZ_BRICKS);
        this.addBlock(ModBlocks.SMOOTH_SMOKY_QUARTZ_BLOCK);
        this.addBlock(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK);
        this.addBlock(ModBlocks.SMOKY_QUARTZ_PILLAR);
        this.addBlock(ModBlocks.SMOKY_QUARTZ_STAIRS);
        this.addBlock(ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS);
        this.addBlock(ModBlocks.SMOKY_QUARTZ_SLAB);
        this.addBlock(ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB);

        this.addBlock(ModBlocks.CRYSTALLINE_BLOCK);
        this.addBlock(ModBlocks.ALUMINUM_BLOCK);
        this.addBlock(ModBlocks.BRASS_BLOCK);
        this.addBlock(ModBlocks.BRONZE_BLOCK);
        this.addBlock(ModBlocks.STEEL_BLOCK);
        this.addBlock(ModBlocks.ELECTRUM_BLOCK);
        this.addBlock(ModBlocks.DRACONIUM_BLOCK);

        this.addBlock(ModBlocks.TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.WHITE_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.ORANGE_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.MAGENTA_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.YELLOW_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.LIME_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.PINK_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.GRAY_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.CYAN_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.PURPLE_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.BLUE_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.BROWN_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.GREEN_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.RED_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.BLACK_TERRACOTTA_STAIRS);
        this.addBlock(ModBlocks.TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.WHITE_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.ORANGE_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.MAGENTA_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.YELLOW_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.LIME_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.PINK_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.GRAY_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.CYAN_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.PURPLE_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.BLUE_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.BROWN_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.GREEN_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.RED_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.BLACK_TERRACOTTA_SLAB);
        this.addBlock(ModBlocks.POTTED_CHERRY_SAPLING);

        this.addEntityType(ModEntityTypes.MOD_CHEST_BOAT, "Boat with Chest");

        this.addBlock(ModBlocks.POTTER, "Terracotta Planter");
        this.addBlock(ModBlocks.CONCRETE_POTTER, "Concrete Planter");

        this.addSound(ModSounds.CAST_FAILED, "Spell cast Failed");
        this.addSound(ModSounds.INCANTATION_FAILED);
        this.addSound(ModSounds.INCANTATION_SUCCESS);
        this.addSound(ModSounds.SPELL_FIREBALL, "Spell casted: Fireball");
        this.addSound(ModSounds.SPELL_SLOWFALLING, "Spell casted: Slowfalling");

        this.addItemGroup(ModCreativeModeTab.MAGIC, "Magic");
        this.addItemGroup(ModCreativeModeTab.MODDED, "Modded");
        this.addItemGroup(ModCreativeModeTab.MINERALS, "Crystals, Ores, and Alloys");
    }

    // Helper Functions

    public void addItemGroup(CreativeModeTab tab, String name) {
        this.add(tab.getDisplayName().getString(), name);
    }

    public void addSound(Supplier<? extends SoundEvent> key) {
        this.add(this.getSoundEventDescriptionId(key.get()));
    }

    public void addSound(Supplier<? extends SoundEvent> key, String name) {
        this.add(this.getSoundEventDescriptionId(key.get()), name);
    }

    public void addEntity(Supplier<? extends EntityType<?>> key) {
        this.add(key.get().getDescriptionId());
    }

    public void addBlock(Supplier<? extends Block> key) {
        this.add(key.get().getDescriptionId());
    }

    public void addItem(Supplier<? extends Item> key) {
        this.add(key.get().getDescriptionId());
    }

    public void add(String id) {
        String[] translation = id.split("\\.");
        this.add(id, WordUtils.capitalizeFully(translation[translation.length - 1].replace("_", " ")));
    }

    public String getSoundEventDescriptionId(SoundEvent sound) {
        return Util.makeDescriptionId("sounds", Registry.SOUND_EVENT.getKey(sound));
    }
}
