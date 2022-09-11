package gliese832c.circulatorySystem.systems;

import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

public class ConsumablesList {

    public static ArrayList<Consumable> consumablesList = new ArrayList<Consumable>();

    public static void initConsumablesList() {
        consumablesList.add(new Consumable("minecraft:cooked_beef",
                new ArrayList<>(Arrays.asList(new ConsumableEffect[] {
                        new ConsumableEffect("sugar", -0.1, false),
                        new ConsumableEffect("obesity", -0.01, false),
                        new ConsumableEffect("gastrointestinal", -0.001, false),
                        new ConsumableEffect("immune_system", 0.001, false),
                        new ConsumableEffect("liver", 0.005, false),
                        new ConsumableEffect("lungs", 0.02, false),
                        new ConsumableEffect("heart", 0.05, false),
                        new ConsumableEffect("muscles", 0.25, false),
                        new ConsumableEffect("eyes", 0.5, true),
                        new ConsumableEffect("brain", 1.5, true)
        }))));
        consumablesList.add(new Consumable("minecraft:cooked_porkchop",
                new ArrayList<>(Arrays.asList(new ConsumableEffect[] {
                        new ConsumableEffect("brain", 0.4, false),
                        new ConsumableEffect("eyes", 0.6, true)
        }))));
    }

    public static Consumable getConsumableByResourceLocation(String resourceLocation) {
        for (Consumable consumable : consumablesList) {
            if (resourceLocation.equals(consumable.resourceLocation)) {
                return consumable;
            }
        }
        return null;
    }

    public static boolean isValidConsumable(ItemStack itemStack) {
        for (Consumable consumable : consumablesList) {
            if (itemStack.getItem().getRegistryName().toString().equals(consumable.resourceLocation)) {
                return true;
            }
        }
        return false;
    }
}
