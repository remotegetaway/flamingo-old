package rocks.sakira.flamingo

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.entity.FlyingItemEntityRenderer
import net.minecraft.entity.SpawnGroup
import net.minecraft.entity.SpawnRestriction
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.projectile.thrown.EggEntity
import net.minecraft.loot.LootTables
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.util.registry.Registry
import net.minecraft.world.Heightmap
import net.minecraft.world.biome.Biome
import rocks.sakira.flamingo.client.render.FlamingoRenderer
import rocks.sakira.flamingo.mixin.LootPoolMixin
import rocks.sakira.flamingo.mixin.LootTableMixin
import rocks.sakira.flamingo.mixin.SpawnRestrictionMixin
import rocks.sakira.flamingo.register.Effects
import rocks.sakira.flamingo.register.Entities
import rocks.sakira.flamingo.register.Items
import rocks.sakira.flamingo.register.Sounds

const val MOD_ID = "flamingo_ooo"

fun init() {
    Items.register()
    Sounds.register()
    Effects.register()
    Entities.registerAttributes()

    registerSpawnRestrictions()
    registerSpawns()
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

fun registerSpawns() {
    for (biome in Registry.BIOME.stream()) {
        if (biome.category == Biome.Category.SWAMP) {
            biome.getEntitySpawnList(SpawnGroup.CREATURE).add(
                Biome.SpawnEntry(
                    Entities.FLAMINGO,
                    15,
                    5,
                    12
                )
            )
        }
    }
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
