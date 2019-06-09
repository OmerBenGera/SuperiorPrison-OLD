package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.configuration.ConfigFile;
import com.bgsoftware.superiorprison.objects.ranks.Rank;

import java.util.*;

public class RankManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private Set<Rank> ranks;
    private Rank defaultRank;

    public RankManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void load() {
        ranks = new HashSet<>();

        ConfigFile file = loader.getManager().getFileManager().getRanksYaml();

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

    @Override
    public void save() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Rank rank : ranks)
            list.add(rank.serialize());

        ConfigFile file = loader.getManager().getFileManager().getRanksYaml();

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
