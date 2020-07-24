package rocks.sakira.flamingo.register;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.Flamingo;

public class SoundEvents {
    public static final DeferredRegister<SoundEvent> REGISTER = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Flamingo.MOD_ID);

    public static final RegistryObject<SoundEvent> FLAMINGO_AMBIENT_SOUND = REGISTER.register(
            "entity.flamingo.ambient",

            () -> new SoundEvent(new ResourceLocation(Flamingo.MOD_ID, "entity.flamingo.ambient"))
    );

    public static final RegistryObject<SoundEvent> BABY_FLAMINGO_AMBIENT_SOUND = REGISTER.register(
            "entity.flamingo.baby.ambient",

            () -> new SoundEvent(new ResourceLocation(Flamingo.MOD_ID, "entity.flamingo.baby.ambient"))
    );
}
