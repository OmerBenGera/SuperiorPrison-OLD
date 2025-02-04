package com.bgsoftware.superiorprison.objects.ranks;

import com.bgsoftware.superiorprison.managers.RankManager;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.*;

public class Rank implements ConfigurationSerializable {

    private UUID uuid;

    private String name;
    private String prefix;

    private double price;

    private Set<Command> commands;

    private Rank next;

    public Rank() {
        RankManager manager = SuperiorPrisonPlugin.getPlugin().getRankManager();
        List<Rank> ranks = manager.listRanks();

        uuid = UUID.randomUUID();
        name = "Rank #" + (ranks.size() + 1);
        prefix = "[" + name + "]";
        price = 0;
        next = null;
        commands = new HashSet<>();

        int count = 1;
        while (manager.getRank(name) != null) {
            name = "Rank #" + (ranks.size() + 1) + " (" + count + ")";
            count++;
        }

        if (manager.getDefaultRank() == null)
            manager.setDefaultRank(this);
        else
            ranks.get(ranks.size() - 1).setNext(this);

        manager.getRanks().add(this);
    }

    @SuppressWarnings("unchecked")
    public Rank(Map<String, Object> map) {
        uuid = UUID.fromString((String) map.get("uuid"));
        name = (String) map.get("name");
        prefix = (String) map.get("prefix");
        price = (double) map.get("price");
        commands = new HashSet<>();

        for (String s : (List<String>) map.get("commands"))
            commands.add(new Command(s));

        SuperiorPrisonPlugin.getPlugin().getRankManager().getRanks().add(this);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        List<String> commands = new ArrayList<>();
        for (Command command : this.commands)
            commands.add(command.toString());

        map.put("uuid", uuid.toString());
        map.put("name", name);
        map.put("prefix", prefix);
        map.put("price", price);
        map.put("next", hasNext() ? next.getUuid().toString() : "none");
        map.put("commands", commands);

        return map;
    }

    public void remove() {
        RankManager manager = SuperiorPrisonPlugin.getPlugin().getRankManager();
        List<Rank> ranks = manager.listRanks();

        boolean found = false;
        for (int i = 0; i < ranks.size(); i++) {
            Rank current = ranks.get(i);

            if (current.next != this)
                continue;

            found = true;
            current.next = next;
        }

        if (!found)
            manager.setDefaultRank(next);

        manager.getRanks().remove(this);
    }

    public boolean isHigherThan(Rank rank) {
        boolean found = false;

        while (rank != null) {

            if (rank.equals(this)) {
                found = true;
                break;
            }

            rank = rank.getNext();
        }

        return found;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Rank getNext() {
        return next;
    }

    public void setNext(Rank next) {
        this.next = next;
    }

    public UUID getUuid() {
        return uuid;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Set<Command> getCommands() {
        return commands;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
