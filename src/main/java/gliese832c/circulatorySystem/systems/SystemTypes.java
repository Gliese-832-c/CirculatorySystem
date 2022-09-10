package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.util.CirculatorySystemLogger;

import java.util.ArrayList;

public class SystemTypes {

    public static ArrayList<SystemType> systemTypes = new ArrayList<SystemType>();

    public static void initEffectTypes() {
        systemTypes.add(new SystemType("sugar", "chat.circulatory_system.sugar"));
        systemTypes.add(new SystemType("obesity", "chat.circulatory_system.obesity"));
        systemTypes.add(new SystemType("gastrointestinal", "chat.circulatory_system.gastrointestinal"));
        systemTypes.add(new SystemType("immune_system", "chat.circulatory_system.immune_system"));

        systemTypes.add(new SystemType("liver", "chat.circulatory_system.liver"));
        systemTypes.add(new SystemType("lungs", "chat.circulatory_system.lungs"));
        systemTypes.add(new SystemType("heart", "chat.circulatory_system.heart"));

        systemTypes.add(new SystemType("muscles", "chat.circulatory_system.muscles"));
        systemTypes.add(new SystemType("eyes", "chat.circulatory_system.eyes"));
        systemTypes.add(new SystemType("brain", "chat.circulatory_system.brain"));
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
