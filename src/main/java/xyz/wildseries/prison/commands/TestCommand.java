package xyz.wildseries.prison.commands;

import org.bukkit.command.CommandSender;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

public class TestCommand extends BaseCommand {

    public TestCommand(SuperiorPrisonPlugin plugin) {
        super(plugin, "test");

    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return true;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(new String[] {"Usages:", "/test fruit <name>", "/test vegetable <name>"});
            return;
        }

        executeNext(sender, args);

    }

}