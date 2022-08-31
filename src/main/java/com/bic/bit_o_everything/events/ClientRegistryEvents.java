package com.bic.bit_o_everything.events;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.item.ModItems;
import com.bic.bit_o_everything.item.custom.SpellItem;
import com.bic.bit_o_everything.spells.AbstractSpell;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = BitOEverything.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegistryEvents {
    @SubscribeEvent
    public static void registerItemColor(RegisterColorHandlersEvent.Item event) {
        regSpellColor(event, ModItems.SLOWFALLING_SPELL.get());
        regSpellColor(event, ModItems.TORCH_SPELL.get());
        regSpellColor(event, ModItems.FIREBALL_SPELL.get());
        regSpellColor(event, ModItems.WEATHER_SPELL.get());
        regSpellColor(event, ModItems.HASTE_SPELL.get());
        regSpellColor(event, ModItems.DAMAGE_SPELL.get());
    }

    public static void regSpellColor(RegisterColorHandlersEvent.Item event, Item item) {
        if (item instanceof SpellItem spellItem) {
            event.getItemColors().register(AbstractSpell.getItemColor(spellItem.SPELL), item);
        }
    }


}
