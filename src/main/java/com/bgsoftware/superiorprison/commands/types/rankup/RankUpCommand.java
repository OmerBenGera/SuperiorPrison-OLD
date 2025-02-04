package com.bgsoftware.superiorprison.commands.types.rankup;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.commands.BaseCommand;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.setup.Permission;

public class RankUpCommand extends BaseCommand {

    public RankUpCommand(SuperiorPrisonPlugin plugin) {
        super(plugin, Permission.CMD_RANKUP, "rankup", "rankupgrade");

        subs.add(new ConfirmSubCommand());
        subs.add(new AllSubCommand());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player)) {
            Message.CMD_MUST_BE_PLAYER.send(sender);
            return;
        }

        Player player = (Player) sender;
        Prisoner prisoner = SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPrisoner(player);

        if (!permission.hasPermission(player)) {
            Message.CMD_NO_PERMISSION.send(player);
            return;
        }

        Rank rank = prisoner.getNextRank();

        if (rank == null) {
            Message.RANKUP_NO_RANK.send(player);
            return;
        }

        if (args.length > 0) {
            if (!executeNext(sender, args)) {
                Message.CMD_INVALID_USAGE.send(sender, "command:/prison help");
                return;
            }
            return;
        }

        Message.RANKUP_INFO.send(player, "name:" + rank.getName() + ",price:" + rank.getPrice() + ",balance:" + prisoner.getBalance());

        if (prisoner.hasEnoughMoney(rank.getPrice()))
            Message.RANKUP_CONFIRM.send(player);
        else
            Message.RANKUP_NOT_ENOUGH_MONEY.send(player);

    }
}
