package com.bgsoftware.superiorprison.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class ConfigUtils {

    public static HashMap<String, Object> getConfigSectionValue(Object o, boolean deep) {
        if (o == null) {
            return null;
        }
        Map<String, Object> map;
        if (o instanceof ConfigurationSection) {
            map = ((ConfigurationSection) o).getValues(deep);
        } else if (o instanceof Map) {
            map = (Map<String, Object>) o;
        } else {
            return null;
        }
        return new HashMap<>(map);
    }

    public static Map<String, Object> serializeVector(Vector vector) {
        Map<String, Object> map = new HashMap<>();

        map.put("x", vector.getX());
        map.put("y", vector.getY());
        map.put("z", vector.getZ());

        return map;
    }

    public static Vector deserializeVector(Map<String, Object> map) {
        double x = (double) map.get("x");
        double y = (double) map.get("y");
        double z = (double) map.get("z");

        return new Vector(x, y, z);
    }

    public static Map<String, Object> serializeLocation(Location location) {
        Map<String, Object> map = serializeVector(location.toVector());

        map.put("world", location.getWorld().getName());

        return map;
    }

    public static Location deserializeLocation(Map<String, Object> map) {
        Vector vector = deserializeVector(map);

        World world = Bukkit.getServer().getWorld((String) map.get("world"));

        return new Location(world, vector.getX(), vector.getY(), vector.getZ());

    }

}
