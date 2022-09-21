package gliese832c.circulatorySystem.item;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.tab.CirculatoryTabs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CirculatoryItems {
    public static Item pill;

    public static void init()
    {
        pill = withName(new ItemMeta(ItemEnums.PillType.class, "pill"), "pill");
    }

    public static void register()
    {
        registerItem(pill, CirculatoryTabs.MAIN);
    }

    public static void registerRenders()
    {
        for(int i = 0; i < ItemEnums.PillType.values().length; i++)
        {
            registerRender(pill, i, ItemEnums.PillType.values()[i].getName());
        }
    }



    public static void colorizeItems() {
        ItemColors itemColors = Minecraft.getMinecraft().getItemColors();

        itemColors.registerItemColorHandler(new CirculatoryColorizationHandler.ColorizationHandlerPill(), pill);
    }



    public static <T extends Item & IInfoItem> Item withName(T item, String name)
    {
        item.setTranslationKey(CirculatorySystem.MOD_ID + "." + name).setRegistryName(new ResourceLocation(CirculatorySystem.MOD_ID, name));
        item.setInfo();
        return item;
    }

    public static String infoLine(String name)
    {
        return "item." + CirculatorySystem.MOD_ID + "." + name + ".desc";
    }

    public static void registerItem(Item item, CreativeTabs tab)
    {
        item.setCreativeTab(tab);
        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerRender(Item item)
    {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void registerRender(Item item, int meta, String type)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(CirculatorySystem.MOD_ID, "items/" + item.getRegistryName().getPath()), "type=" + type));
    }
}


