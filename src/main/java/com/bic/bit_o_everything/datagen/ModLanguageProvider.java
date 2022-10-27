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
        //region Woods
        //region Cherry Wood
        this.addItem(ModItems.CHERRY_BOAT);
        this.addItem(ModItems.CHERRY_CHEST_BOAT, "Cherry Boat with Chest");
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
        this.addBlock(ModBlocks.POTTED_CHERRY_SAPLING);
        //endregion
        //region Maple Wood
        this.addItem(ModItems.MAPLE_BOAT);
        this.addItem(ModItems.MAPLE_CHEST_BOAT, "Maple Boat with Chest");
        this.addBlock(ModBlocks.MAPLE_LOG);
        this.addBlock(ModBlocks.MAPLE_PLANKS);
        this.addBlock(ModBlocks.MAPLE_WOOD);
        this.addBlock(ModBlocks.STRIPPED_MAPLE_LOG);
        this.addBlock(ModBlocks.STRIPPED_MAPLE_WOOD);
        this.addBlock(ModBlocks.MAPLE_STAIRS);
        this.addBlock(ModBlocks.MAPLE_SLAB);
        this.addBlock(ModBlocks.MAPLE_FENCE);
        this.addBlock(ModBlocks.MAPLE_FENCE_GATE);
        this.addBlock(ModBlocks.MAPLE_BUTTON);
        this.addBlock(ModBlocks.MAPLE_PRESSURE_PLATE);
        this.addBlock(ModBlocks.MAPLE_DOOR);
        this.addBlock(ModBlocks.MAPLE_TRAPDOOR);
        this.addBlock(ModBlocks.MAPLE_SIGN);
        this.addBlock(ModBlocks.MAPLE_LEAVES_RED);
        this.addBlock(ModBlocks.MAPLE_LEAVES_ORANGE);
        this.addBlock(ModBlocks.MAPLE_SAPLING);
        this.addBlock(ModBlocks.POTTED_MAPLE_SAPLING);
        //endregion
        //region Dogwood Wood
        this.addItem(ModItems.DOGWOOD_BOAT);
        this.addItem(ModItems.DOGWOOD_CHEST_BOAT, "Dogwood Boat with Chest");
        this.addBlock(ModBlocks.DOGWOOD_LOG);
        this.addBlock(ModBlocks.DOGWOOD_PLANKS);
        this.addBlock(ModBlocks.DOGWOOD_WOOD);
        this.addBlock(ModBlocks.STRIPPED_DOGWOOD_LOG);
        this.addBlock(ModBlocks.STRIPPED_DOGWOOD_WOOD);
        this.addBlock(ModBlocks.DOGWOOD_STAIRS);
        this.addBlock(ModBlocks.DOGWOOD_SLAB);
        this.addBlock(ModBlocks.DOGWOOD_FENCE);
        this.addBlock(ModBlocks.DOGWOOD_FENCE_GATE);
        this.addBlock(ModBlocks.DOGWOOD_BUTTON);
        this.addBlock(ModBlocks.DOGWOOD_PRESSURE_PLATE);
        this.addBlock(ModBlocks.DOGWOOD_DOOR);
        this.addBlock(ModBlocks.DOGWOOD_TRAPDOOR);
        this.addBlock(ModBlocks.DOGWOOD_SIGN);
        this.addBlock(ModBlocks.DOGWOOD_LEAVES);
        this.addBlock(ModBlocks.DOGWOOD_SAPLING);
        this.addBlock(ModBlocks.POTTED_DOGWOOD_SAPLING);
        //endregion
        //region Redwood Wood
        this.addItem(ModItems.REDWOOD_BOAT);
        this.addItem(ModItems.REDWOOD_CHEST_BOAT, "Redwood Boat with Chest");
        this.addBlock(ModBlocks.REDWOOD_LOG);
        this.addBlock(ModBlocks.REDWOOD_PLANKS);
        this.addBlock(ModBlocks.REDWOOD_WOOD);
        this.addBlock(ModBlocks.STRIPPED_REDWOOD_LOG);
        this.addBlock(ModBlocks.STRIPPED_REDWOOD_WOOD);
        this.addBlock(ModBlocks.REDWOOD_STAIRS);
        this.addBlock(ModBlocks.REDWOOD_SLAB);
        this.addBlock(ModBlocks.REDWOOD_FENCE);
        this.addBlock(ModBlocks.REDWOOD_FENCE_GATE);
        this.addBlock(ModBlocks.REDWOOD_BUTTON);
        this.addBlock(ModBlocks.REDWOOD_PRESSURE_PLATE);
        this.addBlock(ModBlocks.REDWOOD_DOOR);
        this.addBlock(ModBlocks.REDWOOD_TRAPDOOR);
        this.addBlock(ModBlocks.REDWOOD_SIGN);
        this.addBlock(ModBlocks.REDWOOD_LEAVES);
        this.addBlock(ModBlocks.REDWOOD_SAPLING);
        this.addBlock(ModBlocks.POTTED_REDWOOD_SAPLING);
        //endregion
        //region Olive Wood
        this.addItem(ModItems.OLIVE_BOAT);
        this.addItem(ModItems.OLIVE_CHEST_BOAT, "Olive Boat with Chest");
        this.addBlock(ModBlocks.OLIVE_LOG);
        this.addBlock(ModBlocks.OLIVE_PLANKS);
        this.addBlock(ModBlocks.OLIVE_WOOD);
        this.addBlock(ModBlocks.STRIPPED_OLIVE_LOG);
        this.addBlock(ModBlocks.STRIPPED_OLIVE_WOOD);
        this.addBlock(ModBlocks.OLIVE_STAIRS);
        this.addBlock(ModBlocks.OLIVE_SLAB);
        this.addBlock(ModBlocks.OLIVE_FENCE);
        this.addBlock(ModBlocks.OLIVE_FENCE_GATE);
        this.addBlock(ModBlocks.OLIVE_BUTTON);
        this.addBlock(ModBlocks.OLIVE_PRESSURE_PLATE);
        this.addBlock(ModBlocks.OLIVE_DOOR);
        this.addBlock(ModBlocks.OLIVE_TRAPDOOR);
        this.addBlock(ModBlocks.OLIVE_SIGN);
        this.addBlock(ModBlocks.OLIVE_LEAVES);
        this.addBlock(ModBlocks.OLIVE_SAPLING);
        this.addBlock(ModBlocks.POTTED_OLIVE_SAPLING);
        //endregion
        //region Peach Wood
        this.addItem(ModItems.PEACH_BOAT);
        this.addItem(ModItems.PEACH_CHEST_BOAT, "Peach Boat with Chest");
        this.addBlock(ModBlocks.PEACH_LOG);
        this.addBlock(ModBlocks.PEACH_PLANKS);
        this.addBlock(ModBlocks.PEACH_WOOD);
        this.addBlock(ModBlocks.STRIPPED_PEACH_LOG);
        this.addBlock(ModBlocks.STRIPPED_PEACH_WOOD);
        this.addBlock(ModBlocks.PEACH_STAIRS);
        this.addBlock(ModBlocks.PEACH_SLAB);
        this.addBlock(ModBlocks.PEACH_FENCE);
        this.addBlock(ModBlocks.PEACH_FENCE_GATE);
        this.addBlock(ModBlocks.PEACH_BUTTON);
        this.addBlock(ModBlocks.PEACH_PRESSURE_PLATE);
        this.addBlock(ModBlocks.PEACH_DOOR);
        this.addBlock(ModBlocks.PEACH_TRAPDOOR);
        this.addBlock(ModBlocks.PEACH_SIGN);
        this.addBlock(ModBlocks.PEACH_LEAVES);
        this.addBlock(ModBlocks.PEACH_SAPLING);
        this.addBlock(ModBlocks.POTTED_PEACH_SAPLING);
        //endregion
        //region Ebony Wood
        this.addItem(ModItems.EBONY_BOAT);
        this.addItem(ModItems.EBONY_CHEST_BOAT, "Ebony Boat with Chest");
        this.addBlock(ModBlocks.EBONY_LOG);
        this.addBlock(ModBlocks.EBONY_PLANKS);
        this.addBlock(ModBlocks.EBONY_WOOD);
        this.addBlock(ModBlocks.STRIPPED_EBONY_LOG);
        this.addBlock(ModBlocks.STRIPPED_EBONY_WOOD);
        this.addBlock(ModBlocks.EBONY_STAIRS);
        this.addBlock(ModBlocks.EBONY_SLAB);
        this.addBlock(ModBlocks.EBONY_FENCE);
        this.addBlock(ModBlocks.EBONY_FENCE_GATE);
        this.addBlock(ModBlocks.EBONY_BUTTON);
        this.addBlock(ModBlocks.EBONY_PRESSURE_PLATE);
        this.addBlock(ModBlocks.EBONY_DOOR);
        this.addBlock(ModBlocks.EBONY_TRAPDOOR);
        this.addBlock(ModBlocks.EBONY_SIGN);
        this.addBlock(ModBlocks.EBONY_LEAVES);
        this.addBlock(ModBlocks.EBONY_SAPLING);
        this.addBlock(ModBlocks.POTTED_EBONY_SAPLING);
        //endregion
        //region Plum Wood
        this.addItem(ModItems.PLUM_BOAT);
        this.addItem(ModItems.PLUM_CHEST_BOAT, "Plum Boat with Chest");
        this.addBlock(ModBlocks.PLUM_LOG);
        this.addBlock(ModBlocks.PLUM_PLANKS);
        this.addBlock(ModBlocks.PLUM_WOOD);
        this.addBlock(ModBlocks.STRIPPED_PLUM_LOG);
        this.addBlock(ModBlocks.STRIPPED_PLUM_WOOD);
        this.addBlock(ModBlocks.PLUM_STAIRS);
        this.addBlock(ModBlocks.PLUM_SLAB);
        this.addBlock(ModBlocks.PLUM_FENCE);
        this.addBlock(ModBlocks.PLUM_FENCE_GATE);
        this.addBlock(ModBlocks.PLUM_BUTTON);
        this.addBlock(ModBlocks.PLUM_PRESSURE_PLATE);
        this.addBlock(ModBlocks.PLUM_DOOR);
        this.addBlock(ModBlocks.PLUM_TRAPDOOR);
        this.addBlock(ModBlocks.PLUM_SIGN);
        this.addBlock(ModBlocks.PLUM_LEAVES);
        this.addBlock(ModBlocks.PLUM_SAPLING);
        this.addBlock(ModBlocks.POTTED_PLUM_SAPLING);
        //endregion
        //region Orange Wood
        this.addItem(ModItems.ORANGE_BOAT);
        this.addItem(ModItems.ORANGE_CHEST_BOAT, "Orange Boat with Chest");
        this.addBlock(ModBlocks.ORANGE_LOG);
        this.addBlock(ModBlocks.ORANGE_PLANKS);
        this.addBlock(ModBlocks.ORANGE_WOOD);
        this.addBlock(ModBlocks.STRIPPED_ORANGE_LOG);
        this.addBlock(ModBlocks.STRIPPED_ORANGE_WOOD);
        this.addBlock(ModBlocks.ORANGE_STAIRS);
        this.addBlock(ModBlocks.ORANGE_SLAB);
        this.addBlock(ModBlocks.ORANGE_FENCE);
        this.addBlock(ModBlocks.ORANGE_FENCE_GATE);
        this.addBlock(ModBlocks.ORANGE_BUTTON);
        this.addBlock(ModBlocks.ORANGE_PRESSURE_PLATE);
        this.addBlock(ModBlocks.ORANGE_DOOR);
        this.addBlock(ModBlocks.ORANGE_TRAPDOOR);
        this.addBlock(ModBlocks.ORANGE_SIGN);
        this.addBlock(ModBlocks.ORANGE_LEAVES);
        this.addBlock(ModBlocks.ORANGE_SAPLING);
        this.addBlock(ModBlocks.POTTED_ORANGE_SAPLING);
        //endregion
        //region Infected Wood
        this.addItem(ModItems.INFECTED_BOAT);
        this.addItem(ModItems.INFECTED_CHEST_BOAT, "Infected Boat with Chest");
        this.addBlock(ModBlocks.INFECTED_LOG);
        this.addBlock(ModBlocks.INFECTED_PLANKS);
        this.addBlock(ModBlocks.INFECTED_WOOD);
        this.addBlock(ModBlocks.STRIPPED_INFECTED_LOG);
        this.addBlock(ModBlocks.STRIPPED_INFECTED_WOOD);
        this.addBlock(ModBlocks.INFECTED_STAIRS);
        this.addBlock(ModBlocks.INFECTED_SLAB);
        this.addBlock(ModBlocks.INFECTED_FENCE);
        this.addBlock(ModBlocks.INFECTED_FENCE_GATE);
        this.addBlock(ModBlocks.INFECTED_BUTTON);
        this.addBlock(ModBlocks.INFECTED_PRESSURE_PLATE);
        this.addBlock(ModBlocks.INFECTED_DOOR);
        this.addBlock(ModBlocks.INFECTED_TRAPDOOR);
        this.addBlock(ModBlocks.INFECTED_SIGN);
        this.addBlock(ModBlocks.INFECTED_LEAVES);
        this.addBlock(ModBlocks.INFECTED_SAPLING);
        this.addBlock(ModBlocks.POTTED_INFECTED_SAPLING);
        //endregion
        //region Corrupt Wood
        this.addItem(ModItems.CORRUPT_BOAT);
        this.addItem(ModItems.CORRUPT_CHEST_BOAT, "Corrupt Boat with Chest");
        this.addBlock(ModBlocks.CORRUPT_LOG);
        this.addBlock(ModBlocks.CORRUPT_PLANKS);
        this.addBlock(ModBlocks.CORRUPT_WOOD);
        this.addBlock(ModBlocks.STRIPPED_CORRUPT_LOG);
        this.addBlock(ModBlocks.STRIPPED_CORRUPT_WOOD);
        this.addBlock(ModBlocks.CORRUPT_STAIRS);
        this.addBlock(ModBlocks.CORRUPT_SLAB);
        this.addBlock(ModBlocks.CORRUPT_FENCE);
        this.addBlock(ModBlocks.CORRUPT_FENCE_GATE);
        this.addBlock(ModBlocks.CORRUPT_BUTTON);
        this.addBlock(ModBlocks.CORRUPT_PRESSURE_PLATE);
        this.addBlock(ModBlocks.CORRUPT_DOOR);
        this.addBlock(ModBlocks.CORRUPT_TRAPDOOR);
        this.addBlock(ModBlocks.CORRUPT_SIGN);
        this.addBlock(ModBlocks.CORRUPT_LEAVES);
        this.addBlock(ModBlocks.CORRUPT_SAPLING);
        this.addBlock(ModBlocks.POTTED_CORRUPT_SAPLING);
        //endregion
        //region Pear Wood
        this.addItem(ModItems.PEAR_BOAT);
        this.addItem(ModItems.PEAR_CHEST_BOAT, "Pear Boat with Chest");
        this.addBlock(ModBlocks.PEAR_LOG);
        this.addBlock(ModBlocks.PEAR_PLANKS);
        this.addBlock(ModBlocks.PEAR_WOOD);
        this.addBlock(ModBlocks.STRIPPED_PEAR_LOG);
        this.addBlock(ModBlocks.STRIPPED_PEAR_WOOD);
        this.addBlock(ModBlocks.PEAR_STAIRS);
        this.addBlock(ModBlocks.PEAR_SLAB);
        this.addBlock(ModBlocks.PEAR_FENCE);
        this.addBlock(ModBlocks.PEAR_FENCE_GATE);
        this.addBlock(ModBlocks.PEAR_BUTTON);
        this.addBlock(ModBlocks.PEAR_PRESSURE_PLATE);
        this.addBlock(ModBlocks.PEAR_DOOR);
        this.addBlock(ModBlocks.PEAR_TRAPDOOR);
        this.addBlock(ModBlocks.PEAR_SIGN);
        this.addBlock(ModBlocks.PEAR_LEAVES);
        this.addBlock(ModBlocks.PEAR_SAPLING);
        this.addBlock(ModBlocks.POTTED_PEAR_SAPLING);
        //endregion
        //region Wisteria Wood
        this.addItem(ModItems.WISTERIA_BOAT);
        this.addItem(ModItems.WISTERIA_CHEST_BOAT, "Wisteria Boat with Chest");
        this.addBlock(ModBlocks.WISTERIA_LOG);
        this.addBlock(ModBlocks.WISTERIA_PLANKS);
        this.addBlock(ModBlocks.WISTERIA_WOOD);
        this.addBlock(ModBlocks.STRIPPED_WISTERIA_LOG);
        this.addBlock(ModBlocks.STRIPPED_WISTERIA_WOOD);
        this.addBlock(ModBlocks.WISTERIA_STAIRS);
        this.addBlock(ModBlocks.WISTERIA_SLAB);
        this.addBlock(ModBlocks.WISTERIA_FENCE);
        this.addBlock(ModBlocks.WISTERIA_FENCE_GATE);
        this.addBlock(ModBlocks.WISTERIA_BUTTON);
        this.addBlock(ModBlocks.WISTERIA_PRESSURE_PLATE);
        this.addBlock(ModBlocks.WISTERIA_DOOR);
        this.addBlock(ModBlocks.WISTERIA_TRAPDOOR);
        this.addBlock(ModBlocks.WISTERIA_SIGN);
        this.addBlock(ModBlocks.WISTERIA_LEAVES_BLUE);
        this.addBlock(ModBlocks.WISTERIA_LEAVES_PURPLE);
        this.addBlock(ModBlocks.WISTERIA_SAPLING);
        this.addBlock(ModBlocks.POTTED_WISTERIA_SAPLING);
        //endregion
        //region Charred Wood
        this.addItem(ModItems.CHARRED_BOAT);
        this.addItem(ModItems.CHARRED_CHEST_BOAT, "Charred Boat with Chest");
        this.addBlock(ModBlocks.CHARRED_LOG);
        this.addBlock(ModBlocks.CHARRED_PLANKS);
        this.addBlock(ModBlocks.CHARRED_WOOD);
        this.addBlock(ModBlocks.STRIPPED_CHARRED_LOG);
        this.addBlock(ModBlocks.STRIPPED_CHARRED_WOOD);
        this.addBlock(ModBlocks.CHARRED_STAIRS);
        this.addBlock(ModBlocks.CHARRED_SLAB);
        this.addBlock(ModBlocks.CHARRED_FENCE);
        this.addBlock(ModBlocks.CHARRED_FENCE_GATE);
        this.addBlock(ModBlocks.CHARRED_BUTTON);
        this.addBlock(ModBlocks.CHARRED_PRESSURE_PLATE);
        this.addBlock(ModBlocks.CHARRED_DOOR);
        this.addBlock(ModBlocks.CHARRED_TRAPDOOR);
        this.addBlock(ModBlocks.CHARRED_SIGN);
        this.addBlock(ModBlocks.CHARRED_LEAVES);
        this.addBlock(ModBlocks.CHARRED_SAPLING);
        this.addBlock(ModBlocks.POTTED_CHARRED_SAPLING);
        //endregion
        //region Ice Wood
        this.addItem(ModItems.ICE_BOAT);
        this.addItem(ModItems.ICE_CHEST_BOAT, "Ice Boat with Chest");
        this.addBlock(ModBlocks.ICE_LOG);
        this.addBlock(ModBlocks.ICE_PLANKS);
        this.addBlock(ModBlocks.ICE_WOOD);
        this.addBlock(ModBlocks.STRIPPED_ICE_LOG);
        this.addBlock(ModBlocks.STRIPPED_ICE_WOOD);
        this.addBlock(ModBlocks.ICE_STAIRS);
        this.addBlock(ModBlocks.ICE_SLAB);
        this.addBlock(ModBlocks.ICE_FENCE);
        this.addBlock(ModBlocks.ICE_FENCE_GATE);
        this.addBlock(ModBlocks.ICE_BUTTON);
        this.addBlock(ModBlocks.ICE_PRESSURE_PLATE);
        this.addBlock(ModBlocks.ICE_DOOR);
        this.addBlock(ModBlocks.ICE_TRAPDOOR);
        this.addBlock(ModBlocks.ICE_SIGN);
        this.addBlock(ModBlocks.ICE_LEAVES);
        this.addBlock(ModBlocks.ICE_SAPLING);
        this.addBlock(ModBlocks.POTTED_ICE_SAPLING);
        //endregion
        //region Dead Wood
        this.addItem(ModItems.DEAD_BOAT);
        this.addItem(ModItems.DEAD_CHEST_BOAT, "Dead Boat with Chest");
        this.addBlock(ModBlocks.DEAD_LOG);
        this.addBlock(ModBlocks.DEAD_PLANKS);
        this.addBlock(ModBlocks.DEAD_WOOD);
        this.addBlock(ModBlocks.STRIPPED_DEAD_LOG);
        this.addBlock(ModBlocks.STRIPPED_DEAD_WOOD);
        this.addBlock(ModBlocks.DEAD_STAIRS);
        this.addBlock(ModBlocks.DEAD_SLAB);
        this.addBlock(ModBlocks.DEAD_FENCE);
        this.addBlock(ModBlocks.DEAD_FENCE_GATE);
        this.addBlock(ModBlocks.DEAD_BUTTON);
        this.addBlock(ModBlocks.DEAD_PRESSURE_PLATE);
        this.addBlock(ModBlocks.DEAD_DOOR);
        this.addBlock(ModBlocks.DEAD_TRAPDOOR);
        this.addBlock(ModBlocks.DEAD_SIGN);
        this.addBlock(ModBlocks.DEAD_LEAVES);
        this.addBlock(ModBlocks.DEAD_SAPLING);
        this.addBlock(ModBlocks.POTTED_DEAD_SAPLING);
        //endregion
        //endregion
        
        this.addItem(ModItems.OLIVES);
        this.addItem(ModItems.PEACH);
        this.addItem(ModItems.PEAR);
        this.addItem(ModItems.PLUM);
        this.addItem(ModItems.ORANGE);
        
        this.addBlock(ModBlocks.BLUE_LUNALIGHT);
        this.addBlock(ModBlocks.PURPLE_LUNALIGHT);
        
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
        this.addItemGroup(ModCreativeModeTab.WOOD, "Wood Types");
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
