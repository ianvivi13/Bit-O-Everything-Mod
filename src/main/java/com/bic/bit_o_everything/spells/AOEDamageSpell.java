package com.bic.bit_o_everything.spells;

import com.bic.bit_o_everything.sound.ModSounds;
import com.bic.bit_o_everything.util.ModUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class AOEDamageSpell implements AbstractSpell{
    public static final AbstractSpell DAMAGE = new AOEDamageSpell();

    private static final int color = Mth.color(255,0,0);

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
        return "Damage";
    }

    public String getDescription() {
        return "Damage AOE";
    }

    public SimpleParticleType getParticles() {
        return ParticleTypes.EFFECT;
    }

    public boolean castSpell(Level level, Player player) {
        int range = 5;
        double power = 1;
        int damage = 6;
        Vec3 playerPos = player.getPosition(0);
        AABB aabb = new AABB(playerPos.subtract(range, range, range), playerPos.add(range, range, range));
        List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, aabb);
        for (LivingEntity e : entities) {
            if (e != player) {
                Vec3 vec = playerPos.subtract(e.getPosition(0));//.normalize();
                float dist = (float) vec.length(); // get distance to mob from player
                double scale = ModUtils.advancedMath.scale(0,range,dist,0.4);
                e.hurt(DamageSource.MAGIC, (float) (damage * scale));
                e.knockback(power * scale, vec.x, vec.z);
            }
        }
        return true;
    }

    public boolean castSpellEmpty(Level level, Player player, InteractionHand pUsedHand) {
        return castSpell(level, player);
    }

    public boolean castSpellEntity(Player player, LivingEntity livingEntity) {
        return castSpell(player.getLevel(), player);
    }

    public boolean castSpellBlock(UseOnContext useOnContext) {
        return castSpell(useOnContext.getLevel(), useOnContext.getPlayer());
    }
}
