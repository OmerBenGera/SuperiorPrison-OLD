package com.bgsoftware.superiorprison.gui;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;

@Getter
public enum MenuItem {

    WHITE_BORDER(ItemUtils.build(XMaterial.WHITE_STAINED_GLASS_PANE, " "));

    private ItemStack item;

    MenuItem(ItemStack item) {
        this.item = item;
    }

    public void set(Inventory inventory, int slot) {
        inventory.setItem(slot, item.clone());
    }
}
