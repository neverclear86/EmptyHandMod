package net.neverclear.emptyhand.network

import cpw.mods.fml.common.network.simpleimpl.IMessage
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler
import cpw.mods.fml.common.network.simpleimpl.MessageContext
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.InventoryPlayer
import net.minecraft.item.ItemStack

class MessageHandler : IMessageHandler<MessageEmptyHand, IMessage> {

    var tmpItem: ItemStack? = null
    var slot: Int = 0

    override fun onMessage(message: MessageEmptyHand, ctx: MessageContext): IMessage? {
        val player = ctx.serverHandler.playerEntity
        val data = message.data.toInt()
        if (tmpItem == null && data == 0) {
            toEmpty(player.inventory)
        } else if (tmpItem != null) {
            restore(player.inventory)
        }

        return null
    }

    private fun toEmpty(inv: InventoryPlayer) {
        slot = inv.currentItem
        tmpItem = inv.mainInventory[slot]
        inv.mainInventory[slot] = null
    }

    private fun restore(inv: InventoryPlayer) {
        inv.mainInventory[slot] = tmpItem
        tmpItem = null
    }
}