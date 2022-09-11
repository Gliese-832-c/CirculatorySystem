package gliese832c.circulatorySystem.systems;

public class PotionEffect {

    String resourceLocation;
    int level;
    double minValue;
    double maxValue;

    public PotionEffect(String resourceLocation, int level, double minValue, double maxValue) {
        this.resourceLocation = resourceLocation;
        this.level = level;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
