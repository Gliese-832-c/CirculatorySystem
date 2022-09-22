package gliese832c.circulatorySystem.gui;

import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventTexture {

    @SubscribeEvent
    public static void TextureStitchEvent(TextureStitchEvent event) {
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            event.getMap().registerSprite(statusTracker.resourceLocation);
        }
    }
}
