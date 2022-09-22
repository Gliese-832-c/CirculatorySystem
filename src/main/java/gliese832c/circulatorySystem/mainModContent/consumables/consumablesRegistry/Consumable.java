package gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry;

import java.util.ArrayList;

public class Consumable {

    public String resourceLocation;
    public int metadata;
    public ArrayList<ConsumableStatusTrackerChangeData> consumableStatusTrackerChangeData;

    public Consumable(String resourceLocation, int metadata, ArrayList<ConsumableStatusTrackerChangeData> consumableStatusTrackerChangeData) {
        this.resourceLocation = resourceLocation;
        this.metadata = metadata;
        this.consumableStatusTrackerChangeData = consumableStatusTrackerChangeData;
    }
}
