package com.bic.bit_o_everything.entity.custom;

import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.entity.ModEntityTypes;
import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;

public class ModChestBoatEntity extends ChestBoat {

    private static final EntityDataAccessor<Integer> BOAT_TYPE =
            SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(EntityType<? extends Boat> type, Level level) {
        super(type, level);
        this.blocksBuilding = true;
    }

    public ModChestBoatEntity(Level worldIn, double x, double y, double z) {
        this(ModEntityTypes.MOD_CHEST_BOAT.get(), worldIn);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public ModChestBoatEntity.Type getModChestBoatEntityType() {
        return ModChestBoatEntity.Type.byId(this.entityData.get(BOAT_TYPE));
    }

    @Override
    public float getGroundFriction() {
        if(getModChestBoatEntityType() == ModChestBoatEntity.Type.ICE) {
            if(getBlockStateOn().getMaterial() == Material.WOOL) {
                return 0.1f;
            } else if(getBlockSpeedFactor() != 1) {
                return 0.81f;
            } else if(getBlockSpeedFactor() == 1) {
                return 0.98f;
            }
        }
        return super.getGroundFriction();
    }

    @Override
    public Item getDropItem() {
        return switch (this.getModChestBoatEntityType()) {
            case CHERRY -> ModItems.CHERRY_CHEST_BOAT.get();
            case MAPLE -> ModItems.MAPLE_CHEST_BOAT.get();
            case DOGWOOD -> ModItems.DOGWOOD_CHEST_BOAT.get();
            case REDWOOD -> ModItems.REDWOOD_CHEST_BOAT.get();
            case OLIVE -> ModItems.OLIVE_CHEST_BOAT.get();
            case PEACH -> ModItems.PEACH_CHEST_BOAT.get();
            case EBONY -> ModItems.EBONY_CHEST_BOAT.get();
            case PLUM -> ModItems.PLUM_CHEST_BOAT.get();
            case ORANGE -> ModItems.ORANGE_CHEST_BOAT.get();
            case INFECTED -> ModItems.INFECTED_CHEST_BOAT.get();
            case CORRUPT -> ModItems.CORRUPT_CHEST_BOAT.get();
            case PEAR -> ModItems.PEAR_CHEST_BOAT.get();
            case WISTERIA -> ModItems.WISTERIA_CHEST_BOAT.get();
            case CHARRED -> ModItems.CHARRED_CHEST_BOAT.get();
            case ICE -> ModItems.ICE_CHEST_BOAT.get();
            case DEAD -> ModItems.DEAD_CHEST_BOAT.get();
        };
    }

    public void setBoatType(ModChestBoatEntity.Type boatType) {
        this.entityData.set(BOAT_TYPE, boatType.ordinal());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BOAT_TYPE, Type.CHERRY.ordinal());
        /*
        this.entityData.define(BOAT_TYPE, Type.MAPLE.ordinal());
        this.entityData.define(BOAT_TYPE, Type.DOGWOOD.ordinal());
        this.entityData.define(BOAT_TYPE, Type.REDWOOD.ordinal());
        this.entityData.define(BOAT_TYPE, Type.OLIVE.ordinal());
        this.entityData.define(BOAT_TYPE, Type.PEACH.ordinal());
        this.entityData.define(BOAT_TYPE, Type.EBONY.ordinal());
        this.entityData.define(BOAT_TYPE, Type.PLUM.ordinal());
        this.entityData.define(BOAT_TYPE, Type.ORANGE.ordinal());
        this.entityData.define(BOAT_TYPE, Type.INFECTED.ordinal());
        this.entityData.define(BOAT_TYPE, Type.CORRUPT.ordinal());
        this.entityData.define(BOAT_TYPE, Type.PEAR.ordinal());
        this.entityData.define(BOAT_TYPE, Type.WISTERIA.ordinal());
        this.entityData.define(BOAT_TYPE, Type.CHARRED.ordinal());
        this.entityData.define(BOAT_TYPE, Type.ICE.ordinal());
        this.entityData.define(BOAT_TYPE, Type.DEAD.ordinal());
        */
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("Type", this.getModChestBoatEntityType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("Type", 8)) {
            this.setBoatType(ModChestBoatEntity.Type.getTypeFromString(compound.getString("Type")));
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }

    public enum Type {
        CHERRY(ModBlocks.CHERRY_PLANKS.get(), "cherry"),
        MAPLE(ModBlocks.MAPLE_PLANKS.get(), "maple"),
        DOGWOOD(ModBlocks.DOGWOOD_PLANKS.get(), "dogwood"),
        REDWOOD(ModBlocks.REDWOOD_PLANKS.get(), "redwood"),
        OLIVE(ModBlocks.OLIVE_PLANKS.get(), "olive"),
        PEACH(ModBlocks.PEACH_PLANKS.get(), "peach"),
        EBONY(ModBlocks.EBONY_PLANKS.get(), "ebony"),
        PLUM(ModBlocks.PLUM_PLANKS.get(), "plum"),
        ORANGE(ModBlocks.ORANGE_PLANKS.get(), "orange"),
        INFECTED(ModBlocks.INFECTED_PLANKS.get(), "infected"),
        CORRUPT(ModBlocks.CORRUPT_PLANKS.get(), "corrupt"),
        PEAR(ModBlocks.PEAR_PLANKS.get(), "pear"),
        WISTERIA(ModBlocks.WISTERIA_PLANKS.get(), "wisteria"),
        CHARRED(ModBlocks.CHARRED_PLANKS.get(), "charred"),
        ICE(ModBlocks.ICE_PLANKS.get(), "ice"),
        DEAD(ModBlocks.DEAD_PLANKS.get(), "dead")
        ;

        private final String name;
        private final Block block;

        Type(Block block, String name) {
            this.name = name;
            this.block = block;
        }

        public String getName() {
            return this.name;
        }

        public Block asPlank() {
            return this.block;
        }

        public String toString() {
            return this.name;
        }

        public static ModChestBoatEntity.Type byId(int id) {
            ModChestBoatEntity.Type[] aModBoatEntityEntity$type = values();
            if (id < 0 || id >= aModBoatEntityEntity$type.length) {
                id = 0;
            }

            return aModBoatEntityEntity$type[id];
        }

        public static ModChestBoatEntity.Type getTypeFromString(String nameIn) {
            ModChestBoatEntity.Type[] boatTypeArray = values();

            for (Type type : boatTypeArray) {
                if (type.getName().equals(nameIn)) {
                    return type;
                }
            }

            return boatTypeArray[0];
        }
    }

}
