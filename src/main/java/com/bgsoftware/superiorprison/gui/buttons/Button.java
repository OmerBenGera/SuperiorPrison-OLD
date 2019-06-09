package com.bgsoftware.superiorprison.gui.buttons;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import com.bgsoftware.superiorprison.gui.menus.Menu;

public abstract class Button {

    protected Menu menu;

    protected ItemStack item;

    public Button(Menu menu, ItemStack item) {
        this.menu = menu;
        this.item = item;
    }

    public abstract void onClick(InventoryClickEvent event);

    public void updateItem() {
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}
