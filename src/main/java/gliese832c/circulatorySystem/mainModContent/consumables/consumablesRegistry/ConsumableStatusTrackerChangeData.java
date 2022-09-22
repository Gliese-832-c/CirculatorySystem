package gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry;

public class ConsumableStatusTrackerChangeData {

    public String key;
    public double amount;
    public double chance;
    public boolean isRelative;

    public ConsumableStatusTrackerChangeData(String key, double amount, double chance, boolean isRelative) {
        this.key = key;
        this.amount = amount;
        this.chance = chance;
        this.isRelative = isRelative;
    }
}