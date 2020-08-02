package rocks.sakira.flamingo.entity.goals;

import net.minecraft.block.BlockState;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;

public class DeepSwimGoal extends SwimGoal {
    private final MobEntity entity;

    public DeepSwimGoal(MobEntity entityIn) {
        super(entityIn);
        this.entity = entityIn;
    }

    @Override
    public boolean shouldExecute() {
        BlockState below = this.entity.world.getBlockState(new BlockPos(this.entity.getPosX(), this.entity.getPosY(), this.entity.getPosZ()).down());
        BlockState above = this.entity.world.getBlockState(new BlockPos(this.entity.getPosX(), this.entity.getPosY(), this.entity.getPosZ()).up());

        boolean fluidBelow = !below.getFluidState().getFluid().isEquivalentTo(Fluids.EMPTY);
        boolean fluidAbove = !above.getFluidState().getFluid().isEquivalentTo(Fluids.EMPTY);

        return (fluidBelow || fluidAbove) && super.shouldExecute();
    }
}
