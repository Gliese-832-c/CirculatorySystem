package gliese832c.circulatorySystem.gui;

import gliese832c.circulatorySystem.systems.SystemType;
import gliese832c.circulatorySystem.systems.SystemTypes;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventTexture {

    @SubscribeEvent
    public static void TextureStitchEvent(TextureStitchEvent event) {
        for (SystemType systemType : SystemTypes.systemTypes) {
            event.getMap().registerSprite(systemType.resourceLocation);
        }
    }
}
