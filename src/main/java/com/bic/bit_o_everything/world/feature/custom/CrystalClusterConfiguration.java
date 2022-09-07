package com.bic.bit_o_everything.world.feature.custom;

import com.bic.bit_o_everything.ModUtils;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.custom.CrystalBlock;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistryCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class CrystalClusterConfiguration implements FeatureConfiguration {
    public static List<Double> DEFAULT_EXTRA_CHANCES = List.of(0.4d, 0.3d);
    public static WeightedStateProvider DEFAULT_CRYSTAL_WEIGHTS = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
            .add(ModBlocks.AQUAMARINE.get().defaultBlockState(), 1)
            .add(ModBlocks.TANZANITE.get().defaultBlockState(), 1)
            .add(ModBlocks.MOLDAVITE.get().defaultBlockState(), 1)
            .add(ModBlocks.RHODOCHROSITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CELESTITE.get().defaultBlockState(), 1)
            .add(ModBlocks.CITRINE.get().defaultBlockState(), 1)
    );
    public static final HolderSet<Block> DEFAULT_CRYSTALS_PLACED_ON = HolderSet.direct(Block::builtInRegistryHolder,
            Blocks.STONE, Blocks.DEEPSLATE, Blocks.ANDESITE, Blocks.GRANITE, Blocks.DIORITE,
            Blocks.SMOOTH_BASALT, Blocks.CALCITE, Blocks.TUFF, Blocks.OBSIDIAN, Blocks.DRIPSTONE_BLOCK,
            Blocks.COAL_ORE, Blocks.COPPER_ORE, Blocks.DEEPSLATE_COPPER_ORE, Blocks.DEEPSLATE_COAL_ORE,
            Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_ORE,
            Blocks.IRON_ORE, Blocks.DEEPSLATE_IRON_ORE, Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE,
            Blocks.REDSTONE_ORE, Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.LAPIS_ORE, Blocks.DEEPSLATE_LAPIS_ORE,
            ModBlocks.PYRITE_ORE.get(), ModBlocks.DEEPSLATE_PYRITE_ORE.get(), ModBlocks.ZINC_ORE.get(),
            ModBlocks.DEEPSLATE_ZINC_ORE.get(), ModBlocks.MAGNESIUM_ORE.get(), ModBlocks.DEEPSLATE_MAGNESIUM_ORE.get(),
            ModBlocks.SILVER_ORE.get(), ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModBlocks.TIN_ORE.get(), ModBlocks.DEEPSLATE_TIN_ORE.get(),
            ModBlocks.LEAD_ORE.get(), ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModBlocks.TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get(),
            ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            ModBlocks.BISMUTH_ORE.get(), ModBlocks.DEEPSLATE_BISMUTH_ORE.get(), ModBlocks.ANDESITE_BISMUTH_ORE.get(),
            ModBlocks.GRANITE_BISMUTH_ORE.get(), ModBlocks.DIORITE_BISMUTH_ORE.get(), ModBlocks.TUFF_BISMUTH_ORE.get());

    public static final Codec<CrystalClusterConfiguration> CODEC = RecordCodecBuilder.create((crystalGrowthConfiguration) -> crystalGrowthConfiguration.group(
            BlockStateProvider.CODEC.fieldOf("crystals").orElse(DEFAULT_CRYSTAL_WEIGHTS).forGetter((CGC) -> CGC.crystals),
            RegistryCodecs.homogeneousList(ForgeRegistries.BLOCKS.getRegistryKey()).fieldOf("can_be_placed_on").orElse(DEFAULT_CRYSTALS_PLACED_ON).forGetter((CGC) -> CGC.canBePlacedOn),
            Codec.INT.fieldOf("attempts").orElse(15).forGetter((CGC) -> CGC.attempts),
            Codec.DOUBLE.listOf().fieldOf("extra_chances").orElse(DEFAULT_EXTRA_CHANCES).forGetter((CGC) -> CGC.extraChances),
            Codec.INT.fieldOf("extra_radius").orElse(10).forGetter((CGC) -> CGC.extraRadius)
    ).apply(crystalGrowthConfiguration, CrystalClusterConfiguration::new));

    public final int extraRadius; // radius to place extra crystals in
    public final HolderSet<Block> canBePlacedOn; // list of blocks that the crystal may be placed on
    public final int attempts; // attempts to place
    public final List<Double> extraChances; // chances to place each next crystal
    public final BlockStateProvider crystals; // weighted list of crystals to be placed

    public CrystalBlock getCrystal(RandomSource randomSource) {
        return (CrystalBlock) this.crystals.getState(randomSource, null).getBlock();
    }

    public int quantityToPlace(RandomSource randomSource) {
        int quantity = 1;
        for (double d : this.extraChances) {
            if (randomSource.nextDouble() > d) {
                break;
            }
            quantity ++;
        }
        return quantity;
    }

    public CrystalClusterConfiguration(BlockStateProvider crystals, HolderSet<Block> canBePlacedOn, int attempts, List<Double> extraChances, int extraRadius) {
        this.crystals = crystals;
        this.extraRadius = extraRadius;
        this.attempts = attempts;
        this.canBePlacedOn = canBePlacedOn;
        this.extraChances = extraChances;
    }

    //CrystalBlock
    public CrystalClusterConfiguration(CrystalBlock crystal, HolderSet<Block> canBePlacedOn, int attempts, List<Double> extraChances, int extraRadius) {
        this.crystals = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(crystal.defaultBlockState(), 1));
        this.extraRadius = extraRadius;
        this.attempts = attempts;
        this.canBePlacedOn = canBePlacedOn;
        this.extraChances = extraChances;
    }

    //Default canBePlacedOn
    public CrystalClusterConfiguration(Supplier<BlockStateProvider> crystals, int attempts, List<Double> extraChances, int extraRadius) {
        this.crystals = crystals.get();
        this.extraRadius = extraRadius;
        this.attempts = attempts;
        this.canBePlacedOn = DEFAULT_CRYSTALS_PLACED_ON;
        this.extraChances = extraChances;
    }

    //Default canBePlacedOn & Default extraRadius & Default attempts
    public CrystalClusterConfiguration(Supplier<BlockStateProvider> crystals, List<Double> extraChances) {
        this.crystals = crystals.get();
        this.extraRadius = 5;
        this.attempts = 30;
        this.canBePlacedOn = DEFAULT_CRYSTALS_PLACED_ON;
        this.extraChances = extraChances;
    }

    //CrystalBlock & Default canBePlacedOn
    public CrystalClusterConfiguration(CrystalBlock crystal, int attempts, List<Double> extraChances, int extraRadius) {
        this.crystals = new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(crystal.defaultBlockState(), 1));
        this.extraRadius = extraRadius;
        this.attempts = attempts;
        this.canBePlacedOn = DEFAULT_CRYSTALS_PLACED_ON;
        this.extraChances = extraChances;
    }

}
