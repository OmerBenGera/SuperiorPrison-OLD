package xyz.wildseries.prison.objects;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import xyz.wildseries.prison.utils.PlaceholdersUtils;

@Getter
@Setter
public class Command {

    private String command;

    public Command(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }

    public void execute(String placeholders) {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), PlaceholdersUtils.applyPlaceholders(new String[] {command}, placeholders)[0]);
    }
}
