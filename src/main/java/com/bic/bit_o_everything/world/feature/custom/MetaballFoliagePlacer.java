package com.bic.bit_o_everything.world.feature.custom;

import com.bic.bit_o_everything.util.metaballs.Metaball;
import com.bic.bit_o_everything.util.metaballs.Metafield;
import com.bic.bit_o_everything.world.feature.ModFoliagePlacerType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class MetaballFoliagePlacer extends AdvancedFoliagePlacer {
    public static final Codec<MetaballFoliagePlacer> CODEC = RecordCodecBuilder.create((placerInstance) ->
            foliagePlacerParts(placerInstance).and(placerInstance.group(
                    IntProvider.CODEC.fieldOf("y_offset").forGetter((instance) -> instance.yOffset),
                    IntProvider.CODEC.fieldOf("z_offset").forGetter((instance) -> instance.zOffset),
                    FloatProvider.CODEC.fieldOf("metaball_x_scale").forGetter((instance) -> instance.metaballXScale),
                    FloatProvider.CODEC.fieldOf("metaball_y_scale").forGetter((instance) -> instance.metaballYScale),
                    FloatProvider.CODEC.fieldOf("metaball_z_scale").forGetter((instance) -> instance.metaballZScale),
                    FloatProvider.CODEC.fieldOf("threshold").forGetter((instance) -> instance.threshold)
            )).apply(placerInstance, MetaballFoliagePlacer::new));
    
    protected final IntProvider yOffset;
    protected final IntProvider zOffset;
    protected final FloatProvider metaballXScale;
    protected final FloatProvider metaballYScale;
    protected final FloatProvider metaballZScale;
    protected final FloatProvider threshold;
    
    public MetaballFoliagePlacer(IntProvider radius, IntProvider xOffset, IntProvider yOffset, IntProvider zOffset, FloatProvider metaballXScale, FloatProvider metaballYScale, FloatProvider metaballZScale, FloatProvider threshold) {
        super(radius, xOffset);
        this.yOffset = yOffset;
        this.zOffset = zOffset;
        this.metaballXScale = metaballXScale;
        this.metaballYScale = metaballYScale;
        this.metaballZScale = metaballZScale;
        this.threshold = threshold;
    }
    
    private BlockPos getFoliagePosition(RandomSource randomSource, FoliageAttachment attachment) {
        return attachment.pos().offset(this.offset.sample(randomSource), this.yOffset.sample(randomSource), this.zOffset.sample(randomSource));
    }
    
    private Metaball createMetaball(RandomSource randomSource, FoliageAttachment attachment) {
        return Metaball.createEllipsoid(
                this.getFoliagePosition(randomSource, attachment),
                this.radius.sample(randomSource),
                1 / this.metaballXScale.sample(randomSource),
                1 / this.metaballYScale.sample(randomSource),
                1 / this.metaballZScale.sample(randomSource)
        );
    }
    
    @Override
    protected void createFoliage(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, TreeConfiguration treeConfiguration, int p_225617_, List<FoliageAttachment> foliageAttachments, int p_225619_, int p_225620_, int offset) {
        if (foliageAttachments.size() == 0) return;
        Metafield metafield = new Metafield(this.threshold.sample(randomSource));
        foliageAttachments.forEach((attachment -> metafield.addMetaball(this.createMetaball(randomSource, attachment))));
        BlockPos center = findCenterPosition(foliageAttachments);
        attemptLeafPlacements(simulatedReader, biConsumer, randomSource, treeConfiguration, metafield.determineLeafPlacements(center, 16));
    }
    
    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacerType.METABALL_FOLIAGE_PLACER.get();
    }
    
    @Override
    public int foliageHeight(RandomSource p_225601_, int p_225602_, TreeConfiguration p_225603_) {
        return 0;
    }
    
    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int p_225489_, int p_225490_, int p_225491_, int p_225492_, boolean p_225493_) {
        return false;
    }
}
