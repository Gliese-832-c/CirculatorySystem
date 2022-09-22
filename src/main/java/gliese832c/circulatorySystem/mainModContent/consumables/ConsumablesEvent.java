package gliese832c.circulatorySystem.mainModContent.consumables;

import gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry.Consumable;
import gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry.ConsumableStatusTrackerChangeData;
import gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry.ConsumablesList;
import gliese832c.circulatorySystem.util.CirculatoryLogger;
import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class ConsumablesEvent {
    @SubscribeEvent
    public static void finishUsingItem(LivingEntityUseItemEvent.Finish event) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
            // Only check against players
            if (!(event.getEntity() instanceof EntityPlayer))
                return;

            // Get ItemStack of eaten food
            ItemStack itemStack = event.getItem();
            int stackSize = itemStack.getCount();
            itemStack.setCount(1); // Temporarily setting stack size to 1 so .copy works for stack sizes of 0
            //ItemStack dummyStack = itemStack.copy(); // Create dummy copy to not affect original item
            //itemStack.setCount(stackSize); // Restore original stack size

            // Apply actions to item
            EntityPlayer player = (EntityPlayer) event.getEntity();

            for (Consumable consumable : ConsumablesList.consumablesList) {
                if (itemStack.getItem().getRegistryName().toString().equals(consumable.resourceLocation) && itemStack.getMetadata() == consumable.metadata) {
                    CirculatoryLogger.getLogger().error("Made it through the if check! " + consumable.resourceLocation);
                    for (ConsumableStatusTrackerChangeData statusTrackerChangeData : consumable.consumableStatusTrackerChangeData) {
                        if (Math.random() > (1 - statusTrackerChangeData.chance)) {
                            NBTHandler.setNBTdata(player, statusTrackerChangeData.key, statusTrackerChangeData.isRelative ? NBTHandler.getNBTdata(player, statusTrackerChangeData.key) * (1 + statusTrackerChangeData.amount) : NBTHandler.getNBTdata(player, statusTrackerChangeData.key) + statusTrackerChangeData.amount);
                        }
                    }
                }
            }
        }
    }
}