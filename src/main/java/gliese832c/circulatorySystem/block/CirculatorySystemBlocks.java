
package gliese832c.circulatorySystem.block;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.block.item.ItemBlockMeta;
import gliese832c.circulatorySystem.enums.BlockTypes;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CirculatorySystemBlocks {

    public static Block rockVolcanic;

    public static void init()
    {
        rockVolcanic = withName(new BlockRockVolcanic(), "rock_volcanic");
    }

    public static void register()
    {
        registerBlock(rockVolcanic, new ItemBlockMeta(rockVolcanic, BlockTypes.RockVolcanicTypes.class, ""));
    }

    public static void registerRenders()
    {
        for (int i=0; i < BlockTypes.RockVolcanicTypes.values().length; i++) {
            registerRender(rockVolcanic, i, BlockTypes.RockVolcanicTypes.values()[i].getName());
        }
    }




    public static Block withName(Block block, String name) {
        return block.setTranslationKey(CirculatorySystem.MOD_ID + "." + name).setRegistryName(new ResourceLocation(CirculatorySystem.MOD_ID, name));
    }

    /*public static <T extends Block & ITileType> Block withName(T block) {
        return block.setTranslationKey(Geology.MOD_ID + "." + block.getTileName()).setRegistryName(new ResourceLocation(Geology.MOD_ID, block.getTileName()));
    }*/

    public static String fixedLine(String name) {
        return "tile." + CirculatorySystem.MOD_ID + "." + name + ".fixd";
    }

    public static String infoLine(String name) {
        return "tile." + CirculatorySystem.MOD_ID + "." + name + ".desc";
    }

    public static void registerBlock(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ItemBlock itemBlock = new ItemBlock(block);
        ForgeRegistries.ITEMS.register(itemBlock.setRegistryName(block.getRegistryName()));
    }

    public static void registerBlock(Block block, ItemBlock itemBlock) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(itemBlock.setRegistryName(block.getRegistryName()));
    }

    public static void registerRender(Block block) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void registerRender(Block block, int meta, String type) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(CirculatorySystem.MOD_ID, block.getRegistryName().getPath()), "type=" + type));
    }
}