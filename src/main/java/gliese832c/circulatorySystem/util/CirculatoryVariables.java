package gliese832c.circulatorySystem.util;

import gliese832c.circulatorySystem.CirculatorySystem;
import net.minecraft.util.ResourceLocation;

public class CirculatoryVariables {
    public static final ResourceLocation tunnelVisionLevel1 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/tunnel_vision_1.png");
    public static final ResourceLocation tunnelVisionLevel2 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/tunnel_vision_2.png");
    public static final ResourceLocation tunnelVisionLevel3 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/tunnel_vision_3.png");
    public static final ResourceLocation tunnelVisionLevel4 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/tunnel_vision_4.png");
    public static final ResourceLocation tunnelVisionLevel5 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/tunnel_vision_5.png");
    public static final ResourceLocation tunnelVisionLevelNaN = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/tunnel_vision_nan.png");

    public static final ResourceLocation heartAttackLevel1 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/heart_attack_1.png");
    public static final ResourceLocation heartAttackLevel2 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/heart_attack_2.png");
    public static final ResourceLocation heartAttackLevel3 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/heart_attack_3.png");
    public static final ResourceLocation heartAttackLevel4 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/heart_attack_4.png");
    public static final ResourceLocation heartAttackLevel5 = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/heart_attack_5.png");
    public static final ResourceLocation heartAttackLevelNaN = new ResourceLocation(CirculatorySystem.MOD_ID, "textures/overlays/heart_attack_nan.png");


    public static class FormattingCodes {
        public static final String BLACK = "§0", DARK_BLUE = "§1", DARK_GREEN = "§2", DARK_AQUA = "§3",
                                    DARK_RED = "§4", DARK_PURPLE = "§5", GOLD = "§6", GRAY = "§7",
                                    DARK_GRAY = "§8", BLUE = "§9", GREEN = "§a", AQUA = "§b",
                                    RED = "§c", LIGHT_PURPLE = "§d", YELLOW = "§e", WHITE = "§f",

                                    UNDERLINE = "§u", BOLD = "§u", ITALIC = "§u", STRIKETHROUGH = "§u", OBFUSCATE = "§u", RESET = "§u";
    }
}
