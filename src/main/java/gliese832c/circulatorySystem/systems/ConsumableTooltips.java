package gliese832c.circulatorySystem.systems;

import gliese832c.circulatorySystem.CirculatorySystem;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.StringJoiner;

import static gliese832c.circulatorySystem.util.StringProcessing.getValueColorizedPercentageConsumable;

@Mod.EventBusSubscriber
public class ConsumableTooltips {
    @SubscribeEvent
    public static void addTooltipToValidConsumables(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();

        if (!ConsumablesList.isValidConsumable(itemStack)) {
            return;
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            Consumable consumable = ConsumablesList.getConsumableByResourceLocation(itemStack.getItem().getRegistryName().toString());
            for (ConsumableEffect consumableEffect : consumable.consumableEffects) {
                event.getToolTip().add("§b" + I18n.format(SystemTypes.getSystemTypeFromKey(consumableEffect.key).chatInfoMessage) + ": " + getValueColorizedPercentageConsumable(consumableEffect.amount) + (consumableEffect.isRelative ? "§7 - " + I18n.format("tooltip." + CirculatorySystem.MOD_ID + ".is_relative") : ""));
            }
        } else {
            event.getToolTip().add("§7[" + I18n.format("tooltip." + CirculatorySystem.MOD_ID + ".hold_shift") + "]");
        }
    }
}
