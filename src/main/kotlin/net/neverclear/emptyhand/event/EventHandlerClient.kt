package net.neverclear.emptyhand.event

import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent
import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.MouseEvent
import net.neverclear.emptyhand.KeyBindings
import net.neverclear.emptyhand.network.MessageEmptyHand
import net.neverclear.emptyhand.network.PacketHandler

class EventHandlerClient {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun keyPressed(event: KeyInputEvent) {
        if (KeyBindings.toEmptyKey.isPressed) {
            PacketHandler.INSTANCE.sendToServer(MessageEmptyHand(0.toByte()))
//        } else {
//            PacketHandler.INSTANCE.sendToServer(MessageEmptyHand(1.toByte()))
        } else if (Minecraft.getMinecraft().gameSettings.keyBindsHotbar.any { it.isPressed }) {
            PacketHandler.INSTANCE.sendToServer(MessageEmptyHand(1.toByte()))
        }

//        if (Minecraft.getMinecraft().gameSettings.keyBindsHotbar.any { it.isPressed }) {
//            PacketHandler.INSTANCE.sendToServer(MessageEmptyHand(1.toByte()))
//        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun mouseEvent(event: MouseEvent) {
        if (event.dwheel != 0) {
            PacketHandler.INSTANCE.sendToServer(MessageEmptyHand(1.toByte()))
        }
    }

}