package gliese832c.circulatorySystem.systems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SystemEffects {

    @SubscribeEvent
    public void tickUpdate(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        NBTTagCompound data = NBTHandler.getNBTall(player);

        data = updateSystemTypes(player, data);
        applyEffects(player, data);

        NBTHandler.setNBTall(player, data);
    }

    public NBTTagCompound updateSystemTypes(EntityPlayer player, NBTTagCompound data) {

        for (SystemType systemType : SystemTypes.systemTypes) {
            //data.setDouble(systemType.key, data.getDouble(systemType.key) * 0.9999995d);
            data.setDouble(systemType.key, data.getDouble(systemType.key) * 0.9999d);
        }

        return data;
    }

    public void applyEffects(EntityPlayer player, NBTTagCompound data) {

        if (!player.isCreative() && !player.isSpectator()) {

            // Blood Sugar
            if (data.getDouble("sugar") > 0.5) {
                if (player.isPotionActive(Potion.getPotionFromResourceLocation("minecraft:poison"))) {
                    if (player.getActivePotionEffect(Potion.getPotionFromResourceLocation("minecraft:poison")).getDuration() < 50) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:poison"), 150, 0, false, false));
                    }
                } else {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:poison"), 150, 0, false, false));
                }
            }

            // Obesity
            if (data.getDouble("obesity") > 0.5) {
                if (player.isPotionActive(Potion.getPotionFromResourceLocation("minecraft:wither"))) {
                    if (player.getActivePotionEffect(Potion.getPotionFromResourceLocation("minecraft:wither")).getDuration() < 50) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:wither"), 150, 0, false, false));
                    }
                } else {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:wither"), 150, 0, false, false));
                }
            }

            // Gastrointestinal Damage
            if (data.getDouble("gastrointestinal") > 0.5) {
                if (player.isPotionActive(Potion.getPotionFromResourceLocation("minecraft:weakness"))) {
                    if (player.getActivePotionEffect(Potion.getPotionFromResourceLocation("minecraft:weakness")).getDuration() < 50) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:weakness"), 150, 0, false, false));
                    }
                } else {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:weakness"), 150, 0, false, false));
                }
            }

            // Immunocompromisation
            if (data.getDouble("immune_system") > 0.5) {
                if (player.isPotionActive(Potion.getPotionFromResourceLocation("minecraft:blindness"))) {
                    if (player.getActivePotionEffect(Potion.getPotionFromResourceLocation("minecraft:blindness")).getDuration() < 50) {
                        player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:blindness"), 150, 0, false, false));
                    }
                } else {
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("minecraft:blindness"), 150, 0, false, false));
                }
            }
        }
    }
}
