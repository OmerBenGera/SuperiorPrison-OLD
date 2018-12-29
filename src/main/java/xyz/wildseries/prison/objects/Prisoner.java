package xyz.wildseries.prison.objects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.configuration.PlayerFile;
import xyz.wildseries.prison.managers.RankManager;
import xyz.wildseries.prison.tasks.Task;

import java.util.*;

@Getter
public class Prisoner implements ConfigurationSerializable {

    private UUID uuid;
    private PlayerFile file;

    private Rank rank;

    private Set<Task> tasks;

    public Prisoner(UUID uuid) {
        RankManager rankManager = SuperiorPrisonPlugin.getInstance().getManager().getRankManager();

        this.uuid = uuid;
        file = new PlayerFile(uuid);
        rank = file.contains("rank") ?
                rankManager.getRank(UUID.fromString(file.getString("rank"))) :
                rankManager.getDefaultRank();
        tasks = new HashSet<>();

        SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPlayers().add(this);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("rank", rank == null ? null : rank.getUuid().toString());

        return map;
    }

    public void unload() {
        for (Task task : tasks)
            task.end();

        file.setMap(serialize());
        file.save();

        SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPlayers().remove(this);
    }

    public Rank getNextRank() {
        return rank == null ? SuperiorPrisonPlugin.getInstance().getManager().getRankManager().getDefaultRank() : rank.getNext();
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public boolean isOnline() {
        return getPlayer() != null;
    }
}
