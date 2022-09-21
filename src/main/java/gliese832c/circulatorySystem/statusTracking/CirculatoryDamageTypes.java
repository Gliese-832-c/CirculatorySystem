package gliese832c.circulatorySystem.statusTracking;

import net.minecraft.util.DamageSource;

public class CirculatoryDamageTypes {
    public static final DamageSource EXPLOSION = new DamageSource("custom_effect_explosion").setDamageBypassesArmor().setDamageIsAbsolute();
    public static final DamageSource CRITICAL_CONDITION = new DamageSource("critical_condition").setDamageBypassesArmor().setDamageIsAbsolute();
    public static final DamageSource HEART_ATTACK = new DamageSource("heart_attack").setDamageBypassesArmor().setDamageIsAbsolute();
}
