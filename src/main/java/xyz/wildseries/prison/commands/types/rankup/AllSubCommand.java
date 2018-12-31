package xyz.wildseries.prison.commands.types.rankup;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.SubCommand;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.setup.Permission;

public class AllSubCommand extends SubCommand {

    public AllSubCommand() {
        super(Permission.CMD_RANKUP, "all");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        Prisoner prisoner = SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(player);

        int count = 0;
        while (prisoner.getNextRank() != null && prisoner.hasEnoughMoney(prisoner.getNextRank().getPrice())) {
            prisoner.rankup();
            count++;
        }

        Message.RANKUP_ALL.send(player, "count:" + count);
    }
}
