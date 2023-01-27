package com.bic.bit_o_everything.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Random;

import net.minecraft.world.item.Item.Properties;

public class RainbowDyeItem extends DyeItem {


    public RainbowDyeItem(DyeColor pDyeColor, Properties pProperties) {
        super(pDyeColor, pProperties);
    }

    @Override
    public DyeColor getDyeColor() {
        Random rand = new Random();
        return DyeColor.byId(rand.nextInt(16));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pTarget, InteractionHand pHand) {
        DyeColor randColor = getDyeColor();
        if (pTarget instanceof Sheep sheep) {
            if (sheep.isAlive() && !sheep.isSheared() && randColor != sheep.getColor()) {
                sheep.level.playSound(pPlayer, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
                if (!pPlayer.level.isClientSide) {
                    sheep.setColor(randColor);
                    pStack.shrink(1);
                    sheep.setCustomName(Component.nullToEmpty("jeb_"));
                }

                return InteractionResult.sidedSuccess(pPlayer.level.isClientSide);
            }
        }

        return InteractionResult.PASS;
    }
}
