package com.bic.bit_o_everything.block.custom;

import com.bic.bit_o_everything.ModUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BasaltRosaliteOreBlock extends RotatedPillarDropExperienceBlock {

    public BasaltRosaliteOreBlock(Properties p_221081_) {
        super(p_221081_);
    }

    public BasaltRosaliteOreBlock(Properties p_221083_, IntProvider p_221084_) {
        super(p_221083_, p_221084_);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (!level.isClientSide()) {
            if (ModUtils.advancedRandom.randomTrue(0.07)) {
                this.boomBoom(level, pos);
            }
        }
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        super.onBlockExploded(state, level, pos, explosion);
        this.boomBoom(level, pos);
    }

    @Override
    public boolean canDropFromExplosion(BlockState state, BlockGetter level, BlockPos pos, Explosion explosion) {
        return false;
    }

    public void boomBoom(Level level, BlockPos pos) {
        level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 4.2f, true, Explosion.BlockInteraction.BREAK);

    }

    @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos) {
        return 3;
    }

}
