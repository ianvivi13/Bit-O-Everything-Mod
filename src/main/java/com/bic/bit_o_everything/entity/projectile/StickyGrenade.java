package com.bic.bit_o_everything.entity.projectile;

import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class StickyGrenade extends AbstractThrowableExplosive {
    protected boolean explodeByDetonator = false;

    public StickyGrenade(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public StickyGrenade(Level pLevel, Player pPlayer, Boolean hasDetonator) {
        super(ModEntityTypes.STICKY_GRENADE.get(), pPlayer, pLevel);
        explodeByDetonator = hasDetonator;
    }

    public void explodeSelf() {
        super.explode(this.position());
    }

    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        if (explodeByDetonator) {
            setNoGravity(true);
            BlockState blockstate = this.level.getBlockState(blockHitResult.getBlockPos());
            blockstate.onProjectileHit(this.level, blockstate, blockHitResult, this);
            Vec3 vec3 = blockHitResult.getLocation().subtract(this.getX(), this.getY(), this.getZ());
            this.setDeltaMovement(vec3);
            Vec3 vec31 = vec3.normalize().scale(0.05F);
            this.setPosRaw(this.getX() - vec31.x, this.getY() - vec31.y, this.getZ() - vec31.z);
        } else {
            super.onHitBlock(blockHitResult);
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.STICKY_GRENADE.get();
    }

    @Override
    protected float getExpRadius() {
        return 3f;
    }


}
