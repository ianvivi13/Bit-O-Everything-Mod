package com.bic.bit_o_everything.datagen;


import com.bic.bit_o_everything.BitOEverything;
import net.minecraft.core.Registry;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static final class Blocks {
        public static final TagKey<Block> CHERRY_LOGS = tag("cherry_logs");

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
