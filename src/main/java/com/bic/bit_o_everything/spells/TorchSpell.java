package com.bic.bit_o_everything.spells;

import com.bic.bit_o_everything.util.ModUtils.advancedPlayerView;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class TorchSpell implements AbstractSpell {
    public static final AbstractSpell TORCHSPELL = new TorchSpell();

    private static final int color = Mth.color(255,127,0);

    public SoundEvent getSound() {
        return SoundEvents.REDSTONE_TORCH_BURNOUT;
    }

    public int spellColor() {
        return color;
    }

    public int cooldownTime() {
        return 20;
    }

    public int xpConsumed() {
        return 100;
    }

    public String spellName() {
        return "Torch";
    }

    public String getDescription() {
        return "Creates torches";
    }

    public SimpleParticleType getParticles() {
        return ParticleTypes.ASH;
    }

    public boolean castSpellEmpty(Level level, Player player, InteractionHand pUsedHand) {
        UseOnContext useOnContext = new UseOnContext(level, player, pUsedHand, player.getItemInHand(pUsedHand), advancedPlayerView.getBlockLookingAt(level, player, 32));
        return castSpellBlock(useOnContext);
    }

    public boolean castSpellEntity(Player player, LivingEntity livingEntity) {
        return false;
    }

    public boolean castSpellBlock(UseOnContext useOnContext) {
        if (Items.TORCH.useOn(useOnContext).consumesAction()) {
            useOnContext.getItemInHand().shrink(-1);
            return true;
        }
        return false;
    }

}
