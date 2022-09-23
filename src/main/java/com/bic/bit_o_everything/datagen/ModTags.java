package com.bic.bit_o_everything.datagen;


import com.bic.bit_o_everything.BitOEverything;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final class Blocks {
        public static final TagKey<Block> CHERRY_LOGS = tag("cherry_logs");
        public static final TagKey<Block> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Block> DOGWOOD_LOGS = tag("dogwood_logs");
        public static final TagKey<Block> REDWOOD_LOGS = tag("redwood_logs");
        public static final TagKey<Block> OLIVE_LOGS = tag("olive_logs");
        public static final TagKey<Block> PEACH_LOGS = tag("peach_logs");
        public static final TagKey<Block> EBONY_LOGS = tag("ebony_logs");
        public static final TagKey<Block> PLUM_LOGS = tag("plum_logs");
        public static final TagKey<Block> ORANGE_LOGS = tag("orange_logs");
        public static final TagKey<Block> INFECTED_LOGS = tag("infected_logs");
        public static final TagKey<Block> CORRUPT_LOGS = tag("corrupt_logs");
        public static final TagKey<Block> PEAR_LOGS = tag("pear_logs");
        public static final TagKey<Block> WISTERIA_LOGS = tag("wisteria_logs");
        public static final TagKey<Block> CHARRED_LOGS = tag("charred_logs");
        public static final TagKey<Block> ICE_LOGS = tag("ice_logs");
        public static final TagKey<Block> DEAD_LOGS = tag("dead_logs");

        public static final TagKey<Block> SAND_ORE_REPLACEABLES = tag("sand_ore_replaceables");
        public static final TagKey<Block> RED_SAND_ORE_REPLACEABLES = tag("red_sand_ore_replaceables");
        public static final TagKey<Block> ANDESITE_ORE_REPLACEABLES = tag("andesite_ore_replaceables");
        public static final TagKey<Block> GRANITE_ORE_REPLACEABLES = tag("granite_ore_replaceables");
        public static final TagKey<Block> DIORITE_ORE_REPLACEABLES = tag("diorite_ore_replaceables");
        public static final TagKey<Block> TUFF_ORE_REPLACEABLES = tag("tuff_ore_replaceables");
        public static final TagKey<Block> BASALT_ORE_REPLACEABLES = tag("basalt_ore_replaceables");
        public static final TagKey<Block> UNOBTAINIUM_ORE_REPLACEABLES = tag("unobtainium_ore_replaceables");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(BitOEverything.MOD_ID, name));
        }

    }


    public static final class Items {
        public static final TagKey<Item> CHERRY_LOGS = tag("cherry_logs");
        public static final TagKey<Item> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Item> DOGWOOD_LOGS = tag("dogwood_logs");
        public static final TagKey<Item> REDWOOD_LOGS = tag("redwood_logs");
        public static final TagKey<Item> OLIVE_LOGS = tag("olive_logs");
        public static final TagKey<Item> PEACH_LOGS = tag("peach_logs");
        public static final TagKey<Item> EBONY_LOGS = tag("ebony_logs");
        public static final TagKey<Item> PLUM_LOGS = tag("plum_logs");
        public static final TagKey<Item> ORANGE_LOGS = tag("orange_logs");
        public static final TagKey<Item> INFECTED_LOGS = tag("infected_logs");
        public static final TagKey<Item> CORRUPT_LOGS = tag("corrupt_logs");
        public static final TagKey<Item> PEAR_LOGS = tag("pear_logs");
        public static final TagKey<Item> WISTERIA_LOGS = tag("wisteria_logs");
        public static final TagKey<Item> CHARRED_LOGS = tag("charred_logs");
        public static final TagKey<Item> ICE_LOGS = tag("ice_logs");
        public static final TagKey<Item> DEAD_LOGS = tag("dead_logs");
        public static final TagKey<Item> CONCRETES = tag("concretes");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(BitOEverything.MOD_ID, name));
        }
    }

    //IDK IF THIS IS CORRECT
    public static final class Biomes {

        public static final TagKey<Biome> IS_SILICON_VALID = tag("is_silicon_valid");

        private static TagKey<Biome> tag(String name) {
            return create(new ResourceLocation(BitOEverything.MOD_ID, name));
        }

        private static TagKey<Biome> create(final ResourceLocation pName) {
            return TagKey.create(Registry.BIOME_REGISTRY, pName);
        }
    }
}
