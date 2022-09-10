package gliese832c.circulatorySystem.commands;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandHandler {
    public static void registerCommands(FMLServerStartingEvent serverStartEvent) {
        serverStartEvent.registerServerCommand(new CommandSetSystem());
        serverStartEvent.registerServerCommand(new CommandGetSystem());
        serverStartEvent.registerServerCommand(new CommandGetSystemAll());
        serverStartEvent.registerServerCommand(new CommandReset());
    }
}
