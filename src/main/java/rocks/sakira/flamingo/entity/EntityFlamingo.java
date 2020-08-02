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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import rocks.sakira.flamingo.entity.goals.DeepSwimGoal;
import rocks.sakira.flamingo.register.Entities;
import rocks.sakira.flamingo.register.Items;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityFlamingo extends AnimalEntity {
    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.SHRIMP.get());
    private static final DataParameter<Boolean> LEG_UP_STATE = EntityDataManager.createKey(EntityFlamingo.class, DataSerializers.BOOLEAN);

    public int timeUntilNextEgg = this.rand.nextInt(6000) + 6000;

    public EntityFlamingo(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);

        this.stepHeight = 1.6F;  // A block and a slab
    }

    @Override
    protected void registerData() {
        super.registerData();

        getDataManager().register(LEG_UP_STATE, false);
    }

    @Override
    protected void registerGoals() {  // TODO
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.4));
        this.goalSelector.addGoal(1, new TemptGoal(this, 0.4, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(2, new BreedGoal(this, 0.3));
//        this.goalSelector.addGoal(3, new LegUpGoal(this));
        this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.25));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(6, new DeepSwimGoal(this));
        this.goalSelector.addGoal(7, new FollowParentGoal(this, 0.4));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookAtGoal(this, EntityFlamingo.class, 6.0F));
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

        if (compound.contains("EggLayTime"))
            this.timeUntilNextEgg = compound.getInt("EggLayTime");

        if (compound.contains("LegUpState"))
            dataManager.set(LEG_UP_STATE, compound.getBoolean("LegUpState"));
    }

    public boolean isOneLegged() {
        return dataManager.get(LEG_UP_STATE);
    }

    public void setOneLegged(boolean state) {
        dataManager.set(LEG_UP_STATE, state);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putInt("EggLayTime", this.timeUntilNextEgg);
        compound.putBoolean("LegUpState", dataManager.get(LEG_UP_STATE));
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(Items.FLAMINGO_SPAWN_EGG.get());
    }

    @Override
    public SoundEvent getAmbientSound() {
        if (this.isChild()) return rocks.sakira.flamingo.register.SoundEvents.BABY_FLAMINGO_AMBIENT_SOUND.get();

        return rocks.sakira.flamingo.register.SoundEvents.FLAMINGO_AMBIENT_SOUND.get();
    }
}
