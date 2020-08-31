package rocks.sakira.flamingo.item

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.EggItem
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvents
import net.minecraft.stat.Stats
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import rocks.sakira.flamingo.entity.FlamingoEggEntity

class FlamingoEggItem(settings: Settings?) : EggItem(settings) {
    override fun use(world: World, user: PlayerEntity, hand: Hand): TypedActionResult<ItemStack> {
        val stack = user.getStackInHand(hand)

        world.playSound(
            null,
            user.x,
            user.y,
            user.z,
            SoundEvents.ENTITY_EGG_THROW,
            SoundCategory.PLAYERS,
            0.5F,
            0.4F / (world.random.nextFloat() * 0.4F + 0.8F)
        )

        if (!world.isClient) {
            val egg = FlamingoEggEntity(world, user)

            egg.setItem(stack)
            egg.setProperties(user, user.pitch, user.yaw, 0F, 1.5F, 1.0F)

            world.spawnEntity(egg)
        }

        user.increaseStat(Stats.USED.getOrCreateStat(this), 1)

        if (!user.isCreative) {
            stack.count -= 1
        }

        return TypedActionResult.success(stack)
    }
}
