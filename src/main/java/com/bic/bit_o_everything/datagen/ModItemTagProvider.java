package com.bic.bit_o_everything.datagen;

import com.bic.bit_o_everything.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(DataGenerator p_126530_, BlockTagsProvider p_126531_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126530_, p_126531_, modId, existingFileHelper);
    }

    @Override
    protected void addTags() {
        //region Copy Block Tags
        // mod tags
        this.copy(ModTags.Blocks.CHERRY_LOGS, ModTags.Items.CHERRY_LOGS);
        this.copy(ModTags.Blocks.MAPLE_LOGS, ModTags.Items.MAPLE_LOGS);
        this.copy(ModTags.Blocks.DOGWOOD_LOGS, ModTags.Items.DOGWOOD_LOGS);
        this.copy(ModTags.Blocks.REDWOOD_LOGS, ModTags.Items.REDWOOD_LOGS);
        this.copy(ModTags.Blocks.OLIVE_LOGS, ModTags.Items.OLIVE_LOGS);
        this.copy(ModTags.Blocks.PEACH_LOGS, ModTags.Items.PEACH_LOGS);
        this.copy(ModTags.Blocks.EBONY_LOGS, ModTags.Items.EBONY_LOGS);
        this.copy(ModTags.Blocks.PLUM_LOGS, ModTags.Items.PLUM_LOGS);
        this.copy(ModTags.Blocks.ORANGE_LOGS, ModTags.Items.ORANGE_LOGS);
        this.copy(ModTags.Blocks.INFECTED_LOGS, ModTags.Items.INFECTED_LOGS);
        this.copy(ModTags.Blocks.CORRUPT_LOGS, ModTags.Items.CORRUPT_LOGS);
        this.copy(ModTags.Blocks.PEAR_LOGS, ModTags.Items.PEAR_LOGS);
        this.copy(ModTags.Blocks.WISTERIA_LOGS, ModTags.Items.WISTERIA_LOGS);
        this.copy(ModTags.Blocks.CHARRED_LOGS, ModTags.Items.CHARRED_LOGS);
        this.copy(ModTags.Blocks.ICE_LOGS, ModTags.Items.ICE_LOGS);
        this.copy(ModTags.Blocks.DEAD_LOGS, ModTags.Items.DEAD_LOGS);

        // minecraft tags
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
        this.copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
        this.copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
        this.copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
        this.copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
        this.copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
        this.copy(BlockTags.SLABS, ItemTags.SLABS);
        this.copy(BlockTags.STAIRS, ItemTags.STAIRS);
        //endregion
        //region Beacon
        this.tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(ModItems.SAPPHIRE.get())
                .add(ModItems.RUBY.get())
                .add(ModItems.TITANIUM_INGOT.get())
                .add(ModItems.SILVER_INGOT.get())
        ;
        //endregion
        this.tag(ItemTags.FOX_FOOD)
                .add(ModItems.WILDBERRIES.get())
                .add(ModItems.BLUEBERRIES.get())
                .add(ModItems.GOOSEBERRIES.get())
                .add(ModItems.RASPBERRIES.get())
                .add(ModItems.BLACKBERRIES.get())
        ;
        //region Boats
        this.tag(ItemTags.BOATS)
                .add(ModItems.CHERRY_BOAT.get())
                .add(ModItems.MAPLE_BOAT.get())
                .add(ModItems.DOGWOOD_BOAT.get())
                .add(ModItems.REDWOOD_BOAT.get())
                .add(ModItems.OLIVE_BOAT.get())
                .add(ModItems.PEACH_BOAT.get())
                .add(ModItems.EBONY_BOAT.get())
                .add(ModItems.PLUM_BOAT.get())
                .add(ModItems.ORANGE_BOAT.get())
                .add(ModItems.INFECTED_BOAT.get())
                .add(ModItems.CORRUPT_BOAT.get())
                .add(ModItems.PEAR_BOAT.get())
                .add(ModItems.WISTERIA_BOAT.get())
                .add(ModItems.CHARRED_BOAT.get())
                .add(ModItems.ICE_BOAT.get())
                .add(ModItems.DEAD_BOAT.get())
        ;



        this.tag(ItemTags.CHEST_BOATS)
                .add(ModItems.CHERRY_CHEST_BOAT.get())
                .add(ModItems.MAPLE_CHEST_BOAT.get())
                .add(ModItems.DOGWOOD_CHEST_BOAT.get())
                .add(ModItems.REDWOOD_CHEST_BOAT.get())
                .add(ModItems.OLIVE_CHEST_BOAT.get())
                .add(ModItems.PEACH_CHEST_BOAT.get())
                .add(ModItems.EBONY_CHEST_BOAT.get())
                .add(ModItems.PLUM_CHEST_BOAT.get())
                .add(ModItems.ORANGE_CHEST_BOAT.get())
                .add(ModItems.INFECTED_CHEST_BOAT.get())
                .add(ModItems.CORRUPT_CHEST_BOAT.get())
                .add(ModItems.PEAR_CHEST_BOAT.get())
                .add(ModItems.WISTERIA_CHEST_BOAT.get())
                .add(ModItems.CHARRED_CHEST_BOAT.get())
                .add(ModItems.ICE_CHEST_BOAT.get())
                .add(ModItems.DEAD_CHEST_BOAT.get())
        ;

        this.tag(ItemTags.ARROWS)
                .add(ModItems.EXPLOSIVE_ARROW.get())
                .add(ModItems.TIMED_ARROW_ONE.get())
                .add(ModItems.TIMED_ARROW_TWO.get())
                .add(ModItems.TIMED_ARROW_THREE.get())
                .add(ModItems.SILVER_ARROW.get())
        ;
        //endregion
        this.tag(ModTags.Items.CONCRETES)
                .add(Items.WHITE_CONCRETE)
                .add(Items.ORANGE_CONCRETE)
                .add(Items.MAGENTA_CONCRETE)
                .add(Items.LIGHT_BLUE_CONCRETE)
                .add(Items.YELLOW_CONCRETE)
                .add(Items.LIME_CONCRETE)
                .add(Items.PINK_CONCRETE)
                .add(Items.GRAY_CONCRETE)
                .add(Items.LIGHT_GRAY_CONCRETE)
                .add(Items.CYAN_CONCRETE)
                .add(Items.PURPLE_CONCRETE)
                .add(Items.BLUE_CONCRETE)
                .add(Items.BROWN_CONCRETE)
                .add(Items.GREEN_CONCRETE)
                .add(Items.RED_CONCRETE)
                .add(Items.BLACK_CONCRETE)
        ;

    }
}
