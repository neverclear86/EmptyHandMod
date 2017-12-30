package net.neverclear.emptyhand.proxy

import cpw.mods.fml.common.FMLCommonHandler
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import net.minecraft.client.Minecraft
import net.minecraft.entity.player.EntityPlayer
import net.minecraftforge.common.MinecraftForge
import net.neverclear.emptyhand.KeyBindings
import net.neverclear.emptyhand.event.EventHandlerClient

class ClientProxy : CommonProxy() {

    override fun preInit(event: FMLPreInitializationEvent) {
        super.preInit(event)

        val handler = EventHandlerClient()
        MinecraftForge.EVENT_BUS.register(handler)
        FMLCommonHandler.instance().bus().register(handler)

        KeyBindings.load()
    }

    override fun getEntityPlayer(): EntityPlayer? {
        return Minecraft.getMinecraft().thePlayer
    }
}