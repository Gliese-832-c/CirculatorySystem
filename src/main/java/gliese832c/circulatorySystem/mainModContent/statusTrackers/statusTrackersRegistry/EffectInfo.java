package gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry;

public class EffectInfo {

    public String resourceLocation;
    public int level;
    public double minValue;
    public double maxValue;

    public EffectInfo(String resourceLocation, int level, double minValue, double maxValue) {
        this.resourceLocation = resourceLocation;
        this.level = level;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
