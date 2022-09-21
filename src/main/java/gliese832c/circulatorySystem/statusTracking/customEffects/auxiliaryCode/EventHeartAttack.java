package gliese832c.circulatorySystem.statusTracking.customEffects.auxiliaryCode;

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

import static gliese832c.circulatorySystem.util.CirculatoryVariables.*;

@Mod.EventBusSubscriber
public class EventHeartAttack {
    @SubscribeEvent
    public static void heartAttackEffect(RenderGameOverlayEvent.Pre event) {

        if (event.getType() == RenderGameOverlayEvent.ElementType.VIGNETTE && ClientProxy.clientProxyData.heartAttack && ClientProxy.clientProxyData.heartAttackLevel > 0) {
            ScaledResolution scaledRes = new ScaledResolution(Minecraft.getMinecraft());

            GlStateManager.disableDepth();
            GlStateManager.depthMask(false);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableAlpha();

            switch (ClientProxy.clientProxyData.heartAttackLevel) {
                case 1:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(heartAttackLevel1);
                    break;
                case 2:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(heartAttackLevel2);
                    break;
                case 3:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(heartAttackLevel3);
                    break;
                case 4:
                    Minecraft.getMinecraft().getTextureManager().bindTexture(heartAttackLevel4);
                    break;
                default:
                    if (ClientProxy.clientProxyData.heartAttackLevel > 4) {
                        Minecraft.getMinecraft().getTextureManager().bindTexture(heartAttackLevel5);
                    } else {
                        Minecraft.getMinecraft().getTextureManager().bindTexture(heartAttackLevelNaN);
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