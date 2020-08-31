package rocks.sakira.flamingo.register

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import rocks.sakira.flamingo.MOD_ID
import rocks.sakira.flamingo.item.FlamingoEggItem
import rocks.sakira.flamingo.item.ShrimpCocktailItem
import rocks.sakira.flamingo.item.ShrimpItem

object Items {
    val GROUP: ItemGroup = FabricItemGroupBuilder
        .create(Identifier(MOD_ID, "flamingo"))
        .icon { ItemStack(PINK_FEATHER) }
        .build()

    val PINK_FEATHER = Item(
        Item.Settings().group(GROUP)
    )

    val SHRIMP = ShrimpItem(
        Item.Settings()
            .maxCount(16)
            .food(FoodComponents.SALMON)
            .group(GROUP)
    )

    val COOKED_SHRIMP = Item(
        Item.Settings()
            .maxCount(16)
            .food(FoodComponents.COOKED_RABBIT)
            .group(GROUP)
    )

    val SHRIMP_COCKTAIL = ShrimpCocktailItem(
        Item.Settings()
            .maxCount(16)
            .food(FoodComponents.MUSHROOM_STEW)
            .group(GROUP)
    )

    val SUSPICIOUS_CHICKEN = Item(
        Item.Settings()
            .food(FoodComponents.CHICKEN)
            .group(GROUP)
    )

    val COOKED_SUSPICIOUS_CHICKEN = Item(
        Item.Settings()
            .food(FoodComponents.COOKED_CHICKEN)
            .group(GROUP)
    )

    val FLAMINGO_SPAWN_EGG = SpawnEggItem(
        Entities.FLAMINGO,
        0xEF9A9A,
        0xFFE4E4,
        Item.Settings().group(GROUP)
    )

    val FLAMINGO_EGG = FlamingoEggItem(
        Item.Settings().group(GROUP)
    )

    fun register() {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "pink_feather"), PINK_FEATHER)

        Registry.register(Registry.ITEM, Identifier(MOD_ID, "shrimp"), SHRIMP)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cooked_shrimp"), COOKED_SHRIMP)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "shrimp_cocktail"), SHRIMP_COCKTAIL)

        Registry.register(Registry.ITEM, Identifier(MOD_ID, "suspicious_chicken"), SUSPICIOUS_CHICKEN)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "cooked_suspicious_chicken"), COOKED_SUSPICIOUS_CHICKEN)

        Registry.register(Registry.ITEM, Identifier(MOD_ID, "flamingo_spawn_egg"), FLAMINGO_SPAWN_EGG)
        Registry.register(Registry.ITEM, Identifier(MOD_ID, "flamingo_egg"), FLAMINGO_EGG)
    }
}
