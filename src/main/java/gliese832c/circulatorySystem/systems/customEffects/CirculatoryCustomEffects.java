package gliese832c.circulatorySystem.systems.customEffects;

import gliese832c.circulatorySystem.util.CirculatoryLogger;

import java.util.ArrayList;

public class CirculatoryCustomEffects {

    public static ArrayList<CirculatoryCustomEffect> customEffectList = new ArrayList<CirculatoryCustomEffect>();

    public static void initEffectTypes() {
        customEffectList.add(new CustomEffectSlowness("slowness"));
        customEffectList.add(new CustomEffectMiningFatigue("mining_fatigue"));
        customEffectList.add(new CustomEffectHunger("hunger"));
        customEffectList.add(new CustomEffectBlindness("blindness"));
        customEffectList.add(new CustomEffectWither("wither"));
        customEffectList.add(new CustomEffectResistance("resistance"));
        customEffectList.add(new CustomEffectJumpinhibition("jump_inhibition"));
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
