package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.datagen.ModTags;
import com.bic.bit_o_everything.world.feature.custom.BranchingTrunkPlacer;
import com.bic.bit_o_everything.world.feature.custom.CrystalClusterConfiguration;
import com.bic.bit_o_everything.world.feature.custom.MetaballFoliagePlacer;
import com.bic.bit_o_everything.world.feature.custom.TreeTapDecorator;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.OptionalInt;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BitOEverything.MOD_ID);
    //region ORES

    public static final RuleTest UNOBTAINIUM_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.UNOBTAINIUM_ORE_REPLACEABLES);
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_UNOBTAINIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(UNOBTAINIUM_ORE_REPLACEABLES, ModBlocks.UNOBTAINIUM_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> UNOBTAINIUM_ORE = CONFIGURED_FEATURES.register("unobtainium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_UNOBTAINIUM_ORES.get(), 3, 1.0F)));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PYRITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PYRITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PYRITE_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PYRITE_ORE = register("pyrite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PYRITE_ORES.get(), 9, 0.5F)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> PYRITE_ORE_EXTRA = register("pyrite_ore_extra",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PYRITE_ORES.get(), 9)));
    public static final RuleTest SAND_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.SAND_ORE_REPLACEABLES);
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILICON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(SAND_ORE_REPLACEABLES, ModBlocks.SILICON_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SILICON_ORE = register("silicon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SILICON_ORES.get(), 7, 0.95F)));
    public static final RuleTest RED_SAND_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.RED_SAND_ORE_REPLACEABLES);
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RED_SILICON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(RED_SAND_ORE_REPLACEABLES, ModBlocks.RED_SILICON_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_SILICON_ORE = register("red_silicon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_RED_SILICON_ORES.get(), 4, 0.5F)));
    public static final RuleTest ANDESITE_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.ANDESITE_ORE_REPLACEABLES);
    public static final RuleTest GRANITE_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.GRANITE_ORE_REPLACEABLES);
    public static final RuleTest DIORITE_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.DIORITE_ORE_REPLACEABLES);
    public static final RuleTest TUFF_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.TUFF_ORE_REPLACEABLES);
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BISMUTH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.GRANITE_BISMUTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(ANDESITE_ORE_REPLACEABLES, ModBlocks.ANDESITE_BISMUTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.DIORITE_BISMUTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(TUFF_ORE_REPLACEABLES, ModBlocks.TUFF_BISMUTH_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BISMUTH_ORE = register("bismuth_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BISMUTH_ORES.get(), 8)));
    public static final RuleTest BASALT_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.BASALT_ORE_REPLACEABLES);
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ROSALITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(BASALT_ORE_REPLACEABLES, ModBlocks.BASALT_ROSALITE_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSALITE_ORE = register("rosalite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ROSALITE_ORES.get(), 9)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ZINC_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ZINC_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE = register("zinc_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ZINC_ORES.get(), 6, 0.3F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGNESIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MAGNESIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAGNESIUM_ORE = register("magnesium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESIUM_ORES.get(), 8, 0.4F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SILVER_ORE = register("silver_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORES.get(), 7, 0.6F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TIN_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TIN_ORE = register("tin_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES.get(), 12, 0.4F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_LEAD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> LEAD_ORE = register("lead_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_LEAD_ORES.get(), 7, 0.6F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TITANIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TITANIUM_ORE = register("titanium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TITANIUM_ORES.get(), 4, 0.95F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> RUBY_ORE = register("ruby_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES.get(), 3, 0.2F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SAPPHIRE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SAPPHIRE_ORE = register("sapphire_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SAPPHIRE_ORES.get(), 3, 0.2F)));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_SMOKY_QUARTZ_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHERRACK, ModBlocks.SMOKY_QUARTZ_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOKY_QUARTZ_ORE = register("smoky_quartz_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_SMOKY_QUARTZ_ORES.get(), 14)));
    public static final List<Double> EXTRA_CRYSTAL_CHANCES = List.of(0.95d, 0.90d, 0.85d, 0.8d, 0.75d, 0.7d, 0.65d, 0.6d, 0.55d, 0.5d, 0.45d, 0.4d, 0.35, 0.3d);
    public static final Supplier<BlockStateProvider> MOLDAVITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 95)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 10)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> MOLDAVITE_GROWTH = register("moldavite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(MOLDAVITE_LIST, EXTRA_CRYSTAL_CHANCES)));
    public static final Supplier<BlockStateProvider> RHODOCHROSITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 95)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 10)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> RHODOCHROSITE_GROWTH = register("rhodochrosite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(RHODOCHROSITE_LIST, EXTRA_CRYSTAL_CHANCES)));
    public static final Supplier<BlockStateProvider> TANZANITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 10)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 95)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TANZANITE_GROWTH = register("tanzanite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(TANZANITE_LIST, EXTRA_CRYSTAL_CHANCES)));
    public static final Supplier<BlockStateProvider> CITRINE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 10)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 95)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CITRINE_GROWTH = register("citrine_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(CITRINE_LIST, EXTRA_CRYSTAL_CHANCES)));
    public static final Supplier<BlockStateProvider> AQUAMARINE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 95)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 10)
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> AQUAMARINE_GROWTH = register("aguamarine_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(AQUAMARINE_LIST, EXTRA_CRYSTAL_CHANCES)));
    public static final Supplier<BlockStateProvider> CELESTITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 10)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 95)
    ));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CELESTITE_GROWTH = register("celestite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(CELESTITE_LIST, EXTRA_CRYSTAL_CHANCES)));
    //endregion
    //region Trees
    //region Tree Decorators
    private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F); // 0.2%
    private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F); // 2%
    private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F); // 5%
    private static final BeehiveDecorator BEEHIVE = new BeehiveDecorator(1.0F); // 100%
    
    private static final TreeTapDecorator TREE_TAP_025 = new TreeTapDecorator(0.25F); // 25%
    //endregion
    //region Cherry
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_STANDARD = register("cherry_tree_standard",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_STANDARD_BEES_0002 = register("cherry_tree_standard_bees_0002",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE_0002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_STANDARD_BEES_002 = register("cherry_tree_standard_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_STANDARD_BEES_005 = register("cherry_tree_standard_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_FANCY = register("cherry_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyCherry().build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_FANCY_BEES_0002 = register("cherry_tree_fancy_bees_0002",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE_0002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_FANCY_BEES_002 = register("cherry_tree_fancy_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_FANCY_BEES_005 = register("cherry_tree_fancy_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_FANCY_BEES = register("cherry_tree_fancy_bees",
            () -> new ConfiguredFeature<>(Feature.TREE, createCherry().decorators(List.of(BEEHIVE)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_SPAWN = register("cherry_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_STANDARD_BEES_0002_CHECKED.getHolder().get(), 0.16F),
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_STANDARD_BEES_002_CHECKED.getHolder().get(), 0.24F),
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_FANCY_CHECKED.getHolder().get(), 0.1F),
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_FANCY_BEES_0002_CHECKED.getHolder().get(), 0.06F),
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_FANCY_BEES_002_CHECKED.getHolder().get(), 0.04F)
            ), ModPlacedFeatures.CHERRY_TREE_STANDARD_CHECKED.getHolder().get())));
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHERRY_TREE_EXTRA_BEES_SPAWN = register("cherry_tree_extra_bees_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_FANCY_BEES_005_CHECKED.getHolder().get(), 0.2F),
                    new WeightedPlacedFeature(ModPlacedFeatures.CHERRY_TREE_FANCY_BEES_CHECKED.getHolder().get(), 0.025F)
            ), ModPlacedFeatures.CHERRY_TREE_STANDARD_BEES_005_CHECKED.getHolder().get())));
    
    
    private static TreeConfiguration.TreeConfigurationBuilder createCherry() {
        return createOakStyle(ModBlocks.CHERRY_LOG.get(), ModBlocks.CHERRY_LEAVES.get());
    }
    
    private static TreeConfiguration.TreeConfigurationBuilder createFancyCherry() {
        return createFancyOakStyle(ModBlocks.CHERRY_LOG.get(), ModBlocks.CHERRY_LEAVES.get());
    }
    //endregion
    //region Maple
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_SPRUCE_ORANGE = register("maple_tree_spruce_orange",
            () -> new ConfiguredFeature<>(Feature.TREE, orangeSpruceMaple().build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_SPRUCE_ORANGE_TREE_TAP = register("maple_tree_spruce_orange_tree_tap",
            () -> new ConfiguredFeature<>(Feature.TREE, orangeSpruceMaple().decorators(List.of(TREE_TAP_025)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_PINE_ORANGE = register("maple_tree_pine_orange",
            () -> new ConfiguredFeature<>(Feature.TREE, orangePineMaple().build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_PINE_ORANGE_TREE_TAP = register("maple_tree_pine_orange_tree_tap",
            () -> new ConfiguredFeature<>(Feature.TREE, orangePineMaple().decorators(List.of(TREE_TAP_025)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_SPRUCE_RED = register("maple_tree_spruce_red",
            () -> new ConfiguredFeature<>(Feature.TREE, redSpruceMaple().build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_SPRUCE_RED_TREE_TAP = register("maple_tree_spruce_red_tree_tap",
            () -> new ConfiguredFeature<>(Feature.TREE, redSpruceMaple().decorators(List.of(TREE_TAP_025)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_PINE_RED = register("maple_tree_pine_red",
            () -> new ConfiguredFeature<>(Feature.TREE, redPineMaple().build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_PINE_RED_TREE_TAP = register("maple_tree_pine_red_tree_tap",
            () -> new ConfiguredFeature<>(Feature.TREE, redPineMaple().decorators(List.of(TREE_TAP_025)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> MAPLE_TREE_SPAWN = register("maple_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_SPRUCE_ORANGE_TREE_TAP_CHECKED.getHolder().get(), 0.009F),
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_PINE_ORANGE_CHECKED.getHolder().get(), 0.441F),
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_PINE_ORANGE_TREE_TAP_CHECKED.getHolder().get(), 0.009F),
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_SPRUCE_RED_CHECKED.getHolder().get(), 0.049F),
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_SPRUCE_RED_TREE_TAP_CHECKED.getHolder().get(), 0.001F),
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_PINE_RED_CHECKED.getHolder().get(), 0.049F),
                    new WeightedPlacedFeature(ModPlacedFeatures.MAPLE_TREE_PINE_RED_TREE_TAP_CHECKED.getHolder().get(), 0.0010F)
            ), ModPlacedFeatures.MAPLE_TREE_SPRUCE_ORANGE_CHECKED.getHolder().get())));
    
    private static TreeConfiguration.TreeConfigurationBuilder orangeSpruceMaple() {return createSpruceStyle(ModBlocks.MAPLE_LOG.get(), ModBlocks.MAPLE_LEAVES_ORANGE.get());}
    
    private static TreeConfiguration.TreeConfigurationBuilder orangePineMaple() {return createPineStyle(ModBlocks.MAPLE_LOG.get(), ModBlocks.MAPLE_LEAVES_ORANGE.get());}
    
    private static TreeConfiguration.TreeConfigurationBuilder redSpruceMaple() {return createSpruceStyle(ModBlocks.MAPLE_LOG.get(), ModBlocks.MAPLE_LEAVES_RED.get());}
    
    private static TreeConfiguration.TreeConfigurationBuilder redPineMaple() {return createPineStyle(ModBlocks.MAPLE_LOG.get(), ModBlocks.MAPLE_LEAVES_RED.get());}
    //endregion
    //region Orange
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE = register("orange_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.ORANGE_LOG.get(), ModBlocks.ORANGE_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE_FANCY = register("orange_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.ORANGE_LOG.get(), ModBlocks.ORANGE_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE_BEES_002 = register("orange_tree_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.ORANGE_LOG.get(), ModBlocks.ORANGE_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE_FANCY_BEES_002 = register("orange_tree_fancy_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.ORANGE_LOG.get(), ModBlocks.ORANGE_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE_BEES_005 = register("orange_tree_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.ORANGE_LOG.get(), ModBlocks.ORANGE_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE_FANCY_BEES_005 = register("orange_tree_fancy_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.ORANGE_LOG.get(), ModBlocks.ORANGE_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORANGE_TREE_SPAWN = register("orange_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.ORANGE_TREE_FANCY_BEES_002_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.ORANGE_TREE_BEES_002_CHECKED.getHolder().get())));
    //endregion
    //region Peach
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE = register("peach_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PEACH_LOG.get(), ModBlocks.PEACH_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE_FANCY = register("peach_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PEACH_LOG.get(), ModBlocks.PEACH_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE_BEES_002 = register("peach_tree_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PEACH_LOG.get(), ModBlocks.PEACH_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE_FANCY_BEES_002 = register("peach_tree_fancy_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PEACH_LOG.get(), ModBlocks.PEACH_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE_BEES_005 = register("peach_tree_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PEACH_LOG.get(), ModBlocks.PEACH_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE_FANCY_BEES_005 = register("peach_tree_fancy_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PEACH_LOG.get(), ModBlocks.PEACH_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEACH_TREE_SPAWN = register("peach_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.PEACH_TREE_FANCY_BEES_002_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.PEACH_TREE_BEES_002_CHECKED.getHolder().get())));
    //endregion
    //region Pear
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE = register("pear_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PEAR_LOG.get(), ModBlocks.PEAR_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE_FANCY = register("pear_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PEAR_LOG.get(), ModBlocks.PEAR_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE_BEES_002 = register("pear_tree_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PEAR_LOG.get(), ModBlocks.PEAR_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE_FANCY_BEES_002 = register("pear_tree_fancy_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PEAR_LOG.get(), ModBlocks.PEAR_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE_BEES_005 = register("pear_tree_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PEAR_LOG.get(), ModBlocks.PEAR_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE_FANCY_BEES_005 = register("pear_tree_fancy_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PEAR_LOG.get(), ModBlocks.PEAR_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PEAR_TREE_SPAWN = register("pear_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.PEAR_TREE_FANCY_BEES_002_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.PEAR_TREE_BEES_002_CHECKED.getHolder().get())));
    //endregion
    //region Plum
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE = register("plum_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PLUM_LOG.get(), ModBlocks.PLUM_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE_FANCY = register("plum_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PLUM_LOG.get(), ModBlocks.PLUM_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE_BEES_002 = register("plum_tree_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PLUM_LOG.get(), ModBlocks.PLUM_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE_FANCY_BEES_002 = register("plum_tree_fancy_bees_002",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PLUM_LOG.get(), ModBlocks.PLUM_LEAVES.get()).decorators(List.of(BEEHIVE_002)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE_BEES_005 = register("plum_tree_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.PLUM_LOG.get(), ModBlocks.PLUM_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE_FANCY_BEES_005 = register("plum_tree_fancy_bees_005",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.PLUM_LOG.get(), ModBlocks.PLUM_LEAVES.get()).decorators(List.of(BEEHIVE_005)).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PLUM_TREE_SPAWN = register("plum_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.PLUM_TREE_FANCY_BEES_002_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.PLUM_TREE_BEES_002_CHECKED.getHolder().get())));
    //endregion
    //region Charred
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHARRED_TREE = register("charred_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.CHARRED_LOG.get(), ModBlocks.CHARRED_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHARRED_TREE_FANCY = register("charred_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.CHARRED_LOG.get(), ModBlocks.CHARRED_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CHARRED_TREE_SPAWN = register("charred_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.CHARRED_TREE_FANCY_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.CHARRED_TREE_CHECKED.getHolder().get())));
    //endregion
    //region Corrupt
    public static final RegistryObject<ConfiguredFeature<?, ?>> CORRUPT_TREE = register("corrupt_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.CORRUPT_LOG.get(), ModBlocks.CORRUPT_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CORRUPT_TREE_FANCY = register("corrupt_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.CORRUPT_LOG.get(), ModBlocks.CORRUPT_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> CORRUPT_TREE_SPAWN = register("corrupt_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.CORRUPT_TREE_FANCY_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.CORRUPT_TREE_CHECKED.getHolder().get())));
    //endregion
    //region Dead
    public static final RegistryObject<ConfiguredFeature<?, ?>> DEAD_TREE = register("dead_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.DEAD_LOG.get(), ModBlocks.DEAD_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> DEAD_TREE_FANCY = register("dead_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.DEAD_LOG.get(), ModBlocks.DEAD_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> DEAD_TREE_SPAWN = register("dead_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.DEAD_TREE_FANCY_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.DEAD_TREE_CHECKED.getHolder().get())));
    //endregion
    //region Infected
    public static final RegistryObject<ConfiguredFeature<?, ?>> INFECTED_TREE = register("infected_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createOakStyle(ModBlocks.INFECTED_LOG.get(), ModBlocks.INFECTED_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> INFECTED_TREE_FANCY = register("infected_tree_fancy",
            () -> new ConfiguredFeature<>(Feature.TREE, createFancyOakStyle(ModBlocks.INFECTED_LOG.get(), ModBlocks.INFECTED_LEAVES.get()).build())
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> INFECTED_TREE_SPAWN = register("infected_tree_spawn",
            () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
                    new WeightedPlacedFeature(ModPlacedFeatures.INFECTED_TREE_FANCY_CHECKED.getHolder().get(), 0.1F)
            ), ModPlacedFeatures.INFECTED_TREE_CHECKED.getHolder().get())));
    //endregion
    //region Ebony
    public static final RegistryObject<ConfiguredFeature<?, ?>> EBONY_TREE = register("ebony_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, createStraightSphereBlobTree(ModBlocks.EBONY_LOG.get(), ModBlocks.EBONY_LEAVES.get(), 7, 3, 2, 4).build())
    );
    //endregion
    //region Olive
    public static final RegistryObject<ConfiguredFeature<?, ?>> OLIVE_TREE = register("olive_tree",
            () -> new ConfiguredFeature<>(Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.OLIVE_LOG.get()),
                    new ForkingTrunkPlacer(3,3,3),
                    BlockStateProvider.simple(ModBlocks.OLIVE_LEAVES.get()),
                    new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 2))
            ).ignoreVines().build()));
    
    //endregion
    //region Wisteria
    public static final RegistryObject<ConfiguredFeature<?, ?>> WISTERIA_TREE_BLUE = register("wisteria_tree_blue",
            () -> new ConfiguredFeature<>(ModFeatures.ADVANCED_TREE_FEATURE.get(), createWisteriaStyle(ModBlocks.WISTERIA_LOG.get(), ModBlocks.WISTERIA_LEAVES_BLUE.get().defaultBlockState(), ModBlocks.BLUE_LUNALIGHT.get().defaultBlockState(), ModBlocks.WISTERIA_WOOD.get().defaultBlockState()))
    );
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> WISTERIA_TREE_PURPLE = register("wisteria_tree_purple",
            () -> new ConfiguredFeature<>(ModFeatures.ADVANCED_TREE_FEATURE.get(), createWisteriaStyle(ModBlocks.WISTERIA_LOG.get(), ModBlocks.WISTERIA_LEAVES_PURPLE.get().defaultBlockState(), ModBlocks.PURPLE_LUNALIGHT.get().defaultBlockState(), ModBlocks.WISTERIA_WOOD.get().defaultBlockState()))
    );
    //endregion
    
    private static TreeConfiguration createWisteriaStyle(Block logBlock, BlockState leafBlockState, BlockState randomBlockState, BlockState branchBlockState) {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new BranchingTrunkPlacer(
                        6,
                        3,
                        1,
                        BranchingTrunkPlacer.BranchMovementWeightsProvider.createDefault(),
                        ConstantInt.of(3),
                        BranchingTrunkPlacer.BranchRangeProvider.createDefault(),
                        BlockStateProvider.simple(branchBlockState),
                        0.4d),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(leafBlockState, 85).add(randomBlockState, 1)),
                new MetaballFoliagePlacer(
                        UniformInt.of(2,3),
                        ConstantInt.of(0),
                        ConstantInt.of(0),
                        ConstantInt.of(0),
                        ConstantFloat.of(1F),
                        ConstantFloat.of(0.25F),
                        ConstantFloat.of(1F),
                        ConstantFloat.of(0.5F)),
                new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createOakStyle(Block logBlock, Block leafBlock) {
        return createStraightBlobTree(logBlock, leafBlock, 4, 2, 0, 2).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createFancyOakStyle(Block logBlock, Block leafBlock) {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(leafBlock), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createSpruceStyle(Block logBlock, Block leafBlock) {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.simple(leafBlock),
                new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2))
        ).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createPineStyle(Block logBlock, Block leafBlock) {
        return (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(6, 4, 0),
                BlockStateProvider.simple(leafBlock),
                new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)),
                new TwoLayersFeatureSize(2, 0, 2))
        ).ignoreVines();
    }
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leafBlock, int baseHeight, int addHeightA, int addHeightB, int leafRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(baseHeight, addHeightA, addHeightB),
                BlockStateProvider.simple(leafBlock),
                new BlobFoliagePlacer(ConstantInt.of(leafRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }
    private static TreeConfiguration.TreeConfigurationBuilder createStraightSphereBlobTree(Block logBlock, Block leafBlock, int baseHeight, int addHeightA, int addHeightB, int leafRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(baseHeight, addHeightA, addHeightB),
                BlockStateProvider.simple(leafBlock),
                // radius / offset / height
                new FancyFoliagePlacer(ConstantInt.of(leafRadius), ConstantInt.of(1), leafRadius),
                new TwoLayersFeatureSize(2, 0, 2));
    }
    //endregion
    
    
    public static RegistryObject<ConfiguredFeature<?, ?>> register(final String name, final Supplier<? extends ConfiguredFeature<?, ?>> sup) {
        return CONFIGURED_FEATURES.register(name, sup);
    }

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
