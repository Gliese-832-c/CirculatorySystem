package gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry;

import gliese832c.circulatorySystem.config.CirculatoryConfig;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ConsumablesList {

    public static ArrayList<Consumable> consumablesList = new ArrayList<Consumable>();

    public static void initConsumablesList() {
        for (String entry : CirculatoryConfig.consumablesList) {
            consumablesList.add(getConsumableFromConfigString(entry));
        }
    }



    public static Consumable getConsumableFromConfigString(String entry) {

        String[] itemAndStatusTrackerData = entry.split("\\|");

        ArrayList<ConsumableStatusTrackerChangeData> statusTrackerData = new ArrayList<>();
        for (int i = 1; i < itemAndStatusTrackerData.length; i++) {

            String[] statusTrackerDatum = itemAndStatusTrackerData[i].split(":");

            String[] keys = statusTrackerDatum[0].split(",");
            double amount = Double.parseDouble(statusTrackerDatum[1]);
            double chance = Double.parseDouble(statusTrackerDatum[2]);
            boolean isRelative = Boolean.parseBoolean(statusTrackerDatum[3]);

            for (String key : keys)
                statusTrackerData.add(new ConsumableStatusTrackerChangeData(key, amount, chance, isRelative));
        }

        String[] item = itemAndStatusTrackerData[0].split(":");

        String resourceLocation = item[0] + ":" + item[1];
        int metadata = item.length == 3 ? Integer.parseInt(item[2]) : 0;

        return new Consumable(resourceLocation, metadata, statusTrackerData);
    }



    public static Consumable getConsumableByResourceLocationAndMetadata(String resourceLocation, int metadata) {
        for (Consumable consumable : consumablesList) {
            if (resourceLocation.equals(consumable.resourceLocation) && consumable.metadata == metadata) {
                return consumable;
            }
        }
        return null;
    }

    public static boolean isValidConsumable(ItemStack itemStack) {
        for (Consumable consumable : consumablesList) {
            if (itemStack.getItem().getRegistryName().toString().equals(consumable.resourceLocation) && itemStack.getMetadata() == consumable.metadata) {
                return true;
            }
        }
        return false;
    }
}
