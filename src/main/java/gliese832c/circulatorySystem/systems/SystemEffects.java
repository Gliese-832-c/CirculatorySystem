package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.util.CirculatorySystemLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import scala.Array;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

public class SystemEffects {

    @SubscribeEvent
    public void tickUpdate(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound data = NBTHandler.getNBTall(player);

        data = passiveDecay(data);
        data = specialInteractions(data);

        ArrayList<TemporaryPotionEffectObject> potionsToApply = new ArrayList<TemporaryPotionEffectObject>();
        applyEffects(player, data, potionsToApply);
        potionsToApply.clear();

        NBTHandler.setNBTall(player, data);
    }



    public NBTTagCompound passiveDecay(NBTTagCompound data) {

        for (SystemType systemType : SystemTypes.systemTypes) {
            data.setDouble(systemType.key, data.getDouble(systemType.key) * 0.9999995d);
        }

        return data;
    }

    public NBTTagCompound specialInteractions(NBTTagCompound data) {

        return data;
    }

    public void applyEffects(EntityPlayer player, NBTTagCompound data, ArrayList<TemporaryPotionEffectObject> potionsToApply) {

        if (!player.isCreative() && !player.isSpectator()) {

            // This applies the potion effects as specified in SystemTypes
            for (SystemType systemType : SystemTypes.systemTypes) {
                for (gliese832c.circulatorySystem.systems.PotionEffect potionEffect : systemType.potionEffects) {
                    if (data.getDouble(systemType.key) > potionEffect.minValue && data.getDouble(systemType.key) < potionEffect.maxValue) {
                        addPotionToApply(potionEffect.resourceLocation, potionEffect.level, potionsToApply);
                    }
                }
            }

            applyPotionEffects(player, potionsToApply);
        }
    }

    private void addPotionToApply(String potionEffect, int level, ArrayList<TemporaryPotionEffectObject> potionsToApply) {
        for (TemporaryPotionEffectObject tempEffect : potionsToApply) {
            if (potionEffect.equals(tempEffect.resourceLocation)) {
                tempEffect.levels.add(level);
                return;
            }
        }
        potionsToApply.add(new TemporaryPotionEffectObject(potionEffect, new ArrayList<>(Arrays.asList(new Integer[] { level }))));
    }


    private void applyPotionEffects(EntityPlayer player, ArrayList<TemporaryPotionEffectObject> potionsToApply) {
        ArrayList<TemporaryPotionEffectObject> potionsToApplyCopy = potionsToApply;
        for (TemporaryPotionEffectObject tempEffect : potionsToApplyCopy) {
            applyPotionEffect(player, tempEffect.resourceLocation, doPotionLevelMath(tempEffect.levels));
        }
    }

    private void applyPotionEffect(EntityPlayer player, String potionEffect, int level) {
        if (player.isPotionActive(Potion.getPotionFromResourceLocation(potionEffect))) {
            if (player.getActivePotionEffect(Potion.getPotionFromResourceLocation(potionEffect)).getDuration() < 50) {
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation(potionEffect), 200, level, false, false));
            }
        } else {
            player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation(potionEffect), 200, level, false, false));
        }
    }

    private int doPotionLevelMath(ArrayList<Integer> levels) {
        int tempVal = 0;
        for (int integer : levels) {
            integer++;
            tempVal += integer * integer;
        }
        int resultingPotionEffectLevelNotAdjusted = (int) Math.round(Math.sqrt((double) tempVal));
        return resultingPotionEffectLevelNotAdjusted - 1;
    }
}
