package com.bic.bit_o_everything.world.feature.custom;



import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class AdvancedFoliagePlacer extends FoliagePlacer {
    
    public AdvancedFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }
    
    private int offset(RandomSource p_225592_) {
        return this.offset.sample(p_225592_);
    }
    
    public void createFoliage(LevelSimulatedReader p_225605_, BiConsumer<BlockPos, BlockState> p_225606_, RandomSource p_225607_, TreeConfiguration p_225608_, int p_225609_, List<FoliagePlacer.FoliageAttachment> p_225610_, int p_225611_, int p_225612_) {
        this.createFoliage(p_225605_, p_225606_, p_225607_, p_225608_, p_225609_, p_225610_, p_225611_, p_225612_, this.offset(p_225607_));
    }
    
    protected abstract void createFoliage(LevelSimulatedReader p_225613_, BiConsumer<BlockPos, BlockState> p_225614_, RandomSource p_225615_, TreeConfiguration p_225616_, int p_225617_, List<FoliagePlacer.FoliageAttachment> p_225618_, int p_225619_, int p_225620_, int p_225621_);
    
    protected void createFoliage(LevelSimulatedReader p_225613_, BiConsumer<BlockPos, BlockState> p_225614_, RandomSource p_225615_, TreeConfiguration p_225616_, int p_225617_, FoliagePlacer.FoliageAttachment p_225618_, int p_225619_, int p_225620_, int p_225621_) {
        List<FoliagePlacer.FoliageAttachment> list = new ArrayList<>();
        list.add(p_225618_);
        this.createFoliage(p_225613_, p_225614_, p_225615_, p_225616_, p_225617_, list, p_225619_, p_225620_, p_225621_);
    }
    
    
    protected static BlockPos getPlacePosition(FoliageAttachment attachment, int offset) {
        return attachment.pos().above(offset);
    }
    
    protected static String blockPosString(BlockPos blockPos) {
        return "X: " + blockPos.getX() + "| Y: " + blockPos.getY() + "| Z: " + blockPos.getZ();
    }
    
    protected static BlockPos findCenterPosition(List<FoliageAttachment> foliageAttachments) {
        BlockPos blockPos = new BlockPos(0,0,0);
        for (FoliageAttachment attachment : foliageAttachments) {
            blockPos = blockPos.offset(attachment.pos());
        }
        int x = blockPos.getX() / foliageAttachments.size();
        int y = blockPos.getY() / foliageAttachments.size();
        int z = blockPos.getZ() / foliageAttachments.size();
        return new BlockPos(x,y,z);
    }
    
    protected static void attemptLeafPlacements(LevelSimulatedReader simulatedReader, BiConsumer<BlockPos, BlockState> biConsumer, RandomSource randomSource, TreeConfiguration treeConfiguration, List<BlockPos> positions) {
        positions.forEach((position) -> tryPlaceLeaf(simulatedReader, biConsumer, randomSource, treeConfiguration, position));
    }
}
