package xyz.wildseries.prison.objects.mines;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;
import xyz.wildseries.prison.utils.ConfigUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Region implements ConfigurationSerializable {

    private World world;

    private Vector a;
    private Vector b;

    public Region(World world, Vector a, Vector b) {
        initialize(world, a, b);
    }

    public Region() {
        this.world = null;
        this.a = null;
        this.b = null;
    }

    @SuppressWarnings("unchecked")
    public Region(Map<String, Object> map) {
        this(
                Bukkit.getServer().getWorld((String) map.get("world")),
                ConfigUtils.deserializeVector((Map<String, Object>) map.get("a")),
                ConfigUtils.deserializeVector((Map<String, Object>) map.get("b"))
        );
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("a", ConfigUtils.serializeVector(a));
        map.put("b", ConfigUtils.serializeVector(b));
        map.put("world", world.getName());

        return map;
    }

    @Override
    public String toString() {
        if (world == null || a == null || b == null)
            return "none";

        return world.getName() + ", " + a.getBlockX() + "," + a.getBlockY() + "," + a.getBlockZ() + ", " + b.getBlockX() + "," + b.getBlockY() + "," + b.getBlockZ();
    }

    public boolean isValid() {
        return world != null;
    }

    public void initialize(World world, Vector a, Vector b) {
        this.world = world;

        this.a = new Vector(
                a.getBlockX() < b.getBlockX() ? a.getBlockX() : b.getBlockX(),
                a.getBlockY() < b.getBlockY() ? a.getBlockY() : b.getBlockY(),
                a.getBlockZ() < b.getBlockZ() ? a.getBlockZ() : b.getBlockZ()
        );
        this.a = new Vector(
                a.getBlockX() < b.getBlockX() ? b.getBlockX() : a.getBlockX(),
                a.getBlockY() < b.getBlockY() ? b.getBlockY() : a.getBlockY(),
                a.getBlockZ() < b.getBlockZ() ? b.getBlockZ() : a.getBlockZ()
        );
    }

    public boolean isInLocation(Location location) {
        if (!location.getWorld().equals(world))
            return false;

        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();

        return a.getX() < x && b.getX() > x && a.getY() < y && b.getY() > y && a.getZ() < z && b.getZ() > z;
    }

    public boolean isInLocation(Block block) {
        return isInLocation(block.getLocation());
    }

    public boolean isInLocation(Entity entity) {
        return isInLocation(entity.getLocation());
    }

}
