package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.util.CirculatorySystemLogger;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class SystemTypes {

    public static ArrayList<SystemType> systemTypes = new ArrayList<SystemType>();

    public static void initEffectTypes() {
        systemTypes.add(new SystemType("sugar", "chat.circulatorysystem.sugar", new ResourceLocation("minecraft", "items/sugar")));
        systemTypes.add(new SystemType("obesity", "chat.circulatorysystem.obesity", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/obesity")));
        systemTypes.add(new SystemType("gastrointestinal", "chat.circulatorysystem.gastrointestinal", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/gastrointestinal")));
        systemTypes.add(new SystemType("immune_system", "chat.circulatorysystem.immune_system", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/immune_system")));

        systemTypes.add(new SystemType("liver", "chat.circulatorysystem.liver", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/liver")));
        systemTypes.add(new SystemType("lungs", "chat.circulatorysystem.lungs", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/lungs")));
        systemTypes.add(new SystemType("heart", "chat.circulatorysystem.heart", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/heart")));

        systemTypes.add(new SystemType("muscles", "chat.circulatorysystem.muscles", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/muscles")));
        systemTypes.add(new SystemType("eyes", "chat.circulatorysystem.eyes", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/eyes")));
        systemTypes.add(new SystemType("brain", "chat.circulatorysystem.brain", new ResourceLocation(CirculatorySystem.MOD_ID, "organs/brain")));
    }

    public static SystemType getSystemTypeFromKey(String key) {

        for (SystemType systemType : SystemTypes.systemTypes) {
            if (systemType.key.equals(key)) {
                return systemType;
            }
        }

        CirculatorySystemLogger.getLogger().error("System type '" + key + "' does not exist!");
        return null;
    }
}
