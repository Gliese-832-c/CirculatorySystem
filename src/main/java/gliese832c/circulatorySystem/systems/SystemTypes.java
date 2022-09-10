package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.util.CirculatorySystemLogger;

import java.util.ArrayList;

public class SystemTypes {

    public static ArrayList<SystemType> systemTypes = new ArrayList<SystemType>();

    public static void initEffectTypes() {
        systemTypes.add(new SystemType("sugar", "chat.circulatorysystem.sugar", 0xFF0000));
        systemTypes.add(new SystemType("obesity", "chat.circulatorysystem.obesity", 0x00FF00));
        systemTypes.add(new SystemType("gastrointestinal", "chat.circulatorysystem.gastrointestinal", 0x0000FF));
        systemTypes.add(new SystemType("immune_system", "chat.circulatorysystem.immune_system", 0xFFFFFF));

        systemTypes.add(new SystemType("liver", "chat.circulatorysystem.liver", 0xFFFFFF));
        systemTypes.add(new SystemType("lungs", "chat.circulatorysystem.lungs", 0xFFFFFF));
        systemTypes.add(new SystemType("heart", "chat.circulatorysystem.heart", 0xFFFFFF));

        systemTypes.add(new SystemType("muscles", "chat.circulatorysystem.muscles", 0xFFFFFF));
        systemTypes.add(new SystemType("eyes", "chat.circulatorysystem.eyes", 0xFFFFFF));
        systemTypes.add(new SystemType("brain", "chat.circulatorysystem.brain", 0xFFFFFF));
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
