package io.github.faecraft.flamingo.register

import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricEntityTypeBuilder
import net.minecraft.entity.EntityDimensions
import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.World
import io.github.faecraft.flamingo.MOD_ID
import io.github.faecraft.flamingo.entity.FlamingoEntity
import io.github.faecraft.flamingo.entity.FlamingoEggEntity

object Entities {
    val FLAMINGO: EntityType<FlamingoEntity> = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(MOD_ID, "flamingo"),
        FabricEntityTypeBuilder
            .create(SpawnGroup.AMBIENT, ::createFlamingo)
            .dimensions(EntityDimensions.changing(0.6F, 1.9F))
            .build()
    )

    val FLAMINGO_EGG: EntityType<FlamingoEggEntity> = Registry.register(
        Registry.ENTITY_TYPE,
        Identifier(MOD_ID, "flamingo_egg"),
        FabricEntityTypeBuilder
            .create(SpawnGroup.MISC) { param: EntityType<FlamingoEggEntity>, world: World -> FlamingoEggEntity(param, world) }
            .dimensions(EntityDimensions.fixed(0.25F, 0.25F))
            .build()
    )

    fun registerAttributes() {
        FabricDefaultAttributeRegistry.register(
            FLAMINGO,
            AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0)
        )
    }

    private fun createFlamingo(entityType: EntityType<out AnimalEntity>, world: World) : FlamingoEntity {
        return FlamingoEntity(entityType, world)
    }
}

