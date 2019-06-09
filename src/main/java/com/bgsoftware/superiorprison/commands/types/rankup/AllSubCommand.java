package com.bgsoftware.superiorprison.commands.types.rankup;

import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.setup.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.commands.SubCommand;

public class AllSubCommand extends SubCommand {

    public AllSubCommand() {
        super(Permission.CMD_RANKUP, "all");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Prisoner prisoner = SuperiorPrisonPlugin.getPlugin().getManager().getPlayerManager().getPrisoner(player);

        int count = 0;
        while (prisoner.getNextRank() != null && prisoner.hasEnoughMoney(prisoner.getNextRank().getPrice())) {
            prisoner.rankup();
            count++;
        }

        Message.RANKUP_ALL.send(player, "count:" + count);
    }
}
