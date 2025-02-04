package com.bgsoftware.superiorprison.objects;

import com.bgsoftware.superiorprison.managers.RankManager;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.tasks.Task;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.configuration.PlayerFile;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.tasks.TaskFlag;

import java.util.*;

public class Prisoner implements ConfigurationSerializable {

    private UUID uuid;
    private PlayerFile file;

    private Rank rank;

    private Set<Task> tasks;

    public Prisoner(UUID uuid) {
        RankManager rankManager = SuperiorPrisonPlugin.getPlugin().getRankManager();

        this.uuid = uuid;
        file = new PlayerFile(uuid);
        rank = file.contains("rank") ?
                rankManager.getRank(UUID.fromString(file.getString("rank"))) :
                rankManager.getDefaultRank();
        tasks = new HashSet<>();

        SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPlayers().add(this);
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

        SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPlayers().remove(this);
    }

    public boolean hasTask(Class type) {
        for (Task task : tasks)
            if (task.getClass().equals(type))
                return true;
        return false;
    }

    public boolean hasTask(TaskFlag flag) {
        for (Task task : tasks)
            if (task.hasFlag(flag))
                return true;
        return false;
    }

    public void rankup() {
        takeMoney(getNextRank().getPrice());

        rank = getNextRank();

        Message.RANKUP_BROADCAST.broadcast("name:" + getPlayer().getName() + ",display_name:" + getPlayer().getDisplayName() + ",rank_name:" + rank.getName());
    }

    public Rank getNextRank() {
        return rank == null ? SuperiorPrisonPlugin.getPlugin().getRankManager().getDefaultRank() : rank.getNext();
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public boolean isOnline() {
        return getPlayer() != null;
    }

    public double getBalance() {
        return SuperiorPrisonPlugin.getEconomy().getBalance(getPlayer());
    }

    public boolean hasEnoughMoney(double amount) {
        return SuperiorPrisonPlugin.getEconomy().getBalance(getPlayer()) >= amount;
    }

    public void giveMoney(double amount) {
        SuperiorPrisonPlugin.getEconomy().depositPlayer(getPlayer(), amount);
    }

    public boolean takeMoney(double amount) {
        if (!hasEnoughMoney(amount))
            return false;

        SuperiorPrisonPlugin.getEconomy().withdrawPlayer(getPlayer(), amount);

        return true;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Rank getRank() {
        return rank;
    }
}
