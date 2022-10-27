package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BitOEverything.MOD_ID);
    //region Ores
    public static final RegistryObject<PlacedFeature> UNOBTAINIUM_ORE_PLACED = PLACED_FEATURES.register("unobtainium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.UNOBTAINIUM_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-58)))));

    public static final RegistryObject<PlacedFeature> PYRITE_ORE_PLACED = register("pyrite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PYRITE_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<PlacedFeature> PYRITE_ORE_LOWER_PLACED = register("pyrite_ore_lower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PYRITE_ORE.getHolder().get(),
                    orePlacement(CountPlacement.of(UniformInt.of(0, 1)),
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
    public static final RegistryObject<PlacedFeature> PYRITE_ORE_EXTRA_PLACED = register("pyrite_ore_extra_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PYRITE_ORE_EXTRA.getHolder().get(),
                    commonOrePlacement(20,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256)))));
    public static final RegistryObject<PlacedFeature> ZINC_ORE_PLACED = register("zinc_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ZINC_ORE.getHolder().get(),
                    commonOrePlacement(4,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(64)))));
    public static final RegistryObject<PlacedFeature> MAGNESIUM_ORE_PLACED = register("magnesium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MAGNESIUM_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(48)))));
    public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED = register("silver_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16)))));
    public static final RegistryObject<PlacedFeature> SILVER_ORE_LOWER_PLACED = register("silver_ore_lower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORE.getHolder().get(),
                    orePlacement(CountPlacement.of(UniformInt.of(0, 1)),
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
    public static final RegistryObject<PlacedFeature> TIN_ORE_PLACED = register("tin_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TIN_ORE.getHolder().get(),
                    commonOrePlacement(5,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)))));
    public static final RegistryObject<PlacedFeature> LEAD_ORE_PLACED = register("lead_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LEAD_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)))));
    public static final RegistryObject<PlacedFeature> TITANIUM_ORE_PLACED = register("titanium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TITANIUM_ORE.getHolder().get(),
                    commonOrePlacement(4,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16)))));
    public static final RegistryObject<PlacedFeature> RUBY_ORE_PLACED = register("ruby_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RUBY_ORE.getHolder().get(),
                    commonOrePlacement(100,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(175)))));
    public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE_PLACED = register("sapphire_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAPPHIRE_ORE.getHolder().get(),
                    commonOrePlacement(100,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(175)))));
    public static final RegistryObject<PlacedFeature> SILICON_ORE_PLACED = register("silicon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILICON_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(128)))));
    public static final RegistryObject<PlacedFeature> RED_SILICON_ORE_PLACED = register("red_silicon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RED_SILICON_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(128)))));
    public static final RegistryObject<PlacedFeature> BISMUTH_ORE_PLACED = register("bismuth_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BISMUTH_ORE.getHolder().get(),
                    commonOrePlacement(7,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(48)))));
    public static final RegistryObject<PlacedFeature> ROSALITE_ORE_PLACED = register("rosalite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ROSALITE_ORE.getHolder().get(),
                    commonOrePlacement(6,
                            PlacementUtils.RANGE_10_10)));
    public static final RegistryObject<PlacedFeature> SMOKY_QUARTZ_ORE_PLACED = register("smoky_quartz_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SMOKY_QUARTZ_ORE.getHolder().get(),
                    commonOrePlacement(16,
                            PlacementUtils.RANGE_10_10)));
    public static final int CRYSTAL_LOW = -64;
    public static final int CRYSTAL_HIGH = 32;
    public static final int CHUNKS_PER_CRYSTAL_CLUSTERS = 14;
    public static final RegistryObject<PlacedFeature> MOLDAVITE_PLACED = register("moldavite_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MOLDAVITE_GROWTH.getHolder().get(),
                    rareOrePlacement(CHUNKS_PER_CRYSTAL_CLUSTERS,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(CRYSTAL_LOW), VerticalAnchor.absolute(CRYSTAL_HIGH)))));
    public static final RegistryObject<PlacedFeature> RHODOCHROSITE_PLACED = register("rhodochrosite_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RHODOCHROSITE_GROWTH.getHolder().get(),
                    rareOrePlacement(CHUNKS_PER_CRYSTAL_CLUSTERS,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(CRYSTAL_LOW), VerticalAnchor.absolute(CRYSTAL_HIGH)))));
    public static final RegistryObject<PlacedFeature> TANZANITE_PLACED = register("tanzanite_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TANZANITE_GROWTH.getHolder().get(),
                    rareOrePlacement(CHUNKS_PER_CRYSTAL_CLUSTERS,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(CRYSTAL_LOW), VerticalAnchor.absolute(CRYSTAL_HIGH)))));
    public static final RegistryObject<PlacedFeature> CITRINE_PLACED = register("citrine_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CITRINE_GROWTH.getHolder().get(),
                    rareOrePlacement(CHUNKS_PER_CRYSTAL_CLUSTERS,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(CRYSTAL_LOW), VerticalAnchor.absolute(CRYSTAL_HIGH)))));
    public static final RegistryObject<PlacedFeature> AQUAMARINE_PLACED = register("aquamarine_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.AQUAMARINE_GROWTH.getHolder().get(),
                    rareOrePlacement(CHUNKS_PER_CRYSTAL_CLUSTERS,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(CRYSTAL_LOW), VerticalAnchor.absolute(CRYSTAL_HIGH)))));
    public static final RegistryObject<PlacedFeature> CELESTITE_PLACED = register("celestite_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CELESTITE_GROWTH.getHolder().get(),
                    rareOrePlacement(CHUNKS_PER_CRYSTAL_CLUSTERS,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(CRYSTAL_LOW), VerticalAnchor.absolute(CRYSTAL_HIGH)))));
    //endregion
    
    //region Trees
    //region Cherry
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_STANDARD_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_standard_checked", ModConfiguredFeatures.CHERRY_TREE_STANDARD.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_STANDARD_BEES_0002_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_standard_bees_0002_checked", ModConfiguredFeatures.CHERRY_TREE_STANDARD_BEES_0002.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_STANDARD_BEES_002_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_standard_bees_002_checked", ModConfiguredFeatures.CHERRY_TREE_STANDARD_BEES_002.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_STANDARD_BEES_005_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_standard_bees_005_checked", ModConfiguredFeatures.CHERRY_TREE_STANDARD_BEES_005.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_FANCY_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_fancy_checked", ModConfiguredFeatures.CHERRY_TREE_FANCY.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_FANCY_BEES_0002_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_fancy_bees_0002_checked", ModConfiguredFeatures.CHERRY_TREE_FANCY_BEES_0002.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_FANCY_BEES_002_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_fancy_bees_002_checked", ModConfiguredFeatures.CHERRY_TREE_FANCY_BEES_002.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_FANCY_BEES_005_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_fancy_bees_005_checked", ModConfiguredFeatures.CHERRY_TREE_FANCY_BEES_005.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_TREE_FANCY_BEES_CHECKED =
            resisterOakSurvivalPlacedTree("cherry_tree_fancy_bees_checked", ModConfiguredFeatures.CHERRY_TREE_FANCY_BEES.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> CHERRY_COMMON_PLACED = register("cherry_common_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_TREE_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.3333333333333F, 1))));
    
    public static final RegistryObject<PlacedFeature> CHERRY_COMMON_EXTRA_BEES_PLACED = register("cherry_common_extra_bees_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_TREE_EXTRA_BEES_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.3333333333333F, 1))));
    
    public static final RegistryObject<PlacedFeature> CHERRY_RARE_PLACED = register("cherry_rare_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_TREE_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.01F, 1))));
    
    //endregion
    //region Maple
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_SPRUCE_ORANGE_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_spruce_orange_checked", ModConfiguredFeatures.MAPLE_TREE_SPRUCE_ORANGE.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_SPRUCE_ORANGE_TREE_TAP_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_spruce_orange_tree_tap_checked", ModConfiguredFeatures.MAPLE_TREE_SPRUCE_ORANGE_TREE_TAP.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_PINE_ORANGE_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_pine_orange_checked", ModConfiguredFeatures.MAPLE_TREE_PINE_ORANGE.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_PINE_ORANGE_TREE_TAP_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_pine_orange_tree_tap_checked", ModConfiguredFeatures.MAPLE_TREE_PINE_ORANGE_TREE_TAP.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_SPRUCE_RED_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_spruce_red_checked", ModConfiguredFeatures.MAPLE_TREE_SPRUCE_RED.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_SPRUCE_RED_TREE_TAP_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_spruce_red_tree_tap_checked", ModConfiguredFeatures.MAPLE_TREE_SPRUCE_RED_TREE_TAP.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_PINE_RED_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_pine_red_checked", ModConfiguredFeatures.MAPLE_TREE_PINE_RED.getHolder().get());
    
    public static final RegistryObject<PlacedFeature> MAPLE_TREE_PINE_RED_TREE_TAP_CHECKED =
            resisterOakSurvivalPlacedTree("maple_tree_pine_red_tree_tap_checked", ModConfiguredFeatures.MAPLE_TREE_PINE_RED_TREE_TAP.getHolder().get());
    //endregion
    //region Orange
    public static final RegistryObject<PlacedFeature> ORANGE_TREE_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("orange_tree_bees_002", ModConfiguredFeatures.ORANGE_TREE_BEES_002.getHolder().get());
    public static final RegistryObject<PlacedFeature> ORANGE_TREE_FANCY_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("orange_tree_fancy_bees_002", ModConfiguredFeatures.ORANGE_TREE_FANCY_BEES_002.getHolder().get());
    //endregion
    //region Peach
    public static final RegistryObject<PlacedFeature> PEACH_TREE_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("peach_tree_bees_002", ModConfiguredFeatures.PEACH_TREE_BEES_002.getHolder().get());
    public static final RegistryObject<PlacedFeature> PEACH_TREE_FANCY_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("peach_tree_fancy_bees_002", ModConfiguredFeatures.PEACH_TREE_FANCY_BEES_002.getHolder().get());
    //endregion
    //region Pear
    public static final RegistryObject<PlacedFeature> PEAR_TREE_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("pear_tree_bees_002", ModConfiguredFeatures.PEAR_TREE_BEES_002.getHolder().get());
    public static final RegistryObject<PlacedFeature> PEAR_TREE_FANCY_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("pear_tree_fancy_bees_002", ModConfiguredFeatures.PEAR_TREE_FANCY_BEES_002.getHolder().get());
    //endregion
    //region Plum
    public static final RegistryObject<PlacedFeature> PLUM_TREE_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("plum_tree_bees_002", ModConfiguredFeatures.PLUM_TREE_BEES_002.getHolder().get());
    public static final RegistryObject<PlacedFeature> PLUM_TREE_FANCY_BEES_002_CHECKED = resisterOakSurvivalPlacedTree("plum_tree_fancy_bees_002", ModConfiguredFeatures.PLUM_TREE_FANCY_BEES_002.getHolder().get());
    //endregion
    //region Charred
    public static final RegistryObject<PlacedFeature> CHARRED_TREE_CHECKED = resisterOakSurvivalPlacedTree("charred_tree", ModConfiguredFeatures.CHARRED_TREE.getHolder().get());
    public static final RegistryObject<PlacedFeature> CHARRED_TREE_FANCY_CHECKED = resisterOakSurvivalPlacedTree("charred_tree_fancy", ModConfiguredFeatures.CHARRED_TREE_FANCY.getHolder().get());
    //endregion
    //region Corrupt
    public static final RegistryObject<PlacedFeature> CORRUPT_TREE_CHECKED = resisterOakSurvivalPlacedTree("corrupt_tree", ModConfiguredFeatures.CORRUPT_TREE.getHolder().get());
    public static final RegistryObject<PlacedFeature> CORRUPT_TREE_FANCY_CHECKED = resisterOakSurvivalPlacedTree("corrupt_tree_fancy", ModConfiguredFeatures.CORRUPT_TREE_FANCY.getHolder().get());
    //endregion
    //region Dead
    public static final RegistryObject<PlacedFeature> DEAD_TREE_CHECKED = resisterOakSurvivalPlacedTree("dead_tree", ModConfiguredFeatures.DEAD_TREE.getHolder().get());
    public static final RegistryObject<PlacedFeature> DEAD_TREE_FANCY_CHECKED = resisterOakSurvivalPlacedTree("dead_tree_fancy", ModConfiguredFeatures.DEAD_TREE_FANCY.getHolder().get());
    //endregion
    //region Infected
    public static final RegistryObject<PlacedFeature> INFECTED_TREE_CHECKED = resisterOakSurvivalPlacedTree("infected_tree", ModConfiguredFeatures.INFECTED_TREE.getHolder().get());
    public static final RegistryObject<PlacedFeature> INFECTED_TREE_FANCY_CHECKED = resisterOakSurvivalPlacedTree("infected_tree_fancy", ModConfiguredFeatures.INFECTED_TREE_FANCY.getHolder().get());
    //endregion
    
    public static RegistryObject<PlacedFeature> resisterOakSurvivalPlacedTree(String name, Holder<ConfiguredFeature<?, ?>> configuredTree) {
        return resisterSurvivalPlacedTree(name, configuredTree, List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING)));
    }
    
    public static RegistryObject<PlacedFeature> resisterSurvivalPlacedTree(String name, Holder<ConfiguredFeature<?, ?>> configuredTree, List<PlacementModifier> survivalPlacement) {
        return PLACED_FEATURES.register(name, () -> new PlacedFeature(configuredTree, survivalPlacement));
    }
    //endregion
    

    public static RegistryObject<PlacedFeature> register(final String name, final Supplier<? extends PlacedFeature> sup) {
        return PLACED_FEATURES.register(name, sup);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
