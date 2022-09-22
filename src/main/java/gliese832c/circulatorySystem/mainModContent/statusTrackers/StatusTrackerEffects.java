package gliese832c.circulatorySystem.mainModContent.statusTrackers;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffects;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.EffectInfo;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;
import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.Arrays;

import static gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffects.customEffectList;

public class StatusTrackerEffects {

    @SubscribeEvent
    public void tickUpdate(TickEvent.PlayerTickEvent event) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER && event.phase == TickEvent.Phase.START) {

            EntityPlayer player = event.player;
            NBTTagCompound data = NBTHandler.getNBTall(player);



            deathScan(player, data);
            data = clamp(data);

            ArrayList<TemporaryPotionEffectObject> potionsToApply = new ArrayList<TemporaryPotionEffectObject>();
            applyEffects(player, data, potionsToApply);
            potionsToApply.clear();

            data = specialInteractions(data);
            data = passiveDecay(data);



            NBTHandler.setNBTall(player, data);
        }
    }



    public void deathScan(EntityPlayer player, NBTTagCompound data) {
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            if (statusTracker.dieOn100Percent && data.getDouble(statusTracker.key) >= 1.0) {
                player.attackEntityFrom(new DamageSourceCirculatory("system_value_100_percent", statusTracker).setDamageBypassesArmor().setDamageIsAbsolute(), Float.MAX_VALUE);
            }
        }
    }

    public NBTTagCompound clamp(NBTTagCompound data) {
        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            double dataValue = data.getDouble(statusTracker.key);
            if (dataValue > 1.0d) {
                data.setDouble(statusTracker.key, 1.0d);
            } else if (dataValue < 0.0d) {
                data.setDouble(statusTracker.key, 0.0d);
            }
        }
        return data;
    }

    public NBTTagCompound specialInteractions(NBTTagCompound data) {

        return data;
    }

    public NBTTagCompound passiveDecay(NBTTagCompound data) {

        for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
            data.setDouble(statusTracker.key, data.getDouble(statusTracker.key) * 0.9999995d);
        }

        return data;
    }

    public void applyEffects(EntityPlayer player, NBTTagCompound data, ArrayList<TemporaryPotionEffectObject> potionsToApply) {

        if (!player.isCreative() && !player.isSpectator()) {

            // This applies the potion effects as specified in SystemTypes
            for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
                for (EffectInfo effectInfo : statusTracker.potionEffectData) {
                    if (data.getDouble(statusTracker.key) > effectInfo.minValue && data.getDouble(statusTracker.key) < effectInfo.maxValue) {
                        addPotionToApply(effectInfo.resourceLocation, effectInfo.level, potionsToApply);
                    }
                }
            }

            ArrayList<String> customEffectsThatHaveBeenAppliedThisTickNames = new ArrayList<String>();

            ArrayList<TemporaryPotionEffectObject> potionsToApplyCopy = potionsToApply;
            for (TemporaryPotionEffectObject tempEffect : potionsToApplyCopy) {
                String[] arrOfStr = tempEffect.resourceLocation.split(":");
                if (arrOfStr[0].equals("CUSTOM")) {
                    applyCustomEffect(player, arrOfStr[1], doPotionLevelMath(tempEffect.levels));
                    customEffectsThatHaveBeenAppliedThisTickNames.add(arrOfStr[1]);
                } else {
                    applyPotionEffect(player, tempEffect.resourceLocation, doPotionLevelMath(tempEffect.levels));
                }
            }

            for (CirculatoryCustomEffect customEffect : customEffectList) {
                boolean foundEffectInAppliedEffectsList = false;
                for (String customEffectThatHasBeenAppliedThisTickName : customEffectsThatHaveBeenAppliedThisTickNames) {
                    if (!customEffect.name.equals(customEffectThatHasBeenAppliedThisTickName)) continue;
                    foundEffectInAppliedEffectsList = true;
                    break;
                }
                if (!foundEffectInAppliedEffectsList) {
                    customEffect.notApplyingEffect(player);
                }
            }
        }
    }

    private void addPotionToApply(String potionEffect, int level, ArrayList<TemporaryPotionEffectObject> potionsToApply) {
        for (TemporaryPotionEffectObject tempEffect : potionsToApply) {
            if (potionEffect.equals(tempEffect.resourceLocation)) {
                tempEffect.levels.add(level);
                return;
            }
        }
        potionsToApply.add(new TemporaryPotionEffectObject(potionEffect, new ArrayList<>(Arrays.asList(level))));
    }

    private void applyCustomEffect(EntityPlayer player, String customEffect, int level) throws IllegalStateException {
        if (level == 0) {
            return;
        } else {
            CirculatoryCustomEffects.getCustomEffectFromName(customEffect).applyEffect(player, level);
        }
    }

    private void applyPotionEffect(EntityPlayer player, String potionEffect, int level) {
        if (level == 0) {
            return;
        } else {
            if (level > 0) {
                level--;
            }
            if (player.isPotionActive(Potion.getPotionFromResourceLocation(potionEffect))) {
                if (player.getActivePotionEffect(Potion.getPotionFromResourceLocation(potionEffect)).getDuration() < 50) {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation(potionEffect), 200, level, true, false));
                }
            } else {
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation(potionEffect), 200, level, true, false));
            }
        }
    }

    private int doPotionLevelMath(ArrayList<Integer> levels) {
        long tempVal = 0;
        for (int integer : levels) {
            if (integer < 0) {
                long integerAbsolute = Math.abs(integer);
                tempVal += (integerAbsolute * integerAbsolute) * -1;
            } else {
                integer++;
                tempVal += (long) integer * (long) integer;
            }
        }

        if (tempVal > 0) {
            return (int) Math.round(Math.sqrt((double) tempVal));
        } else if (tempVal < 0) {
            tempVal = Math.abs(tempVal);
            tempVal = (int) Math.round(Math.sqrt((double) tempVal));
            return (int) (tempVal * -1);
        } else {
            return 0;
        }
    }
}
