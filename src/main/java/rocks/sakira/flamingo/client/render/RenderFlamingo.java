package rocks.sakira.flamingo.client.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import rocks.sakira.flamingo.Flamingo;
import rocks.sakira.flamingo.client.model.ModelFlamingo;
import rocks.sakira.flamingo.entity.EntityFlamingo;

public class RenderFlamingo extends MobRenderer<EntityFlamingo, ModelFlamingo> {
    public RenderFlamingo(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelFlamingo(), 0.5f);
    }


    @Override
    protected void preRenderCallback(EntityFlamingo entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.isChild()) {
            matrixStackIn.scale(0.66F, 0.66F, 0.66F);
        }
    }

    @Override
    public ResourceLocation getEntityTexture(EntityFlamingo entity) {
        return getEntityTexture("adult");  // TODO: Child texture
    }

    private ResourceLocation getEntityTexture(String fileName) {
        return new ResourceLocation(Flamingo.MOD_ID, "textures/entity/flamingo/" + fileName + ".png");
    }
}
