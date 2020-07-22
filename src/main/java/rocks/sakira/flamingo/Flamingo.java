package rocks.sakira.flamingo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.client.render.RenderFlamingo;
import rocks.sakira.flamingo.entity.EntityFlamingo;
import rocks.sakira.flamingo.register.Entities;
import rocks.sakira.flamingo.register.Items;
import rocks.sakira.flamingo.register.SoundEvents;

@Mod(Flamingo.MOD_ID)
public class Flamingo {
    public static final String MOD_ID = "flamingo_ooo";

    public Flamingo() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.register(this);

        Entities.REGISTER.register(eventBus);
        Items.REGISTER.register(eventBus);
        SoundEvents.REGISTER.register(eventBus);
    }

    @SubscribeEvent
    public void setupCommon(final FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(
                Entities.FLAMINGO_ENTITY.get(),
                EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                EntityFlamingo::canAnimalSpawn
        );

        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            if (biome.getCategory() == Biome.Category.SWAMP) {
                biome.getSpawns(EntityClassification.CREATURE).add(
                        new Biome.SpawnListEntry(
                                Entities.FLAMINGO_ENTITY.get(),
                                15,
                                5,
                                12
                        )
                );
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void setupClient(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(
                Entities.FLAMINGO_ENTITY.get(),
                RenderFlamingo::new
        );

        RenderingRegistry.registerEntityRenderingHandler(
                Entities.FLAMINGO_EGG_ENTITY.get(),
                (rendererManager) -> new SpriteRenderer<>(rendererManager, Minecraft.getInstance().getItemRenderer())
        );
    }


    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void setupItemColours(final ColorHandlerEvent.Item event) {
        event.getItemColors().register((itemColor, itemsIn) ->
                        Items.FLAMINGO_SPAWN_EGG.get().getColor(itemsIn),
                Items.FLAMINGO_SPAWN_EGG.get()
        );
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void clientSetup(final FMLClientSetupEvent event) throws NoSuchFieldException, IllegalAccessException {

    }
}
