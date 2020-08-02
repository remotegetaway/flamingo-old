package rocks.sakira.flamingo.register;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.Flamingo;
import rocks.sakira.flamingo.entity.EntityFlamingo;
import rocks.sakira.flamingo.entity.EntityFlamingoEgg;

public class Entities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Flamingo.MOD_ID);

    public static final RegistryObject<EntityType<EntityFlamingo>> FLAMINGO_ENTITY = REGISTER.register(
            "flamingo",

            () -> EntityType.Builder
                    .create(EntityFlamingo::new, EntityClassification.CREATURE)
                    .size(0.6F, 1.9F)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .build("flamingo")
    );

    public static final RegistryObject<EntityType<EntityFlamingoEgg>> FLAMINGO_EGG_ENTITY = REGISTER.register(
            "flamingo_egg",

            () -> EntityType.Builder
                    .create(EntityFlamingoEgg::spawnForRegistry, EntityClassification.MISC)
                    .size(0.25F, 0.25F)
                    .build("flamingo_egg")
    );

    @SubscribeEvent
    public static void registerEntities(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(
                FLAMINGO_ENTITY.get(),

                AnimalEntity.func_233666_p_()
                        .func_233815_a_(Attributes.field_233818_a_, 8.0D)  // Max health
                        .func_233815_a_(Attributes.field_233821_d_, 0.25D)  // Movement speed
                        .func_233813_a_()
        );
    }
}
