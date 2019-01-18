package xyz.wildseries.prison.commands.types.mines;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.BaseCommand;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.setup.Permission;

public class MinesCommand extends BaseCommand {

    public MinesCommand(SuperiorPrisonPlugin plugin) {
        super(plugin, Permission.CMD_MINE, "mines", "mine");

        subs.add(new AdminSubCommand());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            Message.CMD_MUST_BE_PLAYER.send(sender);
            return;
        }

        Player player = (Player) sender;

        if (args.length == 1) {

            if (!executeNext(sender, args))
                Message.CMD_INVALID_USAGE.send(sender);

            return;
        }

        // TODO open normal menu

    }
}
