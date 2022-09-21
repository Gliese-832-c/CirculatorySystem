package gliese832c.circulatorySystem.item;

import java.util.List;

import javax.annotation.Nullable;

import gliese832c.circulatorySystem.util.codeThatIstoleFromNuclearCraft.InfoHelper;
import gliese832c.circulatorySystem.util.codeThatIstoleFromNuclearCraft.StackHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.*;

public class ItemMeta<T extends Enum<T> & IStringSerializable & IMetaEnum> extends Item implements IInfoItem {

    private final Class<T> enumm;
    public final T[] values;

    public final TextFormatting infoColor;
    private final String[][] tooltips;
    public String[][] info;



    public String specialProperty = "";



    public ItemMeta(Class<T> enumm, String specialProperty, TextFormatting infoColor, String[]... tooltips) {
        setHasSubtypes(true);
        this.enumm = enumm;
        values = enumm.getEnumConstants();
        this.specialProperty = specialProperty;
        this.infoColor = infoColor;
        this.tooltips = tooltips;
    }

    public ItemMeta(Class<T> enumm, String specialProperty, String[]... tooltips) {
        this(enumm, specialProperty, TextFormatting.AQUA, tooltips);
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            for (int i = 0; i < values.length; ++i) {
                items.add(new ItemStack(this, 1, i));
            }
        }
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        for (int i = 0; i < values.length; ++i) {
            if (StackHelper.getMetadata(stack) == i) {
                return getTranslationKey() + "." + values[i].getName();
            }
        }
        return getTranslationKey() + "." + values[0].getName();
    }

    @Override
    public void setInfo() {
        info = InfoHelper.buildInfo(getTranslationKey(), enumm, tooltips);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flag) {
        super.addInformation(stack, world, tooltip, flag);
        int meta = StackHelper.getMetadata(stack);
        if (info.length > meta) {
            InfoHelper.infoFull(tooltip, TextFormatting.RED, InfoHelper.EMPTY_ARRAY, infoColor, info[meta]);
        }
    }

    protected ActionResult<ItemStack> actionResult(boolean success, ItemStack stack) {
        return new ActionResult<>(success ? EnumActionResult.SUCCESS : EnumActionResult.FAIL, stack);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (specialProperty.equals("pill")) {
            //if (enumm == ItemEnums.PillType.class) {
            if (ItemEnums.PillType.class.isAssignableFrom(enumm)) {
                return  I18n.translateToLocal("chem.circulatorysystem." + this.enumm.getEnumConstants()[stack.getMetadata()] + ".name") + " " + I18n.translateToLocal("item.circulatorysystem.pill.name").trim();
            } else {
                return "§cYou should not be reading this! If you are, something went wrong in the code. Send a bug report to the developer of CirculatorySystem.";
            }
        } else {
            // This is just the regular code
            return I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name").trim();
        }
    }
}