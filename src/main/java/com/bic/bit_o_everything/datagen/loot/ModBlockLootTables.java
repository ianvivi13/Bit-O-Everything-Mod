package com.bic.bit_o_everything.datagen.loot;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
    private static final LootItemCondition.Builder HAS_NO_SILK_TOUCH = HAS_SILK_TOUCH.invert();
    private static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    protected static LootTable.Builder createModifiedOreDrops(Block p_176051_, Item pItem, float min, float max) {
        return createSilkTouchDispatchTable(p_176051_, applyExplosionDecay(p_176051_, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createSilkOrShearsOnly(Block block) {
        return LootTable.lootTable().withPool(LootPool.lootPool().when(HAS_SHEARS_OR_SILK_TOUCH).setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block)));
    }

    protected void dropWhenSilkOrShearsOnly(Block block) {
        this.add(block, this.createSilkOrShearsOnly(block));
    }

    @Override
    protected void addTables() {
        this.dropWhenSilkOrShearsOnly(ModBlocks.WILDBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.BLUEBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.GOOSEBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.RASPBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.BLACKBERRY_BUSH.get());

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
        this.dropSelf(ModBlocks.SILICON_BLOCK.get());
        this.dropSelf(ModBlocks.LEAD_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_LEAD_BLOCK.get());
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

        this.add(ModBlocks.UNOBTAINIUM_ORE.get(), (block) -> createSingleItemTableWithSilkTouch(block, ModItems.UNOBTAINIUM_DUST.get()));

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

        this.dropSelf(ModBlocks.CELESTITE_BLOCK.get());
        this.dropSelf(ModBlocks.CITRINE_BLOCK.get());
        this.dropSelf(ModBlocks.RHODOCHROSITE_BLOCK.get());
        this.dropSelf(ModBlocks.MOLDAVITE_BLOCK.get());
        this.dropSelf(ModBlocks.AQUAMARINE_BLOCK.get());
        this.dropSelf(ModBlocks.TANZANITE_BLOCK.get());

        this.dropSelf(ModBlocks.ALUMINUM_BLOCK.get());
        this.dropSelf(ModBlocks.BRASS_BLOCK.get());
        this.dropSelf(ModBlocks.BRONZE_BLOCK.get());
        this.dropSelf(ModBlocks.ELECTRUM_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.CRYSTALLINE_BLOCK.get());
        this.dropSelf(ModBlocks.DRACONIUM_BLOCK.get());

        this.dropSelf(ModBlocks.ROSALITE_BLOCK.get());
        this.add(ModBlocks.BASALT_ROSALITE_ORE.get(), (block) -> createOreDrop(ModBlocks.BASALT_ROSALITE_ORE.get(), ModItems.ROSALITE.get()));

        this.add(ModBlocks.RAINBOW_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.WHITE_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.BLACK_BRICK_SLAB.get(), BlockLoot::createSlabItemTable);

        this.add(ModBlocks.CHERRY_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.CHERRY_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CHERRY_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.CHERRY_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.CHERRY_LEAVES.get())); //TEMPORARY

        this.add(ModBlocks.SILICON_ORE.get(), (block) -> createModifiedOreDrops(ModBlocks.SILICON_ORE.get(), ModItems.UNREFINED_SILICON.get(), 1.0F, 3.0F));
        this.add(ModBlocks.RED_SILICON_ORE.get(), (block) -> createModifiedOreDrops(ModBlocks.RED_SILICON_ORE.get(), ModItems.RED_UNREFINED_SILICON.get(), 1.0F, 3.0F));

        this.add(ModBlocks.CELESTITE.get(), (block) -> createModifiedOreDrops(ModBlocks.CELESTITE.get(), ModItems.CELESTITE_SHARD.get(), 1f, 3f));
        this.add(ModBlocks.CITRINE.get(), (block) -> createModifiedOreDrops(ModBlocks.CITRINE.get(), ModItems.CITRINE_SHARD.get(), 1f, 3f));
        this.add(ModBlocks.AQUAMARINE.get(), (block) -> createModifiedOreDrops(ModBlocks.AQUAMARINE.get(), ModItems.AQUAMARINE_SHARD.get(), 1f, 3f));
        this.add(ModBlocks.RHODOCHROSITE.get(), (block) -> createModifiedOreDrops(ModBlocks.RHODOCHROSITE.get(), ModItems.RHODOCHROSITE_SHARD.get(), 1f, 3f));
        this.add(ModBlocks.MOLDAVITE.get(), (block) -> createModifiedOreDrops(ModBlocks.MOLDAVITE.get(), ModItems.MOLDAVITE_SHARD.get(), 1f, 3f));
        this.add(ModBlocks.TANZANITE.get(), (block) -> createModifiedOreDrops(ModBlocks.TANZANITE.get(), ModItems.TANZANITE_SHARD.get(), 1f, 3f));

        //Smoky Quartz
        this.dropSelf(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get());
        this.dropSelf(ModBlocks.SMOKY_QUARTZ_BRICKS.get());
        this.dropSelf(ModBlocks.SMOOTH_SMOKY_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get());
        this.dropSelf(ModBlocks.SMOKY_QUARTZ_PILLAR.get());
        this.dropSelf(ModBlocks.SMOKY_QUARTZ_STAIRS.get());
        this.dropSelf(ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.get());
        this.add(ModBlocks.SMOKY_QUARTZ_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.SMOKY_QUARTZ_ORE.get(), (block) -> createOreDrop(ModBlocks.SMOKY_QUARTZ_ORE.get(), ModItems.SMOKY_QUARTZ.get()));

        this.dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        this.add(ModBlocks.BISMUTH_ORE.get(), (block) -> createOreDrop(ModBlocks.BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.DEEPSLATE_BISMUTH_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.GRANITE_BISMUTH_ORE.get(), (block) -> createOreDrop(ModBlocks.GRANITE_BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.TUFF_BISMUTH_ORE.get(), (block) -> createOreDrop(ModBlocks.TUFF_BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.ANDESITE_BISMUTH_ORE.get(), (block) -> createOreDrop(ModBlocks.ANDESITE_BISMUTH_ORE.get(), ModItems.BISMUTH.get()));
        this.add(ModBlocks.DIORITE_BISMUTH_ORE.get(), (block) -> createOreDrop(ModBlocks.DIORITE_BISMUTH_ORE.get(), ModItems.BISMUTH.get()));

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
        this.add(ModBlocks.DEEPSLATE_LEAD_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        this.add(ModBlocks.LEAD_ORE.get(), (block) -> createModifiedOreDrops(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get(), 1.0F, 3.0F));
        this.add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.TITANIUM_ORE.get(), (block) -> createOreDrop(ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get()));
        this.add(ModBlocks.DEEPSLATE_RUBY_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.RUBY_ORE.get(), (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), (block) -> createOreDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));
        this.add(ModBlocks.SAPPHIRE_ORE.get(), (block) -> createOreDrop(ModBlocks.SAPPHIRE_ORE.get(), ModItems.SAPPHIRE.get()));

        this.dropSelf(ModBlocks.POTTER.get());
        this.dropSelf(ModBlocks.CONCRETE_POTTER.get());
        this.dropSelf(ModBlocks.INDICATOR_LEVER.get());

        //region Concrete
        //region Concrete Stairs
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
        //endregion
        //region Concrete Slabs
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
        //endregion
        //region Concrete Walls
        this.dropSelf(ModBlocks.WHITE_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.ORANGE_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.MAGENTA_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.YELLOW_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.LIME_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.PINK_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.GRAY_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.CYAN_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.PURPLE_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.BLUE_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.BROWN_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.GREEN_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.RED_CONCRETE_WALL.get());
        this.dropSelf(ModBlocks.BLACK_CONCRETE_WALL.get());
        //endregion
        //endregion
        //region Terracotta
        //region Terracotta Stairs
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
        //endregion
        //region Terracotta Slabs
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
        //endregion
        //region Terracotta Walls
        this.dropSelf(ModBlocks.TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.WHITE_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.ORANGE_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.MAGENTA_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.YELLOW_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.LIME_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.PINK_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.GRAY_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.CYAN_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.PURPLE_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.BLUE_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.BROWN_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.GREEN_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.RED_TERRACOTTA_WALL.get());
        this.dropSelf(ModBlocks.BLACK_TERRACOTTA_WALL.get());
        //endregion
        //endregion

        this.dropPottedContents(ModBlocks.POTTED_CHERRY_SAPLING.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
