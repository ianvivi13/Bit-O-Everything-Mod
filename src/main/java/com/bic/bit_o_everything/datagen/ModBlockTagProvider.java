package com.bic.bit_o_everything.datagen;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.Tags.Blocks;
import net.minecraft.tags.BlockTags;

import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator dataGenerator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //region Needs Tool
        this.tag(BlockTags.MINEABLE_WITH_HOE)

        ;

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)

        ;

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.CHERRY_LOG.get())
                .add(ModBlocks.STRIPPED_CHERRY_LOG.get())
                .add(ModBlocks.CHERRY_WOOD.get())
                .add(ModBlocks.STRIPPED_CHERRY_WOOD.get())
                .add(ModBlocks.CHERRY_FENCE.get())
                .add(ModBlocks.CHERRY_FENCE_GATE.get())
                .add(ModBlocks.CHERRY_PLANKS.get())
                .add(ModBlocks.CHERRY_STAIRS.get())
                .add(ModBlocks.CHERRY_SLAB.get())
                .add(ModBlocks.CHERRY_PRESSURE_PLATE.get())
                .add(ModBlocks.CHERRY_BUTTON.get())
                .add(ModBlocks.CHERRY_DOOR.get())
                .add(ModBlocks.CHERRY_SIGN.get())
                .add(ModBlocks.CHERRY_WALL_SIGN.get())
                .add(ModBlocks.CHERRY_TRAPDOOR.get())
        ;

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.PYRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_PYRITE_ORE.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.ASPHALT.get())
        ;
        //endregion
        //region Needs <Level>
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ASPHALT.get())
        ;

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PYRITE_ORE.get())
                .add(ModBlocks.DEEPSLATE_PYRITE_ORE.get())
                .add(ModBlocks.PYRITE_BLOCK.get())
                .add(ModBlocks.RAW_PYRITE_BLOCK.get())
        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)

        ;
        //endregion
        //region Beacon
        this.tag(BlockTags.BEACON_BASE_BLOCKS);
        //endregion
        //region Wood Types
        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.CHERRY_PLANKS.get())
        ;

        this.tag(ModTags.Blocks.CHERRY_LOGS)
                .add(ModBlocks.CHERRY_LOG.get())
                .add(ModBlocks.STRIPPED_CHERRY_LOG.get())
                .add(ModBlocks.CHERRY_WOOD.get())
                .add(ModBlocks.STRIPPED_CHERRY_WOOD.get())
        ;

        this.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(ModTags.Blocks.CHERRY_LOGS)
        ;
        //endregion
        //region Wood Stuffs
        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.CHERRY_LEAVES.get())
        ;

        this.tag(BlockTags.SAPLINGS)
                .add(ModBlocks.CHERRY_SAPLING.get())
        ;

        this.tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.CHERRY_STAIRS.get())
        ;

        this.tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.CHERRY_SLAB.get())
        ;

        this.tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.CHERRY_FENCE.get())
        ;

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.CHERRY_FENCE_GATE.get())
        ;

        this.tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.CHERRY_DOOR.get())
        ;

        this.tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.CHERRY_TRAPDOOR.get())
        ;

        this.tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.CHERRY_PRESSURE_PLATE.get())
        ;

        this.tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.CHERRY_BUTTON.get())
        ;

        this.tag(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.CHERRY_SIGN.get())
        ;

        this.tag(BlockTags.WALL_SIGNS)
                .add(ModBlocks.CHERRY_WALL_SIGN.get())
        ;
        //endregion

    }
}