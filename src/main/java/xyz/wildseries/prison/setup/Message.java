package xyz.wildseries.prison.setup;

import lombok.Getter;
import org.bukkit.command.CommandSender;
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
    INPUT_CANCELED(PREFIX.firstLine() + "Successfully cancelled the process.");

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
}
