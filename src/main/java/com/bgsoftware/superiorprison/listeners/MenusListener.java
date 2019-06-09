package com.bgsoftware.superiorprison.listeners;

import com.bgsoftware.superiorprison.gui.menus.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public final class MenusListener implements Listener {

    private final SuperiorPrisonPlugin plugin;

    public MenusListener(SuperiorPrisonPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Menu menu = plugin.getMenuManager().getMenu(event.getInventory());

        if (menu == null)
            return;

        menu.onClick(event);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onInventoryClose(InventoryCloseEvent event) {
        Menu menu = plugin.getMenuManager().getMenu(event.getInventory());

        if (menu == null)
            return;

        plugin.getMenuManager().removeMenu(menu);
    }
}
