package com.bic.bit_o_everything.spells;

import com.bic.bit_o_everything.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.LingeringPotionItem;
import net.minecraft.world.item.SplashPotionItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class SlowfallingSpell implements AbstractSpell{
    public static final AbstractSpell SLOWFALLING = new SlowfallingSpell();

    private static final int color = Mth.color(255,230,238);

    public SoundEvent getSound() {
        return ModSounds.SPELL_SLOWFALLING.get();
    }

    public int spellColor() {
        return color;
    }

    public int cooldownTime() {
        return 2;
    }

    public int xpConsumed() {
        return 1;
    }

    public String spellName() {
        return "Slowfalling";
    }

    public String getDescription() {
        return "Gives the player or entity slowfalling. If cast on a block, an area of effect cloud will be created";
    }

    public SimpleParticleType getParticles() {
        return ParticleTypes.EFFECT;
    }

    public boolean castSpellEmpty(Level level, Player player) {
        // give player slowfalling
        player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 120, 0, false, false, false));
        return true;
    }

    public boolean castSpellEntity(Player player, LivingEntity livingEntity) {
        // give entity slowfalling
        livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 120, 0, false, false, false));
        return true;
    }

    public boolean castSpellBlock(UseOnContext useOnContext) {
        // create slowfalling cloud
        Level level = useOnContext.getLevel();
        BlockPos pos = useOnContext.getClickedPos();
        AreaEffectCloud areaeffectcloud = new AreaEffectCloud(level, pos.getX(), pos.getY(), pos.getZ());
        areaeffectcloud.setOwner((useOnContext.getPlayer()));
        areaeffectcloud.setRadius(3.0F);
        areaeffectcloud.setRadiusOnUse(-0.5F);
        areaeffectcloud.setWaitTime(0);
        areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float)areaeffectcloud.getDuration());
        areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 120, 0, false, false, false));
        areaeffectcloud.setFixedColor(SlowfallingSpell.SLOWFALLING.spellColor());
        level.addFreshEntity(areaeffectcloud);
        return true;
    }
}
