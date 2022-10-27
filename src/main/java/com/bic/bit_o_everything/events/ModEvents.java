package com.bic.bit_o_everything.events;

import com.bic.bit_o_everything.BitOEverything;
import com.bic.bit_o_everything.item.custom.fancyTypes.EmptyLeftClick;
import com.bic.bit_o_everything.item.custom.fancyTypes.LeftClickBlock;
import com.bic.bit_o_everything.network.ModPacketHandler;
import com.bic.bit_o_everything.network.ServerboundEmptyLeftClickPacket;
import com.bic.bit_o_everything.util.ModUtils;
import net.minecraft.Util;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BitOEverything.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void leftClickEmptySendToServer(PlayerInteractEvent.LeftClickEmpty event) { // this is only called on client, must send event to server too
        ItemStack itemStack =  event.getItemStack();
        if (itemStack.getItem() instanceof EmptyLeftClick emptyLeftClickItem) {
            emptyLeftClickItem.emptyLeftClick(event.getEntity(), itemStack);
            ModPacketHandler.INSTANCE.sendToServer(new ServerboundEmptyLeftClickPacket());
        }
    }

    @SubscribeEvent
    public static void leftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        ItemStack itemStack =  event.getItemStack();
        if (itemStack.getItem() instanceof LeftClickBlock leftClickBlock) {
            leftClickBlock.leftClickBlock(event.getEntity(), itemStack);
        }
    }

    @SubscribeEvent
    public static void clientReceivedChat(ClientChatReceivedEvent event) {
        if (!event.getChatSender().uuid().equals(Util.NIL_UUID)) {
            String message = event.getMessage().getString();
            event.setMessage(ModUtils.advancedChat.format(message));
        }
    }
}
