package gliese832c.circulatorySystem.gui;

import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
    // GUI IDs
    public static final int CIRCULATORYSYSTEM_GUI_ID = 0;
    public static CirculatorySystemGui circulatorySystemGui;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == CIRCULATORYSYSTEM_GUI_ID)
            return circulatorySystemGui = new CirculatorySystemGui(player);
        return null;
    }
}