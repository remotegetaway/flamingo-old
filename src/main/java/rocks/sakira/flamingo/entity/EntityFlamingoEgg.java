package rocks.sakira.flamingo.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import rocks.sakira.flamingo.register.Entities;

public class EntityFlamingoEgg extends EggEntity {
    public EntityFlamingoEgg(EntityType<? extends EggEntity> entityType, World world) {
        super(entityType, world);
    }

    public EntityFlamingoEgg(World worldIn, LivingEntity throwerIn) {
        super(worldIn, throwerIn);
    }

    public static EntityFlamingoEgg spawnForRegistry(EntityType<? extends EntityFlamingoEgg> entityType, World world) {
        return new EntityFlamingoEgg(entityType, world);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            ((EntityRayTraceResult) result)
                    .getEntity()
                    .attackEntityFrom(
                            DamageSource.causeThrownDamage(
                                    this,
                                    this.func_234616_v_()  // getThrower
                            ),
                            0.0F);
        }

        if (!this.world.isRemote) {
            if (this.rand.nextInt(8) == 0) {
                int i = 1;

                if (this.rand.nextInt(32) == 0) {
                    i = 4;
                }

                for (int j = 0; j < i; ++j) {
                    EntityFlamingo flamingoEntity = Entities.FLAMINGO_ENTITY.get().create(this.world);
                    flamingoEntity.setGrowingAge(-24000);
                    flamingoEntity.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
                    this.world.addEntity(flamingoEntity);
                }
            }

            this.world.setEntityState(this, (byte) 3);
            this.remove();
        }
    }
}
