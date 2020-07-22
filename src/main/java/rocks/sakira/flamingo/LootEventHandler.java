package rocks.sakira.flamingo;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTables;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.sakira.flamingo.register.Items;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootEventHandler {
    private static final Logger LOGGER = LogManager.getLogger("Flamingo/LootEventHandler");

    @SubscribeEvent
    public static void setupLoot(final LootTableLoadEvent event) {
        if (event.getName().equals(LootTables.GAMEPLAY_FISHING_FISH)) {
            event.getTable()
                    .getPool("main")
                    .lootEntries.add(  // We make this public in an access transformer, ignore IDEA
                            ItemLootEntry.builder(Items.SHRIMP.get())
                                    .weight(13)
                                    .build()
            );

            LOGGER.info("Registered with loot table: " + LootTables.GAMEPLAY_FISHING);
        }
    }
}
