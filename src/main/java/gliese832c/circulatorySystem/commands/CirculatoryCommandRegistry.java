package gliese832c.circulatorySystem.commands;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CirculatoryCommandRegistry {
    public static void registerCommands(FMLServerStartingEvent serverStartEvent) {
        serverStartEvent.registerServerCommand(new CommandSetSystem());
        serverStartEvent.registerServerCommand(new CommandGetSystem());
        serverStartEvent.registerServerCommand(new CommandGetSystemAll());
        serverStartEvent.registerServerCommand(new CommandReset());
        serverStartEvent.registerServerCommand(new CommandInduce());
    }
}
