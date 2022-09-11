package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.util.CirculatorySystemLogger;
import net.minecraft.util.ResourceLocation;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

public class SystemTypes {

    public static ArrayList<SystemType> systemTypes = new ArrayList<SystemType>();

    public static void initEffectTypes() {
        systemTypes.add(new SystemType("sugar", "chat.circulatorysystem.sugar", false,
                new ResourceLocation("minecraft", "items/sugar"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("obesity", "chat.circulatorysystem.obesity", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/obesity"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("gastrointestinal", "chat.circulatorysystem.gastrointestinal", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/gastrointestinal"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("immune_system", "chat.circulatorysystem.immune_system", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/immune_system"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));



        systemTypes.add(new SystemType("liver", "chat.circulatorysystem.liver", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/liver"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("lungs", "chat.circulatorysystem.lungs", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/lungs"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                        new PotionEffectInfo("minecraft:weakness", 1, 0.16667, 0.33333),
                }))
        ));

        systemTypes.add(new SystemType("heart", "chat.circulatorysystem.heart", true,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/heart"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                        new PotionEffectInfo("minecraft:weakness", 0, 0.16667, 0.33333),
                }))
        ));



        systemTypes.add(new SystemType("muscles", "chat.circulatorysystem.muscles", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/muscles"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                        new PotionEffectInfo("minecraft:weakness", 0, 0.16667, 0.33333),
                        new PotionEffectInfo("minecraft:weakness", 1, 0.33333, 0.5),
                        new PotionEffectInfo("minecraft:weakness", 2, 0.5, 0.66667),
                        new PotionEffectInfo("minecraft:weakness", 3, 0.66667, 0.83333),
                        new PotionEffectInfo("minecraft:weakness", 4, 0.83333, Double.MAX_VALUE),

                        new PotionEffectInfo("minecraft:slowness", 0, 0.16667, 0.33333),
                        new PotionEffectInfo("minecraft:slowness", 1, 0.33333, 0.5),
                        new PotionEffectInfo("minecraft:slowness", 2, 0.5, 0.66667),
                        new PotionEffectInfo("minecraft:slowness", 3, 0.66667, 0.83333),
                        new PotionEffectInfo("minecraft:slowness", 4, 0.83333, Double.MAX_VALUE),

                        new PotionEffectInfo("minecraft:mining_fatigue", 0, 0.16667, 0.33333),
                        new PotionEffectInfo("minecraft:mining_fatigue", 1, 0.33333, 0.5),
                        new PotionEffectInfo("minecraft:mining_fatigue", 2, 0.5, 0.66667),
                        new PotionEffectInfo("minecraft:mining_fatigue", 3, 0.66667, 0.83333),
                        new PotionEffectInfo("minecraft:mining_fatigue", 4, 0.83333, Double.MAX_VALUE),

                        new PotionEffectInfo("minecraft:jump_boost", -1, 0.16667, 0.33333),
                        new PotionEffectInfo("minecraft:jump_boost", -2, 0.33333, 0.5),
                        new PotionEffectInfo("minecraft:jump_boost", -3, 0.5, 0.66667),
                        new PotionEffectInfo("minecraft:jump_boost", -4, 0.66667, 0.83333),
                        new PotionEffectInfo("minecraft:jump_boost", -5, 0.83333, Double.MAX_VALUE)
                }))
        ));

        systemTypes.add(new SystemType("eyes", "chat.circulatorysystem.eyes", false,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/eyes"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));

        systemTypes.add(new SystemType("brain", "chat.circulatorysystem.brain", true,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/brain"),
                new ArrayList<>(Arrays.asList(new PotionEffectInfo[] {
                }))
        ));
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
