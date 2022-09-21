package gliese832c.circulatorySystem.sound;

import gliese832c.circulatorySystem.CirculatorySystem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CirculatorySounds {

    public static SoundEvent HEART_ATTACK;
    public static SoundEvent AMOGUS;

    public static void registerSounds() {
        HEART_ATTACK = registerSound("event_heart_attack");
        AMOGUS = registerSound("amogus");
    }

    private static SoundEvent registerSound(String soundNameIn) {
        ResourceLocation location = new ResourceLocation(CirculatorySystem.MOD_ID, soundNameIn);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}