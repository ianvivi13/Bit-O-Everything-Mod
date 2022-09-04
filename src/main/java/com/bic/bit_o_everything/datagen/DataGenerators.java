package com.bic.bit_o_everything.datagen;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.datagen.loot.ModBlockLootTables;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BitOEverything.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        ModBlockTagProvider bp;

        generator.addProvider(true, new ModRecipeProvider(generator));
        generator.addProvider(true, new ModLootTableProvider(generator));
        generator.addProvider(true, bp = new ModBlockTagProvider(generator, BitOEverything.MOD_ID, existingFileHelper));
        generator.addProvider(true, new ModItemTagProvider(generator, bp,BitOEverything.MOD_ID, existingFileHelper));
    }
}
