package gliese832c.circulatorySystem.systems;

public class ConsumableEffect {

    String key;
    double amount;
    boolean isRelative;

    public ConsumableEffect(String key, double amount, boolean isRelative) {
        this.key = key;
        this.amount = amount;
        this.isRelative = isRelative;
    }
}