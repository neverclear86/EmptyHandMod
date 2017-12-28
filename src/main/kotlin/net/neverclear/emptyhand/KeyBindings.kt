package net.neverclear.emptyhand

import cpw.mods.fml.client.registry.ClientRegistry
import net.minecraft.client.settings.KeyBinding
import org.lwjgl.input.Keyboard

class KeyBindings {
    companion object {
        private val CATEGORY_GENERAL = "key.${Constants.MOD_ID}.category.main"

        var toEmptyKey: KeyBinding = KeyBinding("key.${Constants.MOD_ID}.toEmpty", Keyboard.KEY_0, CATEGORY_GENERAL)


        fun load() {
        ClientRegistry.registerKeyBinding(toEmptyKey)
        }
    }

}