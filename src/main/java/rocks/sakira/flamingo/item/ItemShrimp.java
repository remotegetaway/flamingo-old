package rocks.sakira.flamingo.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import rocks.sakira.flamingo.register.Effects;

public class ItemShrimp extends Item {
    private static int baseEffectDuration = 20 * 30; // 30 seconds

    public ItemShrimp(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (this.isFood()) {
            EffectInstance effect = entityLiving.getActivePotionEffect(Effects.SHRIMP_EFFECT.get());

            if (effect == null) {
                entityLiving.addPotionEffect(new EffectInstance(Effects.SHRIMP_EFFECT.get(), baseEffectDuration, 0));
            } else {
                int amplifier = effect.getAmplifier();

                if (amplifier < 4) {
                    amplifier += 1;  // Make it more intense
                }

//                entityLiving.removePotionEffect(Effects.SHRIMP_EFFECT.get());
                entityLiving.addPotionEffect(new EffectInstance(Effects.SHRIMP_EFFECT.get(), baseEffectDuration * (amplifier + 1), amplifier));
            }
        }

        return this.isFood() ? entityLiving.onFoodEaten(worldIn, stack) : stack;
    }
}
