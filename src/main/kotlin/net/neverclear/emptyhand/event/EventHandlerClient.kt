package net.neverclear.emptyhand.event

import cpw.mods.fml.common.eventhandler.EventPriority
import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.InputEvent
import net.minecraft.client.Minecraft
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.neverclear.emptyhand.KeyBindings

class EventHandlerClient {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    fun keyPressed(event: InputEvent.KeyInputEvent) {
        if (KeyBindings.toEmptyKey.isPressed) {
            val player = Minecraft.getMinecraft().thePlayer

            player.sendChatMessage("Emptyyyyyyyyy")

            // ほぼバグ
            player.inventory.currentItem = 10

        }
    }
}