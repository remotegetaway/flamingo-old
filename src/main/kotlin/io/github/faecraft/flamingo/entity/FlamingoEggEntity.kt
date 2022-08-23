package io.github.faecraft.flamingo.entity

import net.minecraft.entity.EntityType
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.projectile.thrown.EggEntity
import net.minecraft.util.hit.EntityHitResult
import net.minecraft.util.hit.HitResult
import net.minecraft.world.World
import io.github.faecraft.flamingo.register.Entities

class FlamingoEggEntity : EggEntity {
    constructor(entityType: EntityType<out EggEntity>?, world: World?) : super(entityType, world)
    constructor(world: World?, owner: LivingEntity?) : super(world, owner)
    constructor(world: World?, x: Double, y: Double, z: Double) : super(world, x, y, z)

    override fun onCollision(hitResult: HitResult?) {
        if (hitResult!!.type == HitResult.Type.ENTITY) {
            val result = hitResult as EntityHitResult

            result.entity.damage(
                DamageSource.thrownProjectile(
                    this, this.owner
                ),
                0F
            )
        }

        if (!this.world.isClient) {
            if (this.random.nextInt(8) == 0) {
                var i = 1

                if (this.random.nextInt(32) == 0) {
                    i = 4
                }

                for (j in 0 until i) {
                    val entity = Entities.FLAMINGO.create(this.world)

                    entity!!.breedingAge = -24000
                    entity.updatePositionAndAngles(this.x, this.y, this.z, this.yaw, 0F)

                    this.world.spawnEntity(entity)
                }
            }

            this.world.sendEntityStatus(this, 3)
            this.remove()
        }
    }
}
