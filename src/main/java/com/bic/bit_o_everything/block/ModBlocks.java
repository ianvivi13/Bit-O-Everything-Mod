package com.bic.bit_o_everything.block;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.custom.*;
import com.bic.bit_o_everything.block.entity.ModWoodTypes;
import com.bic.bit_o_everything.item.ModCreativeModeTab;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.world.feature.tree_growers.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
    //region Potter
    public static final RegistryObject<Block> POTTER = registerBlock("potter",
            () -> new PotterBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().dynamicShape().instabreak()), ModCreativeModeTab.MODDED);

    public static final RegistryObject<Block> CONCRETE_POTTER = registerBlock("concrete_potter",
            () -> new ConcretePotterBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().dynamicShape().instabreak()), ModCreativeModeTab.MODDED);
    //endregion
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
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_WOOD = registerBlock("cherry_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = registerBlock("stripped_cherry_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = registerBlock("stripped_cherry_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_PLANKS = registerBlock("cherry_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_STAIRS = registerBlock("cherry_stairs",
            () -> new BurnableStair(() -> ModBlocks.CHERRY_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_SLAB = registerBlock("cherry_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_FENCE = registerBlock("cherry_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_FENCE_GATE = registerBlock("cherry_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_BUTTON = registerBlock("cherry_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_PRESSURE_PLATE = registerBlock("cherry_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_DOOR = registerBlock("cherry_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_TRAPDOOR = registerBlock("cherry_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_WALL_SIGN = registerBlockWithoutBlockItem("cherry_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHERRY));
    
    public static final RegistryObject<Block> CHERRY_SIGN = registerBlockWithoutBlockItem("cherry_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CHERRY));
    
    public static final RegistryObject<Block> CHERRY_LEAVES = registerBlock("cherry_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHERRY_SAPLING = registerBlock("cherry_sapling",
            () -> new SaplingBlock(new CherryTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_CHERRY_SAPLING = registerPottedPlant("potted_cherry_sapling", ModBlocks.CHERRY_SAPLING);
    //endregion
    //region Maple Woods
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock("maple_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock("maple_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock("maple_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_STAIRS = registerBlock("maple_stairs",
            () -> new BurnableStair(() -> ModBlocks.MAPLE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_SLAB = registerBlock("maple_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_FENCE = registerBlock("maple_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_BUTTON = registerBlock("maple_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_DOOR = registerBlock("maple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_WALL_SIGN = registerBlockWithoutBlockItem("maple_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.MAPLE));
    
    public static final RegistryObject<Block> MAPLE_SIGN = registerBlockWithoutBlockItem("maple_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.MAPLE));
    
    public static final RegistryObject<Block> MAPLE_LEAVES_RED = registerBlock("maple_leaves_red",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_LEAVES_ORANGE = registerBlock("maple_leaves_orange",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = registerPottedPlant("potted_maple_sapling", ModBlocks.MAPLE_SAPLING);
    //endregion
    //region Dogwood Woods
    public static final RegistryObject<Block> DOGWOOD_LOG = registerBlock("dogwood_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_WOOD = registerBlock("dogwood_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_DOGWOOD_LOG = registerBlock("stripped_dogwood_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_DOGWOOD_WOOD = registerBlock("stripped_dogwood_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_PLANKS = registerBlock("dogwood_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_STAIRS = registerBlock("dogwood_stairs",
            () -> new BurnableStair(() -> ModBlocks.DOGWOOD_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_SLAB = registerBlock("dogwood_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_FENCE = registerBlock("dogwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_FENCE_GATE = registerBlock("dogwood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_BUTTON = registerBlock("dogwood_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_PRESSURE_PLATE = registerBlock("dogwood_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_DOOR = registerBlock("dogwood_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_TRAPDOOR = registerBlock("dogwood_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_WALL_SIGN = registerBlockWithoutBlockItem("dogwood_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.DOGWOOD));
    
    public static final RegistryObject<Block> DOGWOOD_SIGN = registerBlockWithoutBlockItem("dogwood_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.DOGWOOD));
    
    public static final RegistryObject<Block> DOGWOOD_LEAVES = registerBlock("dogwood_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DOGWOOD_SAPLING = registerBlock("dogwood_sapling",
            () -> new SaplingBlock(new DogwoodTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_DOGWOOD_SAPLING = registerPottedPlant("potted_dogwood_sapling", ModBlocks.DOGWOOD_SAPLING);
    //endregion
    //region Redwood Woods
    public static final RegistryObject<Block> REDWOOD_LOG = registerBlock("redwood_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_WOOD = registerBlock("redwood_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_PLANKS = registerBlock("redwood_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_STAIRS = registerBlock("redwood_stairs",
            () -> new BurnableStair(() -> ModBlocks.REDWOOD_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_SLAB = registerBlock("redwood_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_FENCE = registerBlock("redwood_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_FENCE_GATE = registerBlock("redwood_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_BUTTON = registerBlock("redwood_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_PRESSURE_PLATE = registerBlock("redwood_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_DOOR = registerBlock("redwood_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_TRAPDOOR = registerBlock("redwood_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_WALL_SIGN = registerBlockWithoutBlockItem("redwood_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.REDWOOD));
    
    public static final RegistryObject<Block> REDWOOD_SIGN = registerBlockWithoutBlockItem("redwood_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.REDWOOD));
    
    public static final RegistryObject<Block> REDWOOD_LEAVES = registerBlock("redwood_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> REDWOOD_SAPLING = registerBlock("redwood_sapling",
            () -> new SaplingBlock(new RedwoodTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_REDWOOD_SAPLING = registerPottedPlant("potted_redwood_sapling", ModBlocks.REDWOOD_SAPLING);
    //endregion
    //region Olive Woods
    public static final RegistryObject<Block> OLIVE_LOG = registerBlock("olive_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_WOOD = registerBlock("olive_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = registerBlock("stripped_olive_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = registerBlock("stripped_olive_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_PLANKS = registerBlock("olive_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_STAIRS = registerBlock("olive_stairs",
            () -> new BurnableStair(() -> ModBlocks.OLIVE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_SLAB = registerBlock("olive_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_FENCE = registerBlock("olive_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_FENCE_GATE = registerBlock("olive_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_BUTTON = registerBlock("olive_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_PRESSURE_PLATE = registerBlock("olive_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_DOOR = registerBlock("olive_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_TRAPDOOR = registerBlock("olive_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_WALL_SIGN = registerBlockWithoutBlockItem("olive_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.OLIVE));
    
    public static final RegistryObject<Block> OLIVE_SIGN = registerBlockWithoutBlockItem("olive_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.OLIVE));
    
    public static final RegistryObject<Block> OLIVE_LEAVES = registerBlock("olive_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> OLIVE_SAPLING = registerBlock("olive_sapling",
            () -> new SaplingBlock(new OliveTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_OLIVE_SAPLING = registerPottedPlant("potted_olive_sapling", ModBlocks.OLIVE_SAPLING);
    //endregion
    //region Peach Woods
    public static final RegistryObject<Block> PEACH_LOG = registerBlock("peach_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_WOOD = registerBlock("peach_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_PEACH_LOG = registerBlock("stripped_peach_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_PEACH_WOOD = registerBlock("stripped_peach_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_PLANKS = registerBlock("peach_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_STAIRS = registerBlock("peach_stairs",
            () -> new BurnableStair(() -> ModBlocks.PEACH_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_SLAB = registerBlock("peach_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_FENCE = registerBlock("peach_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_FENCE_GATE = registerBlock("peach_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_BUTTON = registerBlock("peach_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_PRESSURE_PLATE = registerBlock("peach_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_DOOR = registerBlock("peach_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_TRAPDOOR = registerBlock("peach_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_WALL_SIGN = registerBlockWithoutBlockItem("peach_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PEACH));
    
    public static final RegistryObject<Block> PEACH_SIGN = registerBlockWithoutBlockItem("peach_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PEACH));
    
    public static final RegistryObject<Block> PEACH_LEAVES = registerBlock("peach_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEACH_SAPLING = registerBlock("peach_sapling",
            () -> new SaplingBlock(new PeachTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_PEACH_SAPLING = registerPottedPlant("potted_peach_sapling", ModBlocks.PEACH_SAPLING);
    //endregion
    //region Ebony Woods
    public static final RegistryObject<Block> EBONY_LOG = registerBlock("ebony_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_WOOD = registerBlock("ebony_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = registerBlock("stripped_ebony_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = registerBlock("stripped_ebony_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_PLANKS = registerBlock("ebony_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_STAIRS = registerBlock("ebony_stairs",
            () -> new BurnableStair(() -> ModBlocks.EBONY_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_SLAB = registerBlock("ebony_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_FENCE = registerBlock("ebony_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_FENCE_GATE = registerBlock("ebony_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_BUTTON = registerBlock("ebony_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_PRESSURE_PLATE = registerBlock("ebony_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_DOOR = registerBlock("ebony_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_TRAPDOOR = registerBlock("ebony_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_WALL_SIGN = registerBlockWithoutBlockItem("ebony_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.EBONY));
    
    public static final RegistryObject<Block> EBONY_SIGN = registerBlockWithoutBlockItem("ebony_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.EBONY));
    
    public static final RegistryObject<Block> EBONY_LEAVES = registerBlock("ebony_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> EBONY_SAPLING = registerBlock("ebony_sapling",
            () -> new SaplingBlock(new EbonyTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_EBONY_SAPLING = registerPottedPlant("potted_ebony_sapling", ModBlocks.EBONY_SAPLING);
    //endregion
    //region Plum Woods
    public static final RegistryObject<Block> PLUM_LOG = registerBlock("plum_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_WOOD = registerBlock("plum_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_PLUM_LOG = registerBlock("stripped_plum_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_PLUM_WOOD = registerBlock("stripped_plum_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_PLANKS = registerBlock("plum_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_STAIRS = registerBlock("plum_stairs",
            () -> new BurnableStair(() -> ModBlocks.PLUM_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_SLAB = registerBlock("plum_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_FENCE = registerBlock("plum_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_FENCE_GATE = registerBlock("plum_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_BUTTON = registerBlock("plum_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_PRESSURE_PLATE = registerBlock("plum_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_DOOR = registerBlock("plum_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_TRAPDOOR = registerBlock("plum_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_WALL_SIGN = registerBlockWithoutBlockItem("plum_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PLUM));
    
    public static final RegistryObject<Block> PLUM_SIGN = registerBlockWithoutBlockItem("plum_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PLUM));
    
    public static final RegistryObject<Block> PLUM_LEAVES = registerBlock("plum_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PLUM_SAPLING = registerBlock("plum_sapling",
            () -> new SaplingBlock(new PlumTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_PLUM_SAPLING = registerPottedPlant("potted_plum_sapling", ModBlocks.PLUM_SAPLING);
    //endregion
    //region Orange Woods
    public static final RegistryObject<Block> ORANGE_LOG = registerBlock("orange_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_WOOD = registerBlock("orange_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_ORANGE_LOG = registerBlock("stripped_orange_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_ORANGE_WOOD = registerBlock("stripped_orange_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_PLANKS = registerBlock("orange_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_STAIRS = registerBlock("orange_stairs",
            () -> new BurnableStair(() -> ModBlocks.ORANGE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_SLAB = registerBlock("orange_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_FENCE = registerBlock("orange_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_FENCE_GATE = registerBlock("orange_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_BUTTON = registerBlock("orange_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_PRESSURE_PLATE = registerBlock("orange_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_DOOR = registerBlock("orange_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_TRAPDOOR = registerBlock("orange_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_WALL_SIGN = registerBlockWithoutBlockItem("orange_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.ORANGE));
    
    public static final RegistryObject<Block> ORANGE_SIGN = registerBlockWithoutBlockItem("orange_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.ORANGE));
    
    public static final RegistryObject<Block> ORANGE_LEAVES = registerBlock("orange_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ORANGE_SAPLING = registerBlock("orange_sapling",
            () -> new SaplingBlock(new OrangeTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_ORANGE_SAPLING = registerPottedPlant("potted_orange_sapling", ModBlocks.ORANGE_SAPLING);
    //endregion
    //region Infected Woods
    public static final RegistryObject<Block> INFECTED_LOG = registerBlock("infected_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_WOOD = registerBlock("infected_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_INFECTED_LOG = registerBlock("stripped_infected_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_INFECTED_WOOD = registerBlock("stripped_infected_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_PLANKS = registerBlock("infected_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_STAIRS = registerBlock("infected_stairs",
            () -> new BurnableStair(() -> ModBlocks.INFECTED_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_SLAB = registerBlock("infected_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_FENCE = registerBlock("infected_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_FENCE_GATE = registerBlock("infected_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_BUTTON = registerBlock("infected_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_PRESSURE_PLATE = registerBlock("infected_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_DOOR = registerBlock("infected_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_TRAPDOOR = registerBlock("infected_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_WALL_SIGN = registerBlockWithoutBlockItem("infected_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.INFECTED));
    
    public static final RegistryObject<Block> INFECTED_SIGN = registerBlockWithoutBlockItem("infected_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.INFECTED));
    
    public static final RegistryObject<Block> INFECTED_LEAVES = registerBlock("infected_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> INFECTED_SAPLING = registerBlock("infected_sapling",
            () -> new SaplingBlock(new InfectedTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_INFECTED_SAPLING = registerPottedPlant("potted_infected_sapling", ModBlocks.INFECTED_SAPLING);
    //endregion
    //region Corrupt Woods
    public static final RegistryObject<Block> CORRUPT_LOG = registerBlock("corrupt_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_WOOD = registerBlock("corrupt_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_CORRUPT_LOG = registerBlock("stripped_corrupt_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_CORRUPT_WOOD = registerBlock("stripped_corrupt_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_PLANKS = registerBlock("corrupt_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_STAIRS = registerBlock("corrupt_stairs",
            () -> new BurnableStair(() -> ModBlocks.CORRUPT_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_SLAB = registerBlock("corrupt_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_FENCE = registerBlock("corrupt_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_FENCE_GATE = registerBlock("corrupt_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_BUTTON = registerBlock("corrupt_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_PRESSURE_PLATE = registerBlock("corrupt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_DOOR = registerBlock("corrupt_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_TRAPDOOR = registerBlock("corrupt_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_WALL_SIGN = registerBlockWithoutBlockItem("corrupt_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CORRUPT));
    
    public static final RegistryObject<Block> CORRUPT_SIGN = registerBlockWithoutBlockItem("corrupt_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CORRUPT));
    
    public static final RegistryObject<Block> CORRUPT_LEAVES = registerBlock("corrupt_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CORRUPT_SAPLING = registerBlock("corrupt_sapling",
            () -> new SaplingBlock(new CorruptTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_CORRUPT_SAPLING = registerPottedPlant("potted_corrupt_sapling", ModBlocks.CORRUPT_SAPLING);
    //endregion
    //region Pear Woods
    public static final RegistryObject<Block> PEAR_LOG = registerBlock("pear_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_WOOD = registerBlock("pear_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_PEAR_LOG = registerBlock("stripped_pear_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_PEAR_WOOD = registerBlock("stripped_pear_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_PLANKS = registerBlock("pear_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_STAIRS = registerBlock("pear_stairs",
            () -> new BurnableStair(() -> ModBlocks.PEAR_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_SLAB = registerBlock("pear_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_FENCE = registerBlock("pear_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_FENCE_GATE = registerBlock("pear_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_BUTTON = registerBlock("pear_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_PRESSURE_PLATE = registerBlock("pear_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_DOOR = registerBlock("pear_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_TRAPDOOR = registerBlock("pear_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_WALL_SIGN = registerBlockWithoutBlockItem("pear_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.PEAR));
    
    public static final RegistryObject<Block> PEAR_SIGN = registerBlockWithoutBlockItem("pear_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.PEAR));
    
    public static final RegistryObject<Block> PEAR_LEAVES = registerBlock("pear_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> PEAR_SAPLING = registerBlock("pear_sapling",
            () -> new SaplingBlock(new PearTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_PEAR_SAPLING = registerPottedPlant("potted_pear_sapling", ModBlocks.PEAR_SAPLING);
    //endregion
    //region Wisteria Woods
    public static final RegistryObject<Block> WISTERIA_LOG = registerBlock("wisteria_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_WOOD = registerBlock("wisteria_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_WISTERIA_LOG = registerBlock("stripped_wisteria_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_WISTERIA_WOOD = registerBlock("stripped_wisteria_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_PLANKS = registerBlock("wisteria_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_STAIRS = registerBlock("wisteria_stairs",
            () -> new BurnableStair(() -> ModBlocks.WISTERIA_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_SLAB = registerBlock("wisteria_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_FENCE = registerBlock("wisteria_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_FENCE_GATE = registerBlock("wisteria_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_BUTTON = registerBlock("wisteria_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_PRESSURE_PLATE = registerBlock("wisteria_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_DOOR = registerBlock("wisteria_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_TRAPDOOR = registerBlock("wisteria_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_WALL_SIGN = registerBlockWithoutBlockItem("wisteria_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.WISTERIA));
    
    public static final RegistryObject<Block> WISTERIA_SIGN = registerBlockWithoutBlockItem("wisteria_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.WISTERIA));
    
    public static final RegistryObject<Block> WISTERIA_LEAVES_BLUE = registerBlock("wisteria_leaves_blue",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_LEAVES_PURPLE = registerBlock("wisteria_leaves_purple",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> WISTERIA_SAPLING = registerBlock("wisteria_sapling",
            () -> new SaplingBlock(new WisteriaTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_WISTERIA_SAPLING = registerPottedPlant("potted_wisteria_sapling", ModBlocks.WISTERIA_SAPLING);
    //endregion
    //region Charred Woods
    public static final RegistryObject<Block> CHARRED_LOG = registerBlock("charred_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_WOOD = registerBlock("charred_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_CHARRED_LOG = registerBlock("stripped_charred_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_CHARRED_WOOD = registerBlock("stripped_charred_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_PLANKS = registerBlock("charred_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_STAIRS = registerBlock("charred_stairs",
            () -> new BurnableStair(() -> ModBlocks.CHARRED_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_SLAB = registerBlock("charred_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_FENCE = registerBlock("charred_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_FENCE_GATE = registerBlock("charred_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_BUTTON = registerBlock("charred_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_PRESSURE_PLATE = registerBlock("charred_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_DOOR = registerBlock("charred_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_TRAPDOOR = registerBlock("charred_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_WALL_SIGN = registerBlockWithoutBlockItem("charred_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.CHARRED));
    
    public static final RegistryObject<Block> CHARRED_SIGN = registerBlockWithoutBlockItem("charred_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.CHARRED));
    
    public static final RegistryObject<Block> CHARRED_LEAVES = registerBlock("charred_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> CHARRED_SAPLING = registerBlock("charred_sapling",
            () -> new SaplingBlock(new CharredTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_CHARRED_SAPLING = registerPottedPlant("potted_charred_sapling", ModBlocks.CHARRED_SAPLING);
    //endregion
    //region Ice Woods
    public static final RegistryObject<Block> ICE_LOG = registerBlock("ice_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_WOOD = registerBlock("ice_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_ICE_LOG = registerBlock("stripped_ice_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_ICE_WOOD = registerBlock("stripped_ice_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_PLANKS = registerBlock("ice_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_STAIRS = registerBlock("ice_stairs",
            () -> new BurnableStair(() -> ModBlocks.ICE_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_SLAB = registerBlock("ice_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_FENCE = registerBlock("ice_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_FENCE_GATE = registerBlock("ice_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_BUTTON = registerBlock("ice_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_PRESSURE_PLATE = registerBlock("ice_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_DOOR = registerBlock("ice_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_TRAPDOOR = registerBlock("ice_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_WALL_SIGN = registerBlockWithoutBlockItem("ice_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.ICE));
    
    public static final RegistryObject<Block> ICE_SIGN = registerBlockWithoutBlockItem("ice_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.ICE));
    
    public static final RegistryObject<Block> ICE_LEAVES = registerBlock("ice_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> ICE_SAPLING = registerBlock("ice_sapling",
            () -> new SaplingBlock(new IceTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_ICE_SAPLING = registerPottedPlant("potted_ice_sapling", ModBlocks.ICE_SAPLING);
    //endregion
    //region Dead Woods
    public static final RegistryObject<Block> DEAD_LOG = registerBlock("dead_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_WOOD = registerBlock("dead_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_DEAD_LOG = registerBlock("stripped_dead_log",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> STRIPPED_DEAD_WOOD = registerBlock("stripped_dead_wood",
            () -> new Wood(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_PLANKS = registerBlock("dead_planks",
            () -> new Plank(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_STAIRS = registerBlock("dead_stairs",
            () -> new BurnableStair(() -> ModBlocks.DEAD_PLANKS.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_SLAB = registerBlock("dead_slab",
            () -> new BurnableSlab(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_FENCE = registerBlock("dead_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_FENCE_GATE = registerBlock("dead_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_BUTTON = registerBlock("dead_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).noCollission()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_PRESSURE_PLATE = registerBlock("dead_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_DOOR = registerBlock("dead_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_TRAPDOOR = registerBlock("dead_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR).noOcclusion()), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_WALL_SIGN = registerBlockWithoutBlockItem("dead_wall_sign",
            () -> new ModWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.DEAD));
    
    public static final RegistryObject<Block> DEAD_SIGN = registerBlockWithoutBlockItem("dead_sign",
            () -> new ModStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.DEAD));
    
    public static final RegistryObject<Block> DEAD_LEAVES = registerBlock("dead_leaves",
            () -> new Leaves(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> DEAD_SAPLING = registerBlock("dead_sapling",
            () -> new SaplingBlock(new DeadTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.WOOD);
    
    public static final RegistryObject<Block> POTTED_DEAD_SAPLING = registerPottedPlant("potted_dead_sapling", ModBlocks.DEAD_SAPLING);
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
    //region Berry Bushes
    public static final RegistryObject<Block> WILDBERRY_BUSH =registerBerryBush("wildberry_bush", ModItems.WILDBERRIES::get);
    public static final RegistryObject<Block> BLUEBERRY_BUSH =registerBerryBush("blueberry_bush", ModItems.BLUEBERRIES::get);
    public static final RegistryObject<Block> GOOSEBERRY_BUSH =registerBerryBush("gooseberry_bush", ModItems.GOOSEBERRIES::get);
    public static final RegistryObject<Block> RASPBERRY_BUSH =registerBerryBush("raspberry_bush", ModItems.RASPBERRIES::get);
    public static final RegistryObject<Block> BLACKBERRY_BUSH =registerBerryBush("blackberry_bush", ModItems.BLACKBERRIES::get);
    //endregion
    
    
    public static final RegistryObject<Block> TREE_TAP = registerBlock("tree_tap",
            () -> new TreeTapBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().dynamicShape()), ModCreativeModeTab.MODDED);


    private static RegistryObject<Block> registerBerryBush(String name, Supplier<ItemLike> drop) {
        return registerBlock(name, () -> new BerryBushBlock(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.COLOR_GREEN)
                .sound(SoundType.SWEET_BERRY_BUSH).randomTicks().isSuffocating(ModBlocks::never)
                .isViewBlocking(ModBlocks::never).noOcclusion(), drop), ModCreativeModeTab.MODDED);
    }

    private static RegistryObject<Block> registerPottedPlant(String name, RegistryObject<Block> contents) {
        RegistryObject<Block> ret = registerBlockWithoutBlockItem(name,
                () -> new FlowerPotBlock(() -> (FlowerPotBlock) net.minecraftforge.registries.ForgeRegistries.BLOCKS.getDelegateOrThrow(Blocks.FLOWER_POT).get(),
                        contents, BlockBehaviour.Properties.copy(Blocks.POTTED_OAK_SAPLING).noOcclusion().instabreak()));
        BitOEverything.addPottedPlant(contents, ret);
        return ret;
    }

    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }
    
    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
