package com.bic.bit_o_everything.world.feature.custom;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.custom.TreeTapBlock;
import com.bic.bit_o_everything.world.feature.ModTreeDecoratorType;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeTapDecorator extends TreeDecorator {
    public static final Codec<TreeTapDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(TreeTapDecorator::new, (p_69971_) -> p_69971_.probability).codec();
    private static final Direction WORLDGEN_FACING = Direction.SOUTH;
    private static final Direction[] SPAWN_DIRECTIONS = Direction.Plane.HORIZONTAL.stream().filter((p_202307_) -> p_202307_ != WORLDGEN_FACING.getOpposite()).toArray(Direction[]::new);
    
    private final float probability;
    
    public TreeTapDecorator(float p_69958_) {
        this.probability = p_69958_;
    }
    
    protected TreeDecoratorType<?> type() {
        return ModTreeDecoratorType.TREE_TAP_DECORATOR.get();
    }
    
    public void place(TreeDecorator.Context context) {
        RandomSource randomsource = context.random();
        if (!(randomsource.nextFloat() >= this.probability)) {
            List<BlockPos> leafPosList = context.leaves();
            List<BlockPos> logPosList = context.logs();
            
            // between these 2 values (inclusive) are the Y levels in which taps may be placed
            int bottomLogY = logPosList.get(0).getY();
            int bottomLeafY = leafPosList.isEmpty() ? bottomLogY + 2 : Math.min(leafPosList.get(0).getY() - 1, bottomLogY + 2);
            
            // all horizontal blockPos next to logs where bottomLogY <= Y <= bottomLeafY
            List<BlockPos> availablePositions = logPosList.stream().filter((blockPos) -> blockPos.getY() >= bottomLogY && blockPos.getY() <= bottomLeafY).flatMap((blockPos) -> Stream.of(SPAWN_DIRECTIONS).map(blockPos::relative)).collect(Collectors.toList());
            
            if (!availablePositions.isEmpty()) {
                Collections.shuffle(availablePositions);
                Optional<BlockPos> optional = availablePositions.stream().filter((blockPos) -> context.isAir(blockPos) && context.isAir(blockPos.relative(WORLDGEN_FACING))).findFirst();
                optional.ifPresent(blockPos -> context.setBlock(blockPos, ModBlocks.TREE_TAP.get().defaultBlockState().setValue(TreeTapBlock.FACING, WORLDGEN_FACING).setValue(TreeTapBlock.SYRUP_LEVEL, randomsource.nextIntBetweenInclusive(0, 2))));
            }
        }
    }
}
