package xyz.wildseries.prison.commands;

import org.bukkit.command.CommandSender;

public class FruitSub extends SubCommand {

    public FruitSub() {
        super("fruit", "fruits");

        subs.add(new FruitSub());
    }

    @Override
    public boolean hasPermission(CommandSender sender) {
        return true;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("deee");
    }

}
