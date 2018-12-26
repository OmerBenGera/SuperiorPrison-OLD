package xyz.wildseries.prison.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public abstract class SubCommand {

    protected String[] names;

    protected Set<SubCommand> subs;

    public SubCommand(String... names) {
        this.names = names;
        subs = new HashSet<>();
    }

    @SuppressWarnings("all")
    public List<String> getCompletionOptions(CommandSender sender, String message) {
        List<String> options = new ArrayList<>();

        for (SubCommand sub : subs) {
            if (!sub.hasPermission(sender))
                continue;

            for (String name : sub.names)
                options.add(name);
        }

        List<String> matches = new ArrayList<>();
        StringUtil.copyPartialMatches(message.toLowerCase(), options, matches);
        return matches;
    }

    private boolean isName(String name) {
        for (String s : names)
            if (s.equalsIgnoreCase(name))
                return true;
        return false;
    }

    private SubCommand getSubCommand(String name) {
        for (SubCommand sub : subs)
            if (sub.isName(name))
                return sub;
        return null;
    }

    public boolean executeNext(CommandSender sender, String[] args) {
        SubCommand sub = getSubCommand(args[0]);

        if (sub == null)
            return false;


        String[] newArgs = new String[args.length - 1];
        for (int i = 1; i < args.length; i++)
            newArgs[i - 1] = args[i];

        sub.execute(sender, newArgs);
        return true;
    }

    public abstract boolean hasPermission(CommandSender sender);

    public abstract void execute(CommandSender sender, String[] args);

}
