package com.bic.bit_o_everything.datagen.loot;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    @Override
    protected void addTables() {
        this.dropSelf(ModBlocks.PYRITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_PYRITE_BLOCK.get());
        this.dropSelf(ModBlocks.ZINC_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ZINC_BLOCK.get());
        this.dropSelf(ModBlocks.MAGNESIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_MAGNESIUM_BLOCK.get());
        this.dropSelf(ModBlocks.SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_SILVER_BLOCK.get());
        this.dropSelf(ModBlocks.TIN_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TIN_BLOCK.get());
        this.dropSelf(ModBlocks.TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_TITANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RUBY_BLOCK.get());
        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ModBlocks.ASPHALT.get());
        this.dropSelf(ModBlocks.JUMP_BLOCK.get());
        this.dropSelf(ModBlocks.RAINBOW_BRICKS.get());
        this.dropSelf(ModBlocks.WHITE_BRICKS.get());
        this.dropSelf(ModBlocks.BLACK_BRICKS.get());
        this.dropSelf(ModBlocks.RAINBOW_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.WHITE_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.BLACK_BRICK_STAIRS.get());
        this.dropSelf(ModBlocks.RAINBOW_BRICK_WALL.get());
        this.dropSelf(ModBlocks.WHITE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.BLACK_BRICK_WALL.get());

        this.dropSelf(ModBlocks.CHERRY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_LOG.get());
        this.dropSelf(ModBlocks.CHERRY_LOG.get());
        this.dropSelf(ModBlocks.CHERRY_STAIRS.get());
        this.dropSelf(ModBlocks.CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CHERRY_WOOD.get());
        this.dropSelf(ModBlocks.CHERRY_FENCE.get());
        this.dropSelf(ModBlocks.CHERRY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CHERRY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CHERRY_BUTTON.get());
        this.dropSelf(ModBlocks.CHERRY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CHERRY_SIGN.get());
        this.dropSelf(ModBlocks.CHERRY_WALL_SIGN.get());
        this.dropSelf(ModBlocks.CHERRY_SAPLING.get());

        this.dropSelf(ModBlocks.WHITE_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.LIME_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.PINK_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.GRAY_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.CYAN_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.BLUE_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.BROWN_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.GREEN_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.RED_CONCRETE_STAIRS.get());
        this.dropSelf(ModBlocks.BLACK_CONCRETE_STAIRS.get());

        this.add(ModBlocks.WHITE_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.ORANGE_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.MAGENTA_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.YELLOW_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.LIME_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PINK_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.GRAY_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CYAN_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PURPLE_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BLUE_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BROWN_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.GREEN_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.RED_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BLACK_CONCRETE_SLAB.get(), BlockLoot::createSlabItemTable);

        this.add(ModBlocks.RAINBOW_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.WHITE_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BLACK_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);

        this.add(ModBlocks.CHERRY_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.CHERRY_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CHERRY_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.DEEPSLATE_PYRITE_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_PYRITE_ORE.get(), ModItems.RAW_PYRITE.get()));
        this.add(ModBlocks.PYRITE_ORE.get(), (block) -> createOreDrop(ModBlocks.PYRITE_ORE.get(), ModItems.RAW_PYRITE.get()));
        this.add(ModBlocks.DEEPSLATE_ZINC_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_ZINC_ORE.get(), ModItems.RAW_ZINC.get()));
        this.add(ModBlocks.ZINC_ORE.get(), (block) -> createOreDrop(ModBlocks.ZINC_ORE.get(), ModItems.RAW_ZINC.get()));
        this.add(ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get(), ModItems.RAW_MAGNESIUM.get()));
        this.add(ModBlocks.MAGNESIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.MAGNESIUM_ORE.get(), ModItems.RAW_MAGNESIUM.get()));
        this.add(ModBlocks.DEEPSLATE_SILVER_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.SILVER_ORE.get(), (block) -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        this.add(ModBlocks.DEEPSLATE_TIN_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));
        this.add(ModBlocks.TIN_ORE.get(), (block) -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
        this.add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.TITANIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.RUBY_ORE.get(), (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.SAPPHIRE_ORE.get(), (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        this.dropSelf(ModBlocks.POTTER.get());
        this.dropSelf(ModBlocks.CONCRETE_POTTER.get());
        this.dropSelf(ModBlocks.INDICATOR_LEVER.get());

        this.add(ModBlocks.TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.WHITE_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.ORANGE_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.MAGENTA_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.YELLOW_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.LIME_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PINK_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.GRAY_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CYAN_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PURPLE_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BLUE_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BROWN_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.GREEN_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.RED_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BLACK_TERRACOTTA_SLAB.get(), BlockLoot::createSlabItemTable);

        this.dropSelf(ModBlocks.TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.WHITE_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.YELLOW_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.LIME_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.PINK_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.GRAY_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.CYAN_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.PURPLE_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.BLUE_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.BROWN_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.GREEN_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.RED_TERRACOTTA_STAIRS.get());
        this.dropSelf(ModBlocks.BLACK_TERRACOTTA_STAIRS.get());

        this.dropPottedContents(ModBlocks.POTTED_CHERRY_SAPLING.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
