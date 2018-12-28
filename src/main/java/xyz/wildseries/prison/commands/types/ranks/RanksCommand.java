package xyz.wildseries.prison.commands.types.ranks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.BaseCommand;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.setup.Permission;

public class RanksCommand extends BaseCommand {

    public RanksCommand(SuperiorPrisonPlugin plugin) {
        super(plugin, Permission.CMD_RANK ,"ranks", "ranks");

        subs.add(new AdminSubCommand());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            Message.CMD_MUST_BE_PLAYER.send(sender);
            return;
        }

        if (args.length == 1) {

            if (!executeNext(sender, args))
                Message.CMD_INVALID_USAGE.send(sender, "commands:/prison help");

            return;
        }

        // TODO open ranks menu

    }
}
