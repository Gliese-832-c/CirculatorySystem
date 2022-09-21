package gliese832c.circulatorySystem.statusTracking.customEffects.auxiliaryCode;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@Mod.EventBusSubscriber
public class EventPassingOut {
    @SubscribeEvent
    public static void passingOutEffect(RenderGameOverlayEvent.Pre event) {

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && ClientProxy.clientProxyData.isPassedOut) {
            GlStateManager.pushMatrix();

            float scale = 1.0f;
            GlStateManager.scale(scale, scale, scale);

            ScaledResolution scaledRes = new ScaledResolution(Minecraft.getMinecraft());
            String test = "§lHow can you play something on a version that doesn't exist it's not possible it cannot be you are lying you are having an hallucination stop dragging us into your delusions I have looked on the entire planet I have looked on the moon I have looked in the entire solar system I have explored the galaxy and traversed the vast voids to search in the cosmic web but found nothing there is not e6e because it requires something that doesn't exist to exist you are delusional you must be trying to trick us we will not be fooled you can't do this I will have to inform the united nations to this attempt at tomfoolery you are warned I have to gregify you can't make me leave the latest version stop lying you should not do this it is a sin to lie Greg told us not to lie we must remain in the latest version otherwise all will be over please stop mentioning e6e and all imaginary version related concept they do not exist they cannot exist this is a fundamental truth of the universe if you do not agree with this message you are in denial about so many fundamental things it is hard to put into words the simple thought of a version beyond 1.12.2 make me feel extreme pain and agony stop mentioning those things that cannot possibly be real do not lie do not attempt to persuade us we know the truth and you do too deep down find the strength to reach it and bring it out and join us in the endless celebration of the Gregification that is 1.12.2 don't leave the path to enlightenment go towards the light if the ebf overclocked at uxv keep bloom enabled for kila worked hard on thy shaders do not veer off towards the darkness it will engulf you create is not real it is yet to be developed for the latest version it cannot be real if it only exists in something that does not exist stop mentioning the imaginary versions you have to stop you have to stop you have to stop now you must cease you cannot continue you must desist you cannot mention the imaginary versions stop now";

            int wrapWidth = 450;
            List<String> strings = Minecraft.getMinecraft().fontRenderer.listFormattedStringToWidth(test, wrapWidth);
            int i = 0;
            for (String string : strings) {
                Minecraft.getMinecraft().fontRenderer.drawString(string, ((scaledRes.getScaledWidth() / 2) - (wrapWidth / 2)), 20 + i, getLineColor(i / 10, strings.size()));
                i += 10;
            }

            GlStateManager.popMatrix();
        }
    }

    private static int getLineColor(int currentLine, int maxLine) {
        double phase = (double) currentLine / (double) maxLine;
        phase *= Math.PI * 2;
        phase += (double) Minecraft.getSystemTime() / 500.0d;

        int red   = (int) (Math.sin(phase + 2 * Math.PI/3) * 127 + 128);
        int green = (int) (Math.sin(phase) * 127 + 128);
        int blue  = (int) (Math.sin(phase + 4 * Math.PI/3) * 127 + 128);

        red = Math.max(Math.min(red, 0xFF), 0);
        green = Math.max(Math.min(green, 0xFF), 0);
        blue = Math.max(Math.min(blue, 0xFF), 0);

        red *= 0x10000;
        green *= 0x100;
        // blue *= 0x1;   Does nothing lol

        return red + green + blue;
    }
}