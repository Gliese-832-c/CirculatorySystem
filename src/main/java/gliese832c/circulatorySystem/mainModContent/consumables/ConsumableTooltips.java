package gliese832c.circulatorySystem.mainModContent.consumables;

import gliese832c.circulatorySystem.CirculatorySystem;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;
import gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry.Consumable;
import gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry.ConsumableStatusTrackerChangeData;
import gliese832c.circulatorySystem.mainModContent.consumables.consumablesRegistry.ConsumablesList;
import gliese832c.circulatorySystem.util.CirculatoryVariables.*;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import static gliese832c.circulatorySystem.util.StringProcessing.getValueColorizedPercentageConsumable;
import static gliese832c.circulatorySystem.util.StringProcessing.getValuePercentage;

@Mod.EventBusSubscriber
public class ConsumableTooltips {
    @SubscribeEvent
    public static void addTooltipToValidConsumables(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (!ConsumablesList.isValidConsumable(itemStack)) {
            return;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            event.getToolTip().add(FormattingCodes.BLUE + I18n.format("tooltip." + CirculatorySystem.MOD_ID + ".status_tracker_info"));
            Consumable consumable = ConsumablesList.getConsumableByResourceLocationAndMetadata(itemStack.getItem().getRegistryName().toString(), itemStack.getMetadata());
            for (ConsumableStatusTrackerChangeData consumableStatusTrackerChangeData : consumable.consumableStatusTrackerChangeData) {
                event.getToolTip().add(
                        "  " + FormattingCodes.AQUA + I18n.format(StatusTrackers.getSystemTypeFromKey(consumableStatusTrackerChangeData.key).chatInfoMessage) +
                        ": " + getValueColorizedPercentageConsumable(consumableStatusTrackerChangeData.amount)
                        + (consumableStatusTrackerChangeData.chance < 1.0 ? FormattingCodes.GRAY + " (" + I18n.format("tooltip." + CirculatorySystem.MOD_ID + ".chance") + ": " + FormattingCodes.WHITE + getValuePercentage(consumableStatusTrackerChangeData.chance) + FormattingCodes.GRAY + ")" : "")
                        + (consumableStatusTrackerChangeData.isRelative ? FormattingCodes.GRAY + " - " + I18n.format("tooltip." + CirculatorySystem.MOD_ID + ".is_relative") : ""));
            }
        } else {
            event.getToolTip().add(FormattingCodes.GRAY + "[" + I18n.format("tooltip." + CirculatorySystem.MOD_ID + ".hold_shift") + "]");
        }
    }
}
