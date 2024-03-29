package gliese832c.circulatorySystem.proxy;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.gui.EventNutritionKey;
import gliese832c.circulatorySystem.item.CirculatoryItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {
    public static KeyBinding keyCirculatorySystemGui;
    public static ClientProxyData clientProxyData;

    @Override
    public void preInit(FMLPreInitializationEvent preEvent)
    {
        super.preInit(preEvent);

        clientProxyData = new ClientProxyData();

        CirculatoryItems.registerRenders();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

        CirculatoryItems.colorizeItems();

        ClientRegistry.registerKeyBinding(keyCirculatorySystemGui = new KeyBinding("key.circulatorysystem", Keyboard.KEY_G, "Circulatory System"));
        MinecraftForge.EVENT_BUS.register(new EventNutritionKey());
    }

    @Override
    public void postInit(FMLPostInitializationEvent postEvent)
    {
        super.postInit(postEvent);
    }


    @Override
    public EntityPlayer getPlayerClient()
    {
        return Minecraft.getMinecraft().player;
    }


    @Override
    public void registerFluidBlockRendering(Block block, String name)
    {
        super.registerFluidBlockRendering(block, name);
        FluidStateMapper mapper = new FluidStateMapper(name);

        Item item = Item.getItemFromBlock(block);
        ModelBakery.registerItemVariants(item);
        ModelLoader.setCustomMeshDefinition(item, mapper);

        // ModelLoader.setCustomStateMapper(block, new
        // StateMap.Builder().ignore(block.LEVEL).build());
        ModelLoader.setCustomStateMapper(block, mapper);
    }

    public static class FluidStateMapper extends StateMapperBase implements ItemMeshDefinition
    {
        public final ModelResourceLocation location;

        public FluidStateMapper(String name)
        {
            location = new ModelResourceLocation(CirculatorySystem.MOD_ID + ":fluids", name);
        }

        @Override
        protected ModelResourceLocation getModelResourceLocation(IBlockState state)
        {
            return location;
        }

        @Override
        public ModelResourceLocation getModelLocation(ItemStack stack)
        {
            return location;
        }
    }



    public class ClientProxyData {

        public NBTTagCompound playerStatusTrackers = new NBTTagCompound();

        public boolean heartAttack = false;
        public int heartAttackLevel = 0;

        public boolean isHavingTunnelVision = false;
        public int tunnelVisionLevel = 0;

        public boolean isHavingTunnelVisionBurst = false;
        public int tunnelVisionBurstLevel = 0;

        public boolean isPassedOut = false;

        public boolean onetwelveCopypasta = false;
    }
}