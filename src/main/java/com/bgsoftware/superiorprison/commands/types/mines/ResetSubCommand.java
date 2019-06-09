package com.bgsoftware.superiorprison.commands.types.mines;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.commands.SubCommand;
import com.bgsoftware.superiorprison.objects.mines.Mine;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.setup.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetSubCommand extends SubCommand {

    public ResetSubCommand() {
        super(Permission.CMD_MINE_RESET, "reset");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;

        if (!Permission.CMD_MINE_RESET.hasPermission(player)) {
            Message.CMD_NO_PERMISSION.send(player);
            return;
        }

        player.sendMessage("loading");
        for (Mine mine : SuperiorPrisonPlugin.getPlugin().getMineManager().getMines()) {
            mine.reset();
        }
        player.sendMessage("done");

    }
}
