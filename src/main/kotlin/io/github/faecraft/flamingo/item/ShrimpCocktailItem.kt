package io.github.faecraft.flamingo.item

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.world.World

class ShrimpCocktailItem(settings: Settings) : Item(settings) {
    override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
        val finishedStack = super.finishUsing(stack, world, user)

        if (user is PlayerEntity) {
            if (user.isCreative) {
                return finishedStack
            }
        }

        return ItemStack(Items.BOWL)
    }
}
