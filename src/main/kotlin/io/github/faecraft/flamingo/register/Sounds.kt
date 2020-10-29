package io.github.faecraft.flamingo.register

import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import io.github.faecraft.flamingo.MOD_ID

object Sounds {
    val FLAMINGO_AMBIENT = SoundEvent(Identifier(MOD_ID, "entity.flamingo.ambient"))

    fun register() {
        Registry.register(Registry.SOUND_EVENT, Identifier(MOD_ID, "entity.flamingo.ambient"), FLAMINGO_AMBIENT)
    }
}
