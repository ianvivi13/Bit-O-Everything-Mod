package com.bic.bit_o_everything.datagen;

import com.bic.bit_o_everything.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;

import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //region Needs Tool
        this.tag(BlockTags.MINEABLE_WITH_HOE)

        ;

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)

        ;

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.CHERRY_LOG.get())
                .add(ModBlocks.STRIPPED_CHERRY_LOG.get())
                .add(ModBlocks.CHERRY_WOOD.get())
                .add(ModBlocks.STRIPPED_CHERRY_WOOD.get())
                .add(ModBlocks.CHERRY_FENCE.get())
                .add(ModBlocks.CHERRY_FENCE_GATE.get())
                .add(ModBlocks.CHERRY_PLANKS.get())
                .add(ModBlocks.CHERRY_STAIRS.get())
                .add(ModBlocks.CHERRY_SLAB.get())
                .add(ModBlocks.CHERRY_PRESSURE_PLATE.get())
                .add(ModBlocks.CHERRY_BUTTON.get())
                .add(ModBlocks.CHERRY_DOOR.get())
                .add(ModBlocks.CHERRY_SIGN.get())
                .add(ModBlocks.CHERRY_WALL_SIGN.get())
                .add(ModBlocks.CHERRY_TRAPDOOR.get())
        ;

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PYRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_PYRITE_ORE.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.ASPHALT.get())
                .add(ModBlocks.ZINC_ORE.get())
                .add(ModBlocks.DEEPSLATE_ZINC_ORE.get())
                .add(ModBlocks.RAW_ZINC_BLOCK.get())
                .add(ModBlocks.ZINC_BLOCK.get())
                .add(ModBlocks.MAGNESIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get())
                .add(ModBlocks.RAW_MAGNESIUM_BLOCK.get())
                .add(ModBlocks.MAGNESIUM_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.WHITE_CONCRETE_SLAB.get())
                .add(ModBlocks.ORANGE_CONCRETE_SLAB.get())
                .add(ModBlocks.MAGENTA_CONCRETE_SLAB.get())
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get())
                .add(ModBlocks.YELLOW_CONCRETE_SLAB.get())
                .add(ModBlocks.LIME_CONCRETE_SLAB.get())
                .add(ModBlocks.PINK_CONCRETE_SLAB.get())
                .add(ModBlocks.GRAY_CONCRETE_SLAB.get())
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get())
                .add(ModBlocks.CYAN_CONCRETE_SLAB.get())
                .add(ModBlocks.PURPLE_CONCRETE_SLAB.get())
                .add(ModBlocks.BLUE_CONCRETE_SLAB.get())
                .add(ModBlocks.BROWN_CONCRETE_SLAB.get())
                .add(ModBlocks.GREEN_CONCRETE_SLAB.get())
                .add(ModBlocks.RED_CONCRETE_SLAB.get())
                .add(ModBlocks.BLACK_CONCRETE_SLAB.get())
                .add(ModBlocks.WHITE_CONCRETE_STAIRS.get())
                .add(ModBlocks.ORANGE_CONCRETE_STAIRS.get())
                .add(ModBlocks.MAGENTA_CONCRETE_STAIRS.get())
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get())
                .add(ModBlocks.YELLOW_CONCRETE_STAIRS.get())
                .add(ModBlocks.LIME_CONCRETE_STAIRS.get())
                .add(ModBlocks.PINK_CONCRETE_STAIRS.get())
                .add(ModBlocks.GRAY_CONCRETE_STAIRS.get())
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get())
                .add(ModBlocks.CYAN_CONCRETE_STAIRS.get())
                .add(ModBlocks.PURPLE_CONCRETE_STAIRS.get())
                .add(ModBlocks.BLUE_CONCRETE_STAIRS.get())
                .add(ModBlocks.BROWN_CONCRETE_STAIRS.get())
                .add(ModBlocks.GREEN_CONCRETE_STAIRS.get())
                .add(ModBlocks.RED_CONCRETE_STAIRS.get())
                .add(ModBlocks.BLACK_CONCRETE_STAIRS.get())
                .add(ModBlocks.RAINBOW_BRICKS.get())
                .add(ModBlocks.WHITE_BRICKS.get())
                .add(ModBlocks.BLACK_BRICKS.get())
                .add(ModBlocks.RAINBOW_BRICK_SLAB.get())
                .add(ModBlocks.WHITE_BRICK_SLAB.get())
                .add(ModBlocks.BLACK_BRICK_SLAB.get())
                .add(ModBlocks.RAINBOW_BRICK_STAIRS.get())
                .add(ModBlocks.WHITE_BRICK_STAIRS.get())
                .add(ModBlocks.BLACK_BRICK_STAIRS.get())
                .add(ModBlocks.TERRACOTTA_STAIRS.get())
                .add(ModBlocks.RAINBOW_BRICK_WALL.get())
                .add(ModBlocks.WHITE_BRICK_WALL.get())
                .add(ModBlocks.BLACK_BRICK_WALL.get())
                .add(ModBlocks.WHITE_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.LIME_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.PINK_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.GRAY_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.CYAN_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.BLUE_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.BROWN_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.GREEN_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.RED_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.BLACK_TERRACOTTA_STAIRS.get())
                .add(ModBlocks.TERRACOTTA_SLAB.get())
                .add(ModBlocks.WHITE_TERRACOTTA_SLAB.get())
                .add(ModBlocks.ORANGE_TERRACOTTA_SLAB.get())
                .add(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get())
                .add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get())
                .add(ModBlocks.YELLOW_TERRACOTTA_SLAB.get())
                .add(ModBlocks.LIME_TERRACOTTA_SLAB.get())
                .add(ModBlocks.PINK_TERRACOTTA_SLAB.get())
                .add(ModBlocks.GRAY_TERRACOTTA_SLAB.get())
                .add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get())
                .add(ModBlocks.CYAN_TERRACOTTA_SLAB.get())
                .add(ModBlocks.PURPLE_TERRACOTTA_SLAB.get())
                .add(ModBlocks.BLUE_TERRACOTTA_SLAB.get())
                .add(ModBlocks.BROWN_TERRACOTTA_SLAB.get())
                .add(ModBlocks.GREEN_TERRACOTTA_SLAB.get())
                .add(ModBlocks.RED_TERRACOTTA_SLAB.get())
                .add(ModBlocks.BLACK_TERRACOTTA_SLAB.get())
        ;
        //endregion
        //region Needs <Level>
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ASPHALT.get())
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
        ;

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PYRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_PYRITE_ORE.get())
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
                .add(ModBlocks.ZINC_ORE.get())
                .add(ModBlocks.DEEPSLATE_ZINC_ORE.get())
                .add(ModBlocks.RAW_ZINC_BLOCK.get())
                .add(ModBlocks.ZINC_BLOCK.get())
                .add(ModBlocks.MAGNESIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get())
                .add(ModBlocks.RAW_MAGNESIUM_BLOCK.get())
                .add(ModBlocks.MAGNESIUM_BLOCK.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.RAW_SILVER_BLOCK.get())
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_ORE.get())
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
                .add(ModBlocks.RUBY_ORE.get())
                .add(ModBlocks.DEEPSLATE_RUBY_ORE.get())
                .add(ModBlocks.RUBY_BLOCK.get())
        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TITANIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
                .add(ModBlocks.RAW_TITANIUM_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
        ;
        //endregion
        //region Beacon
        this.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.SILVER_BLOCK.get())
                .add(ModBlocks.TITANIUM_BLOCK.get())
                .add(ModBlocks.RUBY_BLOCK.get())
                .add(ModBlocks.SAPPHIRE_BLOCK.get())
        ;
        //endregion
        //region Wood Types
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.CHERRY_PLANKS.get())
        ;

        this.tag(ModTags.Blocks.CHERRY_LOGS)
                .add(ModBlocks.CHERRY_LOG.get())
                .add(ModBlocks.STRIPPED_CHERRY_LOG.get())
                .add(ModBlocks.CHERRY_WOOD.get())
                .add(ModBlocks.STRIPPED_CHERRY_WOOD.get())
        ;

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.CHERRY_LOGS)
        ;
        //endregion
        //region Wood Stuffs
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.CHERRY_LEAVES.get())
        ;

        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.CHERRY_SAPLING.get())
        ;

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.CHERRY_STAIRS.get())
        ;

        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.CHERRY_SLAB.get())
        ;

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.CHERRY_FENCE.get())
        ;

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CHERRY_FENCE_GATE.get())
        ;

        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.CHERRY_DOOR.get())
        ;

        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CHERRY_TRAPDOOR.get())
        ;

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CHERRY_PRESSURE_PLATE.get())
        ;

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.CHERRY_BUTTON.get())
        ;

        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.CHERRY_SIGN.get())
        ;

        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.CHERRY_WALL_SIGN.get())
        ;
        //endregion
        this.tag(BlockTags.SLABS)
                .add(ModBlocks.WHITE_CONCRETE_SLAB.get())
                .add(ModBlocks.ORANGE_CONCRETE_SLAB.get())
                .add(ModBlocks.MAGENTA_CONCRETE_SLAB.get())
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get())
                .add(ModBlocks.YELLOW_CONCRETE_SLAB.get())
                .add(ModBlocks.LIME_CONCRETE_SLAB.get())
                .add(ModBlocks.PINK_CONCRETE_SLAB.get())
                .add(ModBlocks.GRAY_CONCRETE_SLAB.get())
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get())
                .add(ModBlocks.CYAN_CONCRETE_SLAB.get())
                .add(ModBlocks.PURPLE_CONCRETE_SLAB.get())
                .add(ModBlocks.BLUE_CONCRETE_SLAB.get())
                .add(ModBlocks.BROWN_CONCRETE_SLAB.get())
                .add(ModBlocks.GREEN_CONCRETE_SLAB.get())
                .add(ModBlocks.RED_CONCRETE_SLAB.get())
                .add(ModBlocks.BLACK_CONCRETE_SLAB.get())
                .add(ModBlocks.RAINBOW_BRICK_SLAB.get())
                .add(ModBlocks.WHITE_BRICK_SLAB.get())
                .add(ModBlocks.BLACK_BRICK_SLAB.get())
        ;

        this.tag(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_CHERRY_SAPLING.get())
        ;

        this.tag(BlockTags.STAIRS)
                .add(ModBlocks.WHITE_CONCRETE_STAIRS.get())
                .add(ModBlocks.ORANGE_CONCRETE_STAIRS.get())
                .add(ModBlocks.MAGENTA_CONCRETE_STAIRS.get())
                .add(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get())
                .add(ModBlocks.YELLOW_CONCRETE_STAIRS.get())
                .add(ModBlocks.LIME_CONCRETE_STAIRS.get())
                .add(ModBlocks.PINK_CONCRETE_STAIRS.get())
                .add(ModBlocks.GRAY_CONCRETE_STAIRS.get())
                .add(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get())
                .add(ModBlocks.CYAN_CONCRETE_STAIRS.get())
                .add(ModBlocks.PURPLE_CONCRETE_STAIRS.get())
                .add(ModBlocks.BLUE_CONCRETE_STAIRS.get())
                .add(ModBlocks.BROWN_CONCRETE_STAIRS.get())
                .add(ModBlocks.GREEN_CONCRETE_STAIRS.get())
                .add(ModBlocks.RED_CONCRETE_STAIRS.get())
                .add(ModBlocks.BLACK_CONCRETE_STAIRS.get())
                .add(ModBlocks.RAINBOW_BRICK_STAIRS.get())
                .add(ModBlocks.WHITE_BRICK_STAIRS.get())
                .add(ModBlocks.BLACK_BRICK_STAIRS.get())
        ;

        this.tag(BlockTags.WALLS)
                .add(ModBlocks.RAINBOW_BRICK_WALL.get())
                .add(ModBlocks.WHITE_BRICK_WALL.get())
                .add(ModBlocks.BLACK_BRICK_WALL.get())
        ;
    }
}
