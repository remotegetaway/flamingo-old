package io.github.faecraft.flamingo.register

import net.minecraft.entity.effect.StatusEffectType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import io.github.faecraft.flamingo.MOD_ID
import io.github.faecraft.flamingo.effects.ShrimpEffect

object Effects {
    val SHRIMP_EFFECT = ShrimpEffect(StatusEffectType.HARMFUL, 0xFF96AB)

    fun register() {
        Registry.register(Registry.STATUS_EFFECT, Identifier(MOD_ID, "shrimp"), SHRIMP_EFFECT)
    }
}
