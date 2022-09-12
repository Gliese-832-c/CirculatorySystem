package gliese832c.circulatorySystem.item;

import net.minecraft.util.IStringSerializable;

public class ItemEnums {
    public static enum PillType implements IStringSerializable, IMetaEnum
    {
        CAFFEINE("caffeine", 0),
        COCAINE("cocaine", 1),
        SUS_AMOGUS("sus_amogus", 2),
        GREGIFICATION_AGENT_37X("gregification_agent_37-x", 3),
        G832C("g832c", 4),
        TO_228("to_228", 5);




        private String name;
        private int id;

        private PillType(String name, int id)
        {
            this.name = name;
            this.id = id;
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
    }
}