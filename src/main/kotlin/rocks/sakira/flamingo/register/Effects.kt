package rocks.sakira.flamingo.register

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.entity.effect.StatusEffectType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import rocks.sakira.flamingo.MOD_ID
import rocks.sakira.flamingo.effects.ShrimpEffect

object Effects {
    val SHRIMP_EFFECT = ShrimpEffect(StatusEffectType.HARMFUL, 0xFF96AB)

    fun register() {
        Registry.register(Registry.STATUS_EFFECT, Identifier(MOD_ID, "shrimp"), SHRIMP_EFFECT)
    }
}
