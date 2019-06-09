package com.bgsoftware.superiorprison.listeners;

import com.bgsoftware.superiorprison.gui.menus.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public class MenuListener extends BaseListener {

    public MenuListener(SuperiorPrisonPlugin loader) {
        super(loader);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Menu menu = loader.getMenuManager().getMenu(event.getInventory());
        if (menu == null)
            return;
        menu.onClick(event);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onInventoryClose(InventoryCloseEvent event) {
        Menu menu = loader.getMenuManager().getMenu(event.getInventory());
        if (menu == null)
            return;
        loader.getMenuManager().removeMenu(menu);
    }
}
