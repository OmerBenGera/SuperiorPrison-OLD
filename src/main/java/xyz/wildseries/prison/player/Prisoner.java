package xyz.wildseries.prison.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Prisoner {

    private UUID uuid;
    private Player player;

    public Prisoner(UUID uuid) {
        this.uuid = uuid;
        player = Bukkit.getPlayer(uuid);

    }

}
