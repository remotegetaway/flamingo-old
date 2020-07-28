package rocks.sakira.flamingo.entity.goals;

import net.minecraft.block.BlockState;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rocks.sakira.flamingo.entity.EntityFlamingo;

import java.util.EnumSet;

public class LegUpGoal extends Goal {
    private static final Logger LOGGER = LogManager.getLogger("Flamingo/LegUpGoal");

    private final EntityFlamingo entity;
    private final int totalCycles;
    private int cycleCount = 0;

    public LegUpGoal(EntityFlamingo entityIn) {
        this.entity = entityIn;
        this.totalCycles = 200 + entityIn.world.rand.nextInt(20) * 20;

        this.setMutexFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean shouldExecute() {
        BlockState below = this.entity.world.getBlockState(new BlockPos(this.entity).down());
        BlockState middle = this.entity.world.getBlockState(new BlockPos(this.entity));
        BlockState above = this.entity.world.getBlockState(new BlockPos(this.entity).up());

        boolean fluidBelow = !below.getFluidState().getFluid().isEquivalentTo(Fluids.EMPTY);
        boolean fluidMiddle = !middle.getFluidState().getFluid().isEquivalentTo(Fluids.EMPTY);
        boolean fluidAbove = !above.getFluidState().getFluid().isEquivalentTo(Fluids.EMPTY);

        return !this.entity.isInLava() && fluidMiddle && !(fluidBelow || fluidAbove);
    }

    @Override
    public boolean shouldContinueExecuting() {
        return shouldExecute() && cycleCount <= totalCycles;
    }

    @Override
    public void resetTask() {
        LOGGER.info("Resetting goal");

        this.cycleCount = 0;
        this.entity.setOneLegged(false);
    }

    @Override
    public void tick() {
        if (this.cycleCount == 0) {
            LOGGER.info("Executing goal");
        }

        this.cycleCount += 1;
        this.entity.setOneLegged(true);
    }
}
