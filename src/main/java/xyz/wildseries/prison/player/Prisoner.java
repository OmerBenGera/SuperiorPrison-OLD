package xyz.wildseries.prison.player;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.tasks.Task;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class Prisoner {

    private UUID uuid;

    private Set<Task> tasks;

    public Prisoner(UUID uuid) {
        this.uuid = uuid;
        tasks = new HashSet<>();

        SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPlayers().add(this);
    }

    public void unload() {
        for (Task task : tasks)
            task.end();

        SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPlayers().remove(this);
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public boolean isOnline() {
        return getPlayer() != null;
    }

}
