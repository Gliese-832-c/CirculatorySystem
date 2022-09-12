package gliese832c.circulatorySystem.systems.customEffects;

import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraft.entity.player.EntityPlayer;

public class CustomEffectSlowness extends CirculatoryCustomEffect {
    public CustomEffectSlowness(String name) {
        super(name);
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        CirculatoryLogger.info("Got into the code!");
        player.motionX *= Math.max(1.0d - (level * 0.2d), 0.0d);
        player.motionZ *= Math.max(1.0d - (level * 0.2d), 0.0d);
    }
}
