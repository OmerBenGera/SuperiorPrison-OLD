package com.bgsoftware.superiorprison.objects.ranks;

import com.bgsoftware.superiorprison.utils.PlaceholdersUtils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

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
