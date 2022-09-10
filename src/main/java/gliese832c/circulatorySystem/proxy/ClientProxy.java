package gliese832c.circulatorySystem.proxy;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.gui.EventNutritionKey;
import gliese832c.circulatorySystem.render.CirculatorySystemRenderHandler;
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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy extends CommonProxy {

    public static KeyBinding keyCirculatorySystemGui;

    @Override
    public void preInit(FMLPreInitializationEvent preEvent)
    {
        super.preInit(preEvent);
        //clientPreInit();
        CirculatorySystemRenderHandler.init();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

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
}