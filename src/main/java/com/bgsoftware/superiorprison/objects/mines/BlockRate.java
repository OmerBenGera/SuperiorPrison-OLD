package com.bgsoftware.superiorprison.objects.mines;

import org.bukkit.Material;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class BlockRate implements ConfigurationSerializable {

    private Material material;
    private double rate;

    public BlockRate() {
        material = Material.STONE;
        rate = 0;
    }

    public BlockRate(Map<String, Object> map) {
        material = Material.valueOf((String) map.get("material"));
        rate = (double) map.get("rate");
    }

    public BlockRate(Material material, double rate) {
        this.material = material;
        this.rate = rate;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("material", material.toString());
        map.put("rate", rate);

        return map;
    }

    public Material getMaterial() {
        return material;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
