package gliese832c.circulatorySystem.config;

import gliese832c.circulatorySystem.CirculatorySystem;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = CirculatorySystem.MOD_ID)
public class CirculatoryConfig {

    @Config.Comment("List of consumables and how they affect the player on consumption. (Requires restart.)")
    public static String[] consumablesList = new String[] {
            // Raw Meats
            "minecraft:porkchop|gastrointestinal:0.15:0.05:false",
            "minecraft:beef|gastrointestinal:0.1:0.02:false",
            "minecraft:chicken|gastrointestinal:0.3:0.15:false",
            "minecraft:rabbit|gastrointestinal:0.15:0.05:false",
            "minecraft:mutton|gastrointestinal:0.1:0.02:false",

            "minecraft:fish:0|gastrointestinal:0.05:0.01:false",
            "minecraft:fish:1|gastrointestinal:0.05:0.005:false",
            "minecraft:fish:2|gastrointestinal:0.1:0.02:false",
            "minecraft:fish:3|gastrointestinal:0.2:1.0:false|liver:0.2:1.0:false|brain:0.05:1.0:false",


            // Golden Foods
            "minecraft:golden_carrot|eyes:-0.005:1.0:true",
            "minecraft:golden_apple:0|brain,heart,liver,lungs,eyes,muscles,immune_system,gastrointestinal,obesity,sugar:-0.005:1.0:true",
            "minecraft:golden_apple:1|brain,heart,liver,lungs,eyes,muscles,immune_system,gastrointestinal,obesity,sugar:-0.05:1.0:true",


            // Others
            "minecraft:rotten_flesh|gastrointestinal:0.3:0.5:false|liver:0.25:0.25:false|brain:0.2:0.01:false",
            "minecraft:spider_eye|gastrointestinal:0.3:0.5:false|liver:0.25:0.25:false|brain:0.2:0.01:false",
            "minecraft:potato|gastrointestinal:0.05:0.1:false",
            "minecraft:poisonous_potato|gastrointestinal:0.25:0.1:false|liver:0.15:0.02:false|brain:0.05:0.001:false"
    };



    public static class ConfigHandler
    {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
        {
            if (event.getModID().equalsIgnoreCase(CirculatorySystem.MOD_ID))
            {
                ConfigManager.sync(CirculatorySystem.MOD_ID, Config.Type.INSTANCE);
            }
        }
    }
}
