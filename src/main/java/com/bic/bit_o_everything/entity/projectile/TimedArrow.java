package com.bic.bit_o_everything.entity.projectile;

import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TimedArrow extends ExplosiveArrow {

    private static int expTime;
    private int life;

    public TimedArrow(EntityType<? extends ExplosiveArrow> type, Level level) {
        super(type, level);
    }

    public TimedArrow(EntityType<? extends ExplosiveArrow> type, double x, double y, double z, Level level, double expTime) {
        super(type, x, y, z, level);
        TimedArrow.expTime = (int)(expTime * 20);
    }
 
    public TimedArrow(LivingEntity shooter, Level level, Item referenceItem, double expTime) {
        super(ModEntityTypes.TIMED_ARROW.get(), shooter, level, referenceItem);
        TimedArrow.expTime = (int)(expTime * 20);
    }

    @Override
    public void tick() {
        if(life >= expTime) {
            explode(this.getDeltaMovement());
        }
        super.tick();
        life++;
    }

    @Override
    protected boolean tryPickup(Player player) {
        return false;
    }
}
