package gliese832c.circulatorySystem.systems;

public class PotionEffectInfo {

    String resourceLocation;
    int level;
    double minValue;
    double maxValue;

    public PotionEffectInfo(String resourceLocation, int level, double minValue, double maxValue) {
        this.resourceLocation = resourceLocation;
        this.level = level;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
