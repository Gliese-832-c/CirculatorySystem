package gliese832c.circulatorySystem.statusTracking;

import java.util.ArrayList;

public class Consumable {

    public String resourceLocation;
    public ArrayList<ConsumableEffect> consumableEffects;

    public Consumable(String resourceLocation, ArrayList<ConsumableEffect> consumableEffects) {
        this.resourceLocation = resourceLocation;
        this.consumableEffects = consumableEffects;
    }
}
