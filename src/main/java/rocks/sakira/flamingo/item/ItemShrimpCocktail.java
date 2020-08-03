package rocks.sakira.flamingo.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;
import rocks.sakira.flamingo.register.Effects;

public class ItemShrimpCocktail extends Item {
    public ItemShrimpCocktail(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        ItemStack itemstack = super.onItemUseFinish(stack, worldIn, entityLiving);

        return entityLiving instanceof PlayerEntity && ((PlayerEntity)entityLiving).abilities.isCreativeMode ? itemstack : new ItemStack(Items.BOWL);
    }
}
