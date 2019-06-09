package com.bgsoftware.superiorprison.setup;

import org.bukkit.command.CommandSender;

public enum Permission {

    CMD_RANK("superiorprison.commands.ranks.normal"),
    CMD_RANK_ADMIN("superiorprison.commands.ranks.admin"),

    CMD_MINE("superiorprison.commands.mines.normal"),
    CMD_MINE_RESET("superiorprison.commands.mines.reset"),
    CMD_MINE_ADMIN("superiorprison.commands.mines.admin"),

    CMD_RANKUP("superiorprison.commands.rankup");

    private String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(permission);
    }

    public String getPermission() {
        return permission;
    }
}
