package gliese832c.circulatorySystem.statusTracking.customEffects;

import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public abstract class CirculatoryCustomEffect {

    public String name;

    public ArrayList<CirculatoryCustomEffectDataType> dataTypes = new ArrayList<CirculatoryCustomEffectDataType>();

    public CirculatoryCustomEffect(String name) {
        this.name = name;
    }

    // For any add-on makers who might be reading this. This method runs every tick! If you want something to happen less than once a tick, I recommend either randomizing it or using if(worldTime % x == 0) where worldTime is the total world time in ticks and x making it happen once every x ticks.
    public abstract void applyEffect(EntityPlayer player, int level);

    // This runs always; used to do things like disabling certain variables when the effect is not being applied
    public abstract void notApplyingEffect(EntityPlayer player);



    public NBTTagCompound getCustomEffectData(EntityPlayer player) {
        return NBTHandler.getCustomEffectStorage(player).getCompoundTag(name);
    }

    public void setCustomEffectData(EntityPlayer player, NBTTagCompound data) {
        NBTHandler.setCustomEffectStorage(player, data, name);
    }
}
