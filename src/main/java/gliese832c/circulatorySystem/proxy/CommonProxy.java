package gliese832c.circulatorySystem.proxy;

import java.util.Locale;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.commands.CommandHandler;
import gliese832c.circulatorySystem.gui.EventWorldTick;
import gliese832c.circulatorySystem.gui.ModGuiHandler;
import gliese832c.circulatorySystem.systems.ConsumablesEvent;
import gliese832c.circulatorySystem.systems.ConsumablesList;
import gliese832c.circulatorySystem.systems.SystemEffects;
import gliese832c.circulatorySystem.systems.SystemTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent preEvent)
    {
        SystemTypes.initEffectTypes();
        ConsumablesList.initConsumablesList();

        MinecraftForge.EVENT_BUS.register(new EventWorldTick());
    }

    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(CirculatorySystem.instance, new ModGuiHandler());
    }

    public void postInit(FMLPostInitializationEvent postEvent)
    {
        MinecraftForge.EVENT_BUS.register(new SystemEffects());
    }

    public void serverStart(FMLServerStartingEvent serverStartEvent) {
        CommandHandler.registerCommands(serverStartEvent);
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