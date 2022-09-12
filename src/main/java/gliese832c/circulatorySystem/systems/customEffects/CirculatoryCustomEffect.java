package gliese832c.circulatorySystem.systems.customEffects;

import net.minecraft.entity.player.EntityPlayer;

public abstract class CirculatoryCustomEffect {

    String name;

    public CirculatoryCustomEffect(String name) {
        this.name = name;
    }

    public abstract void applyEffect(EntityPlayer player, int level);
}
