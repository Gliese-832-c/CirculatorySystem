package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraft.util.ResourceLocation;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

public class SystemTypes {

    public static ArrayList<SystemType> systemTypes = new ArrayList<SystemType>();

    public static void initSystemTypes() {
        systemTypes.add(new SystemType("sugar", "chat.circulatorysystem.sugar", false, null,
                new ResourceLocation("minecraft", "items/sugar"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                        new EffectInfo("CUSTOM:slowness", 1, 0.1666667, 0.3333333),
                        new EffectInfo("CUSTOM:slowness", 2, 0.3333333, 0.5),
                        new EffectInfo("CUSTOM:slowness", 3, 0.5, 0.6666667),
                        new EffectInfo("CUSTOM:slowness", 4, 0.6666667, 0.8333333),
                        new EffectInfo("CUSTOM:slowness", 5, 0.8333333, Double.MAX_VALUE)
                }))
        ));

        systemTypes.add(new SystemType("obesity", "chat.circulatorysystem.obesity", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/obesity"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("gastrointestinal", "chat.circulatorysystem.gastrointestinal", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/gastrointestinal"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("immune_system", "chat.circulatorysystem.immune_system", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/immune_system"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));



        systemTypes.add(new SystemType("liver", "chat.circulatorysystem.liver", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/liver"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("lungs", "chat.circulatorysystem.lungs", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/lungs"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("heart", "chat.circulatorysystem.heart", true, "customDeathMessage.circulatorysystem.heart",
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/heart"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));



        systemTypes.add(new SystemType("muscles", "chat.circulatorysystem.muscles", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/muscles"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                        new EffectInfo("minecraft:weakness", 0, 0.16667, 0.33333),
                        new EffectInfo("minecraft:weakness", 1, 0.33333, 0.5),
                        new EffectInfo("minecraft:weakness", 2, 0.5, 0.66667),
                        new EffectInfo("minecraft:weakness", 3, 0.66667, 0.83333),
                        new EffectInfo("minecraft:weakness", 4, 0.83333, Double.MAX_VALUE),

                        new EffectInfo("minecraft:slowness", 0, 0.16667, 0.33333),
                        new EffectInfo("minecraft:slowness", 1, 0.33333, 0.5),
                        new EffectInfo("minecraft:slowness", 2, 0.5, 0.66667),
                        new EffectInfo("minecraft:slowness", 3, 0.66667, 0.83333),
                        new EffectInfo("minecraft:slowness", 4, 0.83333, Double.MAX_VALUE),

                        new EffectInfo("minecraft:mining_fatigue", 0, 0.16667, 0.33333),
                        new EffectInfo("minecraft:mining_fatigue", 1, 0.33333, 0.5),
                        new EffectInfo("minecraft:mining_fatigue", 2, 0.5, 0.66667),
                        new EffectInfo("minecraft:mining_fatigue", 3, 0.66667, 0.83333),
                        new EffectInfo("minecraft:mining_fatigue", 4, 0.83333, Double.MAX_VALUE),

                        new EffectInfo("minecraft:jump_boost", -1, 0.16667, 0.33333),
                        new EffectInfo("minecraft:jump_boost", -2, 0.33333, 0.5),
                        new EffectInfo("minecraft:jump_boost", -3, 0.5, 0.66667),
                        new EffectInfo("minecraft:jump_boost", -4, 0.66667, 0.83333),
                        new EffectInfo("minecraft:jump_boost", -5, 0.83333, Double.MAX_VALUE)
                }))
        ));

        systemTypes.add(new SystemType("eyes", "chat.circulatorysystem.eyes", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/eyes"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("brain", "chat.circulatorysystem.brain", true, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/brain"),
                new ArrayList<>(Arrays.asList(new EffectInfo[] {
                }))
        ));
    }

    public static SystemType getSystemTypeFromKey(String key) {

        for (SystemType systemType : SystemTypes.systemTypes) {
            if (systemType.key.equals(key)) {
                return systemType;
            }
        }

        CirculatoryLogger.getLogger().error("System type '" + key + "' does not exist!");
        return null;
    }
}
