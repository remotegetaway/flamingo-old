package rocks.sakira.flamingo.register;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.Flamingo;
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
                    0xB49D8A,
                    0xF6F3EF,

                    (new Item.Properties())
                            .group(GROUP)
            )
    );
}
