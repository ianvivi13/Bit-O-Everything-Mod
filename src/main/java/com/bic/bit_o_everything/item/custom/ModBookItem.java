package com.bic.bit_o_everything.item.custom;

import com.bic.bit_o_everything.util.bezier.BezierCurve;
import com.bic.bit_o_everything.util.bezier.BezierPoint;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.net.URI;
import java.util.LinkedList;

public class ModBookItem extends Item {
    public ModBookItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        /*
        if (pLevel.isClientSide()) {
            try {
                openWebLink(new URI("https://htmlpreview.github.io/?https://github.com/ianvivi13/MinecraftMod/blob/master/webpage/index.html"));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }*/
        if (!pLevel.isClientSide()) {
            BezierPoint s = new BezierPoint(0, 0, 0);
            BezierPoint a = new BezierPoint(90, 70, 20);
            BezierPoint b = new BezierPoint(30, 15, 20);
            BezierPoint e = new BezierPoint(100, 100, 100);
            
            BezierCurve curve = new BezierCurve(s, a, b, e);
            LinkedList<BlockPos> blocks = curve.getBranchBlocks();
            for (BlockPos block : blocks) {
                pLevel.setBlock(block, Blocks.GOLD_BLOCK.defaultBlockState(), 2);
            }
            pLevel.setBlock(a.toBlockPos(), Blocks.EMERALD_BLOCK.defaultBlockState(), 2);
            pLevel.setBlock(b.toBlockPos(), Blocks.EMERALD_BLOCK.defaultBlockState(), 2);
            pLevel.setBlock(s.toBlockPos(), Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);
            pLevel.setBlock(e.toBlockPos(), Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    private static void openWebLink(URI url)
    {
        Util.getPlatform().openUri(url);
    }

}
