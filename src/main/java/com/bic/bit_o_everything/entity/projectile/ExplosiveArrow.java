package com.bic.bit_o_everything.entity.projectile;

import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class ExplosiveArrow extends AbstractArrow {
    private final Item referenceItem;
    public ExplosiveArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        this.referenceItem = ModItems.EXPLOSIVE_ARROW.get();
    }

    public ExplosiveArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityTypes.EXPLOSIVE_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    public void explode(Vec3 location) {
        if(!this.level.isClientSide) {
            Vec3 vec3 = location.subtract(this.getX(), this.getY(), this.getZ());
            this.setDeltaMovement(vec3);
            Vec3 vec31 = vec3.normalize().scale(0.05F);
            double x = this.getX() - vec31.x;
            double y = this.getY() - vec31.y;
            double z = this.getZ() - vec31.z;
            this.discard();
            float f = 2.5F;
            this.level.explode(this, x, y, z, f, Explosion.BlockInteraction.BREAK);
        }
    }

    @Override
    public void onHitBlock(BlockHitResult blockHitResult) {
        if(this instanceof TimedArrow) {
            super.onHitBlock(blockHitResult);
        } else {
            explode(blockHitResult.getLocation());
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        explode(pResult.getLocation());
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }
}
