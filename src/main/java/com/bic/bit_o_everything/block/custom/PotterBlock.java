package com.bic.bit_o_everything.block.custom;

import com.bic.bit_o_everything.ModUtils;
import com.bic.bit_o_everything.block.ModBlocks;
import com.bic.bit_o_everything.block.entity.custom.PotterBlockEntity;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Supplier;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PotterBlock extends BaseEntityBlock{
    protected static final VoxelShape TALL = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);
    protected static final VoxelShape SHORT = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D);
    protected static final VoxelShape FULL = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);


    public final static ArrayList<Pair<Supplier<Block>, Supplier<Item>>> materialPossibles = new ArrayList<>() {{
        add(new Pair<>(() -> Blocks.TERRACOTTA, () -> Items.CLAY_BALL));
        add(new Pair<>(() -> Blocks.WHITE_TERRACOTTA, () -> Items.WHITE_DYE));
        add(new Pair<>(() -> Blocks.ORANGE_TERRACOTTA, () -> Items.ORANGE_DYE));
        add(new Pair<>(() -> Blocks.MAGENTA_TERRACOTTA, () -> Items.MAGENTA_DYE));
        add(new Pair<>(() -> Blocks.LIGHT_BLUE_TERRACOTTA, () -> Items.LIGHT_BLUE_DYE));
        add(new Pair<>(() -> Blocks.YELLOW_TERRACOTTA, () -> Items.YELLOW_DYE));
        add(new Pair<>(() -> Blocks.LIME_TERRACOTTA, () -> Items.LIME_DYE));
        add(new Pair<>(() -> Blocks.PINK_TERRACOTTA, () -> Items.PINK_DYE));
        add(new Pair<>(() -> Blocks.GRAY_TERRACOTTA, () -> Items.GRAY_DYE));
        add(new Pair<>(() -> Blocks.LIGHT_GRAY_TERRACOTTA, () -> Items.LIGHT_GRAY_DYE));
        add(new Pair<>(() -> Blocks.CYAN_TERRACOTTA, () -> Items.CYAN_DYE));
        add(new Pair<>(() -> Blocks.PURPLE_TERRACOTTA, () -> Items.PURPLE_DYE));
        add(new Pair<>(() -> Blocks.BLUE_TERRACOTTA, () -> Items.BLUE_DYE));
        add(new Pair<>(() -> Blocks.BROWN_TERRACOTTA, () -> Items.BROWN_DYE));
        add(new Pair<>(() -> Blocks.GREEN_TERRACOTTA, () -> Items.GREEN_DYE));
        add(new Pair<>(() -> Blocks.RED_TERRACOTTA, () -> Items.RED_DYE));
        add(new Pair<>(() -> Blocks.BLACK_TERRACOTTA, () -> Items.BLACK_DYE));
    }};

    public final static ArrayList<Pair<Supplier<Block>, Supplier<Item>>> flowerPossibles = new ArrayList<>() {{
        add(new Pair<>(() -> Blocks.DANDELION, () -> Blocks.DANDELION.asItem()));
        add(new Pair<>(() -> Blocks.POPPY, () -> Blocks.POPPY.asItem()));
        add(new Pair<>(() -> Blocks.BLUE_ORCHID, () -> Blocks.BLUE_ORCHID.asItem()));
        add(new Pair<>(() -> Blocks.ALLIUM, () -> Blocks.ALLIUM.asItem()));
        add(new Pair<>(() -> Blocks.AZURE_BLUET, () -> Blocks.AZURE_BLUET.asItem()));
        add(new Pair<>(() -> Blocks.RED_TULIP, () -> Blocks.RED_TULIP.asItem()));
        add(new Pair<>(() -> Blocks.ORANGE_TULIP, () -> Blocks.ORANGE_TULIP.asItem()));
        add(new Pair<>(() -> Blocks.WHITE_TULIP, () -> Blocks.WHITE_TULIP.asItem()));
        add(new Pair<>(() -> Blocks.PINK_TULIP, () -> Blocks.PINK_TULIP.asItem()));
        add(new Pair<>(() -> Blocks.OXEYE_DAISY, () -> Blocks.OXEYE_DAISY.asItem()));
        add(new Pair<>(() -> Blocks.CORNFLOWER, () -> Blocks.CORNFLOWER.asItem()));
        add(new Pair<>(() -> Blocks.LILY_OF_THE_VALLEY, () -> Blocks.LILY_OF_THE_VALLEY.asItem()));
        add(new Pair<>(() -> Blocks.WITHER_ROSE, () -> Blocks.WITHER_ROSE.asItem()));
        add(new Pair<>(() -> Blocks.OAK_SAPLING, () -> Blocks.OAK_SAPLING.asItem()));
        add(new Pair<>(() -> Blocks.SPRUCE_SAPLING, () -> Blocks.SPRUCE_SAPLING.asItem()));
        add(new Pair<>(() -> Blocks.BIRCH_SAPLING, () -> Blocks.BIRCH_SAPLING.asItem()));
        add(new Pair<>(() -> Blocks.JUNGLE_SAPLING, () -> Blocks.JUNGLE_SAPLING.asItem()));
        add(new Pair<>(() -> Blocks.ACACIA_SAPLING, () -> Blocks.ACACIA_SAPLING.asItem()));
        add(new Pair<>(() -> Blocks.DARK_OAK_SAPLING, () -> Blocks.DARK_OAK_SAPLING.asItem()));
        add(new Pair<>(() -> Blocks.RED_MUSHROOM, () -> Blocks.RED_MUSHROOM.asItem()));
        add(new Pair<>(() -> Blocks.BROWN_MUSHROOM, () -> Blocks.BROWN_MUSHROOM.asItem()));
        add(new Pair<>(() -> Blocks.FERN, () -> Blocks.FERN.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BUSH, () -> Blocks.DEAD_BUSH.asItem()));
        add(new Pair<>(() -> Blocks.CACTUS, () -> Blocks.CACTUS.asItem()));
        add(new Pair<>(() -> Blocks.BAMBOO, () -> Blocks.BAMBOO.asItem()));
        add(new Pair<>(() -> Blocks.AZALEA, () -> Blocks.AZALEA.asItem()));
        add(new Pair<>(() -> Blocks.FLOWERING_AZALEA, () -> Blocks.FLOWERING_AZALEA.asItem()));
        add(new Pair<>(() -> Blocks.CRIMSON_FUNGUS, () -> Blocks.CRIMSON_FUNGUS.asItem()));
        add(new Pair<>(() -> Blocks.WARPED_FUNGUS, () -> Blocks.WARPED_FUNGUS.asItem()));
        add(new Pair<>(() -> Blocks.CRIMSON_ROOTS, () -> Blocks.CRIMSON_ROOTS.asItem()));
        add(new Pair<>(() -> Blocks.WARPED_ROOTS, () -> Blocks.WARPED_ROOTS.asItem()));
        add(new Pair<>(() -> Blocks.MANGROVE_PROPAGULE, () -> Blocks.MANGROVE_PROPAGULE.asItem()));
        add(new Pair<>(() -> Blocks.SUGAR_CANE, () -> Blocks.SUGAR_CANE.asItem()));
        add(new Pair<>(() -> Blocks.BIG_DRIPLEAF, () -> Items.BIG_DRIPLEAF));
        add(new Pair<>(() -> Blocks.SWEET_BERRY_BUSH, () -> Items.SWEET_BERRIES));
        add(new Pair<>(() -> Blocks.NETHER_WART, () -> Items.NETHER_WART));
        add(new Pair<>(() -> Blocks.NETHER_SPROUTS, () -> Items.NETHER_SPROUTS));
        add(new Pair<>(() -> Blocks.SMALL_AMETHYST_BUD, () -> Blocks.SMALL_AMETHYST_BUD.asItem()));
        add(new Pair<>(() -> Blocks.MEDIUM_AMETHYST_BUD, () -> Blocks.MEDIUM_AMETHYST_BUD.asItem()));
        add(new Pair<>(() -> Blocks.LARGE_AMETHYST_BUD, () -> Blocks.LARGE_AMETHYST_BUD.asItem()));
        add(new Pair<>(() -> Blocks.AMETHYST_CLUSTER, () -> Blocks.AMETHYST_CLUSTER.asItem()));
        //add(new Pair<>(() -> ModBlocks.CHERRY_SAPLING.get(), () -> ModBlocks.CHERRY_SAPLING.get().asItem()));
        add(new Pair<>(() -> Blocks.LILY_PAD, () -> Blocks.LILY_PAD.asItem()));
        add(new Pair<>(() -> Blocks.FIRE, () -> Items.TORCH));
        add(new Pair<>(() -> Blocks.SOUL_FIRE, () -> Items.SOUL_TORCH));
        add(new Pair<>(() -> Blocks.FIRE_CORAL_FAN, () -> Blocks.FIRE_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_FIRE_CORAL_FAN, () -> Blocks.DEAD_FIRE_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.FIRE_CORAL, () -> Blocks.FIRE_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_FIRE_CORAL, () -> Blocks.DEAD_FIRE_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.HORN_CORAL_FAN, () -> Blocks.HORN_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_HORN_CORAL_FAN, () -> Blocks.DEAD_HORN_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.HORN_CORAL, () -> Blocks.HORN_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_HORN_CORAL, () -> Blocks.DEAD_HORN_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.BRAIN_CORAL_FAN, () -> Blocks.BRAIN_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BRAIN_CORAL_FAN, () -> Blocks.DEAD_BRAIN_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.BRAIN_CORAL, () -> Blocks.BRAIN_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BRAIN_CORAL, () -> Blocks.DEAD_BRAIN_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.TUBE_CORAL_FAN, () -> Blocks.TUBE_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_TUBE_CORAL_FAN, () -> Blocks.DEAD_TUBE_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.TUBE_CORAL, () -> Blocks.TUBE_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_TUBE_CORAL, () -> Blocks.DEAD_TUBE_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.BUBBLE_CORAL_FAN, () -> Blocks.BUBBLE_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BUBBLE_CORAL_FAN, () -> Blocks.DEAD_BUBBLE_CORAL_FAN.asItem()));
        add(new Pair<>(() -> Blocks.BUBBLE_CORAL, () -> Blocks.BUBBLE_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BUBBLE_CORAL, () -> Blocks.DEAD_BUBBLE_CORAL.asItem()));
        add(new Pair<>(() -> Blocks.PUMPKIN, () -> Blocks.PUMPKIN.asItem()));
        add(new Pair<>(() -> Blocks.JACK_O_LANTERN, () -> Blocks.JACK_O_LANTERN.asItem()));
        add(new Pair<>(() -> Blocks.MELON, () -> Blocks.MELON.asItem()));
        add(new Pair<>(() -> Blocks.CHORUS_FLOWER, () -> Blocks.CHORUS_FLOWER.asItem()));
        add(new Pair<>(() -> Blocks.CARVED_PUMPKIN, () -> Blocks.CARVED_PUMPKIN.asItem()));
        add(new Pair<>(() -> Blocks.HAY_BLOCK, () -> Blocks.HAY_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.WHEAT, () -> Blocks.WHEAT.asItem()));
        add(new Pair<>(() -> Blocks.CARROTS, () -> Blocks.CARROTS.asItem()));
        add(new Pair<>(() -> Blocks.BEETROOTS, () -> Blocks.BEETROOTS.asItem()));
        add(new Pair<>(() -> Blocks.POTATOES, () -> Blocks.POTATOES.asItem()));
    }};

    public final static ArrayList<Pair<Supplier<Block>, Supplier<Item>>> dirtPossibles = new ArrayList<>() {{
        add(new Pair<>(() -> Blocks.DIRT, () -> Blocks.DIRT.asItem()));
        add(new Pair<>(() -> Blocks.ROOTED_DIRT, () -> Blocks.ROOTED_DIRT.asItem()));
        add(new Pair<>(() -> Blocks.SAND, () -> Blocks.SAND.asItem()));
        add(new Pair<>(() -> Blocks.MUD, () -> Blocks.MUD.asItem()));
        add(new Pair<>(() -> Blocks.GRASS_BLOCK, () -> Blocks.GRASS_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.MOSS_BLOCK, () -> Blocks.MOSS_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.GRAVEL, () -> Blocks.GRAVEL.asItem()));
        add(new Pair<>(() -> Blocks.MYCELIUM, () -> Blocks.MYCELIUM.asItem()));
        add(new Pair<>(() -> Blocks.COARSE_DIRT, () -> Blocks.COARSE_DIRT.asItem()));
        add(new Pair<>(() -> Blocks.PODZOL, () -> Blocks.PODZOL.asItem()));
        add(new Pair<>(() -> Blocks.RED_SAND, () -> Blocks.RED_SAND.asItem()));
        add(new Pair<>(() -> Blocks.SOUL_SAND, () -> Blocks.SOUL_SAND.asItem()));
        add(new Pair<>(() -> Blocks.SOUL_SOIL, () -> Blocks.SOUL_SOIL.asItem()));
        add(new Pair<>(() -> Blocks.CRIMSON_NYLIUM, () -> Blocks.CRIMSON_NYLIUM.asItem()));
        add(new Pair<>(() -> Blocks.SNOW_BLOCK, () -> Blocks.SNOW_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.WARPED_NYLIUM, () -> Blocks.WARPED_NYLIUM.asItem()));
        add(new Pair<>(() -> Blocks.CLAY, () -> Blocks.CLAY.asItem()));
        add(new Pair<>(() -> Blocks.SCULK, () -> Blocks.SCULK.asItem()));
        add(new Pair<>(() -> Blocks.NETHERRACK, () -> Blocks.NETHERRACK.asItem()));
        add(new Pair<>(() -> Blocks.PACKED_MUD, () -> Blocks.PACKED_MUD.asItem()));
        add(new Pair<>(() -> Blocks.END_STONE, () -> Blocks.END_STONE.asItem()));
        add(new Pair<>(() -> Blocks.MAGMA_BLOCK, () -> Blocks.MAGMA_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.ICE, () -> Blocks.ICE.asItem()));
        add(new Pair<>(() -> Blocks.PACKED_ICE, () -> Blocks.PACKED_ICE.asItem()));
        add(new Pair<>(() -> Blocks.BLUE_ICE, () -> Blocks.BLUE_ICE.asItem()));
        add(new Pair<>(() -> Blocks.BUBBLE_CORAL_BLOCK, () -> Blocks.BUBBLE_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BUBBLE_CORAL_BLOCK, () -> Blocks.DEAD_BUBBLE_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.BRAIN_CORAL_BLOCK, () -> Blocks.BRAIN_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_BRAIN_CORAL_BLOCK, () -> Blocks.DEAD_BRAIN_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.FIRE_CORAL_BLOCK, () -> Blocks.FIRE_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_FIRE_CORAL_BLOCK, () -> Blocks.DEAD_FIRE_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.HORN_CORAL_BLOCK, () -> Blocks.HORN_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_HORN_CORAL_BLOCK, () -> Blocks.DEAD_HORN_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.TUBE_CORAL_BLOCK, () -> Blocks.TUBE_CORAL_BLOCK.asItem()));
        add(new Pair<>(() -> Blocks.DEAD_TUBE_CORAL_BLOCK, () -> Blocks.DEAD_TUBE_CORAL_BLOCK.asItem()));
    }};

    public PotterBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof PotterBlockEntity potterBlockEntity) {
            return potterBlockEntity.connections[4] ? SHORT : TALL;
        }
        return FULL;
    }

    public static Block getDirtBlock(int i) {
        if (i < 0) {
            return null;
        } else {
            return dirtPossibles.get(i).getFirst().get();
        }
    }

    public static Block getMaterialBlock(int i) {
        if (i < 0) {
            return materialPossibles.get(0).getFirst().get();
        } else {
            return materialPossibles.get(i).getFirst().get();
        }
    }

    public ArrayList<Pair<Supplier<Block>, Supplier<Item>>> getMaterialPossibles() {
        return materialPossibles;
    }

    public static Item getDirtItem(int i) {
        if (i < 0) {
            return null;
        } else {
            return dirtPossibles.get(i).getSecond().get();
        }
    }

    public static Block getFlowerBlock(int i) {
        if (i < 0) {
            return null;
        } else {
            return flowerPossibles.get(i).getFirst().get();
        }
    }

    public static void playPlaceSound(Block block, Player player, BlockPos pos) {
        SoundType s = block.getSoundType(block.defaultBlockState(), player.getLevel(), pos , player);
        player.getLevel().playSound(null, pos, s.getPlaceSound(), SoundSource.BLOCKS, s.getVolume(), s.getPitch());
    }

    public static void playHitSound(Block block, Player player, BlockPos pos) {
        SoundType s = block.getSoundType(block.defaultBlockState(), player.getLevel(), pos , player);
        player.getLevel().playSound(null, pos, s.getHitSound(), SoundSource.BLOCKS, s.getVolume(), s.getPitch());
    }

    public static void playBreakSound(Block block, Player player, BlockPos pos) {
        SoundType s = block.getSoundType(block.defaultBlockState(), player.getLevel(), pos , player);
        player.getLevel().playSound(null, pos, s.getBreakSound(), SoundSource.BLOCKS, s.getVolume(), s.getPitch());
    }

    public static Item getFlowerItem(int i) {
        if (i < 0) {
            return null;
        } else {
            return flowerPossibles.get(i).getSecond().get();
        }
    }

    public static float getAngle(BlockPos pPos, Player pPlayer) {
        Vec3 hitLoc = new Vec3(pPos.getX()+0.5,pPos.getY()+0.5, pPos.getZ()+0.5);
        Vec3 playPos = new Vec3(pPlayer.getX(), pPlayer.getY(), pPlayer.getZ());
        Vec3 maybe = hitLoc.subtract(playPos);
        float angle = (float) Math.atan2(maybe.x,maybe.z);
        if (hitLoc.distanceTo(playPos) <= 2) {
            angle = ModUtils.advancedRotation.step(angle, Math.PI/4);
        }
        return angle;
    }



    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemStack = pPlayer.getItemInHand(pHand);
        if (!pLevel.isClientSide) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof PotterBlockEntity potterBlockEntity) {
                if (itemStack.isEmpty()) {
                    if (potterBlockEntity.flower >= 0) {
                        playBreakSound(Objects.requireNonNull(getFlowerBlock(potterBlockEntity.flower)), pPlayer, pPos);
                        dropFlower(pLevel, pPos);
                        potterBlockEntity.updateRender();
                    } else if (potterBlockEntity.dirt >= 0) {
                        playBreakSound(Objects.requireNonNull(getDirtBlock(potterBlockEntity.dirt)), pPlayer, pPos);
                        dropDirt(pLevel, pPos);
                        potterBlockEntity.updateRender();
                    }
                    return InteractionResult.SUCCESS;
                } else if (itemStack.is(Items.WOODEN_HOE)) {
                    Vec3 v = pHit.getLocation();
                    v = v.subtract(pPos.getX(), pPos.getY(), pPos.getZ());
                    int x;
                    if (v.x < 1/8d) {
                        x = 0;
                    } else if (v.x > 7/8d) {
                        x = 2;
                    } else {
                        x = 1;
                    }
                    int z;
                    if (v.z < 1/8d) {
                        z = 0;
                    } else if (v.z > 7/8d) {
                        z = 2;
                    } else {
                        z = 1;
                    }
                    potterBlockEntity.connections[z*3+x] ^= true;
                    potterBlockEntity.updateRender();
                    playHitSound(potterBlockEntity.getMaterial(), pPlayer, pPos);
                    return InteractionResult.SUCCESS;
                } else {
                    int i = 0;
                    for (Pair<Supplier<Block>, Supplier<Item>> p : dirtPossibles) {
                        if (itemStack.is(p.getSecond().get())) {
                            if (i == potterBlockEntity.dirt) {
                                return InteractionResult.SUCCESS;
                            }
                            dropDirt(pLevel, pPos);
                            potterBlockEntity.dirt = i;
                            playPlaceSound(p.getFirst().get(), pPlayer, pPos);
                            itemStack.shrink(1);
                            potterBlockEntity.updateRender();
                            return InteractionResult.SUCCESS;
                        }
                        i ++;
                    }
                    if (potterBlockEntity.dirt >= 0) {
                        int j = 0;
                        for (Pair<Supplier<Block>, Supplier<Item>> p : flowerPossibles) {
                            if (itemStack.is(p.getSecond().get())) {
                                if (j == potterBlockEntity.flower) {
                                    potterBlockEntity.flowerRotation = getAngle(pPos,pPlayer);
                                    potterBlockEntity.updateRender();
                                    return InteractionResult.SUCCESS;
                                }
                                potterBlockEntity.flowerRotation = getAngle(pPos,pPlayer);
                                dropFlower(pLevel, pPos);
                                potterBlockEntity.flower = j;
                                playPlaceSound(p.getFirst().get(), pPlayer, pPos);
                                itemStack.shrink(1);
                                potterBlockEntity.updateRender();
                                return InteractionResult.SUCCESS;
                            }
                            j ++;
                        }
                    }
                    int k = 0;
                    for (Pair<Supplier<Block>, Supplier<Item>> p : getMaterialPossibles()) {
                        if (itemStack.is(p.getSecond().get())) {
                            if (k == potterBlockEntity.material) {
                                return InteractionResult.SUCCESS;
                            }
                            potterBlockEntity.material = k;
                            itemStack.shrink(1);
                            potterBlockEntity.updateRender();
                            return InteractionResult.SUCCESS;
                        }
                        k ++;
                    }
                }

            }
        }
        return InteractionResult.CONSUME;
    }

    public void dropFlower(Level pLevel, BlockPos pPos) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof PotterBlockEntity potterBlockEntity) {
            if (potterBlockEntity.flower >= 0) {
                ItemStack flowerDrop = new ItemStack(getFlowerItem(potterBlockEntity.flower));
                Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY() + 1, pPos.getZ(), flowerDrop);
                potterBlockEntity.flower = -1;
            }
        }
    }

    public void dropDirt(Level pLevel, BlockPos pPos) {
        BlockEntity blockentity = pLevel.getBlockEntity(pPos);
        if (blockentity instanceof PotterBlockEntity potterBlockEntity) {
            if (potterBlockEntity.dirt >= 0) {
                ItemStack flowerDrop = new ItemStack(getDirtItem(potterBlockEntity.dirt));
                Containers.dropItemStack(pLevel, pPos.getX(), pPos.getY() + 1, pPos.getZ(), flowerDrop);
                potterBlockEntity.dirt = -1;
            }
        }
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        dropDirt(pLevel, pPos);
        dropFlower(pLevel, pPos);
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return false;
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        PotterBlockEntity t =  new PotterBlockEntity(pPos, pState);
        t.concrete = false;
        return t;
    }
}
