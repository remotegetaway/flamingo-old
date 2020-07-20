package rocks.sakira.flamingo.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import rocks.sakira.flamingo.register.Entities;
import rocks.sakira.flamingo.register.Items;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityFlamingo extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SHRIMP.get());

    public int timeUntilNextEgg = this.rand.nextInt(6000) + 6000;

    public EntityFlamingo(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);

        this.stepHeight = 1.6F;  // A block and a slab
    }

    @Override
    protected void registerGoals() {  // TODO
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.4));
        this.goalSelector.addGoal(1, new TemptGoal(this, 0.4, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.25));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(4, new DeepSwimGoal(this));
        this.goalSelector.addGoal(5, new BreedGoal(this, 0.3));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 0.4));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookAtGoal(this, EntityFlamingo.class, 6.0F));
    }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) {
        return TEMPTATION_ITEMS.test(stack);
    }

    @Override
    public EntitySize getSize(Pose poseIn) {
        EntitySize size = super.getSize(poseIn);

        return this.isChild() ? size.scale(1.33F) : size;
    }

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return Entities.FLAMINGO_ENTITY.get().create(this.world);
    }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return this.isChild() ? 1.15F : 1.75F;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
//        if (this.isChild()) return SoundEvents.FAWN_SOUND.get();
//        if (this.getTextureName().equals("buck")) return SoundEvents.BUCK_SOUND.get();
//
//        return SoundEvents.DOE_SOUND.get();

        return null;  // TODO
    }

    @Override
    public void livingTick() {
        super.livingTick();

        if (!this.world.isRemote && this.isAlive() && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(rocks.sakira.flamingo.register.Items.FLAMINGO_EGG.get());
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains("EggLayTime")) {
            this.timeUntilNextEgg = compound.getInt("EggLayTime");
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putInt("EggLayTime", this.timeUntilNextEgg);
    }

    // TODO?
//    @Override
//    public void onDeath(DamageSource cause) {
//        Entity damageSource = cause.getImmediateSource();
//
//        if (damageSource != null) {
//            if (damageSource.getType().equals(EntityType.SPECTRAL_ARROW)) {
//                if (damageSource.world.rand.nextInt(4) == 0) {
//                    if (!this.isChild()) {
//                        if (this.getTextureName() == "buck") {
//                            this.entityDropItem(new ItemStack(rocks.sakira.gentlefawn.register.Items.BUCK_HEAD_ITEM.get(), 1));
//                        } else {
//                            this.entityDropItem(new ItemStack(rocks.sakira.gentlefawn.register.Items.DOE_HEAD_ITEM.get(), 1));
//                        }
//                    }
//                }
//            }
//        }
//
//        super.onDeath(cause);
//    }
}
