package com.bic.bit_o_everything.spells;

import com.bic.bit_o_everything.sound.ModSounds;
import com.bic.bit_o_everything.util.ModUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class WeatherSpell implements AbstractSpell {
    public static final AbstractSpell WEATHER = new WeatherSpell();

    private static final int color = Mth.color(10,10,240);

    public SoundEvent getSound() {
        return ModSounds.SPELL_FIREBALL.get();
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
        return "Weather";
    }

    public String getDescription() {
        return "Changes the weather between sunny and raining";
    }

    public SimpleParticleType getParticles() {
        return ParticleTypes.DRIPPING_WATER;
    }

    public boolean castSpellEmpty(Level level, Player player, InteractionHand pUsedHand) {
        changeWeather(level);
        return true;
    }

    public boolean castSpellEntity(Player player, LivingEntity livingEntity) {
        changeWeather(player.getLevel());
        return true;
    }

    public boolean castSpellBlock(UseOnContext useOnContext) {
        changeWeather(useOnContext.getLevel());
        return true;
    }

    public void changeWeather(Level level) {
        ServerLevel Slevel = ((ServerLevel) level);
        System.out.println(Slevel.isRaining());
        if (Slevel.isRaining() || Slevel.isThundering()) {
            Slevel.setWeatherParameters(6000, 0, false, false);
        } else {
            Slevel.setWeatherParameters(0, 6000, true, ModUtils.advancedRandom.randomTrue(0.10));
        }
    }

}
