package xyz.wildseries.prison.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.setup.Permission;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommand extends SubCommand implements CommandExecutor, TabCompleter {

    public BaseCommand(SuperiorPrisonPlugin plugin, Permission permission, String... names) {
        super(permission, names);

        plugin.getCommand(names[0]).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        execute(sender, args);

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        SubCommand current = this;

        for (int i = 0; i < args.length; i++) {
            SubCommand sub = current.getSubCommand(args[i]);

            if (sub != null)
                current = sub;
            else
                break;
        }

        return current == null ? new ArrayList<>() : current.getCompletionOptions(sender, args[args.length - 1]);
    }
}
