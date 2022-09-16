package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BitOEverything.MOD_ID);

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
    // answer to TreePlacements
    public static final RegistryObject<PlacedFeature> CHERRY_CHECKED = register("cherry_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING))));
    // vegetation placement
    public static final RegistryObject<PlacedFeature> CHERRY_COMMON_PLACED = register("cherry_common_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.3333333333333F, 1))));

    public static final RegistryObject<PlacedFeature> CHERRY_RARE_PLACED = register("cherry_rare_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CHERRY_SPAWN.getHolder().get(),
                    VegetationPlacements.treePlacement(PlacementUtils.countExtra(0,0.01F, 1))));


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
