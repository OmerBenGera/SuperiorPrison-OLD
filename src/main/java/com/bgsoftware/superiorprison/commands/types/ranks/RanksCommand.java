package com.bgsoftware.superiorprison.commands.types.ranks;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.commands.BaseCommand;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RanksMenu;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.setup.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
