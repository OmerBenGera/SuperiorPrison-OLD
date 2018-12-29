package xyz.wildseries.prison.managers;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.objects.Prisoner;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
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
}
