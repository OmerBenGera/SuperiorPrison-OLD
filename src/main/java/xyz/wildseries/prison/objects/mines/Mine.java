package xyz.wildseries.prison.objects.mines;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.managers.MineManager;
import xyz.wildseries.prison.utils.ConfigUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class Mine implements ConfigurationSerializable {

    private UUID uuid;

    @Setter private String name;
    @Setter private String permission;

    @Setter private Location spawn;
    private Region region;

    private BlockGenerator blockGenerator;

    public Mine() {
        uuid = UUID.randomUUID();
        name = "#" + getManager().getMines().size();
        permission = "superiorprison.mine." + name;
        spawn = null;
        region = null;
        blockGenerator = new BlockGenerator();

        getManager().getMines().add(this);
    }

    @SuppressWarnings("unchecked")
    public Mine(Map<String, Object> map) {
        uuid = UUID.fromString((String) map.get("uuid"));
        name = (String) map.get("name");
        permission = (String) map.get("permission");
        spawn = map.containsKey("spawn") ? ConfigUtils.deserializeLocation((Map<String, Object>) map.get("spawn")) : null;
        region = map.containsKey("region") ? new Region((Map<String, Object>) map.get("region")) : null;
        blockGenerator = new BlockGenerator((List<Map<String, Object>>) map.get("generator"));

        getManager().getMines().add(this);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("uuid", uuid.toString());
        map.put("name", name);
        map.put("permission", permission);
        if (spawn != null)
            map.put("spawn", ConfigUtils.serializeLocation(spawn));
        if (region != null)
            map.put("region", region.serialize());
        map.put("generator", blockGenerator.serialize());

        return map;
    }

    public void remove() {
        getManager().getMines().remove(this);
    }

    private static MineManager getManager() {
        return SuperiorPrisonPlugin.getInstance().getManager().getMineManager();
    }

}
