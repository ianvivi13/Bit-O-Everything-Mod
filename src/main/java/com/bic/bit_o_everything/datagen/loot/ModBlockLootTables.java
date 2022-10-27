package com.bic.bit_o_everything.datagen.loot;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {
    private static float[] multiplyFloatArr(float multiple, float... array) {
        float[] newFloatArray = new float[array.length];
        int i = 0;
        for (float f : array) {
            newFloatArray[i] = array[i] * multiple;
            i ++;
        }
        return newFloatArray;
    }
    
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] NORMAL_LEAVES_APPLE_CHANCES = new float[]{0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F};
    private static final float[] NORMAL_LEAVES_FRUIT_CHANCES = multiplyFloatArr(6F, NORMAL_LEAVES_APPLE_CHANCES);
    private static final float[] EXTRA_LEAVES_FRUIT_CHANCES = multiplyFloatArr(2F, NORMAL_LEAVES_FRUIT_CHANCES);
    
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
    
    protected static LootTable.Builder createFruitLeavesDrops(Block leaves, Block sapling, ItemLike fruit, float... fruitChances) {
        return createLeavesDrops(leaves, sapling, NORMAL_LEAVES_SAPLING_CHANCES).withPool(
                LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionCondition(
                                leaves, LootItem.lootTableItem(fruit))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                        Enchantments.BLOCK_FORTUNE, fruitChances))));
    }
    
    @Override
    protected void addTables() {
        this.dropWhenSilkOrShearsOnly(ModBlocks.WILDBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.BLUEBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.GOOSEBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.RASPBERRY_BUSH.get());
        this.dropWhenSilkOrShearsOnly(ModBlocks.BLACKBERRY_BUSH.get());
        
        this.dropSelf(ModBlocks.TREE_TAP.get());
        
        this.dropSelf(ModBlocks.BLUE_LUNALIGHT.get());
        this.dropSelf(ModBlocks.PURPLE_LUNALIGHT.get());
        
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
        
        //region Cherry Woods
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
        this.add(ModBlocks.CHERRY_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.CHERRY_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CHERRY_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.CHERRY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_CHERRY_SAPLING.get());
        //endregion
        //region Maple Woods
        this.dropSelf(ModBlocks.MAPLE_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_LOG.get());
        this.dropSelf(ModBlocks.MAPLE_STAIRS.get());
        this.dropSelf(ModBlocks.MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE.get());
        this.dropSelf(ModBlocks.MAPLE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.MAPLE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.MAPLE_BUTTON.get());
        this.dropSelf(ModBlocks.MAPLE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.MAPLE_SIGN.get());
        this.dropSelf(ModBlocks.MAPLE_WALL_SIGN.get());
        this.dropSelf(ModBlocks.MAPLE_SAPLING.get());
        this.add(ModBlocks.MAPLE_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.MAPLE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.MAPLE_LEAVES_RED.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.MAPLE_LEAVES_ORANGE.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_MAPLE_SAPLING.get());
        //endregion
        //region Dogwood Woods
        this.dropSelf(ModBlocks.DOGWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_DOGWOOD_LOG.get());
        this.dropSelf(ModBlocks.DOGWOOD_LOG.get());
        this.dropSelf(ModBlocks.DOGWOOD_STAIRS.get());
        this.dropSelf(ModBlocks.DOGWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DOGWOOD_WOOD.get());
        this.dropSelf(ModBlocks.DOGWOOD_FENCE.get());
        this.dropSelf(ModBlocks.DOGWOOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.DOGWOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.DOGWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.DOGWOOD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DOGWOOD_SIGN.get());
        this.dropSelf(ModBlocks.DOGWOOD_WALL_SIGN.get());
        this.dropSelf(ModBlocks.DOGWOOD_SAPLING.get());
        this.add(ModBlocks.DOGWOOD_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.DOGWOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.DOGWOOD_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.DOGWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_DOGWOOD_SAPLING.get());
        //endregion
        //region Redwood Woods
        this.dropSelf(ModBlocks.REDWOOD_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_REDWOOD_LOG.get());
        this.dropSelf(ModBlocks.REDWOOD_LOG.get());
        this.dropSelf(ModBlocks.REDWOOD_STAIRS.get());
        this.dropSelf(ModBlocks.REDWOOD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_REDWOOD_WOOD.get());
        this.dropSelf(ModBlocks.REDWOOD_FENCE.get());
        this.dropSelf(ModBlocks.REDWOOD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.REDWOOD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.REDWOOD_BUTTON.get());
        this.dropSelf(ModBlocks.REDWOOD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.REDWOOD_SIGN.get());
        this.dropSelf(ModBlocks.REDWOOD_WALL_SIGN.get());
        this.dropSelf(ModBlocks.REDWOOD_SAPLING.get());
        this.add(ModBlocks.REDWOOD_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.REDWOOD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.REDWOOD_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.REDWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_REDWOOD_SAPLING.get());
        //endregion
        //region Olive Woods
        this.dropSelf(ModBlocks.OLIVE_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_LOG.get());
        this.dropSelf(ModBlocks.OLIVE_LOG.get());
        this.dropSelf(ModBlocks.OLIVE_STAIRS.get());
        this.dropSelf(ModBlocks.OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_OLIVE_WOOD.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE.get());
        this.dropSelf(ModBlocks.OLIVE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.OLIVE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.OLIVE_BUTTON.get());
        this.dropSelf(ModBlocks.OLIVE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.OLIVE_SIGN.get());
        this.dropSelf(ModBlocks.OLIVE_WALL_SIGN.get());
        this.dropSelf(ModBlocks.OLIVE_SAPLING.get());
        this.add(ModBlocks.OLIVE_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.OLIVE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.OLIVE_LEAVES.get(), (p_124096_) -> createFruitLeavesDrops(p_124096_, ModBlocks.OLIVE_SAPLING.get(), ModItems.OLIVES.get(), EXTRA_LEAVES_FRUIT_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_OLIVE_SAPLING.get());
        //endregion
        //region Peach Woods
        this.dropSelf(ModBlocks.PEACH_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_PEACH_LOG.get());
        this.dropSelf(ModBlocks.PEACH_LOG.get());
        this.dropSelf(ModBlocks.PEACH_STAIRS.get());
        this.dropSelf(ModBlocks.PEACH_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PEACH_WOOD.get());
        this.dropSelf(ModBlocks.PEACH_FENCE.get());
        this.dropSelf(ModBlocks.PEACH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PEACH_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PEACH_BUTTON.get());
        this.dropSelf(ModBlocks.PEACH_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PEACH_SIGN.get());
        this.dropSelf(ModBlocks.PEACH_WALL_SIGN.get());
        this.dropSelf(ModBlocks.PEACH_SAPLING.get());
        this.add(ModBlocks.PEACH_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.PEACH_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PEACH_LEAVES.get(), (p_124096_) -> createFruitLeavesDrops(p_124096_, ModBlocks.PEACH_SAPLING.get(), ModItems.PEACH.get(), NORMAL_LEAVES_FRUIT_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_PEACH_SAPLING.get());
        //endregion
        //region Ebony Woods
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_STAIRS.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_FENCE.get());
        this.dropSelf(ModBlocks.EBONY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.EBONY_TRAPDOOR.get());
        this.dropSelf(ModBlocks.EBONY_BUTTON.get());
        this.dropSelf(ModBlocks.EBONY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.EBONY_SIGN.get());
        this.dropSelf(ModBlocks.EBONY_WALL_SIGN.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());
        this.add(ModBlocks.EBONY_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.EBONY_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.EBONY_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_EBONY_SAPLING.get());
        //endregion
        //region Plum Woods
        this.dropSelf(ModBlocks.PLUM_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_PLUM_LOG.get());
        this.dropSelf(ModBlocks.PLUM_LOG.get());
        this.dropSelf(ModBlocks.PLUM_STAIRS.get());
        this.dropSelf(ModBlocks.PLUM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PLUM_WOOD.get());
        this.dropSelf(ModBlocks.PLUM_FENCE.get());
        this.dropSelf(ModBlocks.PLUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PLUM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PLUM_BUTTON.get());
        this.dropSelf(ModBlocks.PLUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PLUM_SIGN.get());
        this.dropSelf(ModBlocks.PLUM_WALL_SIGN.get());
        this.dropSelf(ModBlocks.PLUM_SAPLING.get());
        this.add(ModBlocks.PLUM_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.PLUM_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PLUM_LEAVES.get(), (p_124096_) -> createFruitLeavesDrops(p_124096_, ModBlocks.PLUM_SAPLING.get(), ModItems.PLUM.get(), NORMAL_LEAVES_FRUIT_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_PLUM_SAPLING.get());
        //endregion
        //region Orange Woods
        this.dropSelf(ModBlocks.ORANGE_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_ORANGE_LOG.get());
        this.dropSelf(ModBlocks.ORANGE_LOG.get());
        this.dropSelf(ModBlocks.ORANGE_STAIRS.get());
        this.dropSelf(ModBlocks.ORANGE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ORANGE_WOOD.get());
        this.dropSelf(ModBlocks.ORANGE_FENCE.get());
        this.dropSelf(ModBlocks.ORANGE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ORANGE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ORANGE_BUTTON.get());
        this.dropSelf(ModBlocks.ORANGE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ORANGE_SIGN.get());
        this.dropSelf(ModBlocks.ORANGE_WALL_SIGN.get());
        this.dropSelf(ModBlocks.ORANGE_SAPLING.get());
        this.add(ModBlocks.ORANGE_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.ORANGE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.ORANGE_LEAVES.get(), (p_124096_) -> createFruitLeavesDrops(p_124096_, ModBlocks.ORANGE_SAPLING.get(), ModItems.ORANGE.get(), NORMAL_LEAVES_FRUIT_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_ORANGE_SAPLING.get());
        //endregion
        //region Infected Woods
        this.dropSelf(ModBlocks.INFECTED_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_INFECTED_LOG.get());
        this.dropSelf(ModBlocks.INFECTED_LOG.get());
        this.dropSelf(ModBlocks.INFECTED_STAIRS.get());
        this.dropSelf(ModBlocks.INFECTED_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_INFECTED_WOOD.get());
        this.dropSelf(ModBlocks.INFECTED_FENCE.get());
        this.dropSelf(ModBlocks.INFECTED_FENCE_GATE.get());
        this.dropSelf(ModBlocks.INFECTED_TRAPDOOR.get());
        this.dropSelf(ModBlocks.INFECTED_BUTTON.get());
        this.dropSelf(ModBlocks.INFECTED_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.INFECTED_SIGN.get());
        this.dropSelf(ModBlocks.INFECTED_WALL_SIGN.get());
        this.dropSelf(ModBlocks.INFECTED_SAPLING.get());
        this.add(ModBlocks.INFECTED_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.INFECTED_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.INFECTED_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.INFECTED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_INFECTED_SAPLING.get());
        //endregion
        //region Corrupt Woods
        this.dropSelf(ModBlocks.CORRUPT_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_CORRUPT_LOG.get());
        this.dropSelf(ModBlocks.CORRUPT_LOG.get());
        this.dropSelf(ModBlocks.CORRUPT_STAIRS.get());
        this.dropSelf(ModBlocks.CORRUPT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CORRUPT_WOOD.get());
        this.dropSelf(ModBlocks.CORRUPT_FENCE.get());
        this.dropSelf(ModBlocks.CORRUPT_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CORRUPT_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CORRUPT_BUTTON.get());
        this.dropSelf(ModBlocks.CORRUPT_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CORRUPT_SIGN.get());
        this.dropSelf(ModBlocks.CORRUPT_WALL_SIGN.get());
        this.dropSelf(ModBlocks.CORRUPT_SAPLING.get());
        this.add(ModBlocks.CORRUPT_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.CORRUPT_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CORRUPT_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.CORRUPT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_CORRUPT_SAPLING.get());
        //endregion
        //region Pear Woods
        this.dropSelf(ModBlocks.PEAR_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_PEAR_LOG.get());
        this.dropSelf(ModBlocks.PEAR_LOG.get());
        this.dropSelf(ModBlocks.PEAR_STAIRS.get());
        this.dropSelf(ModBlocks.PEAR_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_PEAR_WOOD.get());
        this.dropSelf(ModBlocks.PEAR_FENCE.get());
        this.dropSelf(ModBlocks.PEAR_FENCE_GATE.get());
        this.dropSelf(ModBlocks.PEAR_TRAPDOOR.get());
        this.dropSelf(ModBlocks.PEAR_BUTTON.get());
        this.dropSelf(ModBlocks.PEAR_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.PEAR_SIGN.get());
        this.dropSelf(ModBlocks.PEAR_WALL_SIGN.get());
        this.dropSelf(ModBlocks.PEAR_SAPLING.get());
        this.add(ModBlocks.PEAR_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.PEAR_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.PEAR_LEAVES.get(), (p_124096_) -> createFruitLeavesDrops(p_124096_, ModBlocks.PEAR_SAPLING.get(), ModItems.PEAR.get(), NORMAL_LEAVES_FRUIT_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_PEAR_SAPLING.get());
        //endregion
        //region Wisteria Woods
        this.dropSelf(ModBlocks.WISTERIA_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_WISTERIA_LOG.get());
        this.dropSelf(ModBlocks.WISTERIA_LOG.get());
        this.dropSelf(ModBlocks.WISTERIA_STAIRS.get());
        this.dropSelf(ModBlocks.WISTERIA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WISTERIA_WOOD.get());
        this.dropSelf(ModBlocks.WISTERIA_FENCE.get());
        this.dropSelf(ModBlocks.WISTERIA_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WISTERIA_TRAPDOOR.get());
        this.dropSelf(ModBlocks.WISTERIA_BUTTON.get());
        this.dropSelf(ModBlocks.WISTERIA_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WISTERIA_SIGN.get());
        this.dropSelf(ModBlocks.WISTERIA_WALL_SIGN.get());
        this.dropSelf(ModBlocks.WISTERIA_SAPLING.get());
        this.add(ModBlocks.WISTERIA_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.WISTERIA_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.WISTERIA_LEAVES_BLUE.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.WISTERIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.WISTERIA_LEAVES_PURPLE.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.WISTERIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_WISTERIA_SAPLING.get());
        //endregion
        //region Charred Woods
        this.dropSelf(ModBlocks.CHARRED_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_CHARRED_LOG.get());
        this.dropSelf(ModBlocks.CHARRED_LOG.get());
        this.dropSelf(ModBlocks.CHARRED_STAIRS.get());
        this.dropSelf(ModBlocks.CHARRED_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CHARRED_WOOD.get());
        this.dropSelf(ModBlocks.CHARRED_FENCE.get());
        this.dropSelf(ModBlocks.CHARRED_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CHARRED_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CHARRED_BUTTON.get());
        this.dropSelf(ModBlocks.CHARRED_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CHARRED_SIGN.get());
        this.dropSelf(ModBlocks.CHARRED_WALL_SIGN.get());
        this.dropSelf(ModBlocks.CHARRED_SAPLING.get());
        this.add(ModBlocks.CHARRED_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.CHARRED_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.CHARRED_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.CHARRED_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_CHARRED_SAPLING.get());
        //endregion
        //region Ice Woods
        this.dropSelf(ModBlocks.ICE_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_ICE_LOG.get());
        this.dropSelf(ModBlocks.ICE_LOG.get());
        this.dropSelf(ModBlocks.ICE_STAIRS.get());
        this.dropSelf(ModBlocks.ICE_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ICE_WOOD.get());
        this.dropSelf(ModBlocks.ICE_FENCE.get());
        this.dropSelf(ModBlocks.ICE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ICE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ICE_BUTTON.get());
        this.dropSelf(ModBlocks.ICE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ICE_SIGN.get());
        this.dropSelf(ModBlocks.ICE_WALL_SIGN.get());
        this.dropSelf(ModBlocks.ICE_SAPLING.get());
        this.add(ModBlocks.ICE_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.ICE_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.ICE_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.ICE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_ICE_SAPLING.get());
        //endregion
        //region Dead Woods
        this.dropSelf(ModBlocks.DEAD_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_DEAD_LOG.get());
        this.dropSelf(ModBlocks.DEAD_LOG.get());
        this.dropSelf(ModBlocks.DEAD_STAIRS.get());
        this.dropSelf(ModBlocks.DEAD_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_DEAD_WOOD.get());
        this.dropSelf(ModBlocks.DEAD_FENCE.get());
        this.dropSelf(ModBlocks.DEAD_FENCE_GATE.get());
        this.dropSelf(ModBlocks.DEAD_TRAPDOOR.get());
        this.dropSelf(ModBlocks.DEAD_BUTTON.get());
        this.dropSelf(ModBlocks.DEAD_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.DEAD_SIGN.get());
        this.dropSelf(ModBlocks.DEAD_WALL_SIGN.get());
        this.dropSelf(ModBlocks.DEAD_SAPLING.get());
        this.add(ModBlocks.DEAD_DOOR.get(), BlockLoot::createDoorTable);
        this.add(ModBlocks.DEAD_SLAB.get(), BlockLoot::createSlabItemTable);
        this.add(ModBlocks.DEAD_LEAVES.get(), (p_124096_) -> createLeavesDrops(p_124096_, ModBlocks.DEAD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(ModBlocks.POTTED_DEAD_SAPLING.get());
        //endregion
        
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

        
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
