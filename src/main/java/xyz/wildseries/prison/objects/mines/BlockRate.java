package xyz.wildseries.prison.objects.mines;

import lombok.Getter;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import xyz.wildseries.prison.utils.XMaterial;

import java.util.HashMap;
import java.util.Map;

@Getter
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

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();

        map.put("material", material.toString());
        map.put("rate", rate);

        return map;
    }
}
