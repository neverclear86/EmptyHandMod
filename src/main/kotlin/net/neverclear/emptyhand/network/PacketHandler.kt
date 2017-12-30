package net.neverclear.emptyhand.network

import cpw.mods.fml.common.network.NetworkRegistry
import cpw.mods.fml.relauncher.Side
import net.neverclear.emptyhand.Constants

class PacketHandler {
    companion object {
        val INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Constants.MOD_ID)

        fun init() {
            INSTANCE.registerMessage(MessageHandler::class.java, MessageEmptyHand::class.java, 0, Side.SERVER)
        }
    }
}