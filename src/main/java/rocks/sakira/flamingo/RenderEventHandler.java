package rocks.sakira.flamingo;


import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldVertexBufferUploader;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import rocks.sakira.flamingo.register.Effects;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RenderEventHandler {
    private static final ResourceLocation TEXTURE_SHRIMP_EFFECT = new ResourceLocation(Flamingo.MOD_ID, "textures/misc/shrimp_effect.png");

    @SubscribeEvent
    public static void renderWorldLastEvent(final RenderWorldLastEvent event) {
        Minecraft minecraft = Minecraft.getInstance();

        ClientPlayerEntity player = minecraft.player;
        if (player == null) return;

        EffectInstance effect = player.getActivePotionEffect(Effects.SHRIMP_EFFECT.get());
        if (effect == null) return;

        minecraft.getTextureManager().bindTexture(TEXTURE_SHRIMP_EFFECT);

        BufferBuilder builder = Tessellator.getInstance().getBuffer();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        // These values follow the values used in OverlayRenderer#renderUnderwater
        float f7 = -minecraft.player.rotationYaw / 64.0F;
        float f8 = minecraft.player.rotationPitch / 64.0F;

//        final float alpha = 0.2F * (effect.getAmplifier() + 1);
        final float alpha = 0.1F + (0.3F * (effect.getAmplifier() + 1));
        final float brightness = 1.0F;
        final float zValue = -0.1F;

        builder.begin(7, DefaultVertexFormats.POSITION_COLOR_TEX);

        builder.pos(-1.0F, -1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(4.0F + f7, 4.0F + f8).endVertex();
        builder.pos(1.0F, -1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(0.0F + f7, 4.0F + f8).endVertex();
        builder.pos(1.0F, 1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(0.0F + f7, 0.0F + f8).endVertex();
        builder.pos(-1.0F, 1.0F, zValue).color(brightness, brightness, brightness, alpha).tex(4.0F + f7, 0.0F + f8).endVertex();

        builder.finishDrawing();

        WorldVertexBufferUploader.draw(builder);
        RenderSystem.disableBlend();
    }
}
