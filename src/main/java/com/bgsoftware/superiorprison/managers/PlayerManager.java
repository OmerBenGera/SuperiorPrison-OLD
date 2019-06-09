package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.objects.Prisoner;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private Set<Prisoner> players;

    public PlayerManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @Override
    public void load() {
        players = new HashSet<>();

        for (Player player : Bukkit.getOnlinePlayers())
            new Prisoner(player.getUniqueId());
    }

    @Override
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
