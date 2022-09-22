package gliese832c.circulatorySystem.commands;

import gliese832c.circulatorySystem.mainModContent.customEffects.effects.CustomEffectHeartAttack;
import gliese832c.circulatorySystem.mainModContent.customEffects.effects.CustomEffectNauseaBursts;
import gliese832c.circulatorySystem.mainModContent.customEffects.effects.CustomEffectTunnelVisionBursts;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CommandInduce extends CommandBase {

    @Override
    public String getName() {
        return "circulatorysystem_induce";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.circulatorysystem.circulatorysystem_induce.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 2 || args.length == 3) {

            EntityPlayer entityplayer = getPlayer(server, sender, args[0]);

            int level = 0;
            if (args.length == 3) {
                try {
                    level = Integer.parseInt(args[2]); }
                catch(Exception e) {
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(new TextComponentTranslation("commands.circulatorysystem.induce_level_integer").getFormattedText()));
                    return;
                }
                if (level < 1) {
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(new TextComponentTranslation("commands.circulatorysystem.induce_level_integer").getFormattedText()));
                    return;
                }
            }

            switch (args[1]) {
                case "heart_attack":
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(new TextComponentTranslation("commands.circulatorysystem.caused_heart_attack", entityplayer.getDisplayNameString()).getFormattedText()));
                    if (args.length == 3) { CustomEffectHeartAttack.causeHeartAttack(entityplayer, level); } else { CustomEffectHeartAttack.causeHeartAttack(entityplayer); }
                    break;
                case "tunnel_vision_burst":
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(new TextComponentTranslation("commands.circulatorysystem.caused_tunnel_vision_burst", entityplayer.getDisplayNameString()).getFormattedText()));
                    if (args.length == 3) { CustomEffectTunnelVisionBursts.causeTunnelVisionBurst(entityplayer, level); } else { CustomEffectTunnelVisionBursts.causeTunnelVisionBurst(entityplayer); }
                    break;
                case "nausea_burst":
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(new TextComponentTranslation("commands.circulatorysystem.caused_nausea_burst", entityplayer.getDisplayNameString()).getFormattedText()));
                    if (args.length == 3) { CustomEffectNauseaBursts.causeNauseaBurst(entityplayer, level); } else { CustomEffectNauseaBursts.causeNauseaBurst(entityplayer); }
                    break;
                case "all":
                    getCommandSenderAsPlayer(sender).sendMessage(new TextComponentString(new TextComponentTranslation("commands.circulatorysystem.caused_all", entityplayer.getDisplayNameString()).getFormattedText()));
                    if (args.length == 3) { CustomEffectHeartAttack.causeHeartAttack(entityplayer, level); } else { CustomEffectHeartAttack.causeHeartAttack(entityplayer); }
                    if (args.length == 3) { CustomEffectTunnelVisionBursts.causeTunnelVisionBurst(entityplayer, level); } else { CustomEffectTunnelVisionBursts.causeTunnelVisionBurst(entityplayer); }
                    if (args.length == 3) { CustomEffectNauseaBursts.causeNauseaBurst(entityplayer, level); } else { CustomEffectNauseaBursts.causeNauseaBurst(entityplayer); }
                    break;
            }
        } else {
            throw new WrongUsageException(getUsage(sender), new Object[0]);
        }
    }
}
