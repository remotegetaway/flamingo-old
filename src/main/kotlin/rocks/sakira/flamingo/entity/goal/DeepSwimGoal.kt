package rocks.sakira.flamingo.entity.goal

import net.minecraft.entity.ai.goal.SwimGoal
import net.minecraft.entity.mob.MobEntity
import net.minecraft.fluid.Fluids

class DeepSwimGoal(val mob: MobEntity) : SwimGoal(mob) {
    override fun canStart(): Boolean {
        val below = this.mob.world.getBlockState(this.mob.blockPos.down())
        val above = this.mob.world.getBlockState(this.mob.blockPos.up())

        val fluidBelow = !below.fluidState.fluid.matchesType(Fluids.EMPTY)
        val fluidAbove = !above.fluidState.fluid.matchesType(Fluids.EMPTY)

        return (fluidBelow || fluidAbove) && super.canStart()
    }
}
