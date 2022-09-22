package gliese832c.circulatorySystem.util;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffectDataType;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffects;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import static gliese832c.circulatorySystem.util.StringProcessing.*;

public class NBTHandler {

    public static String tagName = CirculatorySystem.MOD_ID;
    public static String tagNameCustomEffects = CirculatorySystem.MOD_ID + "_customeffects";

    public static void setNBTdata(EntityPlayer player, String systemKey, double value) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagName);
        if (data != null) {
            if (checkWhetherSystemTypeIsValid(systemKey)) {
                data.setDouble(systemKey, value);
            } else {
                CirculatoryLogger.getLogger().error("System type '" + systemKey + "' does not exist!");
            }
        } else {
            data = new NBTTagCompound();
            for (StatusTracker statusTracker : StatusTrackers.statusTrackers) { data.setDouble(statusTracker.key, 0.0d); }
            if (checkWhetherSystemTypeIsValid(systemKey)) {
                data.setDouble(systemKey, value);
            } else {
                CirculatoryLogger.getLogger().error("System type '" + systemKey + "' does not exist!");
            }
            player.getEntityData().setTag(tagName, data);
        }
    }

    public static double getNBTdata(EntityPlayer player, String doubleKey) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagName);
        if (data != null) {
            if (checkWhetherSystemTypeIsValid(doubleKey)) {
                return data.getDouble(doubleKey);
            } else {
                CirculatoryLogger.getLogger().error("System type '" + doubleKey + "' does not exist!");
                return Double.NaN;
            }
        } else {
            data = new NBTTagCompound();
            for (StatusTracker statusTracker : StatusTrackers.statusTrackers) { data.setDouble(statusTracker.key, 0.0d); }
            player.getEntityData().setTag(tagName, data);
            return 0.0d;
        }
    }



    public static NBTTagCompound getNBTall(EntityPlayer player) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagName);
        if (data != null) {
            return data;
        } else {
            data = new NBTTagCompound();
            for (StatusTracker statusTracker : StatusTrackers.statusTrackers) { data.setDouble(statusTracker.key, 0.0d); }
            player.getEntityData().setTag(tagName, data);
            return data;
        }
    }

    public static void setNBTall(EntityPlayer player, NBTTagCompound data) {
        player.getEntityData().setTag(tagName, data);
    }



    public static void resetAllSystemTypes(EntityPlayer player) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagName);
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) { data.setDouble(statusTracker.key, 0.0d); }
    }








    public static NBTTagCompound getCustomEffectStorage(EntityPlayer player) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagNameCustomEffects);
        if (data != null) {
            return data;
        } else {
            data = new NBTTagCompound();
            for (CirculatoryCustomEffect customEffect : CirculatoryCustomEffects.customEffectList) {
                NBTTagCompound subData = new NBTTagCompound();
                for (CirculatoryCustomEffectDataType dataType : customEffect.dataTypes) {
                    subData = setAppropriateValue(subData, dataType);
                    //subData.setTag(dataType.name, setAppropriateValue(dataType));
                }
                data.setTag(customEffect.name, subData);
            }
            player.getEntityData().setTag(tagNameCustomEffects, data);
            return data;
        }
    }

    private static NBTTagCompound setAppropriateValue(NBTTagCompound nbtTagCompound, CirculatoryCustomEffectDataType dataType) {
        if (dataType.type == CirculatoryCustomEffectDataType.DataTypes.BOOLEAN) {
            nbtTagCompound.setBoolean(dataType.name, false);
        } else if (dataType.type == CirculatoryCustomEffectDataType.DataTypes.INT) {
            nbtTagCompound.setInteger(dataType.name, 0);
        } else if (dataType.type == CirculatoryCustomEffectDataType.DataTypes.FLOAT) {
            nbtTagCompound.setFloat(dataType.name, 0.0f);
        } else if (dataType.type == CirculatoryCustomEffectDataType.DataTypes.DOUBLE) {
            nbtTagCompound.setDouble(dataType.name, 0.0d);
        } else if (dataType.type == CirculatoryCustomEffectDataType.DataTypes.STRING) {
            nbtTagCompound.setString(dataType.name, "");
        }
        return nbtTagCompound;
    }

    public static void setCustomEffectStorage(EntityPlayer player, NBTTagCompound data, String customEffectName) {
        NBTTagCompound generalData = (NBTTagCompound) player.getEntityData().getTag(tagNameCustomEffects);
        generalData.setTag(customEffectName, data);
        player.getEntityData().setTag(tagNameCustomEffects, generalData);
    }
}
