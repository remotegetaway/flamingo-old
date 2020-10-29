package io.github.faecraft.flamingo

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.entity.SpawnRestriction
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.projectile.thrown.EggEntity
import net.minecraft.loot.LootTables
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.world.Heightmap
import io.github.faecraft.flamingo.client.render.FlamingoRenderer
import io.github.faecraft.mixin.LootPoolMixin
import io.github.faecraft.mixin.LootTableMixin
import io.github.faecraft.mixin.SpawnRestrictionMixin
import io.github.faecraft.flamingo.register.Effects
import io.github.faecraft.flamingo.register.Entities
import io.github.faecraft.flamingo.register.Items
import io.github.faecraft.flamingo.register.Sounds

const val MOD_ID = "flamingo_ooo"

fun init() {
    Items.register()
    Sounds.register()
    Effects.register()
    Entities.registerAttributes()

    registerSpawnRestrictions()
    registerShrimpLootEntry()
}

fun clientInit() {
    EntityRendererRegistry.INSTANCE.register(Entities.FLAMINGO) { dispatcher, _ ->
        FlamingoRenderer(dispatcher)
    }

    EntityRendererRegistry.INSTANCE.register(Entities.FLAMINGO_EGG) { dispatcher, _ ->
        FlyingItemEntityRenderer<EggEntity>(dispatcher, MinecraftClient.getInstance().itemRenderer)
    }
}


fun registerSpawnRestrictions() {
    SpawnRestrictionMixin.register(
        Entities.FLAMINGO,
        SpawnRestriction.Location.ON_GROUND,
        Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
        AnimalEntity::isValidNaturalSpawn
    )
}

fun registerShrimpLootEntry() {
    LootTableLoadingCallback.EVENT.register(LootTableLoadingCallback { resourceManager, manager, id, supplier, setter ->
        if (id == LootTables.FISHING_FISH_GAMEPLAY) {
            val table = manager.getTable(id)
            val pool = (table as LootTableMixin).pools.first()
            val entries = (pool as LootPoolMixin).entries.toMutableList()

            entries.add(
                ItemEntry.builder(Items.SHRIMP)
                    .weight(13)
                    .build()
            )

            (pool as LootPoolMixin).entries = entries.toTypedArray()
        }
    })
}
