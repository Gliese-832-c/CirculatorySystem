package gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.Arrays;

public class StatusTrackers {

    private static final double   STAGE_ONE = 1.0d / 6.0d,   STAGE_TWO = 2.0d / 6.0d,   STAGE_THREE = 3.0d / 6.0d,   STAGE_FOUR = 4.0d / 6.0d,   STAGE_FIVE = 5.0d / 6.0d,   STAGE_MAX = Double.MAX_VALUE;



    public static ArrayList<StatusTracker> statusTrackers = new ArrayList<StatusTracker>();

    public static void initSystemTypes() {
        statusTrackers.add(new StatusTracker("sugar", "chat.circulatorysystem.sugar", false, null,
                new ResourceLocation("minecraft", "items/sugar"),
                new ArrayList<>(Arrays.asList(
                        new EffectInfo("CUSTOM:increased_hunger", 1000000, 0.1666667, 0.3333333),
                        new EffectInfo("CUSTOM:increased_hunger", 2, 0.3333333, 0.5),
                        new EffectInfo("CUSTOM:increased_hunger", 3, 0.5, 0.6666667),
                        new EffectInfo("CUSTOM:increased_hunger", 4, 0.6666667, 0.8333333),
                        new EffectInfo("CUSTOM:increased_hunger", 5, 0.8333333, Double.MAX_VALUE)
        ))));



        statusTrackers.add(new StatusTracker("obesity", "chat.circulatorysystem.obesity", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/obesity"),
                new ArrayList<>(Arrays.asList(
                        new EffectInfo("CUSTOM:tunnel_vision", 0, STAGE_ONE, STAGE_TWO),
                        new EffectInfo("CUSTOM:tunnel_vision", 1, STAGE_TWO, STAGE_THREE),
                        new EffectInfo("CUSTOM:tunnel_vision", 2, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("CUSTOM:tunnel_vision", 3, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:tunnel_vision", 4, STAGE_FIVE, STAGE_MAX)
        ))));



        statusTrackers.add(new StatusTracker("liver", "chat.circulatorysystem.liver", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/liver"),
                new ArrayList<>(Arrays.asList(
        ))));



        statusTrackers.add(new StatusTracker("heart", "chat.circulatorysystem.heart", true, "customDeathMessage.circulatorysystem.heart",
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/heart"),
                new ArrayList<>(Arrays.asList(
                        // Stage 1
                        new EffectInfo("minecraft:weakness", 0, STAGE_ONE, STAGE_TWO),
                        new EffectInfo("CUSTOM:increased_hunger", 0, STAGE_ONE, STAGE_TWO),

                        // Stage 2
                        new EffectInfo("minecraft:weakness", 0, STAGE_TWO, STAGE_THREE),
                        new EffectInfo("CUSTOM:increased_hunger", 0, STAGE_TWO, STAGE_THREE),
                        new EffectInfo("minecraft:slowness", 0, STAGE_TWO, STAGE_THREE),
                        new EffectInfo("minecraft:jump_boost", -1, STAGE_TWO, STAGE_THREE),

                        // Stage 3
                        new EffectInfo("minecraft:weakness", 1, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("CUSTOM:increased_hunger", 1, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("minecraft:slowness", 1, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("minecraft:jump_boost", -1, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("CUSTOM:nausea_bursts", 0, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("CUSTOM:tunnel_vision_bursts", 0, STAGE_THREE, STAGE_FOUR),

                        // Stage 4
                        new EffectInfo("minecraft:weakness", 3, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:increased_hunger", 1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("minecraft:slowness", 0, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("minecraft:jump_boost", -1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:nausea_bursts", 1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:tunnel_vision_bursts", 1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:heart_attack", 1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:critical_condition", 0, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:passing_out_bursts", 0, STAGE_FOUR, STAGE_FIVE),

                        // Stage 5
                        new EffectInfo("minecraft:weakness", 4, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:increased_hunger", 1, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("minecraft:slowness", 0, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("minecraft:jump_boost", -1, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:nausea_bursts", 2, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:tunnel_vision_bursts", 2, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:heart_attack", 3, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:critical_condition", 1, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:passing_out_bursts", 1, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:tunnel_vision", 0, STAGE_FIVE, STAGE_MAX)
        ))));



        statusTrackers.add(new StatusTracker("muscles", "chat.circulatorysystem.muscles", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/muscles"),
                new ArrayList<>(Arrays.asList(
                        new EffectInfo("minecraft:weakness", 0, STAGE_ONE, STAGE_TWO),
                        new EffectInfo("minecraft:slowness", 0, STAGE_ONE, STAGE_TWO),
                        new EffectInfo("minecraft:mining_fatigue", 0, STAGE_ONE, STAGE_TWO),

                        new EffectInfo("minecraft:weakness", 0, STAGE_TWO, STAGE_THREE),
                        new EffectInfo("minecraft:slowness", 1, STAGE_TWO, STAGE_THREE),
                        new EffectInfo("minecraft:mining_fatigue", 0, STAGE_TWO, STAGE_THREE),

                        new EffectInfo("minecraft:weakness", 1, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("minecraft:slowness", 2, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("minecraft:mining_fatigue", 1, STAGE_THREE, STAGE_FOUR),
                        new EffectInfo("minecraft:jump_boost", -1, STAGE_THREE, STAGE_FOUR),

                        new EffectInfo("minecraft:weakness", 2, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("minecraft:slowness", 3, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("minecraft:mining_fatigue", 1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("minecraft:jump_boost", -1, STAGE_FOUR, STAGE_FIVE),
                        new EffectInfo("CUSTOM:passing_out_bursts", 0, STAGE_FOUR, STAGE_FIVE),

                        new EffectInfo("minecraft:weakness", 3, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("minecraft:slowness", 4, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("minecraft:mining_fatigue", 2, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("minecraft:jump_boost", -2, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:passing_out_bursts", 1, STAGE_FIVE, STAGE_MAX),
                        new EffectInfo("CUSTOM:critical_condition", 0, STAGE_FIVE, STAGE_MAX)
        ))));



        statusTrackers.add(new StatusTracker("gastrointestinal", "chat.circulatorysystem.gastrointestinal", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/gastrointestinal"),
                new ArrayList<>(Arrays.asList(

        ))));



        statusTrackers.add(new StatusTracker("lungs", "chat.circulatorysystem.lungs", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/lungs"),
                new ArrayList<>(Arrays.asList(

        ))));



        statusTrackers.add(new StatusTracker("brain", "chat.circulatorysystem.brain", true, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/brain"),
                new ArrayList<>(Arrays.asList(

        ))));



        statusTrackers.add(new StatusTracker("eyes", "chat.circulatorysystem.eyes", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/eyes"),
                new ArrayList<>(Arrays.asList(

        ))));



        statusTrackers.add(new StatusTracker("immune_system", "chat.circulatorysystem.immune_system", false, null,
                new ResourceLocation(CirculatorySystem.MOD_ID, "organs/immune_system"),
                new ArrayList<>(Arrays.asList(

        ))));
    }



    public static StatusTracker getSystemTypeFromKey(String key) {

        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            if (statusTracker.key.equals(key)) {
                return statusTracker;
            }
        }

        CirculatoryLogger.getLogger().error("System type '" + key + "' does not exist!");
        return null;
    }
}
