package io.github.faecraft.flamingo.entity

import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityPose
import net.minecraft.entity.EntityType
import net.minecraft.entity.ai.goal.*
import net.minecraft.entity.damage.DamageSource
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemStack
import net.minecraft.nbt.CompoundTag
import net.minecraft.recipe.Ingredient
import net.minecraft.server.world.ServerWorld
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.world.World
import io.github.faecraft.flamingo.entity.goal.DeepSwimGoal
import io.github.faecraft.flamingo.register.Entities
import io.github.faecraft.flamingo.register.Items
import io.github.faecraft.flamingo.register.Sounds

class FlamingoEntity(entityType: EntityType<out AnimalEntity>, world: World) : AnimalEntity(entityType, world) {
    // NOTE: No picked result method in Fabric yet

    var timeUntilNextEgg: Int = this.world.random.nextInt(6000) + 6000

    init {
        this.stepHeight = 1.6F
    }

    override fun initGoals() {
        this.goalSelector.add(0, EscapeDangerGoal(this, 1.0))
        this.goalSelector.add(1, TemptGoal(this, 1.0, false, Ingredient.ofItems(Items.SHRIMP)))
        this.goalSelector.add(2, AnimalMateGoal(this, 0.3))
        this.goalSelector.add(3, WanderAroundGoal(this, 0.8))
        this.goalSelector.add(4, WanderAroundGoal(this, 0.8))
        this.goalSelector.add(5, LookAroundGoal(this))
        this.goalSelector.add(6, DeepSwimGoal(this))
        this.goalSelector.add(7, FollowParentGoal(this, 1.0))
        this.goalSelector.add(8, LookAtEntityGoal(this, PlayerEntity::class.java, 6F))
        this.goalSelector.add(9, LookAtEntityGoal(this, FlamingoEntity::class.java, 6F))
    }

    override fun getDimensions(pose: EntityPose?): EntityDimensions {
        val dimensions = super.getDimensions(pose)

        return if (this.isBaby)
            dimensions.scaled(2F)
        else
            dimensions
    }

    override fun createChild(world: ServerWorld, mate: PassiveEntity): PassiveEntity? {
        return Entities.FLAMINGO.create(world)
    }

    override fun isBreedingItem(stack: ItemStack?): Boolean {
        return Ingredient.ofItems(Items.SHRIMP).test(stack)  // NOTE: Can't be stored at class level, throws an NPE
    }

    override fun getActiveEyeHeight(pose: EntityPose?, dimensions: EntityDimensions?): Float = 1.75F
    override fun getHurtSound(source: DamageSource?): SoundEvent? = null  // TODO: No hurt sound

    override fun tickMovement() {
        super.tickMovement()

        if (!this.world.isClient && this.isAlive && !this.isBaby && --this.timeUntilNextEgg == 0) {
            this.playSound(
                SoundEvents.ENTITY_CHICKEN_EGG, 1F,
                (this.world.random.nextFloat() - this.world.random.nextFloat()) * 0.2f + 1.0f
            )

            this.dropItem(Items.FLAMINGO_EGG)
            this.timeUntilNextEgg = this.world.random.nextInt(6000) + 6000
        }
    }

    override fun getAmbientSound(): SoundEvent? = Sounds.FLAMINGO_AMBIENT


    override fun readCustomDataFromTag(tag: CompoundTag) {
        super.readCustomDataFromTag(tag)

        if (tag.contains("EggLayTime"))
            this.timeUntilNextEgg = tag.getInt("EggLayTime")
    }

    override fun writeCustomDataToTag(tag: CompoundTag) {
        super.writeCustomDataToTag(tag)

        tag.putInt("EggLayTime", this.timeUntilNextEgg)
    }
}
