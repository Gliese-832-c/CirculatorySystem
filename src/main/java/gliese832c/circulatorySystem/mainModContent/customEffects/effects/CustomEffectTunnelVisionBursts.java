package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffectDataType;
import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

import java.util.ArrayList;

public class CustomEffectTunnelVisionBursts extends CirculatoryCustomEffect {
    public CustomEffectTunnelVisionBursts(String name, ArrayList<CirculatoryCustomEffectDataType> dataTypes) {
        super(name);
        this.dataTypes = dataTypes;
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        if (!getIsHavingTunnelVisionBurst(player)) {
            setIsHavingTunnelVisionBurstLevel(player, false, 0);

            if (!player.isDead && Math.random() > (1.0d - 0.00001d * (double) level)) {
                player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.tunnel_vision_burst")));
                setIsHavingTunnelVisionBurstLevel(player, true, level);
                setRemainingTunnelVisionBurstTime(player, 301 + (level * 100));
            }
        } else {
            setRemainingTunnelVisionBurstTime(player, getRemainingTunnelVisionBurstTime(player) - 1);
            if (getRemainingTunnelVisionBurstTime(player) < 1) {
                setRemainingTunnelVisionBurstTime(player, 0);
                setIsHavingTunnelVisionBurstLevel(player, false, 0);
                //player.sendMessage(new TextComponentString("§6" + I18n.translateToLocal("chat.circulatorysystem.tunnel_vision_burst_over")));
            }

            if (player.isDead) {
                setRemainingTunnelVisionBurstTime(player, 0);
                setIsHavingTunnelVisionBurstLevel(player, false, 0);
            }
        }
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {
        if (getIsHavingTunnelVisionBurst(player)) {
            setRemainingTunnelVisionBurstTime(player, getRemainingTunnelVisionBurstTime(player) - 1);
            if (getRemainingTunnelVisionBurstTime(player) < 1) {
                setRemainingTunnelVisionBurstTime(player, 0);
                setIsHavingTunnelVisionBurstLevel(player, false, 0);
                //player.sendMessage(new TextComponentString("§6" + I18n.translateToLocal("chat.circulatorysystem.tunnel_vision_burst_over")));
            }

            if (player.isDead) {
                setRemainingTunnelVisionBurstTime(player, 0);
                setIsHavingTunnelVisionBurstLevel(player, false, 0);
            }
        }
    }



    private boolean getIsHavingTunnelVisionBurst(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getBoolean("isHavingTunnelVisionBurst");
    }

    private int getTunnelVisionBurstLevel(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getInteger("tunnelVisionBurstLevel");
    }

    private void setIsHavingTunnelVisionBurstLevel(EntityPlayer player, boolean isHavingTunnelVisionBurst, int tunnelVisionBurstLevel) {
        NBTTagCompound data = this.getCustomEffectData(player);
        data.setBoolean("isHavingTunnelVisionBurst", isHavingTunnelVisionBurst);
        data.setInteger("tunnelVisionBurstLevel", tunnelVisionBurstLevel);
        this.setCustomEffectData(player, data);
    }



    private int getRemainingTunnelVisionBurstTime(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getInteger("remainingTunnelVisionBurstTime");
    }

    private void setRemainingTunnelVisionBurstTime(EntityPlayer player, int remainingTunnelVisionBurstTime) {
        NBTTagCompound data = this.getCustomEffectData(player);
        data.setInteger("remainingTunnelVisionBurstTime", remainingTunnelVisionBurstTime);
        this.setCustomEffectData(player, data);
    }



    public static void causeTunnelVisionBurst(EntityPlayer player) {
        NBTTagCompound data = NBTHandler.getCustomEffectStorage(player).getCompoundTag("tunnel_vision_bursts");
        data.setBoolean("isHavingTunnelVisionBurst", true);
        data.setInteger("tunnelVisionBurstLevel", 4);
        data.setInteger("remainingTunnelVisionBurstTime", 701);
        if (!player.isCreative() && !player.isSpectator())
            player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.tunnel_vision_burst")));
        NBTHandler.setCustomEffectStorage(player, data, "tunnel_vision_bursts");
    }

    public static void causeTunnelVisionBurst(EntityPlayer player, int level) {
        NBTTagCompound data = NBTHandler.getCustomEffectStorage(player).getCompoundTag("tunnel_vision_bursts");
        data.setBoolean("isHavingTunnelVisionBurst", true);
        data.setInteger("tunnelVisionBurstLevel", level);
        data.setInteger("remainingTunnelVisionBurstTime", 301 + (level * 100));
        if (!player.isCreative() && !player.isSpectator())
            player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.tunnel_vision_burst")));
        NBTHandler.setCustomEffectStorage(player, data, "tunnel_vision_bursts");
    }
}
