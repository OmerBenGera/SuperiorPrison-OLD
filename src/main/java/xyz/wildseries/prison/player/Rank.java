package xyz.wildseries.prison.player;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Rank implements ConfigurationSerializable {

    private String id;
    private String prefix;

    private double price;

    private Rank next;

    public Rank(String id) {
        this.id = id;
        prefix = "[" + id + "]";
        price = 0;
        next = null;

        SuperiorPrisonPlugin.getInstance().getManager().getRankManager().getRanks().add(this);
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

    public boolean hasNext() {
        return next != null;
    }
}
