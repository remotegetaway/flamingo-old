package rocks.sakira.flamingo.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import rocks.sakira.flamingo.entity.EntityFlamingo;

public class ModelFlamingo extends EntityModel<EntityFlamingo> {
    private final ModelRenderer head;
    private final ModelRenderer bone;
    private final ModelRenderer bone3;
    private final ModelRenderer bone10;
    private final ModelRenderer neck;
    private final ModelRenderer neck1;
    private final ModelRenderer neck2;
    private final ModelRenderer neck3;
    private final ModelRenderer neck4;
    private final ModelRenderer neck5;
    private final ModelRenderer neck6;
    private final ModelRenderer neckbase;
    private final ModelRenderer body;
    private final ModelRenderer wings;
    private final ModelRenderer tail;
    private final ModelRenderer leftleg;
    private final ModelRenderer upper;
    private final ModelRenderer lower;
    private final ModelRenderer leftfeet;
    private final ModelRenderer rightleg;
    private final ModelRenderer upper2;
    private final ModelRenderer lower2;
    private final ModelRenderer leftfeet2;


    public ModelFlamingo() {
        // NOTE: If you're modifying a model using a model code generator, you should only need to
        // overwrite the contents of this method, and (if you added or removed a ModelRenderer) the
        // list of properties above.

        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -3.0F, -2.0F);


        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(0.0F, -0.9F, -3.6F);
        head.addChild(bone10);
        setRotationAngle(bone10, 0.1745F, 0.0F, 0.0F);
        bone10.setTextureOffset(16, 15).addBox(-1.5F, -1.1528F, -0.0304F, 3.0F, 3.0F, 4.0F, 0.0F, true);

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, -0.0339F, -6.0871F);
        head.addChild(bone3);
        setRotationAngle(bone3, 0.1745F, 0.0F, 0.0F);
        bone3.setTextureOffset(0, 28).addBox(-1.0F, -0.7106F, -0.4341F, 2.0F, 2.0F, 3.0F, 0.0F, true);

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 0.5308F, -7.955F);
        head.addChild(bone);
        setRotationAngle(bone, 0.7854F, 0.0F, 0.0F);
        bone.setTextureOffset(16, 39).addBox(-1.1F, 0.0763F, -0.1965F, 2.2F, 2.1F, 2.0F, 0.0F, true);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 9.0F, -2.0F);


        neck1 = new ModelRenderer(this);
        neck1.setRotationPoint(0.0F, -10.5476F, -2.5583F);
        neck.addChild(neck1);
        setRotationAngle(neck1, 0.1745F, 0.0F, 0.0F);
        neck1.setTextureOffset(0, 39).addBox(-1.0F, -0.6746F, 1.134F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        neck2 = new ModelRenderer(this);
        neck2.setRotationPoint(0.0F, -9.0181F, -2.3415F);
        neck.addChild(neck2);
        setRotationAngle(neck2, -0.192F, 0.0F, 0.0F);
        neck2.setTextureOffset(8, 39).addBox(-1.0F, -1.3635F, 0.9047F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        neck3 = new ModelRenderer(this);
        neck3.setRotationPoint(0.0F, -6.2735F, -3.4362F);
        neck.addChild(neck3);
        setRotationAngle(neck3, -0.4363F, 0.0F, 0.0F);
        neck3.setTextureOffset(10, 33).addBox(-1.0F, -3.0952F, 0.8126F, 2.0F, 4.5F, 2.0F, 0.0F, true);

        neck4 = new ModelRenderer(this);
        neck4.setRotationPoint(0.0F, -3.7704F, -4.7219F);
        neck.addChild(neck4);
        setRotationAngle(neck4, -0.0873F, 0.0F, 0.0F);
        neck4.setTextureOffset(26, 33).addBox(-1.0F, -1.054F, 1.3643F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        neck5 = new ModelRenderer(this);
        neck5.setRotationPoint(0.0F, -2.2486F, -4.1177F);
        neck.addChild(neck5);
        setRotationAngle(neck5, -1.1345F, 0.0F, 0.0F);
        neck5.setTextureOffset(24, 39).addBox(-1.0F, -2.8126F, -0.1548F, 2.0F, 2.0F, 2.0F, 0.0F, true);

        neck6 = new ModelRenderer(this);
        neck6.setRotationPoint(0.0F, -0.8836F, -2.779F);
        neck.addChild(neck6);
        setRotationAngle(neck6, -0.6109F, 0.0F, 0.0F);
        neck6.setTextureOffset(10, 28).addBox(-1.0F, -2.1472F, 0.1383F, 2.0F, 2.0F, 3.0F, 0.0F, true);

        neckbase = new ModelRenderer(this);
        neckbase.setRotationPoint(0.0F, -0.1202F, -1.7808F);
        neck.addChild(neckbase);
        setRotationAngle(neckbase, 0.1745F, 0.0F, 0.0F);
        neckbase.setTextureOffset(20, 28).addBox(-2.0F, -1.6528F, 1.4696F, 4.0F, 4.0F, 1.0F, 0.0F, true);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 8.0F, -2.0F);
        body.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 7.0F, 8.3F, 0.0F, true);

        wings = new ModelRenderer(this);
        wings.setRotationPoint(0.0F, -4.0F, 2.0F);
        body.addChild(wings);
        setRotationAngle(wings, -0.1745F, 0.0F, 0.0F);
        wings.setTextureOffset(0, 15).addBox(-3.5F, 0.3224F, -0.6832F, 1.0F, 6.0F, 7.0F, 0.0F, true);
        wings.setTextureOffset(28, 0).addBox(2.5F, 0.3224F, -0.6832F, 1.0F, 6.0F, 7.0F, 0.0F, true);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 0.4497F, 6.6666F);
        body.addChild(tail);
        setRotationAngle(tail, -0.0873F, 0.0F, 0.0F);
        tail.setTextureOffset(30, 15).addBox(-2.5F, -3.6165F, 1.0515F, 5.0F, 6.0F, 1.0F, 0.0F, true);
        tail.setTextureOffset(18, 33).addBox(-1.5F, -1.7323F, 1.9333F, 3.0F, 4.0F, 1.0F, 0.0F, true);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(-1.5F, 11.5F, 2.0F);
        leftleg.setTextureOffset(8, 45).addBox(-1.0F, 5.8F, -0.65F, 2.0F, 1.0F, 2.0F, 0.0F, true);

        upper = new ModelRenderer(this);
        upper.setRotationPoint(0.0F, 0.0063F, 0.0637F);
        leftleg.addChild(upper);
        setRotationAngle(upper, 0.1745F, 0.0F, 0.0F);
        upper.setTextureOffset(4, 43).addBox(-0.5F, -0.5519F, -1.1916F, 1.0F, 6.5F, 1.0F, 0.0F, true);

        lower = new ModelRenderer(this);
        lower.setRotationPoint(0.0F, 6.45F, 0.8F);
        leftleg.addChild(lower);
        setRotationAngle(lower, -0.0873F, 0.0F, 0.0F);
        lower.setTextureOffset(0, 43).addBox(-0.5F, 0.0758F, -0.8346F, 1.0F, 6.0F, 1.0F, 0.0F, true);

        leftfeet = new ModelRenderer(this);
        leftfeet.setRotationPoint(-0.1333F, 12.3333F, 0.0167F);
        leftleg.addChild(leftfeet);
        leftfeet.setTextureOffset(8, 43).addBox(-0.8667F, 0.1667F, -1.6167F, 2.0F, 0.0F, 2.0F, 0.0F, true);
        leftfeet.setTextureOffset(4, 51).addBox(-0.3667F, 0.1657F, -2.4167F, 1.0F, 0.0F, 1.0F, 0.0F, true);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(1.5F, 11.5F, 2.0F);
        rightleg.setTextureOffset(8, 45).addBox(-1.0F, 5.8F, -0.65F, 2.0F, 1.0F, 2.0F, 0.0F, true);

        upper2 = new ModelRenderer(this);
        upper2.setRotationPoint(0.0F, 0.0063F, 0.0637F);
        rightleg.addChild(upper2);
        setRotationAngle(upper2, 0.1745F, 0.0F, 0.0F);
        upper2.setTextureOffset(4, 43).addBox(-0.5F, -0.5519F, -1.2002F, 1.0F, 6.5F, 1.0F, 0.0F, true);

        lower2 = new ModelRenderer(this);
        lower2.setRotationPoint(0.0F, 6.45F, 0.8F);
        rightleg.addChild(lower2);
        setRotationAngle(lower2, -0.0873F, 0.0F, 0.0F);
        lower2.setTextureOffset(0, 43).addBox(-0.5F, 0.0758F, -0.8346F, 1.0F, 6.0F, 1.0F, 0.0F, true);

        leftfeet2 = new ModelRenderer(this);
        leftfeet2.setRotationPoint(-0.0333F, 12.3333F, 0.6167F);
        rightleg.addChild(leftfeet2);
        leftfeet2.setTextureOffset(4, 51).addBox(-0.3667F, 0.1657F, -3.0167F, 1.0F, 0.0F, 1.0F, 0.0F, true);
        leftfeet2.setTextureOffset(8, 43).addBox(-0.8667F, 0.1667F, -2.2667F, 2.0F, 0.0F, 2.0F, 0.0F, true);
    }

    @Override
    public void setRotationAngles(EntityFlamingo entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // NOTE: Model code generators may tell you that this method is no longer used and that we should
        // defer to the `render` method.
        //
        // Model code generators are wrong.
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 1F) * 0.7F * limbSwingAmount;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 1F + (float) Math.PI) * 0.7F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        // NOTE: Do not modify this method unless you've added more ModelRenderers and they aren't parented
        // to any of the renderers listed here, either directly or indirectly. If you render a parent model
        // as well as the model itself, the model will be rendered twice in different locations.

        head.render(matrixStack, buffer, packedLight, packedOverlay);
        neck.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        // NOTE: This auto-generated method will likely never be changed, so don't bother copying it in
        // from generated model code.

        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
