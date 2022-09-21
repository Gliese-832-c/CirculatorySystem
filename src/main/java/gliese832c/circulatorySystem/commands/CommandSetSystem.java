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

import static gliese832c.circulatorySystem.util.StringProcessing.checkWhetherSystemTypeIsValid;

public class CommandSetSystem extends CommandBase {

    @Override
    public String getName() {
        return "circulatorysystem_set";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.circulatorysystem.circulatorysystem_set.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 2 || args.length == 3) {
            double value = 0d;
            try {
                value = Double.parseDouble(args[1]);
            } catch (NumberFormatException e) {
                throw new WrongUsageException(getUsage(sender), new Object[0]);
            }
            if (value < 0.0d || value > 1.0d) {
                getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.value_out_of_range")));
            } else {
                EntityPlayer player = args.length == 3 ? getPlayer(server, sender, args[2]) : getCommandSenderAsPlayer(sender);

                if (checkWhetherSystemTypeIsValid(args[0])) {
                    StatusTracker statusTracker = StatusTrackers.getSystemTypeFromKey(args[0]);
                    NBTHandler.setNBTdata(player, statusTracker.key, value);
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString("§a" + I18n.translateToLocal("chat.circulatorysystem.value_set")));
                } else {
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.value_null")));
                }
            }
        } else {
            throw new WrongUsageException(getUsage(sender), new Object[0]);
        }
    }
}
