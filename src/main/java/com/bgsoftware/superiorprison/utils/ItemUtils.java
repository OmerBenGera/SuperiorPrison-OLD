package com.bgsoftware.superiorprison.utils;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemUtils {

    public static ItemStack build(XMaterial material) {
        return material.parseItem();
    }

    public static ItemStack build(XMaterial material, String name) {
        ItemStack item = build(material);
        ItemMeta meta = item.getItemMeta();

        meta.addItemFlags(ItemFlag.values());
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack build(XMaterial material, String name, String... lore) {
        ItemStack item = build(material, name);
        ItemMeta meta = item.getItemMeta();

        List<String> list = new ArrayList<>();
        for (String line : lore)
            list.add(line);
        meta.setLore(list);
        item.setItemMeta(meta);

        return item;
    }

}
