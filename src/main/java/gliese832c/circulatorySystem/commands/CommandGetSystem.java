package gliese832c.circulatorySystem.commands;

import gliese832c.circulatorySystem.statusTracking.StatusTrackers;
import gliese832c.circulatorySystem.util.NBTHandler;
import gliese832c.circulatorySystem.statusTracking.StatusTracker;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

import static gliese832c.circulatorySystem.util.StringProcessing.*;

public class CommandGetSystem extends CommandBase {

    @Override
    public String getName() {
        return "circulatorysystem_get";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.circulatorysystem.circulatorysystem_get.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 1 || args.length == 2) {

            EntityPlayer player = args.length == 2 ? getPlayer(server, sender, args[1]) : getCommandSenderAsPlayer(sender);

            double value = 0.0d;
            if (checkWhetherSystemTypeIsValid(args[0])) {
                value = NBTHandler.getNBTdata(player, args[0]);
                StatusTracker statusTracker = StatusTrackers.getSystemTypeFromKey(args[0]);
                getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(I18n.translateToLocal(statusTracker.chatInfoMessage) + ": " + getValueColorizedPercentage(value)));
            } else {
                getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.value_null")));
            }

        } else {
            throw new WrongUsageException(getUsage(sender), new Object[0]);
        }
    }
}
