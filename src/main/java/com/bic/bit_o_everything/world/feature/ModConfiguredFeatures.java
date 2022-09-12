package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.datagen.ModTags;
import com.bic.bit_o_everything.world.feature.custom.CrystalClusterConfiguration;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final RuleTest SAND_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.SAND_ORE_REPLACEABLES);
    public static final RuleTest RED_SAND_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.RED_SAND_ORE_REPLACEABLES);
    public static final RuleTest ANDESITE_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.ANDESITE_ORE_REPLACEABLES);
    public static final RuleTest GRANITE_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.GRANITE_ORE_REPLACEABLES);
    public static final RuleTest DIORITE_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.DIORITE_ORE_REPLACEABLES);
    public static final RuleTest TUFF_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.TUFF_ORE_REPLACEABLES);
    public static final RuleTest BASALT_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.BASALT_ORE_REPLACEABLES);
    public static final RuleTest UNOBTAINIUM_ORE_REPLACEABLES = new TagMatchTest(ModTags.Blocks.UNOBTAINIUM_ORE_REPLACEABLES);

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BitOEverything.MOD_ID);
    /*public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CHERRY_TREE =
            FeatureUtils.register("cherry", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.CHERRY_LOG.get()),
                    new StraightTrunkPlacer(3, 4, 2),
                    BlockStateProvider.simple(ModBlocks.CHERRY_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> CHERRY_CHECKED = PlacementUtils.register("cherry_checked", CHERRY_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.CHERRY_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> CHERRY_SPAWN =
            FeatureUtils.register("cherry_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(CHERRY_CHECKED,
                            0.5F)), CHERRY_CHECKED));*/

    //region ores
    //region overworld
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PYRITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.PYRITE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_PYRITE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_ZINC_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ZINC_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGNESIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MAGNESIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TIN_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_LEAD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.LEAD_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_LEAD_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TITANIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SAPPHIRE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SAPPHIRE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILICON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(SAND_ORE_REPLACEABLES, ModBlocks.SILICON_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RED_SILICON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(RED_SAND_ORE_REPLACEABLES, ModBlocks.RED_SILICON_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BISMUTH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(GRANITE_ORE_REPLACEABLES, ModBlocks.GRANITE_BISMUTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(ANDESITE_ORE_REPLACEABLES, ModBlocks.ANDESITE_BISMUTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(DIORITE_ORE_REPLACEABLES, ModBlocks.DIORITE_BISMUTH_ORE.get().defaultBlockState()),
            OreConfiguration.target(TUFF_ORE_REPLACEABLES, ModBlocks.TUFF_BISMUTH_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_UNOBTAINIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(UNOBTAINIUM_ORE_REPLACEABLES, ModBlocks.UNOBTAINIUM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PYRITE_ORE = CONFIGURED_FEATURES.register("pyrite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PYRITE_ORES.get(), 9, 0.5F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PYRITE_ORE_EXTRA = CONFIGURED_FEATURES.register("pyrite_ore_extra",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_PYRITE_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE = CONFIGURED_FEATURES.register("zinc_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_ZINC_ORES.get(), 6, 0.3F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MAGNESIUM_ORE = CONFIGURED_FEATURES.register("magnesium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_MAGNESIUM_ORES.get(), 8, 0.4F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SILVER_ORE = CONFIGURED_FEATURES.register("silver_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SILVER_ORES.get(), 7, 0.6F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TIN_ORE = CONFIGURED_FEATURES.register("tin_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TIN_ORES.get(), 12, 0.4F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> LEAD_ORE = CONFIGURED_FEATURES.register("lead_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_LEAD_ORES.get(), 7, 0.6F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TITANIUM_ORE = CONFIGURED_FEATURES.register("titanium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TITANIUM_ORES.get(), 4, 0.95F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RUBY_ORE = CONFIGURED_FEATURES.register("ruby_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES.get(), 3, 0.2F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SAPPHIRE_ORE = CONFIGURED_FEATURES.register("sapphire_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SAPPHIRE_ORES.get(), 3, 0.2F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SILICON_ORE = CONFIGURED_FEATURES.register("silicon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_SILICON_ORES.get(), 7, 0.95F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RED_SILICON_ORE = CONFIGURED_FEATURES.register("red_silicon_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_RED_SILICON_ORES.get(), 4, 0.5F)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BISMUTH_ORE = CONFIGURED_FEATURES.register("bismuth_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_BISMUTH_ORES.get(), 8)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> UNOBTAINIUM_ORE = CONFIGURED_FEATURES.register("unobtainium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_UNOBTAINIUM_ORES.get(), 3, 1.0F)));
    //endregion
    //region nether
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_ROSALITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(BASALT_ORE_REPLACEABLES, ModBlocks.BASALT_ROSALITE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_SMOKY_QUARTZ_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHERRACK, ModBlocks.SMOKY_QUARTZ_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ROSALITE_ORE = CONFIGURED_FEATURES.register("rosalite_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_ROSALITE_ORES.get(), 9)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOKY_QUARTZ_ORE = CONFIGURED_FEATURES.register("smoky_quartz_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_SMOKY_QUARTZ_ORES.get(), 14)));


    //endregion
    //endregion
    //region Crystals - Overworld
    public static List<Double> EXTRA_CRYSTAL_CHANCES = List.of(0.95d, 0.90d, 0.85d, 0.8d, 0.75d, 0.7d, 0.65d, 0.6d, 0.55d, 0.5d, 0.45d, 0.4d, 0.35, 0.3d);

    public static final Supplier<BlockStateProvider> MOLDAVITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 95)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 10)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));

    public static final Supplier<BlockStateProvider> RHODOCHROSITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 95)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 10)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));

    public static final Supplier<BlockStateProvider> TANZANITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 10)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 95)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));

    public static final Supplier<BlockStateProvider> CITRINE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 10)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 95)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
    ));

    public static final Supplier<BlockStateProvider> AQUAMARINE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 95)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 10)
    ));

    public static final Supplier<BlockStateProvider> CELESTITE_LIST = Suppliers.memoize(() -> new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 10)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 95)
    ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MOLDAVITE_GROWTH = CONFIGURED_FEATURES.register("moldavite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(MOLDAVITE_LIST, EXTRA_CRYSTAL_CHANCES)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> RHODOCHROSITE_GROWTH = CONFIGURED_FEATURES.register("rhodochrosite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(RHODOCHROSITE_LIST, EXTRA_CRYSTAL_CHANCES)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> TANZANITE_GROWTH = CONFIGURED_FEATURES.register("tanzanite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(TANZANITE_LIST, EXTRA_CRYSTAL_CHANCES)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CITRINE_GROWTH = CONFIGURED_FEATURES.register("citrine_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(CITRINE_LIST, EXTRA_CRYSTAL_CHANCES)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> AQUAMARINE_GROWTH = CONFIGURED_FEATURES.register("aguamarine_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(AQUAMARINE_LIST, EXTRA_CRYSTAL_CHANCES)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CELESTITE_GROWTH = CONFIGURED_FEATURES.register("celestite_growth",
            () -> new ConfiguredFeature<>(ModFeatures.CRYSTAL_CLUSTER.get(), new CrystalClusterConfiguration(CELESTITE_LIST, EXTRA_CRYSTAL_CHANCES)));
    //endregion


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}
