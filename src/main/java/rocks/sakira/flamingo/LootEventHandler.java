package rocks.sakira.flamingo;

import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.sakira.flamingo.register.Items;

import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootEventHandler {
    private static final Logger LOGGER = LogManager.getLogger("Flamingo/LootEventHandler");

    @SubscribeEvent
    public static void setupLoot(final LootTableLoadEvent event) {
        if (event.getName().equals(LootTables.GAMEPLAY_FISHING_FISH)) {
            ArrayList<LootEntry> entries = ObfuscationReflectionHelper.getPrivateValue(
                    LootPool.class,
                    event.getTable().getPool("main"),
                    "field_186453_a"
            );

            entries.add(  // We make this public in an access transformer, ignore IDEA
                    ItemLootEntry.builder(Items.SHRIMP.get())
                            .weight(13)
                            .build()
            );

            LOGGER.info("Registered with loot table: " + LootTables.GAMEPLAY_FISHING);
        }
    }
}
