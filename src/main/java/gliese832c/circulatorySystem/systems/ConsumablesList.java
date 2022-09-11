package gliese832c.circulatorySystem.systems;

import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

public class ConsumablesList {

    public static ArrayList<Consumable> consumablesList = new ArrayList<Consumable>();

    public static void initConsumablesList() {
        consumablesList.add(new Consumable("minecraft:cooked_beef",
                new ArrayList<>(Arrays.asList(new ConsumableEffect[] {
                        new ConsumableEffect("sugar", -0.03d, false),
                        new ConsumableEffect("obesity", -0.003d, false),
                        new ConsumableEffect("gastrointestinal", -0.001d, false),
                        new ConsumableEffect("immune_system", 0.0d, false),
                        new ConsumableEffect("liver", 0.001d, false),
                        new ConsumableEffect("lungs", 0.003d, false),
                        new ConsumableEffect("heart", 0.01d, false),
                        new ConsumableEffect("muscles", 0.03d, false),
                        new ConsumableEffect("eyes", 0.1d, false),
                        new ConsumableEffect("brain", 0.5d, true)
        }))));
        consumablesList.add(new Consumable("minecraft:cooked_porkchop",
                new ArrayList<>(Arrays.asList(new ConsumableEffect[] {
                        new ConsumableEffect("brain", 0.4d, false),
                        new ConsumableEffect("eyes", 0.6d, true)
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
