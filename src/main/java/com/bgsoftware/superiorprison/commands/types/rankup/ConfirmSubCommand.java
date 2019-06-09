package com.bgsoftware.superiorprison.commands.types.rankup;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.setup.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.commands.SubCommand;

public class ConfirmSubCommand extends SubCommand {

    public ConfirmSubCommand() {
        super(Permission.CMD_RANKUP, "confirm");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Prisoner prisoner = SuperiorPrisonPlugin.getPlugin().getManager().getPlayerManager().getPrisoner(player);
        Rank rank = prisoner.getNextRank();

        if (prisoner.hasEnoughMoney(rank.getPrice()))
            prisoner.rankup();
        else
            Message.RANKUP_NOT_ENOUGH_MONEY.send(player);

    }
}
