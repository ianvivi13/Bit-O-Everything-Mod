package com.bic.bit_o_everything.world.feature;

import com.bic.bit_o_everything.BitOEverything;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BitOEverything.MOD_ID);

    //region overworld
    public static final RegistryObject<PlacedFeature> PYRITE_ORE_PLACED = PLACED_FEATURES.register("pyrite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PYRITE_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));

    public static final RegistryObject<PlacedFeature> PYRITE_ORE_LOWER_PLACED = PLACED_FEATURES.register("pyrite_ore_lower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PYRITE_ORE.getHolder().get(),
                    orePlacement(CountPlacement.of(UniformInt.of(0, 1)),
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));

    public static final RegistryObject<PlacedFeature> PYRITE_ORE_EXTRA_PLACED = PLACED_FEATURES.register("pyrite_ore_extra_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PYRITE_ORE_EXTRA.getHolder().get(),
                    commonOrePlacement(20,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(256)))));

    public static final RegistryObject<PlacedFeature> ZINC_ORE_PLACED = PLACED_FEATURES.register("zinc_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ZINC_ORE.getHolder().get(),
                    commonOrePlacement(4,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(64)))));

    public static final RegistryObject<PlacedFeature> MAGNESIUM_ORE_PLACED = PLACED_FEATURES.register("magnesium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MAGNESIUM_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(48)))));

    public static final RegistryObject<PlacedFeature> SILVER_ORE_PLACED = PLACED_FEATURES.register("silver_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORE.getHolder().get(),
                    commonOrePlacement(2,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16)))));

    public static final RegistryObject<PlacedFeature> SILVER_ORE_LOWER_PLACED = PLACED_FEATURES.register("silver_ore_lower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILVER_ORE.getHolder().get(),
                    orePlacement(CountPlacement.of(UniformInt.of(0, 1)),
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));

    public static final RegistryObject<PlacedFeature> TIN_ORE_PLACED = PLACED_FEATURES.register("tin_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TIN_ORE.getHolder().get(),
                    commonOrePlacement(5,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)))));

    public static final RegistryObject<PlacedFeature> LEAD_ORE_PLACED = PLACED_FEATURES.register("lead_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.LEAD_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(256)))));

    public static final RegistryObject<PlacedFeature> TITANIUM_ORE_PLACED = PLACED_FEATURES.register("titanium_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.TITANIUM_ORE.getHolder().get(),
                    commonOrePlacement(4,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-16)))));

    public static final RegistryObject<PlacedFeature> RUBY_ORE_PLACED = PLACED_FEATURES.register("ruby_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RUBY_ORE.getHolder().get(),
                    commonOrePlacement(100,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(175)))));

    public static final RegistryObject<PlacedFeature> SAPPHIRE_ORE_PLACED = PLACED_FEATURES.register("sapphire_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SAPPHIRE_ORE.getHolder().get(),
                    commonOrePlacement(100,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(175)))));

    public static final RegistryObject<PlacedFeature> SILICON_ORE_PLACED = PLACED_FEATURES.register("silicon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SILICON_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(128)))));

    public static final RegistryObject<PlacedFeature> RED_SILICON_ORE_PLACED = PLACED_FEATURES.register("red_silicon_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RED_SILICON_ORE.getHolder().get(),
                    commonOrePlacement(10,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(128)))));

    public static final RegistryObject<PlacedFeature> BISMUTH_ORE_PLACED = PLACED_FEATURES.register("bismuth_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BISMUTH_ORE.getHolder().get(),
                    commonOrePlacement(7,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(48)))));
    //endregion
    //region nether
    public static final RegistryObject<PlacedFeature> ROSALITE_ORE_PLACED = PLACED_FEATURES.register("rosalite_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ROSALITE_ORE.getHolder().get(),
                    commonOrePlacement(6,
                            PlacementUtils.RANGE_10_10)));

    public static final RegistryObject<PlacedFeature> SMOKY_QUARTZ_ORE_PLACED = PLACED_FEATURES.register("smoky_quartz_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SMOKY_QUARTZ_ORE.getHolder().get(),
                    commonOrePlacement(16,
                            PlacementUtils.RANGE_10_10)));
    //endregion



    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}
