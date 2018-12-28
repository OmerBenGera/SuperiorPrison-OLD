package xyz.wildseries.prison.setup;

import lombok.Getter;
import org.bukkit.command.CommandSender;

@Getter
public enum Permission {

    CMD_RANK("superiorprison.commands.ranks.normal"),
    CMD_RANK_ADMIN("superiorprison.commands.ranks.admin");

    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission);
    }
}
