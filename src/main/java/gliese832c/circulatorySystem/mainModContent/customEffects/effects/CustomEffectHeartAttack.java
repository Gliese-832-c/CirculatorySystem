package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.statusTrackers.CirculatoryDamageTypes;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffectDataType;
import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

import java.util.ArrayList;

public class CustomEffectHeartAttack extends CirculatoryCustomEffect {
    public CustomEffectHeartAttack(String name, ArrayList<CirculatoryCustomEffectDataType> dataTypes) {
        super(name);
        this.dataTypes = dataTypes;
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        if (!getIsHavingHeartAttack(player)) {
            setIsHavingHeartAttackLevel(player, false, 0);

            if (!player.isDead && Math.random() > (1.0d - 0.000001d * (double) level)) {
                player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.heart_attack")));
                setIsHavingHeartAttackLevel(player, true, level);
                setRemainingHeartAttackLength(player, 301 + (level * 100));
            }
        } else {
            // Heart Attack Loop

            // Code that affects the player goes here
            if (getRemainingHeartAttackLength(player) % Math.max(1, (400.0f / ((float) level + 3.0f))) == 0) {
                player.attackEntityFrom(CirculatoryDamageTypes.HEART_ATTACK, ((float) level) + 1.0f);
            }

            // Loop Exit
            setRemainingHeartAttackLength(player, getRemainingHeartAttackLength(player) - 1);
            if (getRemainingHeartAttackLength(player) < 1) {
                setRemainingHeartAttackLength(player, 0);
                setIsHavingHeartAttackLevel(player, false, 0);
                player.sendMessage(new TextComponentString("§6" + I18n.translateToLocal("chat.circulatorysystem.heart_attack_over")));
            }

            // Make the heart attack end on death, so it doesn't continue while the player is in the death screen
            if (player.isDead) {
                setRemainingHeartAttackLength(player, 0);
                setIsHavingHeartAttackLevel(player, false, 0);
            }
        }
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {
        if (getIsHavingHeartAttack(player)) {
            // Heart Attack Loop

            // Code that affects the player goes here
            if (getRemainingHeartAttackLength(player) % Math.max(1, (int) (400.0f / ((float) getHeartAttackLevel(player) + 3.0f))) == 0) {
                player.attackEntityFrom(CirculatoryDamageTypes.HEART_ATTACK, ((float) getHeartAttackLevel(player)) + 1.0f);
            }

            // Loop Exit
            setRemainingHeartAttackLength(player, getRemainingHeartAttackLength(player) - 1);
            if (getRemainingHeartAttackLength(player) < 1) {
                setRemainingHeartAttackLength(player, 0);
                setIsHavingHeartAttackLevel(player, false, 0);
                player.sendMessage(new TextComponentString("§6" + I18n.translateToLocal("chat.circulatorysystem.heart_attack_over")));
            }

            // Make the heart attack end on death, so it doesn't continue while the player is in the death screen
            if (player.isDead) {
                setRemainingHeartAttackLength(player, 0);
                setIsHavingHeartAttackLevel(player, false, 0);
            }
        }
    }



    private boolean getIsHavingHeartAttack(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getBoolean("isHavingHeartAttack");
    }

    private int getHeartAttackLevel(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getInteger("heartAttackLevel");
    }

    private void setIsHavingHeartAttackLevel(EntityPlayer player, boolean isHeartAttack, int level) {
        NBTTagCompound data = this.getCustomEffectData(player);
        data.setBoolean("isHavingHeartAttack", isHeartAttack);
        data.setInteger("heartAttackLevel", level);
        this.setCustomEffectData(player, data);
    }



    private int getRemainingHeartAttackLength(EntityPlayer player) {
        NBTTagCompound data = this.getCustomEffectData(player);
        return data.getInteger("remainingHeartAttackLength");
    }

    private void setRemainingHeartAttackLength(EntityPlayer player, int remainingHeartAttackLength) {
        NBTTagCompound data = this.getCustomEffectData(player);
        data.setInteger("remainingHeartAttackLength", remainingHeartAttackLength);
        this.setCustomEffectData(player, data);
    }



    public static void causeHeartAttack(EntityPlayer player) {
        NBTTagCompound data = NBTHandler.getCustomEffectStorage(player).getCompoundTag("heart_attack");
        data.setBoolean("isHavingHeartAttack", true);
        data.setInteger("heartAttackLevel", 4);
        data.setInteger("remainingHeartAttackLength", 701);
        if (!player.isCreative() && !player.isSpectator())
            player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.heart_attack")));
        NBTHandler.setCustomEffectStorage(player, data, "heart_attack");
    }

    public static void causeHeartAttack(EntityPlayer player, int level) {
        NBTTagCompound data = NBTHandler.getCustomEffectStorage(player).getCompoundTag("heart_attack");
        data.setBoolean("isHavingHeartAttack", true);
        data.setInteger("heartAttackLevel", level);
        data.setInteger("remainingHeartAttackLength", 301 + (level * 100));
        if (!player.isCreative() && !player.isSpectator())
            player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.heart_attack")));
        NBTHandler.setCustomEffectStorage(player, data, "heart_attack");
    }
}