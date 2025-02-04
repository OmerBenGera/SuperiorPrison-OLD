package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.objects.Prisoner;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class PlayerManager {

    private Set<Prisoner> players = new HashSet<>();

    public PlayerManager(SuperiorPrisonPlugin plugin) {
        for (Player player : Bukkit.getOnlinePlayers())
            new Prisoner(player.getUniqueId());
    }

    public void save() {
        for (Prisoner prisoner : new HashSet<>(players))
            prisoner.unload();
    }

    public Prisoner getPrisoner(UUID uuid) {
        for (Prisoner prisoner : players)
            if (prisoner.getUuid().equals(uuid))
                return prisoner;
        return new Prisoner(uuid);
    }

    public Prisoner getPrisoner(Player player) {
        return getPrisoner(player.getUniqueId());
    }

    public Set<Prisoner> getPlayers() {
        return players;
    }
}
