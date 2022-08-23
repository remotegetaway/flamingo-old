package io.github.faecraft.flamingo.client.model

import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.math.MathHelper
import io.github.faecraft.flamingo.entity.FlamingoEntity

class FlamingoModel : EntityModel<FlamingoEntity>() {
    private var beak: ModelPart
    private var beaktip: ModelPart
    private var body: ModelPart
    private var head: ModelPart
    private var headbox: ModelPart
    private var leftfeet2: ModelPart
    private var leftfeet: ModelPart
    private var leftleg: ModelPart
    private var lower2: ModelPart
    private var lower: ModelPart
    private var neck1: ModelPart
    private var neck2: ModelPart
    private var neck3: ModelPart
    private var neck4: ModelPart
    private var neck5: ModelPart
    private var neck6: ModelPart
    private var neck: ModelPart
    private var neckbase: ModelPart
    private var rightleg: ModelPart
    private var tail: ModelPart
    private var upper2: ModelPart
    private var upper: ModelPart
    private var wings: ModelPart

    init {
        // NOTE: If you're modifying a model using a model code generator, you should only need to
        // overwrite the contents of this block, and (if you added or removed a ModelPart) the
        // list of properties above.

        this.textureHeight = 64
        this.textureWidth = 64

        head = ModelPart(this)
        head.setPivot(0.0f, -3.75f, -2.5f)

        headbox = ModelPart(this)
        headbox.setPivot(-0.0757f, -0.15f, 0.6424f)
        head.addChild(headbox)
        setAngles(headbox, 0.1745f, 0.0f, 0.0f)
        headbox.setTextureOffset(17, 16).addCuboid(-1.4243f, -1.6643f, -3.231f, 3.0f, 3.0f, 4.0f, 0.0f, true)

        beak = ModelPart(this)
        beak.setPivot(-0.0757f, 0.7161f, -4.0947f)
        head.addChild(beak)
        setAngles(beak, 0.1745f, 0.0f, 0.0f)
        beak.setTextureOffset(0, 30).addCuboid(-0.9243f, -0.8397f, -1.3901f, 2.0f, 2.0f, 3.0f, 0.0f, true)

        beaktip = ModelPart(this)
        beaktip.setPivot(0.0f, 1.5f, -5.7126f)
        head.addChild(beaktip)
        setAngles(beaktip, 0.7854f, 0.0f, 0.0f)
        beaktip.setTextureOffset(27, 47).addCuboid(-1.25f, -0.9339f, -0.7713f, 2.0f, 2.0f, 2.0f, 0.0f, true)
        beaktip.setTextureOffset(27, 39).addCuboid(-0.75f, -0.9339f, -0.7713f, 2.0f, 2.0f, 2.0f, 0.0f, true)

        neck = ModelPart(this)
        neck.setPivot(0.0f, 9.0f, -2.0f)


        neck1 = ModelPart(this)
        neck1.setPivot(0.0f, -11.1335f, -0.3952f)
        neck.addChild(neck1)
        setAngles(neck1, 0.1745f, 0.0f, 0.0f)
        neck1.setTextureOffset(9, 39).addCuboid(-0.999f, -1.4165f, -0.7848f, 2.0f, 2.0f, 2.0f, 0.0f, true)

        neck2 = ModelPart(this)
        neck2.setPivot(0.0f, -9.4989f, -0.5158f)
        neck.addChild(neck2)
        setAngles(neck2, -0.192f, 0.0f, 0.0f)
        neck2.setTextureOffset(9, 39).addCuboid(-1.0f, -1.5211f, -0.8542f, 2.0f, 2.0f, 2.0f, 0.0f, true)

        neck3 = ModelPart(this)
        neck3.setPivot(0.0f, -6.6716f, -1.6113f)
        neck.addChild(neck3)
        setAngles(neck3, -0.4363f, 0.0f, 0.0f)
        neck3.setTextureOffset(0, 36).addCuboid(-0.999f, -2.8484f, -0.9787f, 2.0f, 5.0f, 2.0f, 0.0f, true)

        neck4 = ModelPart(this)
        neck4.setPivot(0.0f, -4.0659f, -2.5144f)
        neck.addChild(neck4)
        setAngles(neck4, -0.0873f, 0.0f, 0.0f)
        neck4.setTextureOffset(9, 39).addCuboid(-1.0f, -0.9841f, -0.9856f, 2.0f, 2.0f, 2.0f, 0.0f, true)

        neck5 = ModelPart(this)
        neck5.setPivot(0.0f, -2.7267f, -2.304f)
        neck.addChild(neck5)
        setAngles(neck5, -1.1345f, 0.0f, 0.0f)
        neck5.setTextureOffset(18, 39).addCuboid(-0.999f, -1.0233f, -0.926f, 2.0f, 2.0f, 2.0f, 0.0f, true)

        neck6 = ModelPart(this)
        neck6.setPivot(0.0f, -1.1638f, -0.8853f)
        neck.addChild(neck6)
        setAngles(neck6, -0.6109f, 0.0f, 0.0f)
        neck6.setTextureOffset(11, 30).addCuboid(-1.0f, -1.0862f, -1.6147f, 2.0f, 2.0f, 3.0f, 0.0f, true)

        neckbase = ModelPart(this)
        neckbase.setPivot(0.0f, -0.7578f, 0.0152f)
        neck.addChild(neckbase)
        setAngles(neckbase, 0.1745f, 0.0f, 0.0f)
        neckbase.setTextureOffset(17, 24).addCuboid(-2.0f, -2.4922f, -0.5152f, 4.0f, 4.0f, 1.0f, 0.0f, true)

        body = ModelPart(this)
        body.setPivot(0.0f, 8.0f, -2.0f)
        body.setTextureOffset(0, 0).addCuboid(-3.0f, -4.0f, 0.0f, 6.0f, 7.0f, 8.0f, 0.0f, true)

        wings = ModelPart(this)
        wings.setPivot(0.0f, -4.0f, 2.0f)
        body.addChild(wings)
        setAngles(wings, -0.1745f, 0.0f, 0.0f)
        wings.setTextureOffset(0, 16).addCuboid(-3.5f, 0.3224f, -0.6832f, 1.0f, 6.0f, 7.0f, 0.0f, true)
        wings.setTextureOffset(29, 0).addCuboid(2.5f, 0.3224f, -0.6832f, 1.0f, 6.0f, 7.0f, 0.0f, true)

        tail = ModelPart(this)
        tail.setPivot(0.0f, 0.4497f, 6.6666f)
        body.addChild(tail)
        setAngles(tail, -0.0873f, 0.0f, 0.0f)
        tail.setTextureOffset(32, 16).addCuboid(-2.5f, -3.6165f, 1.0515f, 5.0f, 6.0f, 1.0f, 0.0f, true)
        tail.setTextureOffset(22, 30).addCuboid(-1.5f, -1.7323f, 1.9333f, 3.0f, 4.0f, 1.0f, 0.0f, true)

        leftleg = ModelPart(this)
        leftleg.setPivot(-1.5f, 11.5f, 2.0f)
        leftleg.setTextureOffset(10, 48).addCuboid(-1.0f, 5.8f, -0.65f, 2.0f, 1.0f, 2.0f, 0.0f, true)

        upper = ModelPart(this)
        upper.setPivot(0.0f, 0.0063f, 0.0637f)
        leftleg.addChild(upper)
        setAngles(upper, 0.1745f, 0.0f, 0.0f)
        upper.setTextureOffset(5, 44).addCuboid(-0.5f, -1.0519f, -1.1916f, 1.0f, 7.0f, 1.0f, 0.0f, true)

        lower = ModelPart(this)
        lower.setPivot(0.0f, 6.45f, 0.8f)
        leftleg.addChild(lower)
        setAngles(lower, -0.0873f, 0.0f, 0.0f)
        lower.setTextureOffset(0, 44).addCuboid(-0.5f, 0.0758f, -0.8346f, 1.0f, 6.0f, 1.0f, 0.0f, true)

        leftfeet = ModelPart(this)
        leftfeet.setPivot(-0.1333f, 12.3333f, 0.0167f)
        leftleg.addChild(leftfeet)
        leftfeet.setTextureOffset(10, 44).addCuboid(-0.8667f, 0.1667f, -1.6167f, 2.0f, 0.0f, 2.0f, 0.0f, true)
        leftfeet.setTextureOffset(19, 50).addCuboid(-0.3667f, 0.1657f, -2.4167f, 1.0f, 0.0f, 1.0f, 0.0f, true)

        rightleg = ModelPart(this)
        rightleg.setPivot(1.5f, 11.5f, 2.0f)
        rightleg.setTextureOffset(10, 48).addCuboid(-1.0f, 5.8f, -0.65f, 2.0f, 1.0f, 2.0f, 0.0f, true)

        upper2 = ModelPart(this)
        upper2.setPivot(0.0f, 0.0063f, 0.0637f)
        rightleg.addChild(upper2)
        setAngles(upper2, 0.1745f, 0.0f, 0.0f)
        upper2.setTextureOffset(5, 44).addCuboid(-0.5f, -1.0519f, -1.2002f, 1.0f, 7.0f, 1.0f, 0.0f, true)

        lower2 = ModelPart(this)
        lower2.setPivot(0.0f, 6.45f, 0.8f)
        rightleg.addChild(lower2)
        setAngles(lower2, -0.0873f, 0.0f, 0.0f)
        lower2.setTextureOffset(0, 44).addCuboid(-0.5f, 0.0758f, -0.8346f, 1.0f, 6.0f, 1.0f, 0.0f, true)

        leftfeet2 = ModelPart(this)
        leftfeet2.setPivot(-0.0333f, 12.3333f, 0.6167f)
        rightleg.addChild(leftfeet2)
        leftfeet2.setTextureOffset(19, 50).addCuboid(-0.3667f, 0.1657f, -3.0167f, 1.0f, 0.0f, 1.0f, 0.0f, true)
        leftfeet2.setTextureOffset(10, 44).addCuboid(-0.8667f, 0.1667f, -2.2667f, 2.0f, 0.0f, 2.0f, 0.0f, true)
    }

