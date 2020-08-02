package rocks.sakira.flamingo.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import rocks.sakira.flamingo.entity.EntityFlamingoEgg;

public class ItemFlamingoEgg extends EggItem {
    public ItemFlamingoEgg(Properties builder) {
        super(builder);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        worldIn.playSound(
                null,
                playerIn.getPosX(),
                playerIn.getPosY(),
                playerIn.getPosZ(),
                SoundEvents.ENTITY_EGG_THROW,
                SoundCategory.PLAYERS,
                0.5F,
                0.4F / (random.nextFloat() * 0.4F + 0.8F)
        );

        if (!worldIn.isRemote) {
            EntityFlamingoEgg eggentity = new EntityFlamingoEgg(worldIn, playerIn);

            eggentity.setItem(itemstack);
            eggentity.func_234612_a_(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);  // shoot

            worldIn.addEntity(eggentity);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));

        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        return ActionResult.resultSuccess(itemstack);
    }
}
