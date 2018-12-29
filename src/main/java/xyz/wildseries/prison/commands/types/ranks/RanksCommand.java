package xyz.wildseries.prison.commands.types.ranks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.BaseCommand;
import xyz.wildseries.prison.gui.menus.ranks.RanksMenu;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.setup.Permission;

public class RanksCommand extends BaseCommand {

    public RanksCommand(SuperiorPrisonPlugin plugin) {
        super(plugin, Permission.CMD_RANK ,"ranks", "rank");

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
                Message.CMD_INVALID_USAGE.send(sender, "commands:/prison help");

            return;
        }

        new RanksMenu(player).open();

    }
}
