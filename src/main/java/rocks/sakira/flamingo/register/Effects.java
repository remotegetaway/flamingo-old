package rocks.sakira.flamingo.register;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import rocks.sakira.flamingo.Flamingo;
import rocks.sakira.flamingo.effects.ShrimpEffect;

public class Effects {
    public static final DeferredRegister<Effect> REGISTER = DeferredRegister.create(ForgeRegistries.POTIONS, Flamingo.MOD_ID);

    public static final RegistryObject<Effect> SHRIMP_EFFECT = REGISTER.register(
            "shrimp",

            () -> new ShrimpEffect(EffectType.HARMFUL, 0xFF96AB)
    );
}
