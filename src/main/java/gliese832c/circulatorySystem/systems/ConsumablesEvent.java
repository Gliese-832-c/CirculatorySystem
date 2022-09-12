package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ConsumablesEvent {
    @SubscribeEvent
    public static void finishUsingItem(LivingEntityUseItemEvent.Finish event) {
        // Only check against players
        if (!(event.getEntity() instanceof EntityPlayer))
            return;

        // Get ItemStack of eaten food
        ItemStack itemStack = event.getItem();
        int stackSize = itemStack.getCount();
        itemStack.setCount(1); // Temporarily setting stack size to 1 so .copy works for stack sizes of 0
        ItemStack dummyStack = itemStack.copy(); // Create dummy copy to not affect original item
        itemStack.setCount(stackSize); // Restore original stack size

        // Apply actions to item
        EntityPlayer player = (EntityPlayer) event.getEntity();

        for (Consumable consumable : ConsumablesList.consumablesList) {
            String itemRegistryName = itemStack.getItem().getRegistryName().toString();
            if (itemRegistryName.equals(consumable.resourceLocation)) {
                CirculatoryLogger.getLogger().error("Made it through the if check! " + consumable.resourceLocation);
                for (ConsumableEffect effect : consumable.consumableEffects) {
                    if (effect.isRelative) {
                        NBTHandler.setNBTdata(player, effect.key, NBTHandler.getNBTdata(player, effect.key) * (1 + effect.amount));
                    } else {
                        NBTHandler.setNBTdata(player, effect.key, NBTHandler.getNBTdata(player, effect.key) + effect.amount);
                    }
                }
            }
        }
    }
}