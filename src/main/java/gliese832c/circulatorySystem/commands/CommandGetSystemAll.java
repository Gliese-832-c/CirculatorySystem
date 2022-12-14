package gliese832c.circulatorySystem.commands;

import gliese832c.circulatorySystem.util.NBTHandler;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTrackers;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

import static gliese832c.circulatorySystem.util.StringProcessing.getValueColorizedPercentage;

public class CommandGetSystemAll extends CommandBase {

    @Override
    public String getName() {
        return "circulatorysystem_getall";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.circulatorysystem.circulatorysystem_getall.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0 || args.length == 1) {

            EntityPlayer player = args.length == 1 ? getPlayer(server, sender, args[0]) : getCommandSenderAsPlayer(sender);

            double value = 0.0d;
            for (StatusTracker statusTracker : StatusTrackers.statusTrackers) {
                value = NBTHandler.getNBTdata(player, statusTracker.key);
                getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(I18n.translateToLocal(statusTracker.chatInfoMessage) + ": " + getValueColorizedPercentage(value)));
            }

        } else {
            throw new WrongUsageException(getUsage(sender), new Object[0]);
        }
    }
}
