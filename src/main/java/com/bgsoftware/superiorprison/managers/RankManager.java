package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.configuration.ConfigFile;
import com.bgsoftware.superiorprison.objects.ranks.Rank;

import java.util.*;

public final class RankManager{

    private SuperiorPrisonPlugin plugin;

    private Set<Rank> ranks = new HashSet<>();
    private Rank defaultRank;

    public RankManager(SuperiorPrisonPlugin plugin) {
        this.plugin = plugin;

        ConfigFile file = plugin.getFileManager().getRanksYaml();

        // Loading the ranks
        Map<Rank, String> nextMap = new HashMap<>();
        for (Map<?, ?> map : file.getBukkitConfig().getMapList("ranks"))
            nextMap.put(new Rank((Map<String, Object>) map), (String) map.get("next"));

        // Loading the ranks's next step
        for (Rank rank : nextMap.keySet())
            if (!nextMap.get(rank).equalsIgnoreCase("none"))
                rank.setNext(getRank(UUID.fromString(nextMap.get(rank))));

        // Loading the default ranks
        defaultRank = !file.getBukkitConfig().contains("default_rank") || file.getBukkitConfig().get("default_rank").equals("none") ?
                null :
                getRank(UUID.fromString(file.getBukkitConfig().getString("default_rank")));
    }

    public void save() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Rank rank : ranks)
            list.add(rank.serialize());

        ConfigFile file = plugin.getFileManager().getRanksYaml();

        file.getBukkitConfig().set("ranks", list);
        file.getBukkitConfig().set("default_rank", defaultRank == null ? "none" : defaultRank.getUuid().toString());
    }

    public List<Rank> listRanks() {
        List<Rank> list = new ArrayList<>();

        Rank rank = defaultRank;

        while (rank != null) {
            list.add(rank);
            rank = rank.getNext();
        }

        return list;
    }

    public Rank getRank(String name) {
        for (Rank rank : ranks)
            if (rank.getName().equalsIgnoreCase(name))
                return rank;
        return null;
    }

    public Rank getRank(UUID uuid) {
        for (Rank rank : ranks)
            if (rank.getUuid().equals(uuid))
                return rank;
        return null;
    }

    public void setDefaultRank(Rank defaultRank) {
        this.defaultRank = defaultRank;
    }

    public Rank getDefaultRank() {
        return defaultRank;
    }

    public Set<Rank> getRanks() {
        return ranks;
    }
}
