package com.bgsoftware.superiorprison.objects.mines;

import com.bgsoftware.superiorprison.managers.MineManager;
import com.bgsoftware.superiorprison.utils.ConfigUtils;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Mine implements ConfigurationSerializable {

    private UUID uuid;

    private String name;
    private String permission;

    private Location spawn;
    private Region region;

    private BlockGenerator blockGenerator;

    public Mine() {
        uuid = UUID.randomUUID();
        name = "#" + getManager().getMines().size();
        permission = "superiorprison.mine." + name;
        spawn = null;
        region = new Region();
        blockGenerator = new BlockGenerator();

        getManager().getMines().add(this);
    }

    @SuppressWarnings("unchecked")
    public Mine(Map<String, Object> map) {
        uuid = UUID.fromString((String) map.get("uuid"));
        name = (String) map.get("name");
        permission = (String) map.get("permission");
        spawn = map.containsKey("spawn") ? ConfigUtils.deserializeLocation((Map<String, Object>) map.get("spawn")) : null;
        region = map.containsKey("region") ? new Region((Map<String, Object>) map.get("region")) : new Region();
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
        if (region != null && region.isValid())
            map.put("region", region.serialize());
        map.put("generator", blockGenerator.serialize());

        return map;
    }

    public void remove() {
        getManager().getMines().remove(this);
    }

    public void reset() {
        if (region == null)
            return;

        blockGenerator.generate(region);
    }

    private static MineManager getManager() {
        return SuperiorPrisonPlugin.getPlugin().getMineManager();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public BlockGenerator getBlockGenerator() {
        return blockGenerator;
    }

    public String getName() {
        return name;
    }

    public void setSpawn(Location spawn) {
        this.spawn = spawn;
    }

    public Location getSpawn() {
        return spawn;
    }

    public String getPermission() {
        return permission;
    }

    public Region getRegion() {
        return region;
    }
}
