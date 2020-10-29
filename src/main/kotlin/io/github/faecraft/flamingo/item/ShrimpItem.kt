package io.github.faecraft.flamingo.item

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World
import io.github.faecraft.flamingo.register.Effects

class ShrimpItem(settings: Settings?) : Item(settings) {
    private val baseEffectDuration = 20 * 30 // 30 seconds

    override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
        if (this.isFood) {
            val effect = user.getStatusEffect(Effects.SHRIMP_EFFECT)

            if (effect == null) {
                user.addStatusEffect(StatusEffectInstance(Effects.SHRIMP_EFFECT, baseEffectDuration, 0))
            } else {
                var amplifier = effect.amplifier

                if (amplifier < 2) amplifier += 1  // Make it more intense

                user.addStatusEffect(
                    StatusEffectInstance(
                        Effects.SHRIMP_EFFECT,
                        baseEffectDuration * (amplifier + 1),
                        amplifier
                    )
                )
            }

            return user.eatFood(world, stack)
        }

        return stack
    }
}
