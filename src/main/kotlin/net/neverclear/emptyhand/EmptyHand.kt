package net.neverclear.emptyhand

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.SidedProxy
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.neverclear.emptyhand.network.PacketHandler
import net.neverclear.emptyhand.proxy.CommonProxy
import org.apache.logging.log4j.Logger

/**
 * EmptyHand メインクラス
 */
@Mod(modid = Constants.MOD_ID, version = Constants.VERSION)
class EmptyHand {
    companion object {
        @SidedProxy(clientSide = "net.neverclear.emptyhand.proxy.ClientProxy",
                    serverSide = "net.neverclear.emptyhand.proxy.CommonProxy")
        lateinit var proxy : CommonProxy
    }
    private lateinit var logger : Logger


    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        logger.trace("EmptyHand: preInit")
        proxy.preInit(event)
        PacketHandler.init()
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        logger.trace("EmptyHand: init")
        proxy.init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        logger.trace("EmptyHand: postInit")
        proxy.postInit(event)
    }
}