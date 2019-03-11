package com.bgsoftware.superiorprison.objects.mines;

import com.bgsoftware.superiorprison.utils.XMaterial;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class BlockRate implements ConfigurationSerializable {

    private XMaterial material;
    private double rate;

    public BlockRate() {
        material = XMaterial.STONE;
        rate = 0;
    }

    public BlockRate(Map<String, Object> map) {
        material = XMaterial.valueOf((String) map.get("material"));
        rate = (double) map.get("rate");
    }

    public BlockRate(XMaterial material, double rate) {
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
}
