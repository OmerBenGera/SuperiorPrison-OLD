package xyz.wildseries.prison.player;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.managers.RankManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Rank implements ConfigurationSerializable {

    private String id;
    private String prefix;

    private double price;

    private Rank next;

    public Rank() {
        RankManager manager = SuperiorPrisonPlugin.getInstance().getManager().getRankManager();
        List<Rank> ranks = manager.listRanks();

        this.id = "Rank #" + (ranks.size() + 1);
        prefix = "[" + id + "]";
        price = 0;
        next = null;

        int count = 1;
        while (manager.getRank(id) != null) {
            id = "Rank #" + (ranks.size() + 1) + " (" + count + ")";
            count++;
        }

        if (manager.getDefaultRank() == null)
            manager.setDefaultRank(this);
        else
            ranks.get(ranks.size() - 1).setNext(this);

        manager.getRanks().add(this);
    }

    public Rank(Map<String, Object> map) {
        id = (String) map.get("id");
        prefix = (String) map.get("prefix");
        price = (double) map.get("price");

        SuperiorPrisonPlugin.getInstance().getManager().getRankManager().getRanks().add(this);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("prefix", prefix);
        map.put("price", price);
        map.put("next", hasNext() ? next.getId() : "~none");

        return map;
    }

    public void remove() {
        RankManager manager = SuperiorPrisonPlugin.getInstance().getManager().getRankManager();
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

    public boolean hasNext() {
        return next != null;
    }
}
