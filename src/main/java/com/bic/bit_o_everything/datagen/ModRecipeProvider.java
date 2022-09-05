package com.bic.bit_o_everything.datagen;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    private static final int BlastFurnaceTime = 100;
    private static final int CampfireTime = 600;
    private static final int FurnaceTime = 200;
    private static final int SmokerTime = 100;

    //region Helper Functions
    protected void Compact(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike in, ItemLike out) {
        ShapedRecipeBuilder.shaped(out)
                .define('#', in)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());

        ShapelessRecipeBuilder.shapeless(in, 9)
                .requires(out)
                .unlockedBy("has_" + out.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(out).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + in.asItem() + "_from_" + out.asItem());
    }

    protected void SmallCompact(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike in, ItemLike out) {
        ShapedRecipeBuilder.shaped(out)
                .define('#', in)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());

        ShapelessRecipeBuilder.shapeless(in, 4)
                .requires(out)
                .unlockedBy("has_" + out.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(out).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + in.asItem() + "_from_" + out.asItem());
    }

    protected void FurnaceCampSmoke(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, float xp, ItemLike ... inList) {
        for (ItemLike in: inList) {
            FurnaceCampSmoke(pFinishedRecipeConsumer, out, xp, in);
        }
    }

    protected void FurnaceBlast(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, float xp, ItemLike ... inList) {
        for (ItemLike in: inList) {
            FurnaceBlast(pFinishedRecipeConsumer, out, xp, in);
        }
    }

    protected void FurnaceBlast(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, float xp, ItemLike in) {
        String unlockName = "has" + in;
        String baseRecipeName = "bit_o_everything:" + out.asItem() + "_from_" + in.asItem() + "_in_";

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, xp, FurnaceTime)
                .unlockedBy(unlockName, inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, baseRecipeName + "furnace");

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(in), out, xp, BlastFurnaceTime)
                .unlockedBy(unlockName, inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, baseRecipeName + "blastfurnace");
    }

    protected void FurnaceCampSmoke(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, float xp, ItemLike in) {
        String unlockName = "has" + in;
        String baseRecipeName = "bit_o_everything:" + out.asItem() + "_from_" + in.asItem() + "_in_";

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(in), out, xp, FurnaceTime)
                .unlockedBy(unlockName, inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, baseRecipeName + "furnace");

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(in), out, xp, CampfireTime)
                .unlockedBy(unlockName, inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, baseRecipeName + "campfire");

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(in), out, xp, SmokerTime)
                .unlockedBy(unlockName, inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, baseRecipeName + "smoker");
    }

    // wood style stuffs
    protected void Door(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 3)
                .define('#', in)
                .pattern("##")
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Trapdoor(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 2)
                .define('#', in)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Fence(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 3)
                .define('#', in)
                .define('I', Items.STICK)
                .pattern("#I#")
                .pattern("#I#")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Fencegate(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out)
                .define('I', in)
                .define('#', Items.STICK)
                .pattern("#I#")
                .pattern("#I#")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Sign(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 3)
                .define('#', in)
                .define('I', Items.STICK)
                .pattern("###")
                .pattern("###")
                .pattern(" I ")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Boat(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out)
                .define('#', in)
                .pattern("# #")
                .pattern("###")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Chestboat(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapelessRecipeBuilder.shapeless(out, 1)
                .requires(in)
                .requires(Items.CHEST)
                .unlockedBy("has_" + out.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(out).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void OneToX(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in, int x) {
        ShapelessRecipeBuilder.shapeless(out, x)
                .requires(in)
                .unlockedBy("has_" + out.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(out).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Pressureplate(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out)
                .define('#', in)
                .pattern("##")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Slab(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 6)
                .define('#', in)
                .pattern("###")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Wall(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 6)
                .define('#', in)
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Stair(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 4)
                .define('#', in)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void LogToWood(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike in) {
        ShapedRecipeBuilder.shaped(out, 3)
                .define('#', in)
                .pattern("##")
                .pattern("##")
                .unlockedBy("has_" + in.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(in).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + in.asItem());
    }

    protected void Surround(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike center, ItemLike outside, int quantity) {
        ShapedRecipeBuilder.shaped(out, quantity)
                .define('#', outside)
                .define('C', center)
                .pattern("###")
                .pattern("#C#")
                .pattern("###")
                .unlockedBy("has_" + outside.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(outside).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + center.asItem() + "_and_" + outside.asItem());
    }

    protected void AllWoodRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike log, ItemLike strippedLog,
                                  ItemLike wood, ItemLike strippedWood, ItemLike plank, ItemLike stair, ItemLike slab,
                                  ItemLike fence, ItemLike fenceGate, ItemLike door, ItemLike trapdoor, ItemLike sign,
                                  ItemLike button, ItemLike pressurePlate, ItemLike boat, ItemLike chestBoat) {

        LogToWood(pFinishedRecipeConsumer, wood, log);
        LogToWood(pFinishedRecipeConsumer, strippedWood, strippedLog);
        OneToX(pFinishedRecipeConsumer, plank, log, 4);
        OneToX(pFinishedRecipeConsumer, plank, strippedLog, 4);
        OneToX(pFinishedRecipeConsumer, plank, wood, 4);
        OneToX(pFinishedRecipeConsumer, plank, strippedWood, 4);
        Stair(pFinishedRecipeConsumer, stair, plank);
        Slab(pFinishedRecipeConsumer, slab, plank);
        Fence(pFinishedRecipeConsumer, fence, plank);
        Fencegate(pFinishedRecipeConsumer, fenceGate, plank);
        Door(pFinishedRecipeConsumer, door, plank);
        Trapdoor(pFinishedRecipeConsumer, trapdoor, plank);
        Sign(pFinishedRecipeConsumer, sign, plank);
        OneToX(pFinishedRecipeConsumer, button, plank,1);
        Pressureplate(pFinishedRecipeConsumer, pressurePlate, plank);
        Boat(pFinishedRecipeConsumer, boat, plank);
        Chestboat(pFinishedRecipeConsumer, chestBoat, boat);
    }

    protected void horseArmor(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ItemLike out, ItemLike material) {
        ShapedRecipeBuilder.shaped(out)
                .define('L', Items.LEATHER)
                .define('M', material)
                .pattern("M M")
                .pattern("MLM")
                .pattern("M M")
                .unlockedBy("has_" + material.asItem(), inventoryTrigger(ItemPredicate.Builder.item().of(material).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:" + out.asItem() + "_from_" + material.asItem());
    }
    //endregion

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        /*  crafting recipes are easier
            Compact: 9 in make out, 1 out makes 9 in
         */

        /* smelting recipes are easier:
            FurnaceBlast: creates furnace & blasting recipes
            FurnaceCampSmoke: creates furnace & campfire & smoking recipes
            Both of these can take an extension of parameters of inputs to make multiple for the same output - good for ores
        */

        //region Terracotta
        slab(pFinishedRecipeConsumer, ModBlocks.TERRACOTTA_SLAB.get(), Blocks.TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.WHITE_TERRACOTTA_SLAB.get(), Blocks.WHITE_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.ORANGE_TERRACOTTA_SLAB.get(), Blocks.ORANGE_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.MAGENTA_TERRACOTTA_SLAB.get(), Blocks.MAGENTA_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.YELLOW_TERRACOTTA_SLAB.get(), Blocks.YELLOW_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.LIME_TERRACOTTA_SLAB.get(), Blocks.LIME_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.PINK_TERRACOTTA_SLAB.get(), Blocks.PINK_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.GRAY_TERRACOTTA_SLAB.get(), Blocks.GRAY_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.CYAN_TERRACOTTA_SLAB.get(), Blocks.CYAN_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.PURPLE_TERRACOTTA_SLAB.get(), Blocks.PURPLE_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.BLUE_TERRACOTTA_SLAB.get(), Blocks.BLUE_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.BROWN_TERRACOTTA_SLAB.get(), Blocks.BROWN_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.GREEN_TERRACOTTA_SLAB.get(), Blocks.GREEN_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.RED_TERRACOTTA_SLAB.get(), Blocks.RED_TERRACOTTA);
        slab(pFinishedRecipeConsumer, ModBlocks.BLACK_TERRACOTTA_SLAB.get(), Blocks.BLACK_TERRACOTTA);

        Stair(pFinishedRecipeConsumer, ModBlocks.TERRACOTTA_STAIRS.get(), Blocks.TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.WHITE_TERRACOTTA_STAIRS.get(), Blocks.WHITE_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.ORANGE_TERRACOTTA_STAIRS.get(), Blocks.ORANGE_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.MAGENTA_TERRACOTTA_STAIRS.get(), Blocks.MAGENTA_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.YELLOW_TERRACOTTA_STAIRS.get(), Blocks.YELLOW_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.LIME_TERRACOTTA_STAIRS.get(), Blocks.LIME_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.PINK_TERRACOTTA_STAIRS.get(), Blocks.PINK_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.GRAY_TERRACOTTA_STAIRS.get(), Blocks.GRAY_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.CYAN_TERRACOTTA_STAIRS.get(), Blocks.CYAN_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.PURPLE_TERRACOTTA_STAIRS.get(), Blocks.PURPLE_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.BLUE_TERRACOTTA_STAIRS.get(), Blocks.BLUE_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.BROWN_TERRACOTTA_STAIRS.get(), Blocks.BROWN_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.GREEN_TERRACOTTA_STAIRS.get(), Blocks.GREEN_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.RED_TERRACOTTA_STAIRS.get(), Blocks.RED_TERRACOTTA);
        Stair(pFinishedRecipeConsumer, ModBlocks.BLACK_TERRACOTTA_STAIRS.get(), Blocks.BLACK_TERRACOTTA);

        Wall(pFinishedRecipeConsumer, ModBlocks.TERRACOTTA_WALL.get(), Blocks.TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.WHITE_TERRACOTTA_WALL.get(), Blocks.WHITE_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.ORANGE_TERRACOTTA_WALL.get(), Blocks.ORANGE_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.MAGENTA_TERRACOTTA_WALL.get(), Blocks.MAGENTA_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), Blocks.LIGHT_BLUE_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.YELLOW_TERRACOTTA_WALL.get(), Blocks.YELLOW_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.LIME_TERRACOTTA_WALL.get(), Blocks.LIME_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.PINK_TERRACOTTA_WALL.get(), Blocks.PINK_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.GRAY_TERRACOTTA_WALL.get(), Blocks.GRAY_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), Blocks.LIGHT_GRAY_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.CYAN_TERRACOTTA_WALL.get(), Blocks.CYAN_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.PURPLE_TERRACOTTA_WALL.get(), Blocks.PURPLE_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.BLUE_TERRACOTTA_WALL.get(), Blocks.BLUE_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.BROWN_TERRACOTTA_WALL.get(), Blocks.BROWN_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.GREEN_TERRACOTTA_WALL.get(), Blocks.GREEN_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.RED_TERRACOTTA_WALL.get(), Blocks.RED_TERRACOTTA);
        Wall(pFinishedRecipeConsumer, ModBlocks.BLACK_TERRACOTTA_WALL.get(), Blocks.BLACK_TERRACOTTA);
        //endregion
        //region Concrete
        slab(pFinishedRecipeConsumer, ModBlocks.WHITE_CONCRETE_SLAB.get(), Blocks.WHITE_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.ORANGE_CONCRETE_SLAB.get(), Blocks.ORANGE_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.MAGENTA_CONCRETE_SLAB.get(), Blocks.MAGENTA_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), Blocks.LIGHT_BLUE_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.YELLOW_CONCRETE_SLAB.get(), Blocks.YELLOW_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.LIME_CONCRETE_SLAB.get(), Blocks.LIME_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.PINK_CONCRETE_SLAB.get(), Blocks.PINK_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.GRAY_CONCRETE_SLAB.get(), Blocks.GRAY_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), Blocks.LIGHT_GRAY_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.CYAN_CONCRETE_SLAB.get(), Blocks.CYAN_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.PURPLE_CONCRETE_SLAB.get(), Blocks.PURPLE_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.BLUE_CONCRETE_SLAB.get(), Blocks.BLUE_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.BROWN_CONCRETE_SLAB.get(), Blocks.BROWN_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.GREEN_CONCRETE_SLAB.get(), Blocks.GREEN_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.RED_CONCRETE_SLAB.get(), Blocks.RED_CONCRETE);
        slab(pFinishedRecipeConsumer, ModBlocks.BLACK_CONCRETE_SLAB.get(), Blocks.BLACK_CONCRETE);

        Stair(pFinishedRecipeConsumer, ModBlocks.WHITE_CONCRETE_STAIRS.get(), Blocks.WHITE_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.ORANGE_CONCRETE_STAIRS.get(), Blocks.ORANGE_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.MAGENTA_CONCRETE_STAIRS.get(), Blocks.MAGENTA_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), Blocks.LIGHT_BLUE_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.YELLOW_CONCRETE_STAIRS.get(), Blocks.YELLOW_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.LIME_CONCRETE_STAIRS.get(), Blocks.LIME_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.PINK_CONCRETE_STAIRS.get(), Blocks.PINK_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.GRAY_CONCRETE_STAIRS.get(), Blocks.GRAY_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), Blocks.LIGHT_GRAY_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.CYAN_CONCRETE_STAIRS.get(), Blocks.CYAN_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.PURPLE_CONCRETE_STAIRS.get(), Blocks.PURPLE_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.BLUE_CONCRETE_STAIRS.get(), Blocks.BLUE_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.BROWN_CONCRETE_STAIRS.get(), Blocks.BROWN_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.GREEN_CONCRETE_STAIRS.get(), Blocks.GREEN_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.RED_CONCRETE_STAIRS.get(), Blocks.RED_CONCRETE);
        Stair(pFinishedRecipeConsumer, ModBlocks.BLACK_CONCRETE_STAIRS.get(), Blocks.BLACK_CONCRETE);

        Wall(pFinishedRecipeConsumer, ModBlocks.WHITE_CONCRETE_WALL.get(), Blocks.WHITE_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.ORANGE_CONCRETE_WALL.get(), Blocks.ORANGE_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.MAGENTA_CONCRETE_WALL.get(), Blocks.MAGENTA_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.LIGHT_BLUE_CONCRETE_WALL.get(), Blocks.LIGHT_BLUE_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.YELLOW_CONCRETE_WALL.get(), Blocks.YELLOW_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.LIME_CONCRETE_WALL.get(), Blocks.LIME_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.PINK_CONCRETE_WALL.get(), Blocks.PINK_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.GRAY_CONCRETE_WALL.get(), Blocks.GRAY_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.LIGHT_GRAY_CONCRETE_WALL.get(), Blocks.LIGHT_GRAY_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.CYAN_CONCRETE_WALL.get(), Blocks.CYAN_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.PURPLE_CONCRETE_WALL.get(), Blocks.PURPLE_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.BLUE_CONCRETE_WALL.get(), Blocks.BLUE_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.BROWN_CONCRETE_WALL.get(), Blocks.BROWN_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.GREEN_CONCRETE_WALL.get(), Blocks.GREEN_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.RED_CONCRETE_WALL.get(), Blocks.RED_CONCRETE);
        Wall(pFinishedRecipeConsumer, ModBlocks.BLACK_CONCRETE_WALL.get(), Blocks.BLACK_CONCRETE);
        //endregion

        ShapedRecipeBuilder.shaped(ModBlocks.ASPHALT.get(), 4)
                .define('S', Blocks.STONE)
                .define('C', Blocks.COBBLESTONE)
                .define('L', ModItems.SLAG.get())
                .pattern("CSC")
                .pattern("SLS")
                .pattern("CSC")
                .unlockedBy("has_slag", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.SLAG.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ModItems.MOD_BOOK.get())
                .requires(Items.BOOK)
                .unlockedBy("has_book", inventoryTrigger(ItemPredicate.Builder.item().of(Items.BOOK).build()))
                .save(pFinishedRecipeConsumer);

        //region Pyrite
        Compact(pFinishedRecipeConsumer, ModItems.RAW_PYRITE.get(), ModBlocks.RAW_PYRITE_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.PYRITE.get(), ModBlocks.PYRITE_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.PYRITE_NUGGET.get(), ModItems.PYRITE.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.PYRITE.get(),1.0f, ModBlocks.DEEPSLATE_PYRITE_ORE.get(), ModBlocks.PYRITE_ORE.get(), ModItems.RAW_PYRITE.get());
        //endregion
        //region Zinc
        Compact(pFinishedRecipeConsumer, ModItems.RAW_ZINC.get(), ModBlocks.RAW_ZINC_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.ZINC_INGOT.get(), ModBlocks.ZINC_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.ZINC_INGOT.get(),0.7f, ModBlocks.DEEPSLATE_ZINC_ORE.get(), ModBlocks.ZINC_ORE.get(), ModItems.RAW_ZINC.get());
        Compact(pFinishedRecipeConsumer, ModItems.ZINC_NUGGET.get(), ModItems.ZINC_INGOT.get());
        //endregion
        //region Magnesium
        Compact(pFinishedRecipeConsumer, ModItems.RAW_MAGNESIUM.get(), ModBlocks.RAW_MAGNESIUM_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.MAGNESIUM_INGOT.get(), ModBlocks.MAGNESIUM_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.MAGNESIUM_INGOT.get(),0.7f, ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get(), ModBlocks.MAGNESIUM_ORE.get(), ModItems.RAW_MAGNESIUM.get());
        Compact(pFinishedRecipeConsumer, ModItems.MAGNESIUM_NUGGET.get(), ModItems.MAGNESIUM_INGOT.get());
        //endregion
        //region Silver
        Compact(pFinishedRecipeConsumer, ModItems.RAW_SILVER.get(), ModBlocks.RAW_SILVER_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.SILVER_INGOT.get(), ModBlocks.SILVER_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.SILVER_INGOT.get(),1.0f, ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get());
        Compact(pFinishedRecipeConsumer, ModItems.SILVER_NUGGET.get(), ModItems.SILVER_INGOT.get());
        //endregion
        //region Tin
        Compact(pFinishedRecipeConsumer, ModItems.RAW_TIN.get(), ModBlocks.RAW_TIN_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.TIN_INGOT.get(), ModBlocks.TIN_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.TIN_INGOT.get(),0.7f, ModBlocks.DEEPSLATE_TIN_ORE.get(), ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get());
        Compact(pFinishedRecipeConsumer, ModItems.TIN_NUGGET.get(), ModItems.TIN_INGOT.get());
        //endregion
        //region Silicon
        Compact(pFinishedRecipeConsumer, ModItems.SILICON.get(), ModBlocks.SILICON_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.SILICON.get(),0.2f, ModBlocks.SILICON_ORE.get(), ModBlocks.RED_SILICON_ORE.get(), ModItems.RED_UNREFINED_SILICON.get(), ModItems.UNREFINED_SILICON.get());
        //endregion
        //region Lead
        Compact(pFinishedRecipeConsumer, ModItems.RAW_LEAD.get(), ModBlocks.RAW_LEAD_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.LEAD_INGOT.get(), ModBlocks.LEAD_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.LEAD_INGOT.get(),0.7f, ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get());
        Compact(pFinishedRecipeConsumer, ModItems.LEAD_NUGGET.get(), ModItems.LEAD_INGOT.get());
        //endregion
        //region Titanium
        Compact(pFinishedRecipeConsumer, ModItems.RAW_TITANIUM.get(), ModBlocks.RAW_TITANIUM_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.TITANIUM_INGOT.get(), ModBlocks.TITANIUM_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.TITANIUM_INGOT.get(),1.2f, ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get());
        Compact(pFinishedRecipeConsumer, ModItems.TITANIUM_NUGGET.get(), ModItems.TITANIUM_INGOT.get());
        //endregion
        //region Ruby
        Compact(pFinishedRecipeConsumer, ModItems.RUBY.get(), ModBlocks.RUBY_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.RUBY.get(),1.0f, ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.RUBY_ORE.get());
        SmallCompact(pFinishedRecipeConsumer, ModItems.RUBY_SHARD.get(), ModItems.RUBY.get());
        //endregion
        //region Sapphire
        Compact(pFinishedRecipeConsumer, ModItems.SAPPHIRE.get(), ModBlocks.SAPPHIRE_BLOCK.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.SAPPHIRE.get(),1.0f, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.SAPPHIRE_ORE.get());
        SmallCompact(pFinishedRecipeConsumer, ModItems.SAPPHIRE_SHARD.get(), ModItems.SAPPHIRE.get());
        //endregion
        //region Aluminum
        Compact(pFinishedRecipeConsumer, ModItems.ALUMINUM_NUGGET.get(), ModItems.ALUMINUM_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.ALUMINUM_INGOT.get(), ModBlocks.ALUMINUM_BLOCK.get());
        //endregion
        //region Steel
        Compact(pFinishedRecipeConsumer, ModItems.STEEL_NUGGET.get(), ModItems.STEEL_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.STEEL_INGOT.get(), ModBlocks.STEEL_BLOCK.get());
        //endregion
        //region Brass
        Compact(pFinishedRecipeConsumer, ModItems.BRASS_NUGGET.get(), ModItems.BRASS_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.BRASS_INGOT.get(), ModBlocks.BRASS_BLOCK.get());
        //endregion
        //region Crystalline
        SmallCompact(pFinishedRecipeConsumer, ModItems.CRYSTALLINE_SHARD.get(), ModItems.CRYSTALLINE_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.CRYSTALLINE_INGOT.get(), ModBlocks.CRYSTALLINE_BLOCK.get());
        //endregion
        //region Bronze
        Compact(pFinishedRecipeConsumer, ModItems.BRONZE_NUGGET.get(), ModItems.BRONZE_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.BRONZE_INGOT.get(), ModBlocks.BRONZE_BLOCK.get());
        //endregion
        //region Electrum
        Compact(pFinishedRecipeConsumer, ModItems.ELECTRUM_NUGGET.get(), ModItems.ELECTRUM_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.ELECTRUM_INGOT.get(), ModBlocks.ELECTRUM_BLOCK.get());
        //endregion
        //region Draconium
        Compact(pFinishedRecipeConsumer, ModItems.DRACONIUM_NUGGET.get(), ModItems.DRACONIUM_INGOT.get());
        Compact(pFinishedRecipeConsumer, ModItems.DRACONIUM_INGOT.get(), ModBlocks.DRACONIUM_BLOCK.get());
        //endregion
        //region Vanilla Shards & Nuggets
        Compact(pFinishedRecipeConsumer, ModItems.COPPER_NUGGET.get(), Items.COPPER_INGOT);
        SmallCompact(pFinishedRecipeConsumer, ModItems.DIAMOND_SHARD.get(), Items.DIAMOND);
        SmallCompact(pFinishedRecipeConsumer, ModItems.EMERALD_SHARD.get(), Items.EMERALD);
        //endregion
        //region Bismuth
        Compact(pFinishedRecipeConsumer, ModItems.BISMUTH_INGOT.get(), ModBlocks.BISMUTH_BLOCK.get());
        Compact(pFinishedRecipeConsumer, ModItems.BISMUTH_NUGGET.get(), ModItems.BISMUTH_INGOT.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.BISMUTH_INGOT.get(),0.7f, ModItems.BISMUTH.get(), ModBlocks.BISMUTH_ORE.get(), ModBlocks.TUFF_BISMUTH_ORE.get(), ModBlocks.DEEPSLATE_BISMUTH_ORE.get(), ModBlocks.GRANITE_BISMUTH_ORE.get(), ModBlocks.ANDESITE_BISMUTH_ORE.get(), ModBlocks.DIORITE_BISMUTH_ORE.get());
        //endregion
        //region Rosalite
        Compact(pFinishedRecipeConsumer, ModItems.ROSALITE.get(), ModBlocks.ROSALITE_BLOCK.get());
        SmallCompact(pFinishedRecipeConsumer, ModItems.ROSALITE_SHARD.get(), ModItems.ROSALITE.get());
        FurnaceBlast(pFinishedRecipeConsumer, ModItems.ROSALITE.get(),1.0f, ModBlocks.BASALT_ROSALITE_ORE.get());
        //endregion
        //region Smoky Quartz
        chiseledBuilder(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get(), Ingredient.of(ModBlocks.SMOKY_QUARTZ_SLAB.get())).unlockedBy("has_chiseled_smoky_quartz_block", has(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get())).unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).unlockedBy("has_smoky_quartz_pillar", has(ModBlocks.SMOKY_QUARTZ_PILLAR.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SMOKY_QUARTZ_PILLAR.get(), 2).define('#', ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get()).pattern("#").pattern("#").unlockedBy("has_chiseled_smoky_quartz_block", has(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get())).unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).unlockedBy("has_smoky_quartz_pillar", has(ModBlocks.SMOKY_QUARTZ_PILLAR.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get()).define('#', ModItems.SMOKY_QUARTZ.get()).pattern("##").pattern("##").unlockedBy("has_smoky_quartz", has(ModItems.SMOKY_QUARTZ.get())).save(pFinishedRecipeConsumer);
        ShapedRecipeBuilder.shaped(ModBlocks.SMOKY_QUARTZ_BRICKS.get(), 4).define('#', ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get()).pattern("##").pattern("##").unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).save(pFinishedRecipeConsumer);
        slabBuilder(ModBlocks.SMOKY_QUARTZ_SLAB.get(), Ingredient.of(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get(), ModBlocks.SMOKY_QUARTZ_PILLAR.get())).unlockedBy("has_chiseled_smoky_quartz_block", has(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get())).unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).unlockedBy("has_smoky_quartz_pillar", has(ModBlocks.SMOKY_QUARTZ_PILLAR.get())).save(pFinishedRecipeConsumer);
        stairBuilder(ModBlocks.SMOKY_QUARTZ_STAIRS.get(), Ingredient.of(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get(), ModBlocks.SMOKY_QUARTZ_PILLAR.get())).unlockedBy("has_chiseled_smoky_quartz_block", has(ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get())).unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).unlockedBy("has_smoky_quartz_pillar", has(ModBlocks.SMOKY_QUARTZ_PILLAR.get())).save(pFinishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SMOKY_QUARTZ_ORE.get()), ModItems.SMOKY_QUARTZ.get(), 0.2F, 200).unlockedBy("has_smoky_quartz_ore", has(ModBlocks.SMOKY_QUARTZ_ORE.get())).save(pFinishedRecipeConsumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get()), ModBlocks.SMOOTH_SMOKY_QUARTZ_BLOCK.get().asItem(), 0.1F, 200).unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).save(pFinishedRecipeConsumer);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get()), ModBlocks.SMOKY_QUARTZ_SLAB.get(), 2).unlockedBy("has_block_of_smoky_quartz", has(ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get())).save(pFinishedRecipeConsumer, "smoky_quartz_slab_from_stonecutting");
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.SMOKY_QUARTZ_STAIRS.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.SMOKY_QUARTZ_PILLAR.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.CHISELED_SMOKY_QUARTZ_BLOCK.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.SMOKY_QUARTZ_BRICKS.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get());
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.SMOOTH_SMOKY_QUARTZ_SLAB.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get(), 2);
        stonecutterResultFromBase(pFinishedRecipeConsumer, ModBlocks.SMOOTH_SMOKY_QUARTZ_STAIRS.get(), ModBlocks.BLOCK_OF_SMOKY_QUARTZ.get());
        //endregion

        FurnaceCampSmoke(pFinishedRecipeConsumer, ModItems.FRIED_EGG.get(), 0.35f, Items.EGG);

        // cherry wood recipes
        AllWoodRecipes(pFinishedRecipeConsumer, ModBlocks.CHERRY_LOG.get(), ModBlocks.STRIPPED_CHERRY_LOG.get(),
                ModBlocks.CHERRY_WOOD.get(), ModBlocks.STRIPPED_CHERRY_WOOD.get(), ModBlocks.CHERRY_PLANKS.get(),
                ModBlocks.CHERRY_STAIRS.get(), ModBlocks.CHERRY_SLAB.get(), ModBlocks.CHERRY_FENCE.get(),
                ModBlocks.CHERRY_FENCE_GATE.get(), ModBlocks.CHERRY_DOOR.get(), ModBlocks.CHERRY_TRAPDOOR.get(),
                ModItems.CHERRY_SIGN.get(), ModBlocks.CHERRY_BUTTON.get(), ModBlocks.CHERRY_PRESSURE_PLATE.get(),
                ModItems.CHERRY_BOAT.get(), ModItems.CHERRY_CHEST_BOAT.get());












        Surround(pFinishedRecipeConsumer, ModItems.EXPLOSIVE_ARROW.get(), Blocks.TNT, Items.ARROW, 8);
        Surround(pFinishedRecipeConsumer, ModItems.TIMED_ARROW_ONE.get(), Items.STRING, ModItems.EXPLOSIVE_ARROW.get(), 8);
        Surround(pFinishedRecipeConsumer, ModItems.TIMED_ARROW_TWO.get(), Items.STRING, ModItems.TIMED_ARROW_ONE.get(), 8);
        Surround(pFinishedRecipeConsumer, ModItems.TIMED_ARROW_THREE.get(), Items.STRING, ModItems.TIMED_ARROW_TWO.get(), 8);
        Surround(pFinishedRecipeConsumer, ModItems.SILVER_ARROW.get(), ModItems.SILVER_INGOT.get(), Items.ARROW, 8);

        Surround(pFinishedRecipeConsumer, ModBlocks.RAINBOW_BRICKS.get(), ModItems.RAINBOW_DYE.get(), Blocks.BRICKS, 8);
        Surround(pFinishedRecipeConsumer, ModBlocks.WHITE_BRICKS.get(), Items.WHITE_DYE, Blocks.BRICKS, 8);
        Surround(pFinishedRecipeConsumer, ModBlocks.BLACK_BRICKS.get(), Items.BLACK_DYE, Blocks.BRICKS, 8);
        Slab(pFinishedRecipeConsumer, ModBlocks.RAINBOW_BRICK_SLAB.get(), ModBlocks.RAINBOW_BRICKS.get());
        Slab(pFinishedRecipeConsumer, ModBlocks.WHITE_BRICK_SLAB.get(), ModBlocks.WHITE_BRICKS.get());
        Slab(pFinishedRecipeConsumer, ModBlocks.BLACK_BRICK_SLAB.get(), ModBlocks.BLACK_BRICKS.get());
        Stair(pFinishedRecipeConsumer, ModBlocks.RAINBOW_BRICK_STAIRS.get(), ModBlocks.RAINBOW_BRICKS.get());
        Stair(pFinishedRecipeConsumer, ModBlocks.WHITE_BRICK_STAIRS.get(), ModBlocks.WHITE_BRICKS.get());
        Stair(pFinishedRecipeConsumer, ModBlocks.BLACK_BRICK_STAIRS.get(), ModBlocks.BLACK_BRICKS.get());
        Wall(pFinishedRecipeConsumer, ModBlocks.RAINBOW_BRICK_WALL.get(), ModBlocks.RAINBOW_BRICKS.get());
        Wall(pFinishedRecipeConsumer, ModBlocks.WHITE_BRICK_WALL.get(), ModBlocks.WHITE_BRICKS.get());
        Wall(pFinishedRecipeConsumer, ModBlocks.BLACK_BRICK_WALL.get(), ModBlocks.BLACK_BRICKS.get());

        ShapelessRecipeBuilder.shapeless(ModItems.RAINBOW_DYE.get(), 6)
                .requires(Items.RED_DYE)
                .requires(Items.GREEN_DYE)
                .requires(Items.BLUE_DYE)
                .requires(Items.CYAN_DYE)
                .requires(Items.MAGENTA_DYE)
                .requires(Items.YELLOW_DYE)
                .unlockedBy("has_red_dye", inventoryTrigger(ItemPredicate.Builder.item().of(Items.RED_DYE).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:rainbow_dye_from_various_dyes");

        ShapelessRecipeBuilder.shapeless(ModItems.STICKY_GRENADE.get())
                .requires(ModItems.GRENADE.get())
                .requires(Items.REDSTONE)
                .requires(Items.SLIME_BALL)
                .unlockedBy("has_grenade", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GRENADE.get()).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:sticky_grenade_from_slimeball");

        ShapelessRecipeBuilder.shapeless(ModItems.STICKY_GRENADE.get())
                .requires(ModItems.GRENADE.get())
                .requires(Items.REDSTONE)
                .requires(Items.HONEY_BOTTLE)
                .unlockedBy("has_grenade", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.GRENADE.get()).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:sticky_grenade_from_honey_bottle");

        ShapedRecipeBuilder.shaped(ModItems.STICKY_DETONATOR.get())
                .define('N', Blocks.TNT)
                .define('T', Items.REDSTONE_TORCH)
                .define('B', Items.STONE_BUTTON)
                .define('U', ModItems.TITANIUM_INGOT.get())
                .define('I', ModBlocks.TIN_BLOCK.get())
                .pattern("ITI")
                .pattern("IBI")
                .pattern("UNU")
                .unlockedBy("has_titanium", inventoryTrigger(ItemPredicate.Builder.item().of(ModItems.TITANIUM_INGOT.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.GRENADE.get(), 2)
                .define('N', Blocks.TNT)
                .define('S', Items.STRING)
                .define('I', Items.IRON_NUGGET)
                .pattern("ISI")
                .pattern("INI")
                .pattern("III")
                .unlockedBy("has_tnt", inventoryTrigger(ItemPredicate.Builder.item().of(Blocks.TNT).build()))
                .save(pFinishedRecipeConsumer);

        ShapelessRecipeBuilder.shapeless(ModBlocks.INDICATOR_LEVER.get())
                .requires(Blocks.LEVER)
                .requires(Blocks.REDSTONE_LAMP)
                .unlockedBy("has_lever", inventoryTrigger(ItemPredicate.Builder.item().of(Blocks.LEVER).build()))
                .save(pFinishedRecipeConsumer, "bit_o_everything:indicator_lever_from_lever_and_lamp");

        ShapedRecipeBuilder.shaped(ModBlocks.POTTER.get())
                .define('N', ItemTags.TERRACOTTA)
                .pattern("N N")
                .pattern("N N")
                .pattern("NNN")
                .unlockedBy("has_terracotta", inventoryTrigger(ItemPredicate.Builder.item().of(ItemTags.TERRACOTTA).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModBlocks.CONCRETE_POTTER.get())
                .define('N', ModTags.Items.CONCRETES)
                .pattern("N N")
                .pattern("N N")
                .pattern("NNN")
                .unlockedBy("has_concrete", inventoryTrigger(ItemPredicate.Builder.item().of(ModTags.Items.CONCRETES).build()))
                .save(pFinishedRecipeConsumer);




        ShapedRecipeBuilder.shaped(Blocks.COBWEB)
                .define('s', Items.STRING)
                .pattern("s s")
                .pattern(" s ")
                .pattern("s s")
                .unlockedBy("has_string", inventoryTrigger(ItemPredicate.Builder.item().of(Items.STRING).build()))
                .save(pFinishedRecipeConsumer);

        /*
        ShapedRecipeBuilder.shaped(Items.BUNDLE.asItem()) //TODO fix bundle
                .define('s', Items.STRING)
                .define('h', Items.RABBIT_HIDE)
                .pattern("shs")
                .pattern("h h")
                .pattern("hhh")
                .unlockedBy("has_rabbit_hide", inventoryTrigger(ItemPredicate.Builder.item().of(Items.RABBIT_HIDE).build()))
                .save(pFinishedRecipeConsumer);
         */

        horseArmor(pFinishedRecipeConsumer, Items.IRON_HORSE_ARMOR, Items.IRON_INGOT);
        horseArmor(pFinishedRecipeConsumer, Items.GOLDEN_HORSE_ARMOR, Items.GOLD_INGOT);
        horseArmor(pFinishedRecipeConsumer, Items.DIAMOND_HORSE_ARMOR, Items.DIAMOND);

        ShapedRecipeBuilder.shaped(Items.SADDLE)
                .define('S', Items.STRING)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .pattern("LLL")
                .pattern("S S")
                .pattern("I I")
                .unlockedBy("has_leather", inventoryTrigger(ItemPredicate.Builder.item().of(Items.LEATHER).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(Items.NAME_TAG)
                .define('S', Items.STRING)
                .define('I', Items.IRON_INGOT)
                .define('L', Items.LEATHER)
                .define('B', Items.SLIME_BALL)
                .pattern("SBS")
                .pattern("SLS")
                .pattern("IS ")
                .unlockedBy("has_leather", inventoryTrigger(ItemPredicate.Builder.item().of(Items.LEATHER).build()))
                .save(pFinishedRecipeConsumer);
    }
}
