package rocks.sakira.flamingo.register;

import net.minecraft.item.Foods;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.Flamingo;
import rocks.sakira.flamingo.item.ItemFlamingoEgg;
import rocks.sakira.flamingo.item.SupplierSpawnEggItem;

public class Items {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Flamingo.MOD_ID);

    private static final ItemGroup GROUP = new ItemGroup("flamingo_ooo") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(FLAMINGO_SPAWN_EGG.get());
        }
    };

    public static final RegistryObject<Item> FLAMINGO_SPAWN_EGG = REGISTER.register(
            "flamingo_spawn_egg",

            () -> new SupplierSpawnEggItem(
                    Entities.FLAMINGO_ENTITY,
                    0xEF9A9A,
                    0xFFE4E4,

                    (new Item.Properties())
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> FLAMINGO_EGG = REGISTER.register(
            "flamingo_egg",

            () -> new ItemFlamingoEgg(
                    new Item.Properties()
                            .maxStackSize(16)
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> PINK_FEATHERS = REGISTER.register(
            "pink_feather",

            () -> new Item(
                    new Item.Properties()
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> SHRIMP = REGISTER.register(
            "shrimp",

            () -> new Item(
                    new Item.Properties()
                            .maxStackSize(16)
                            .food(Foods.SALMON)  // 2 hunger
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> COOKED_SHRIMP = REGISTER.register(
            "cooked_shrimp",

            () -> new Item(
                    new Item.Properties()
                            .maxStackSize(16)
                            .food(Foods.COOKED_RABBIT)  // 5 hunger
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> SUSPICIOUS_CHICKEN = REGISTER.register(
            "suspicious_chicken",

            () -> new Item(
                    new Item.Properties()
                            .food(Foods.CHICKEN)  // 5 hunger
                            .group(GROUP)
            )
    );

    public static final RegistryObject<Item> COOKED_SUSPICIOUS_CHICKEN = REGISTER.register(
            "cooked_suspicious_chicken",

            () -> new Item(
                    new Item.Properties()
                            .food(Foods.COOKED_CHICKEN)  // 5 hunger
                            .group(GROUP)
            )
    );
}
