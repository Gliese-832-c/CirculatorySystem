package gliese832c.circulatorySystem.commands;

import gliese832c.circulatorySystem.systems.NBTHandler;
import gliese832c.circulatorySystem.systems.SystemType;
import gliese832c.circulatorySystem.systems.SystemTypes;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

public class CommandReset extends CommandBase {

    @Override
    public String getName() {
        return "circulatorysystem_reset";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.circulatorysystem.circulatorysystem_reset.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0 || args.length == 1) {

            EntityPlayer player = args.length == 1 ? getPlayer(server, sender, args[0]) : getCommandSenderAsPlayer(sender);
            NBTHandler.resetAllSystemTypes(player);

            getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString("§e" + I18n.translateToLocal("chat.circulatorysystem.values_reset")));

        } else {
            throw new WrongUsageException(getUsage(sender), new Object[0]);
        }
    }
}
