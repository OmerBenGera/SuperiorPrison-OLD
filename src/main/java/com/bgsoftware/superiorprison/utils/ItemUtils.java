package com.bgsoftware.superiorprison.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    public static ItemStack build(Material material, int data) {
        return material == null ? null : new ItemStack(material, 1, (byte) data);
    }

    public static ItemStack build(Material material, int data, String name) {
        ItemStack item = build(material, data);
        ItemMeta meta = item.getItemMeta();

        meta.addItemFlags(ItemFlag.values());
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack build(Material material, int data, String name, String... lore) {
        ItemStack item = build(material, data, name);
        ItemMeta meta = item.getItemMeta();

        List<String> list = new ArrayList<>();
        for (String line : lore)
            list.add(line);
        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }

}
