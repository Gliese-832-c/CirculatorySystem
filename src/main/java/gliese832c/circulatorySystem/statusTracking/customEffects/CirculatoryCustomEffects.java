package gliese832c.circulatorySystem.statusTracking.customEffects;

import gliese832c.circulatorySystem.statusTracking.customEffects.effects.*;
import gliese832c.circulatorySystem.util.CirculatoryLogger;

import java.util.ArrayList;
import java.util.Arrays;

public class CirculatoryCustomEffects {

    public static ArrayList<CirculatoryCustomEffect> customEffectList = new ArrayList<CirculatoryCustomEffect>();

    public static void initEffectTypes() {
        customEffectList.add(new CustomEffectCriticalCondition("critical_condition"));     // Done!

        customEffectList.add(new CustomEffectHeartAttack("heart_attack",     // Done!
                new ArrayList<CirculatoryCustomEffectDataType>(Arrays.asList(
                        new CirculatoryCustomEffectDataType("isHavingHeartAttack", CirculatoryCustomEffectDataType.DataTypes.BOOLEAN),
                        new CirculatoryCustomEffectDataType("heartAttackLevel", CirculatoryCustomEffectDataType.DataTypes.INT),
                        new CirculatoryCustomEffectDataType("remainingHeartAttackLength", CirculatoryCustomEffectDataType.DataTypes.INT)))));

        customEffectList.add(new CustomEffectIncreasedHunger("increased_hunger"));     // Done!

        customEffectList.add(new CustomEffectNauseaBursts("nausea_bursts"));     // Done!

        customEffectList.add(new CustomEffectPassingOutBursts("passing_out_bursts"));

        customEffectList.add(new CustomEffectTunnelVision("tunnel_vision",     // Done!
                new ArrayList<CirculatoryCustomEffectDataType>(Arrays.asList(
                        new CirculatoryCustomEffectDataType("isHavingTunnelVision", CirculatoryCustomEffectDataType.DataTypes.BOOLEAN),
                        new CirculatoryCustomEffectDataType("tunnelVisionLevel", CirculatoryCustomEffectDataType.DataTypes.INT)))));

        customEffectList.add(new CustomEffectTunnelVisionBursts("tunnel_vision_bursts",     // Done!
                new ArrayList<CirculatoryCustomEffectDataType>(Arrays.asList(
                        new CirculatoryCustomEffectDataType("isHavingTunnelVisionBurst", CirculatoryCustomEffectDataType.DataTypes.BOOLEAN),
                        new CirculatoryCustomEffectDataType("tunnelVisionBurstLevel", CirculatoryCustomEffectDataType.DataTypes.INT),
                        new CirculatoryCustomEffectDataType("remainingTunnelVisionBurstTime", CirculatoryCustomEffectDataType.DataTypes.INT)))));



        // These effects were added as a joke, but they are 100% functional, so feel free to use them!

        customEffectList.add(new CustomEffectExplosion("explosion",     // Done!
                new ArrayList<CirculatoryCustomEffectDataType>(Arrays.asList(
                        new CirculatoryCustomEffectDataType("hasExploded", CirculatoryCustomEffectDataType.DataTypes.BOOLEAN)))));
    }

    public static CirculatoryCustomEffect getCustomEffectFromName(String name) {

        for (CirculatoryCustomEffect circulatoryCustomEffect : customEffectList) {
            if (circulatoryCustomEffect.name.equals(name)) {
                return circulatoryCustomEffect;
            }
        }

        CirculatoryLogger.getLogger().error("Custom Effect '" + name + "' does not exist!");
        return null;
    }
}