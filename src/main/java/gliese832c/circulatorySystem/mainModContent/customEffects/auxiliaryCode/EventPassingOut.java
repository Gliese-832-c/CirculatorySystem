package gliese832c.circulatorySystem.mainModContent.customEffects.auxiliaryCode;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

import static gliese832c.circulatorySystem.util.CirculatoryVariables.ResourceLocations.*;

@Mod.EventBusSubscriber
public class EventPassingOut {
    @SubscribeEvent
    public static void passingOutEffect(RenderGameOverlayEvent.Pre event) {

        if (ClientProxy.clientProxyData.isPassedOut) {

            if (event.getType() == RenderGameOverlayEvent.ElementType.VIGNETTE) {
                ScaledResolution scaledRes = new ScaledResolution(Minecraft.getMinecraft());

                GlStateManager.disableDepth();
                GlStateManager.depthMask(false);
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                GlStateManager.disableAlpha();

                Minecraft.getMinecraft().getTextureManager().bindTexture(passedOut);

                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder bufferbuilder = tessellator.getBuffer();
                bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
                bufferbuilder.pos(0.0, (double) scaledRes.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
                bufferbuilder.pos((double) scaledRes.getScaledWidth(), (double) scaledRes.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
                bufferbuilder.pos((double) scaledRes.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
                bufferbuilder.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
                tessellator.draw();
                GlStateManager.depthMask(true);
                GlStateManager.enableDepth();
                GlStateManager.enableAlpha();
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            }

            if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                GlStateManager.pushMatrix();

                float scale = 2.5f;
                GlStateManager.scale(scale, scale, scale);

                ScaledResolution scaledRes = new ScaledResolution(Minecraft.getMinecraft());
                double scaledScaledWidth = scaledRes.getScaledWidth() / scale;
                double scaledScaledHeight = scaledRes.getScaledHeight() / scale;

                String passedOutString = I18n.translateToLocal("gui.circulatorysystem.passed_out");
                double scaledStringWidth = Minecraft.getMinecraft().fontRenderer.getStringWidth(passedOutString); // * scale;
                double scaledStringHeight = Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT; // * scale;

                int xPos = (int) ((scaledScaledWidth / 2) - (scaledStringWidth / 2));
                int yPos = (int) ((scaledScaledHeight / 2) - (scaledStringHeight / 2));

                Minecraft.getMinecraft().fontRenderer.drawString(passedOutString, xPos, yPos, 0xFFFFFF);

                GlStateManager.popMatrix();
            }
        }
    }
}