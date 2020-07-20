package rocks.sakira.flamingo.register;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
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
                    .size(0.6F, 1.9F)  // TODO
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
}
