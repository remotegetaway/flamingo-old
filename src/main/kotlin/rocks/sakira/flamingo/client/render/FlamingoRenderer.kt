package rocks.sakira.flamingo.client.render

import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRenderDispatcher
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import rocks.sakira.flamingo.MOD_ID
import rocks.sakira.flamingo.client.model.FlamingoModel
import rocks.sakira.flamingo.entity.FlamingoEntity

class FlamingoRenderer(entityRenderDispatcher: EntityRenderDispatcher?) :
    MobEntityRenderer<FlamingoEntity, FlamingoModel>(entityRenderDispatcher, FlamingoModel(), 0.5F) {

    override fun render(
        mobEntity: FlamingoEntity?,
        f: Float,
        g: Float,
        matrixStack: MatrixStack?,
        vertexConsumerProvider: VertexConsumerProvider?,
        i: Int
    ) {
        if (mobEntity!!.isBaby) {
            matrixStack!!.scale(0.66F, 0.66F, 0.66F)
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i)
    }

    override fun getTexture(entity: FlamingoEntity?): Identifier {
        return if (entity!!.isBaby) {
            Identifier(MOD_ID, "textures/entity/flamingo/baby.png")
        } else {
            Identifier(MOD_ID, "textures/entity/flamingo/adult.png")
        }
    }
}
