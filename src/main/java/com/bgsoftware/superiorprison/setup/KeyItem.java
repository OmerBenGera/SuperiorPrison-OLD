package com.bgsoftware.superiorprison.setup;

import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum KeyItem {

    REGION_TOOL(ItemUtils.build(Material.GOLD_AXE, 0, "§6Region Tool")),
    BTN_CONFIRM(ItemUtils.build(Material.STAINED_GLASS_PANE, 5, "§aConfirm")),
    BTN_CANCEL(ItemUtils.build(Material.STAINED_GLASS_PANE, 14, "§cCancel"));

    private ItemStack item;

    KeyItem(ItemStack item) {
        this.item = item;
    }

    public boolean isSimilar(ItemStack item) {
        return this.item.isSimilar(item);
    }

    public ItemStack getItem() {
        return item.clone();
    }

    public static KeyItem idenfiy(ItemStack item) {
        for (KeyItem key : values())
            if (key.isSimilar(item))
                return key;
        return null;
    }
}
