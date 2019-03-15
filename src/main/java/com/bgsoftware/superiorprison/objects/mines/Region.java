package com.bgsoftware.superiorprison.objects.mines;

import com.bgsoftware.superiorprison.utils.ConfigUtils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.*;

@Getter
@Setter
public class Region implements ConfigurationSerializable {

    private World world;

    private Vector a;
    private Vector b;

    private int currentX;
    private int currentY;
    private int currentZ;

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
                Math.min(a.getBlockX(), b.getBlockX()),
                Math.min(a.getBlockY(), b.getBlockY()),
                Math.min(a.getBlockZ(), b.getBlockZ())
        );
        this.b = new Vector(
                Math.max(a.getBlockX(), b.getBlockX()),
                Math.max(a.getBlockY(), b.getBlockY()),
                Math.max(a.getBlockZ(), b.getBlockZ())
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

    public List<Block> getBlocks() {
        List<Block> blocks = new ArrayList<>();
        for (int x = a.getBlockX(); x <= b.getBlockX(); x++) {
            for (int y = a.getBlockY(); y <= b.getBlockY(); y++) {
                for (int z = a.getBlockZ(); z <= b.getBlockZ(); z++) {
                    blocks.add(world.getBlockAt(x, y, z));
                }
            }
        }

        return blocks;
    }

    public void resetPointer() {
        currentX = a.getBlockX();
        currentY = a.getBlockY();
        currentZ = a.getBlockZ();
    }

    public Block nextBlock() {

        int x = currentX;
        int y = currentY;
        int z = currentZ;

        boolean out = isPointerOutOfBounds();

        currentX++;

        if (currentX > b.getBlockX()) {
            currentY++;
            currentX = a.getBlockX();
        }

        if (currentY > b.getBlockY()) {
            currentZ++;
            currentY = a.getBlockY();
        }

        return out ? null : world.getBlockAt(x, y, z);
    }

    public int getVolume() {
        int xScale = b.getBlockX() - a.getBlockX() + 1;
        int yScale = b.getBlockY() - a.getBlockY() + 1;
        int zScale = b.getBlockZ() - a.getBlockZ() + 1;

        return xScale * yScale * zScale;
    }

    public boolean isPointerOutOfBounds() {
        return currentZ > b.getBlockZ();
    }

    public boolean isInLocation(Block block) {
        return isInLocation(block.getLocation());
    }

    public boolean isInLocation(Entity entity) {
        return isInLocation(entity.getLocation());
    }

}
