package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.statusTrackers.CirculatoryDamageTypes;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffectDataType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class CustomEffectExplosion extends CirculatoryCustomEffect {
    public CustomEffectExplosion(String name, ArrayList<CirculatoryCustomEffectDataType> dataTypes) {
        super(name);
        this.dataTypes = dataTypes;
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        if (!getHasExploded(player)) {
            player.getEntityWorld().newExplosion(player, player.posX, player.posY, player.posZ, level, true, true);
            player.attackEntityFrom(CirculatoryDamageTypes.EXPLOSION, Float.MAX_VALUE);
            setHasExploded(player, true);
        }
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {
        setHasExploded(player, false);
    }



    private boolean getHasExploded(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getBoolean("hasExploded");
    }

    private void setHasExploded(EntityPlayer player, boolean hasExploded) {
        NBTTagCompound data = this.getCustomEffectData(player);
        data.setBoolean("hasExploded", hasExploded);
        this.setCustomEffectData(player, data);
    }
}
