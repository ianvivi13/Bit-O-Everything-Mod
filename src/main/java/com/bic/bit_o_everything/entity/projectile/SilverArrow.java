package com.bic.bit_o_everything.entity.projectile;

import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SilverArrow extends AbstractArrow {
    private final Item referenceItem;
    public SilverArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.SILVER_ARROW.get();
    }

    public SilverArrow(EntityType<? extends AbstractArrow> type, double x, double y, double z, Level level) {
        super(type, x, y, z, level);
        this.referenceItem = ModItems.SILVER_ARROW.get();
    }

    public SilverArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityTypes.SILVER_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
}
