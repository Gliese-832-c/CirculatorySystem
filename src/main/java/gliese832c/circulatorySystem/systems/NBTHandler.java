package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.util.CirculatorySystemLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import static gliese832c.circulatorySystem.util.StringProcessing.*;

public class NBTHandler {

    static String tagName = CirculatorySystem.MOD_ID;

    public static void setNBTdata(EntityPlayer player, String systemKey, double value) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagName);
        if (data != null) {
            if (checkWhetherSystemTypeIsValid(systemKey)) {
                data.setDouble(systemKey, value);
            } else {
                CirculatorySystemLogger.getLogger().error("System type '" + systemKey + "' does not exist!");
            }
        } else {
            data = new NBTTagCompound();
            for (SystemType systemType : SystemTypes.systemTypes) { data.setDouble(systemType.key, 0.0d); }
            if (checkWhetherSystemTypeIsValid(systemKey)) {
                data.setDouble(systemKey, value);
            } else {
                CirculatorySystemLogger.getLogger().error("System type '" + systemKey + "' does not exist!");
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
                CirculatorySystemLogger.getLogger().error("System type '" + doubleKey + "' does not exist!");
                return Double.NaN;
            }
        } else {
            data = new NBTTagCompound();
            for (SystemType systemType : SystemTypes.systemTypes) { data.setDouble(systemType.key, 0.0d); }
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
            for (SystemType systemType : SystemTypes.systemTypes) { data.setDouble(systemType.key, 0.0d); }
            player.getEntityData().setTag(tagName, data);
            return data;
        }
    }

    public static void setNBTall(EntityPlayer player, NBTTagCompound data) {
        player.getEntityData().setTag(tagName, data);
    }



    public static void resetAllSystemTypes(EntityPlayer player) {
        NBTTagCompound data = (NBTTagCompound) player.getEntityData().getTag(tagName);
        for (SystemType systemType : SystemTypes.systemTypes) { data.setDouble(systemType.key, 0.0d); }
    }
}
