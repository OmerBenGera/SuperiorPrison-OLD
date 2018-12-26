package xyz.wildseries.prison.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommand extends SubCommand implements CommandExecutor, TabCompleter {

    public BaseCommand(SuperiorPrisonPlugin plugin, String... names) {
        super(names);

        plugin.getCommand(names[0]).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        execute(sender, args);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {


        return null;
    }
}
