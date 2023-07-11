package gliese832c.circulatorySystem.mainModContent.customEffects.auxiliaryCode;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static gliese832c.circulatorySystem.util.CirculatoryVariables.ResourceLocations.*;;

@Mod.EventBusSubscriber
public class EventTunnelVision {
    @SubscribeEvent
    public static void tunnelVisionEffect(RenderGameOverlayEvent.Pre event) {

        if (
                event.getType() == RenderGameOverlayEvent.ElementType.VIGNETTE &&
                ((ClientProxy.clientProxyData.isHavingTunnelVision && ClientProxy.clientProxyData.tunnelVisionLevel > 0) ||
                (ClientProxy.clientProxyData.isHavingTunnelVisionBurst && ClientProxy.clientProxyData.tunnelVisionBurstLevel > 0))
        ) {

            ScaledResolution scaledRes = new ScaledResolution(Minecraft.getMinecraft());

            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableAlpha();

            int level = ClientProxy.clientProxyData.tunnelVisionLevel + ClientProxy.clientProxyData.tunnelVisionBurstLevel;

            switch (level) {
                case 1:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(tunnelVisionLevel1);
                    break;
                case 2:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(tunnelVisionLevel2);
                    break;
                case 3:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(tunnelVisionLevel3);
                    break;
                case 4:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(tunnelVisionLevel4);
                    break;
                default:
                    if (level > 4) {
                        Minecraft.getMinecraft().getTextureManager().bindTexture(tunnelVisionLevel5);
                    } else {
                        Minecraft.getMinecraft().getTextureManager().bindTexture(tunnelVisionLevelNaN);
                    }
                    break;
            }

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
    }
}