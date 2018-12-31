package xyz.wildseries.prison.commands.types.rankup;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.SubCommand;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.ranks.Rank;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.setup.Permission;

public class ConfirmSubCommand extends SubCommand {

    public ConfirmSubCommand() {
        super(Permission.CMD_RANKUP, "confirm");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Prisoner prisoner = SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(player);
        Rank rank = prisoner.getNextRank();

        if (prisoner.hasEnoughMoney(rank.getPrice()))
            prisoner.rankup();
        else
            Message.RANKUP_NOT_ENOUGH_MONEY.send(player);

    }
}
