package com.bgsoftware.superiorprison.objects.mines;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
//        List<Block> blocks = region.getBlocks();
//
//        for (BlockRate rate : rates) {
//            int amount = (int) ((rate.getRate() / 100.0) * blocks.size());
//
//            while (amount > 0) {
//                getAndRemove(blocks).setType(rate.getMaterial().parseMaterial());
//                amount--;
//            }
//        }
//
//        while (!blocks.isEmpty()) {
//            getAndRemove(blocks).setType(rates.get(0).getMaterial().parseMaterial());
//        }

//        region.resetPointer();
//        Block block = region.nextBlock();
//        while (block != null) {
//            block.setType(getRandomMaterial());
//            block = region.nextBlock();
//        }


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

//    private Material getRandomMaterial() {
//        return rates.get(ThreadLocalRandom.current().nextInt(rates.size())).getMaterial().parseMaterial();
//    }

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
}
