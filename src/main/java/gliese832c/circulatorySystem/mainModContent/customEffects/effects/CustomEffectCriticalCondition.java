package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.statusTrackers.CirculatoryDamageTypes;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import net.minecraft.entity.player.EntityPlayer;

public class CustomEffectCriticalCondition extends CirculatoryCustomEffect {
    public CustomEffectCriticalCondition(String name) {
        super(name);
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {

        long worldTime = player.world.getTotalWorldTime();
        long divisor = (long) (400.0d / ((double) level + 1.0d));

        if (worldTime % divisor == 0) {
            player.attackEntityFrom(CirculatoryDamageTypes.CRITICAL_CONDITION, ((float) level * 0.5f) + 1.5f);
        }
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {
        // Nothing
    }
}
