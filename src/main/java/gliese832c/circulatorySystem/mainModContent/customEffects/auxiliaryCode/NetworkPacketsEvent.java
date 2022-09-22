package gliese832c.circulatorySystem.mainModContent.customEffects.auxiliaryCode;

import gliese832c.circulatorySystem.network.*;
import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NetworkPacketsEvent {

    @SubscribeEvent
    public void networkPacketEvent(TickEvent.PlayerTickEvent event) {
        if (event.player instanceof EntityPlayerMP) {

            NBTTagCompound playerStatusTrackers = NBTHandler.getNBTall(event.player);
            NBTTagCompound customEffectStorage = NBTHandler.getCustomEffectStorage(event.player);



            // Status Trackers

            CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.sendTo(new CirculatoryMessagePlayerStatusTrackers(playerStatusTrackers), (EntityPlayerMP) event.player);



            // Tunnel Vision

            NBTTagCompound dataTunnelVision = customEffectStorage.getCompoundTag("tunnel_vision");

            isHavingTunnelVision = dataTunnelVision.getBoolean("isHavingTunnelVision");
            tunnelVisionLevel = dataTunnelVision.getInteger("tunnelVisionLevel");

            if (isHavingTunnelVision != isHavingTunnelVision_previous || tunnelVisionLevel != tunnelVisionLevel_previous) {
                CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.sendTo(new CirculatoryMessageTunnelVision(isHavingTunnelVision, tunnelVisionLevel), (EntityPlayerMP) event.player);
            }

            isHavingTunnelVision_previous = dataTunnelVision.getBoolean("isHavingTunnelVision");
            tunnelVisionLevel_previous = dataTunnelVision.getInteger("tunnelVisionLevel");



            // Tunnel Vision Bursts

            NBTTagCompound dataTunnelVisionBurst = customEffectStorage.getCompoundTag("tunnel_vision_bursts");

            isHavingTunnelVisionBurst = dataTunnelVisionBurst.getBoolean("isHavingTunnelVisionBurst");
            tunnelVisionBurstLevel = dataTunnelVisionBurst.getInteger("tunnelVisionBurstLevel");

            if (isHavingTunnelVisionBurst != isHavingTunnelVisionBurst_previous || tunnelVisionBurstLevel != tunnelVisionBurstLevel_previous) {
                CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.sendTo(new CirculatoryMessageTunnelVisionBurst(isHavingTunnelVisionBurst, tunnelVisionBurstLevel), (EntityPlayerMP) event.player);
            }

            isHavingTunnelVisionBurst_previous = dataTunnelVisionBurst.getBoolean("isHavingTunnelVisionBurst");
            tunnelVisionBurstLevel_previous = dataTunnelVisionBurst.getInteger("tunnelVisionBurstLevel");



            // Heart Attack

            NBTTagCompound dataHeartAttack = customEffectStorage.getCompoundTag("heart_attack");

            isHavingHeartAttack = dataHeartAttack.getBoolean("isHavingHeartAttack");
            heartAttackLevel = dataHeartAttack.getInteger("heartAttackLevel");

            if (isHavingHeartAttack != isHavingHeartAttack_previous || heartAttackLevel != heartAttackLevel_previous) {
                CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.sendTo(new CirculatoryMessageHeartAttack(isHavingHeartAttack, heartAttackLevel), (EntityPlayerMP) event.player);
            }

            if (isHavingHeartAttack && !isHavingHeartAttack_previous) {
                CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.sendTo(new CirculatoryMessageHeartAttackSound(heartAttackLevel), (EntityPlayerMP) event.player);
            }

            isHavingHeartAttack_previous = dataHeartAttack.getBoolean("isHavingHeartAttack");
            heartAttackLevel_previous = dataHeartAttack.getInteger("heartAttackLevel");
        }
    }



    public static boolean isHavingTunnelVision;
    public static int tunnelVisionLevel;

    public static boolean isHavingTunnelVision_previous = false;
    public static int tunnelVisionLevel_previous = 0;


    public static boolean isHavingTunnelVisionBurst;
    public static int tunnelVisionBurstLevel;

    public static boolean isHavingTunnelVisionBurst_previous = false;
    public static int tunnelVisionBurstLevel_previous = 0;




    public static boolean isHavingHeartAttack;
    public static int heartAttackLevel;

    public static boolean isHavingHeartAttack_previous = false;
    public static int heartAttackLevel_previous = 0;
}