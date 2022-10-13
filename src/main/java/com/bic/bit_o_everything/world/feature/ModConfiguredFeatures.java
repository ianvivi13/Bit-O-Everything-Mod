package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.datagen.ModTags;
import com.bic.bit_o_everything.world.feature.custom.CrystalClusterConfiguration;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
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
    //region Decorators
    private static final BeehiveDecorator BEEHIVE_0002 = new BeehiveDecorator(0.002F); // 0.2%
    private static final BeehiveDecorator BEEHIVE_002 = new BeehiveDecorator(0.02F); // 2%
    private static final BeehiveDecorator BEEHIVE_005 = new BeehiveDecorator(0.05F); // 5%
    private static final BeehiveDecorator BEEHIVE = new BeehiveDecorator(1.0F); // 100%
    //endregion
    //region Trees
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
    
    // Regular Oak Style Tree
    private static TreeConfiguration.TreeConfigurationBuilder createOakStyle(Block logBlock, Block leafBlock) {
        return createStraightBlobTree(logBlock, leafBlock, 4, 2, 0, 2).ignoreVines();
    }
    
    // Regular Large Oak Style Tree
    private static TreeConfiguration.TreeConfigurationBuilder createFancyOakStyle(Block logBlock, Block leafBlock) {
        return (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock), new FancyTrunkPlacer(3, 11, 0), BlockStateProvider.simple(leafBlock), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines();
    }
    
    private static TreeConfiguration.TreeConfigurationBuilder createStraightBlobTree(Block logBlock, Block leafBlock, int baseHeight, int addHeightA, int addHeightB, int leafRadius) {
        return new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(logBlock),
                new StraightTrunkPlacer(baseHeight, addHeightA, addHeightB), BlockStateProvider.simple(leafBlock),
                new BlobFoliagePlacer(ConstantInt.of(leafRadius), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1));
    }
    //endregion
    
    
    public static RegistryObject<ConfiguredFeature<?, ?>> register(final String name, final Supplier<? extends ConfiguredFeature<?, ?>> sup) {
        return CONFIGURED_FEATURES.register(name, sup);
    }

    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
