package xyz.wildseries.prison.utils;

import org.bukkit.Location;

public class StringUtils {

    public static String locationToString(Location location) {
        if (location == null)
            return "none";
        return location.getWorld().getName() + ", " + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ();
    }

}
