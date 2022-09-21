package gliese832c.circulatorySystem.item;

import net.minecraft.util.IStringSerializable;

public class ItemEnums {
    public static enum PillType implements IStringSerializable, IMetaEnum
    {
        CAFFEINE("caffeine", 0, 0xFF3333, 0xFFFFFF),
        COCAINE("cyanide", 1, 0x0092FF, 0xA8DAFF);




        private String name;
        private int id;
        private int colorLeft;
        private int colorRight;

        private PillType(String name, int id, int colorLeft, int colorRight)
        {
            this.name = name;
            this.id = id;
            this.colorLeft = colorLeft;
            this.colorRight = colorRight;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public String toString()
        {
            return getName();
        }

        @Override
        public int getID()
        {
            return id;
        }

        public int getColorLeft()
        {
            return colorLeft;
        }
        public int getColorRight()
        {
            return colorRight;
        }
    }
}