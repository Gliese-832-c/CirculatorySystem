package gliese832c.circulatorySystem.item;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

import java.awt.*;

public class CirculatoryColorizationHandler {

    public static class ColorizationHandlerPill implements IItemColor {

        @Override
        public int colorMultiplier(ItemStack itemStack, int i) {
            int result = Color.PINK.getRGB();
            ItemEnums.PillType[] pillTypes = ItemEnums.PillType.values();

            if (pillTypes.length > itemStack.getMetadata()) {
                if (pillTypes[itemStack.getMetadata()] != null) {
                    if (i == 0) {
                        result = pillTypes[itemStack.getMetadata()].getColorRight();
                    } else {
                        result = pillTypes[itemStack.getMetadata()].getColorLeft();
                    }
                }
            }
            return result;
        }
    }
}
