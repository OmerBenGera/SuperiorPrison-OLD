package xyz.wildseries.prison.setup;

import lombok.Getter;
import org.bukkit.command.CommandSender;
import xyz.wildseries.prison.utils.PlaceholdersUtils;

@Getter
public enum Message {

    PREFIX("§e§lPrison §e"),
    ERROR("§c§lError §4"),

    CMD_MUST_BE_PLAYER(ERROR.firstLine() + "You must be a player to execute this command."),
    CMD_NO_PERMISSION(ERROR.firstLine() + "You don't have permission to execute this command."),
    CMD_INVALID_USAGE(ERROR.firstLine() + "Invalid Usage. Type §c%command §4for help.");

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
}
