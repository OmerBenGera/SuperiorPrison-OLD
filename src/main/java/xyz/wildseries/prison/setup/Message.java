package xyz.wildseries.prison.setup;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import sun.management.counter.perf.PerfLongArrayCounter;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.utils.PlaceholdersUtils;

@Getter
public enum Message {

    PREFIX("§e§lPrison §7"),
    ERROR("§c§lError §4"),

    CMD_MUST_BE_PLAYER(ERROR.firstLine() + "You must be a player to execute this commands."),
    CMD_NO_PERMISSION(ERROR.firstLine() + "You don't have permission to execute this commands."),
    CMD_INVALID_USAGE(ERROR.firstLine() + "Invalid Usage. Type §c%commands §4for help."),

    INPUT_ENTER(PREFIX.firstLine() + "Please enter §e%input §7in chat. type §eCANCEL §7to cancel the process."),
    INPUT_INVALID(ERROR.firstLine() + "Invalid Input. Reason: §c%reason§4. You can cancel the process by typing §cCANCEL§4."),
    INPUT_CANCELED(PREFIX.firstLine() + "Successfully cancelled the process."),

    RANKUP_INFO(PREFIX.firstLine() + "Rank Upgrade Information:", " §7Name: §e%name", " §7Price: §e$%price", " §7Your Money: §e$%balance"),
    RANKUP_CONFIRM(PREFIX.firstLine() + "Type §e/rankup confirm §7to upgrade your rank."),
    RANKUP_NOT_ENOUGH_MONEY(ERROR.firstLine() + "You don't have enough money to preform this action."),
    RANKUP_NO_RANK(ERROR.firstLine() + "You already have the highest rank."),
    RANKUP_ALL(PREFIX.firstLine() + "You ranked up §e%count §7times."),
    RANKUP_BROADCAST(PREFIX.firstLine() + "§e%name §7ranked up to §e%rank_name§7.");

    private String[] message;

    Message(String... message) {
        this.message = message;
    }

    public String firstLine() {
        return message[0];
    }

    public void send(CommandSender sender, String placeholders) {
        sender.sendMessage(PlaceholdersUtils.applyPlaceholders(message, placeholders));
    }

    public void send(CommandSender sender) {
        sender.sendMessage(message);
    }

    public void send(Prisoner prisoner, String placeholders) {
        send(prisoner.getPlayer(), placeholders);
    }

    public void send(Prisoner prisoner) {
        send(prisoner.getPlayer());
    }

    public void broadcast(String placeholders) {
        for (Player player : Bukkit.getOnlinePlayers())
            send(player, placeholders);
    }

    public void broadcast() {
        broadcast("");
    }
}
