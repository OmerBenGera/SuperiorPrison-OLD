package xyz.wildseries.prison.setup;

import lombok.Getter;
import org.bukkit.command.CommandSender;

@Getter
public enum Permission {

    ;

    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission);
    }
}
