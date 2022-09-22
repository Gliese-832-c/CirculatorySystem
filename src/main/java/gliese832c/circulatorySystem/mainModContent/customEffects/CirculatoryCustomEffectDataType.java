package gliese832c.circulatorySystem.mainModContent.customEffects;

public class CirculatoryCustomEffectDataType {
    public enum DataTypes {
        BOOLEAN,
        INT,
        FLOAT,
        DOUBLE,
        STRING
    }

    public String name;
    public DataTypes type;

    public CirculatoryCustomEffectDataType(String name, DataTypes type) {
        this.name = name;
        this.type = type;
    }
}
