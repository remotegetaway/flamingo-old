package rocks.sakira.flamingo.register;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.Flamingo;
import rocks.sakira.flamingo.entity.EntityFlamingo;

public class Entities {
    public static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.ENTITIES, Flamingo.MOD_ID);

    public static final RegistryObject<EntityType<EntityFlamingo>> FLAMINGO_ENTITY = REGISTER.register(
            "flamingo",

            () -> EntityType.Builder
                    .create(EntityFlamingo::new, EntityClassification.CREATURE)
                    .size(0.6F, 1.3F)  // TODO
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .build("flamingo")
    );

//    @SubscribeEvent
//    public static void registerEntities(final FMLCommonSetupEvent event) {
//        GlobalEntityTypeAttributes.put(
//                DEER_ENTITY.get(),
//
//                AnimalEntity.func_233666_p_()
//                        .func_233815_a_(Attributes.field_233818_a_, 8.0D)  // Max health
//                        .func_233815_a_(Attributes.field_233821_d_, 0.16D)  // Movement speed
//                        .func_233813_a_()
//        );
//    }
}
