package com.bgsoftware.superiorprison.gui;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import com.bgsoftware.superiorprison.utils.ItemUtils;

@Getter
public enum MenuItem {

    WHITE_BORDER(ItemUtils.build(Material.STAINED_GLASS_PANE, 0, " "));

    private ItemStack item;

    MenuItem(ItemStack item) {
        this.item = item;
    }

    public void set(Inventory inventory, int slot) {
        inventory.setItem(slot, item.clone());
    }
}
