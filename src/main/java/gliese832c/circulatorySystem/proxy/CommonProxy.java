package gliese832c.circulatorySystem.proxy;

import java.util.Locale;

//import lach_01298.qmd.ArmourBonusHandler;
//import lach_01298.qmd.QMDOreDictionary;
//import lach_01298.qmd.block.QMDBlocks;
//import lach_01298.qmd.fluid.QMDFluids;
//import lach_01298.qmd.item.QMDItems;
//import lach_01298.qmd.recipes.QMDRecipes;
import gliese832c.circulatorySystem.block.CirculatorySystemBlocks;
import gliese832c.circulatorySystem.commands.CommandHandler;
import gliese832c.circulatorySystem.systems.SystemTypes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent preEvent)
    {
        CirculatorySystemBlocks.init();
        CirculatorySystemBlocks.register();
        SystemTypes.initEffectTypes();
    }

    public void init(FMLInitializationEvent event)
    {
        /*MinecraftForge.EVENT_BUS.register(new ArmourBonusHandler());*/
    }

    public void postInit(FMLPostInitializationEvent postEvent)
    {

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