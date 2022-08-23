package io.github.faecraft.flamingo.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import io.github.faecraft.flamingo.FlamingoKt;
import io.github.faecraft.flamingo.register.Effects;

@Mixin(WorldRenderer.class)
public class WorldRenderMixin {
    private static final Identifier TEXTURE_SHRIMP_EFFECT = new Identifier(FlamingoKt.MOD_ID, "textures/misc/shrimp_effect.png");

    @Inject(at = @At("TAIL"), method = "render")
    public void render(CallbackInfo info) {
        MinecraftClient minecraft = MinecraftClient.getInstance();

        ClientPlayerEntity player = minecraft.player;
        if (player == null) return;

        StatusEffectInstance effect = player.getStatusEffect(Effects.INSTANCE.getSHRIMP_EFFECT());
        if (effect == null) return;

        minecraft.getTextureManager().bindTexture(TEXTURE_SHRIMP_EFFECT);

        BufferBuilder builder = Tessellator.getInstance().getBuffer();

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();

        float f7 = -player.yaw / 64.0F;
        float f8 = player.pitch / 64.0F;

        final float alpha = 0.1F + (0.3F * (effect.getAmplifier() + 1));
        final float brightness = 1.0F;
        final float zValue = -0.1F;

        builder.begin(7, VertexFormats.POSITION_COLOR_TEXTURE);

        builder.vertex(-1.0F, -1.0F, zValue).color(brightness, brightness, brightness, alpha).texture(4.0F + f7, 4.0F + f8).next();
        builder.vertex(1.0F, -1.0F, zValue).color(brightness, brightness, brightness, alpha).texture(0.0F + f7, 4.0F + f8).next();
        builder.vertex(1.0F, 1.0F, zValue).color(brightness, brightness, brightness, alpha).texture(0.0F + f7, 0.0F + f8).next();
        builder.vertex(-1.0F, 1.0F, zValue).color(brightness, brightness, brightness, alpha).texture(4.0F + f7, 0.0F + f8).next();

        builder.end();

        BufferRenderer.draw(builder);

        RenderSystem.disableBlend();
    }
}
