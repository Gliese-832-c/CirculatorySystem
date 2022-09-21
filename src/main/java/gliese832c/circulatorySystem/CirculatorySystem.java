package gliese832c.circulatorySystem;

import gliese832c.circulatorySystem.gui.ModGuiHandler;
import gliese832c.circulatorySystem.proxy.CommonProxy;
import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLModIdMappingEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = CirculatorySystem.MOD_ID, name = CirculatorySystem.MOD_NAME, version = CirculatorySystem.VERSION, acceptedMinecraftVersions = CirculatorySystem.MCVERSION)
public class CirculatorySystem {

    public static final String MOD_NAME = "Circulatory System";
    public static final String MOD_ID = "circulatorysystem";
    public static final String VERSION = "0.1.0";
    public static final String MCVERSION = "1.12.2";

    @Instance(MOD_ID)
    public static CirculatorySystem instance;

    @SidedProxy(clientSide = "gliese832c.circulatorySystem.proxy.ClientProxy", serverSide = "gliese832c.circulatorySystem.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CirculatoryLogger.info("PreInitialization");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        CirculatoryLogger.info("Initialization");
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        CirculatoryLogger.info("PostInitialization");
        proxy.postInit(event);
    }

    @EventHandler
    public void serverStart(FMLServerStartingEvent serverStartEvent) {
        CirculatoryLogger.info("Server Load");
        proxy.serverStart(serverStartEvent);
    }

    @EventHandler
    public void onIdMapping(FMLModIdMappingEvent idMappingEvent)
    {
        proxy.onIdMapping(idMappingEvent);
    }
}