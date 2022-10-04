package com.bic.bit_o_everything.block;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.custom.*;
import com.bic.bit_o_everything.block.custom.gates.*;
import com.bic.bit_o_everything.block.entity.ModWoodTypes;
import com.bic.bit_o_everything.item.ModCreativeModeTab;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.world.feature.tree_growers.CherryTreeGrower;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BitOEverything.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    // Create blocks here

    public static final RegistryObject<Block> ASPHALT = registerBlock("asphalt",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE)
                    .strength(1.5f).speedFactor(1.2F).requiresCorrectToolForDrops()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> JUMP_BLOCK = registerBlock("jump_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL)
                    .strength(0.4f).jumpFactor(2.0F)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> INDICATOR_LEVER = registerBlock("indicator_lever",
            () -> new LeverBlock(BlockBehaviour.Properties.copy(Blocks.LEVER)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> POTTER = registerBlock("potter",
            () -> new PotterBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().dynamicShape().instabreak()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CONCRETE_POTTER = registerBlock("concrete_potter",
            () -> new ConcretePotterBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().dynamicShape().instabreak()), ModCreativeModeTab.MODDED);

    //region Bricks
    public static final RegistryObject<Block> RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_BRICKS)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> RAINBOW_BRICK_SLAB = registerBlock("rainbow_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> RAINBOW_BRICK_STAIRS = registerBlock("rainbow_brick_stairs",
            () -> new StairBlock(Blocks.BRICK_STAIRS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> RAINBOW_BRICK_WALL = registerBlock("rainbow_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> WHITE_BRICKS = registerBlock("white_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_BRICKS)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> WHITE_BRICK_SLAB = registerBlock("white_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> WHITE_BRICK_STAIRS = registerBlock("white_brick_stairs",
            () -> new StairBlock(Blocks.BRICK_STAIRS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> WHITE_BRICK_WALL = registerBlock("white_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> BLACK_BRICKS = registerBlock("black_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE_BRICKS)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> BLACK_BRICK_SLAB = registerBlock("black_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_SLAB)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> BLACK_BRICK_STAIRS = registerBlock("black_brick_stairs",
            () -> new StairBlock(Blocks.BRICK_STAIRS::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BRICK_STAIRS)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> BLACK_BRICK_WALL = registerBlock("black_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICK_WALL)), ModCreativeModeTab.MODDED);

    //endregion
    //region Wood
    //region Cherry Woods
    public static final RegistryObject<Block> CHERRY_LOG = registerBlock("cherry_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.MODDED);
    
    public static final RegistryObject<Block> CHERRY_WOOD = registerBlock("cherry_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_STAIRS = registerBlock("cherry_stairs",
            () -> new BurnableStair(() -> ModBlocks.CHERRY_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_SLAB = registerBlock("cherry_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_FENCE = registerBlock("cherry_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_BUTTON = registerBlock("cherry_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_DOOR = registerBlock("cherry_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_WALL_SIGN = registerBlockWithoutBlockItem("cherry_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHERRY));

    public static final RegistryObject<Block> CHERRY_SIGN = registerBlockWithoutBlockItem("cherry_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CHERRY));

    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling",
            () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = registerPottedPlant("potted_cherry_sapling", ModBlocks.CHERRY_SAPLING);

    //endregion
    //endregion
    //region Concrete
    //region Concrete Slabs
    public static final RegistryObject<Block> WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    //endregion
    //region Concrete Stairs
    public static final RegistryObject<Block> WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            () -> new StairBlock(Blocks.WHITE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            () -> new StairBlock(Blocks.ORANGE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concrete_stairs",
            () -> new StairBlock(Blocks.MAGENTA_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            () -> new StairBlock(Blocks.LIGHT_BLUE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            () -> new StairBlock(Blocks.YELLOW_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            () -> new StairBlock(Blocks.LIME_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            () -> new StairBlock(Blocks.PINK_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            () -> new StairBlock(Blocks.GRAY_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            () -> new StairBlock(Blocks.LIGHT_GRAY_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            () -> new StairBlock(Blocks.CYAN_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            () -> new StairBlock(Blocks.PURPLE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            () -> new StairBlock(Blocks.BLUE_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            () -> new StairBlock(Blocks.BROWN_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            () -> new StairBlock(Blocks.GREEN_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            () -> new StairBlock(Blocks.RED_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            () -> new StairBlock(Blocks.BLACK_CONCRETE::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)), ModCreativeModeTab.MODDED);
    //endregion
    //region Concrete Walls
    public static final RegistryObject<Block> WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    //endregion
    //endregion
    //region Terracotta
    //region Terracotta Slabs
    public static final RegistryObject<Block> TERRACOTTA_SLAB = registerBlock("terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> WHITE_TERRACOTTA_SLAB = registerBlock("white_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_SLAB = registerBlock("orange_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_SLAB = registerBlock("magenta_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_SLAB = registerBlock("light_blue_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_SLAB = registerBlock("yellow_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIME_TERRACOTTA_SLAB = registerBlock("lime_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LIME_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PINK_TERRACOTTA_SLAB = registerBlock("pink_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PINK_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_SLAB = registerBlock("gray_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_SLAB = registerBlock("light_gray_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_SLAB = registerBlock("cyan_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_SLAB = registerBlock("purple_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_SLAB = registerBlock("blue_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_SLAB = registerBlock("brown_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_SLAB = registerBlock("green_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> RED_TERRACOTTA_SLAB = registerBlock("red_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_SLAB = registerBlock("black_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_TERRACOTTA)), ModCreativeModeTab.MODDED);
    //endregion
    //region Terracotta Stairs
    public static final RegistryObject<Block> TERRACOTTA_STAIRS = registerBlock("terracotta_stairs",
            () -> new StairBlock(Blocks.TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> WHITE_TERRACOTTA_STAIRS = registerBlock("white_terracotta_stairs",
            () -> new StairBlock(Blocks.WHITE_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.WHITE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_STAIRS = registerBlock("orange_terracotta_stairs",
            () -> new StairBlock(Blocks.ORANGE_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.ORANGE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_STAIRS = registerBlock("magenta_terracotta_stairs",
            () -> new StairBlock(Blocks.MAGENTA_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.MAGENTA_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlock("light_blue_terracotta_stairs",
            () -> new StairBlock(Blocks.LIGHT_BLUE_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_STAIRS = registerBlock("yellow_terracotta_stairs",
            () -> new StairBlock(Blocks.YELLOW_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.YELLOW_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIME_TERRACOTTA_STAIRS = registerBlock("lime_terracotta_stairs",
            () -> new StairBlock(Blocks.LIME_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.LIME_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PINK_TERRACOTTA_STAIRS = registerBlock("pink_terracotta_stairs",
            () -> new StairBlock(Blocks.PINK_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.PINK_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_STAIRS = registerBlock("gray_terracotta_stairs",
            () -> new StairBlock(Blocks.GRAY_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.GRAY_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlock("light_gray_terracotta_stairs",
            () -> new StairBlock(Blocks.LIGHT_GRAY_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_STAIRS = registerBlock("cyan_terracotta_stairs",
            () -> new StairBlock(Blocks.CYAN_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.CYAN_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_STAIRS = registerBlock("purple_terracotta_stairs",
            () -> new StairBlock(Blocks.PURPLE_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.PURPLE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_STAIRS = registerBlock("blue_terracotta_stairs",
            () -> new StairBlock(Blocks.BLUE_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BLUE_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_STAIRS = registerBlock("brown_terracotta_stairs",
            () -> new StairBlock(Blocks.BROWN_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BROWN_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_STAIRS = registerBlock("green_terracotta_stairs",
            () -> new StairBlock(Blocks.GREEN_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.GREEN_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> RED_TERRACOTTA_STAIRS = registerBlock("red_terracotta_stairs",
            () -> new StairBlock(Blocks.RED_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.RED_TERRACOTTA)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_STAIRS = registerBlock("black_terracotta_stairs",
            () -> new StairBlock(Blocks.BLACK_TERRACOTTA::defaultBlockState, BlockBehaviour.Properties.copy(Blocks.BLACK_TERRACOTTA)), ModCreativeModeTab.MODDED);
    //endregion
    //region Terracotta Walls
    public static final RegistryObject<Block> TERRACOTTA_WALL = registerBlock("terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> WHITE_TERRACOTTA_WALL = registerBlock("white_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> ORANGE_TERRACOTTA_WALL = registerBlock("orange_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> MAGENTA_TERRACOTTA_WALL = registerBlock("magenta_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_BLUE_TERRACOTTA_WALL = registerBlock("light_blue_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> YELLOW_TERRACOTTA_WALL = registerBlock("yellow_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIME_TERRACOTTA_WALL = registerBlock("lime_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PINK_TERRACOTTA_WALL = registerBlock("pink_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GRAY_TERRACOTTA_WALL = registerBlock("gray_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> LIGHT_GRAY_TERRACOTTA_WALL = registerBlock("light_gray_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> CYAN_TERRACOTTA_WALL = registerBlock("cyan_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> PURPLE_TERRACOTTA_WALL = registerBlock("purple_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLUE_TERRACOTTA_WALL = registerBlock("blue_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BROWN_TERRACOTTA_WALL = registerBlock("brown_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> GREEN_TERRACOTTA_WALL = registerBlock("green_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> RED_TERRACOTTA_WALL = registerBlock("red_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    public static final RegistryObject<Block> BLACK_TERRACOTTA_WALL = registerBlock("black_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)), ModCreativeModeTab.MODDED);
    //endregion
    //endregion
    //region Ores
    //region Pyrite
    public static final RegistryObject<Block> PYRITE_ORE = registerBlock("pyrite_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f,3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_PYRITE_ORE = registerBlock("deepslate_pyrite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f,3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_PYRITE_BLOCK = registerBlock("raw_pyrite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.GOLD)
                    .strength(5f, 6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> PYRITE_BLOCK = registerBlock("pyrite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).sound(SoundType.METAL)
                    .strength(3f, 6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Zinc
    public static final RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f,3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> ZINC_BLOCK = registerBlock("zinc_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).color(MaterialColor.METAL).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_ZINC_BLOCK = registerBlock("raw_zinc_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.RAW_IRON)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Magnesium
    public static final RegistryObject<Block> MAGNESIUM_ORE = registerBlock("magnesium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_MAGNESIUM_ORE = registerBlock("deepslate_magnesium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f,3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> MAGNESIUM_BLOCK = registerBlock("magnesium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).color(MaterialColor.METAL).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_MAGNESIUM_BLOCK = registerBlock("raw_magnesium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.RAW_IRON)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Silver
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f, 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.RAW_IRON)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Tin
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f,3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).color(MaterialColor.METAL).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.RAW_IRON)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Lead
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f,3f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).color(MaterialColor.METAL).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.RAW_IRON)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Silicon
    public static final RegistryObject<SandBlock> SILICON_ORE = registerBlock("silicon_ore",
            () -> new SandBlock(14406560, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(SoundType.SAND)
                    .strength(0.5f)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<SandBlock> RED_SILICON_ORE = registerBlock("red_silicon_ore",
            () -> new SandBlock(11098145, BlockBehaviour.Properties.of(Material.SAND, MaterialColor.COLOR_ORANGE).sound(SoundType.SAND)
                    .strength(0.5f)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SILICON_BLOCK = registerBlock("silicon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL)
                    .strength(3f, 6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Titanium
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(10f, 80f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_ORE).color(MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE)
                    .strength(12.5f, 80f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).sound(SoundType.METAL)
                    .strength(20f,600f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RAW_TITANIUM_BLOCK = registerBlock("raw_titanium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.RAW_IRON)
                    .strength(20f,600f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Ruby
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f,3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f, 3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Sapphire
    public static final RegistryObject<Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f, 3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_SAPPHIRE_ORE = registerBlock("deepslate_sapphire_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f, 3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Rosalite
    public static final RegistryObject<Block> BASALT_ROSALITE_ORE = registerBlock("basalt_rosalite_ore",
            () -> new BasaltRosaliteOreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).sound(SoundType.BASALT)
                    .strength(1.5f, 3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> ROSALITE_BLOCK = registerBlock("rosalite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_MAGENTA).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Bismuth
    public static final RegistryObject<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL)
                    .strength(5f, 6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> BISMUTH_ORE= registerBlock("bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)
                    .strength(3f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DEEPSLATE_BISMUTH_ORE= registerBlock("deepslate_bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE)
                    .strength(4.5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> TUFF_BISMUTH_ORE= registerBlock("tuff_bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GRAY).sound(SoundType.TUFF)
                    .strength(3f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> ANDESITE_BISMUTH_ORE= registerBlock("andesite_bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE)
                    .strength(3f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> GRANITE_BISMUTH_ORE= registerBlock("granite_bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.DIRT)
                    .strength(3f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DIORITE_BISMUTH_ORE= registerBlock("diorite_bismuth_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(3f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Smoky Quartz
    public static final RegistryObject<Block> SMOKY_QUARTZ_ORE = registerBlock("smoky_quartz_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.NETHER).sound(SoundType.NETHER_ORE)
                    .strength(3f, 3f).requiresCorrectToolForDrops(), UniformInt.of(2, 5)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> BLOCK_OF_SMOKY_QUARTZ = registerBlock("block_of_smoky_quartz",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOKY_QUARTZ_BRICKS = registerBlock("smoky_quartz_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOOTH_SMOKY_QUARTZ_BLOCK = registerBlock("smooth_smoky_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> CHISELED_SMOKY_QUARTZ_BLOCK = registerBlock("chiseled_smoky_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOKY_QUARTZ_PILLAR = registerBlock("smoky_quartz_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOKY_QUARTZ_STAIRS = registerBlock("smoky_quartz_stairs",
            () -> new StairBlock(Blocks.QUARTZ_STAIRS::defaultBlockState, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOOTH_SMOKY_QUARTZ_STAIRS = registerBlock("smooth_smoky_quartz_stairs",
            () -> new StairBlock(Blocks.SMOOTH_QUARTZ_STAIRS::defaultBlockState, BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOKY_QUARTZ_SLAB = registerBlock("smoky_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> SMOOTH_SMOKY_QUARTZ_SLAB = registerBlock("smooth_smoky_quartz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.QUARTZ)
                    .strength(0.8f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Crystals
    public static final RegistryObject<Crystal> CELESTITE = registerBlock("celestite",
            () -> new Crystal(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.TERRACOTTA_WHITE)
                    .instabreak().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Crystal> TANZANITE = registerBlock("tanzanite",
            () -> new Crystal(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_PURPLE)
                    .instabreak().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Crystal> MOLDAVITE = registerBlock("moldavite",
            () -> new Crystal(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_GREEN)
                    .instabreak().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Crystal> CITRINE = registerBlock("citrine",
            () -> new Crystal(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_ORANGE)
                    .instabreak().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Crystal> RHODOCHROSITE = registerBlock("rhodochrosite",
            () -> new Crystal(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED)
                    .instabreak().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Crystal> AQUAMARINE = registerBlock("aquamarine",
            () -> new Crystal(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_CYAN)
                    .instabreak().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<CrystalBlock> CELESTITE_BLOCK = registerBlock("celestite_block",
            () -> new CrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.TERRACOTTA_WHITE)
                    .strength(1.5F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<CrystalBlock> CITRINE_BLOCK = registerBlock("citrine_block",
            () -> new CrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_ORANGE)
                    .strength(1.5F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<CrystalBlock> RHODOCHROSITE_BLOCK = registerBlock("rhodochrosite_block",
            () -> new CrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_RED)
                    .strength(1.5F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<CrystalBlock> MOLDAVITE_BLOCK = registerBlock("moldavite_block",
            () -> new CrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_GREEN)
                    .strength(1.5F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<CrystalBlock> AQUAMARINE_BLOCK = registerBlock("aquamarine_block",
            () -> new CrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_CYAN)
                    .strength(1.5F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<CrystalBlock> TANZANITE_BLOCK = registerBlock("tanzanite_block",
            () -> new CrystalBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_PURPLE)
                    .strength(1.5F).requiresCorrectToolForDrops().sound(SoundType.AMETHYST_CLUSTER)), ModCreativeModeTab.MINERALS);
    //endregion
    //region Unobtainium
    public static final RegistryObject<Block> UNOBTAINIUM_ORE = registerBlock("unobtainium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(100F, 3600000.0F).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //endregion
    //region Alloys
    public static final RegistryObject<Block> ALUMINUM_BLOCK = registerBlock("aluminum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_GRAY).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> BRASS_BLOCK = registerBlock("brass_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> BRONZE_BLOCK = registerBlock("bronze_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.GOLD).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> ELECTRUM_BLOCK = registerBlock("electrum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_YELLOW).sound(SoundType.METAL)
                    .strength(5f,6f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).sound(SoundType.METAL)
                    .strength(10f,12f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> CRYSTALLINE_BLOCK = registerBlock("crystalline_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.GLASS)
                    .strength(25f,600f).requiresCorrectToolForDrops().noOcclusion()), ModCreativeModeTab.MINERALS);

    public static final RegistryObject<Block> DRACONIUM_BLOCK = registerBlock("draconium_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PURPLE).sound(SoundType.NETHERITE_BLOCK)
                    .strength(50f,1200f).requiresCorrectToolForDrops()), ModCreativeModeTab.MINERALS);
    //endregion
    //region Redstone
    public static final RegistryObject<Block> AND_GATE_BLOCK = registerBlock("and_gate_block",
        () -> new TwoInputGateBlock(BlockBehaviour.Properties.copy(Blocks.REPEATER).sound(SoundType.WOOD)
                    .instabreak(), TwoInputGateBlock.AND), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> NAND_GATE_BLOCK = registerBlock("nand_gate_block",
            () -> new TwoInputGateBlock(BlockBehaviour.Properties.copy(Blocks.REPEATER).sound(SoundType.WOOD)
                    .instabreak(), TwoInputGateBlock.NAND), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> OR_GATE_BLOCK = registerBlock("or_gate_block",
            () -> new TwoInputGateBlock(BlockBehaviour.Properties.copy(Blocks.REPEATER).sound(SoundType.WOOD)
                    .instabreak(), TwoInputGateBlock.OR), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> NOR_GATE_BLOCK = registerBlock("nor_gate_block",
            () -> new TwoInputGateBlock(BlockBehaviour.Properties.copy(Blocks.REPEATER).sound(SoundType.WOOD)
                    .instabreak(), TwoInputGateBlock.NOR), ModCreativeModeTab.MODDED);
    //endregion

    private static RegistryObject<Block> registerPottedPlant(String name, RegistryObject<Block> contents) {
        RegistryObject<Block> ret = registerBlockWithoutBlockItem(name,
                () -> new FlowerPotBlock(() -> (FlowerPotBlock) net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.FLOWER_POT).get(),
                        contents, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion().instabreak()));
        BitOEverything.addPottedPlant(contents, ret);
        return ret;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
