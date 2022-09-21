package gliese832c.circulatorySystem.statusTracking;

public class EffectInfo {

    String resourceLocation;
    int level;
    double minValue;
    double maxValue;

    public EffectInfo(String resourceLocation, int level, double minValue, double maxValue) {
        this.resourceLocation = resourceLocation;
        this.level = level;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
