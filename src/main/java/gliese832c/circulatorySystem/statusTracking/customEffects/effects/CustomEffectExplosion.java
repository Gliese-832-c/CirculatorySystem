package gliese832c.circulatorySystem.statusTracking.customEffects.effects;

import gliese832c.circulatorySystem.statusTracking.CirculatoryDamageTypes;
import gliese832c.circulatorySystem.statusTracking.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.statusTracking.customEffects.CirculatoryCustomEffectDataType;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.Map;

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
