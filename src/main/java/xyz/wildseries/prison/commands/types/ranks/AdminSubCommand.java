package xyz.wildseries.prison.commands.types.ranks;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.commands.SubCommand;
import xyz.wildseries.prison.gui.menus.ranks.RanksAdminMenu;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.setup.Permission;

public class AdminSubCommand extends SubCommand {

    public AdminSubCommand() {
        super(Permission.CMD_RANK_ADMIN, "admin");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (!Permission.CMD_RANK_ADMIN.hasPermission(player)) {
            Message.CMD_NO_PERMISSION.send(player);
            return;
        }

        new RanksAdminMenu(player).open();
    }
}
