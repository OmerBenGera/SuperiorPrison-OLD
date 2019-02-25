package com.bgsoftware.superiorprison.objects.mines;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class BlockGenerator {

    private List<BlockRate> rates;

    public BlockGenerator() {
        rates = new ArrayList<>();
    }

    public BlockGenerator(List<Map<String, Object>> list) {
        rates = new ArrayList<>();

        for (Map<String, Object> map : list)
            rates.add(new BlockRate(map));
    }

    public List<Map<String, Object>> serialize() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (BlockRate rate : rates)
            list.add(rate.serialize());

        return list;
    }

    public void generate(Region region) {
        // TODO
    }
}
