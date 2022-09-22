package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffectDataType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class CustomEffectTunnelVision extends CirculatoryCustomEffect {
    public CustomEffectTunnelVision(String name, ArrayList<CirculatoryCustomEffectDataType> dataTypes) {
        super(name);
        this.dataTypes = dataTypes;
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        setIsTunnelVisionLevel(player, true, level);
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {
        setIsTunnelVisionLevel(player, false, 0);
    }



    private void setIsTunnelVisionLevel(EntityPlayer player, boolean isTunnelVision, int level) {
        NBTTagCompound data = this.getCustomEffectData(player);
        data.setBoolean("isHavingTunnelVision", isTunnelVision);
        data.setInteger("tunnelVisionLevel", level);
        this.setCustomEffectData(player, data);
    }
}
