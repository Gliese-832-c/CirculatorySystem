package gliese832c.circulatorySystem.proxy;

import java.util.Locale;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.commands.CirculatoryCommandRegistry;
import gliese832c.circulatorySystem.gui.ModGuiHandler;
import gliese832c.circulatorySystem.item.CirculatoryItems;
import gliese832c.circulatorySystem.network.*;
import gliese832c.circulatorySystem.sound.CirculatorySounds;
import gliese832c.circulatorySystem.statusTracking.ConsumablesList;
import gliese832c.circulatorySystem.statusTracking.StatusTrackerEffects;
import gliese832c.circulatorySystem.statusTracking.StatusTrackers;
import gliese832c.circulatorySystem.statusTracking.customEffects.CirculatoryCustomEffects;
import gliese832c.circulatorySystem.statusTracking.customEffects.auxiliaryCode.NetworkPacketsEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent preEvent)
    {
        CirculatoryItems.init();
        CirculatoryItems.register();
        CirculatorySounds.registerSounds();

        StatusTrackers.initSystemTypes();
        CirculatoryCustomEffects.initEffectTypes();

        CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.registerMessage(CirculatoryMessagePlayerStatusTrackers.CirculatoryMessagePlayerStatusTrackersHandler.class, CirculatoryMessagePlayerStatusTrackers.class, 0, Side.CLIENT);

        CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.registerMessage(CirculatoryMessageTunnelVision.CirculatoryMessageTunnelVisionHandler.class, CirculatoryMessageTunnelVision.class, 1, Side.CLIENT);
        CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.registerMessage(CirculatoryMessageTunnelVisionBurst.CirculatoryMessageTunnelVisionBurstHandler.class, CirculatoryMessageTunnelVisionBurst.class, 2, Side.CLIENT);

        CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.registerMessage(CirculatoryMessageHeartAttack.CirculatoryMessageHeartAttackHandler.class, CirculatoryMessageHeartAttack.class, 3, Side.CLIENT);
        CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.registerMessage(CirculatoryMessageHeartAttackSound.CirculatoryMessageHeartAttackSoundHandler.class, CirculatoryMessageHeartAttackSound.class, 4, Side.CLIENT);
    }

    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(CirculatorySystem.instance, new ModGuiHandler());
    }

    public void postInit(FMLPostInitializationEvent postEvent)
    {
        ConsumablesList.initConsumablesList();

        MinecraftForge.EVENT_BUS.register(new StatusTrackerEffects());
        MinecraftForge.EVENT_BUS.register(new NetworkPacketsEvent());
    }

    public void serverStart(FMLServerStartingEvent serverStartEvent) {
        CirculatoryCommandRegistry.registerCommands(serverStartEvent);
    }

    public void onIdMapping(FMLModIdMappingEvent idMappingEvent)
    {

    }

    public void registerFluidBlockRendering(Block block, String name)
    {
        name = name.toLowerCase(Locale.ROOT);
    }

    public EntityPlayer getPlayerClient()
    {
        return null;
    }
}