    override fun render(
        matrices: MatrixStack?,
        vertices: VertexConsumer?,
        light: Int,
        overlay: Int,
        red: Float,
        green: Float,
        blue: Float,
        alpha: Float
    ) {
        // NOTE: Do not modify this method unless you've added more ModelRenderers and they aren't parented
        // to any of the renderers listed here, either directly or indirectly. If you render a parent model
        // as well as the model itself, the model will be rendered twice in different locations.

        head.render(matrices, vertices, light, overlay)
        neck.render(matrices, vertices, light, overlay)
        body.render(matrices, vertices, light, overlay)
        leftleg.render(matrices, vertices, light, overlay)
        rightleg.render(matrices, vertices, light, overlay)
    }

    override fun setAngles(
        entity: FlamingoEntity?,
        limbAngle: Float,
        limbDistance: Float,
        animationProgress: Float,
        headYaw: Float,
        headPitch: Float
    ) {
        // NOTE: Model code generators may tell you that this method is no longer used and that we should
        // defer to the `render` method.
        //
        // Model code generators are wrong.

        head.pitch = headPitch * 0.017453292f
        head.yaw = headYaw * 0.017453292f
        body.yaw = headYaw * 0.017453292f * 0.25f
        neck.yaw = headYaw * 0.017453292f * 0.25f

        upper2.pitch = 0.1745f
        lower2.pitch = 0F
        leftfeet2.pitch = 0F

        leftleg.pitch = MathHelper.cos(limbAngle * 1f) * 0.7f * limbDistance
        rightleg.pitch = MathHelper.cos(limbAngle * 1f + Math.PI.toFloat()) * 0.7f * limbDistance
    }

    private fun setAngles(part: ModelPart, pitch: Float, yaw: Float, roll: Float) {
        // NOTE: This auto-generated method will likely never be changed, so don't bother copying it in
        // from generated model code.

        part.pitch = pitch
        part.yaw = yaw
        part.roll = roll
    }
}
