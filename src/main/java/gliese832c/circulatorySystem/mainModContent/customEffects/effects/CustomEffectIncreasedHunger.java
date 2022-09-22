package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import net.minecraft.entity.player.EntityPlayer;

import static java.lang.Math.sqrt;

public class CustomEffectIncreasedHunger extends CirculatoryCustomEffect {
    public CustomEffectIncreasedHunger(String name) {
        super(name);
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        player.addExhaustion(0.001f * (float) sqrt(level));
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {

    }
}
