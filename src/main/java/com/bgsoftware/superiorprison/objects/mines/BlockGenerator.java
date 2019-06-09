package com.bgsoftware.superiorprison.objects.mines;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        List<Material> materials = new ArrayList<>();
        int volume = region.getVolume();

        for (BlockRate rate : rates) {
            Material material = rate.getMaterial();
            int amount = (int) ((rate.getRate() / 100.0) * volume);
            for (int i = 0; i < amount; i++) {
                materials.add(material);
            }
        }

        Collections.shuffle(materials);

        region.resetPointer();
        for (Material material : materials) {
            region.nextBlock().setType(material);
        }
    }

    public double getSolidPercent(BlockRate... ignore) {
        List<BlockRate> ignoreList = Arrays.asList(ignore);

        double total = 0;
        for (BlockRate rate : rates) {
            if (ignoreList.contains(rate))
                continue;

            total += rate.getRate();
        }

        return total;
    }

    private static Block getAndRemove(List<Block> blocks) {
        Block block = blocks.get(ThreadLocalRandom.current().nextInt(blocks.size()));
        blocks.remove(block);
        return block;
    }

    public List<BlockRate> getRates() {
        return rates;
    }
}
