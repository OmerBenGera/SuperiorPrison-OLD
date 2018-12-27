package xyz.wildseries.prison.managers;

import lombok.Getter;
import lombok.Setter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.configuration.ConfigFile;
import xyz.wildseries.prison.player.Rank;

import java.util.*;

@Getter
public class RankManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private Set<Rank> ranks;
    @Setter private Rank defaultRank;

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

        // Loading the rank's next step
        for (Rank rank : nextMap.keySet())
            rank.setNext(getRank(nextMap.get(rank)));

        // Loading the default rank
        defaultRank = getRank(file.getBukkitConfig().getString("default_rank"));
    }

    @Override
    public void save() {

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
            if (rank.getId().equalsIgnoreCase(name))
                return rank;
        return null;
    }

}
