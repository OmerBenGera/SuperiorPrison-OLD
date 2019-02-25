package com.bgsoftware.superiorprison.commands.types.ranks;

import com.bgsoftware.superiorprison.commands.SubCommand;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RanksAdminMenu;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.setup.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
