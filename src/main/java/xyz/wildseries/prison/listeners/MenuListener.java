package xyz.wildseries.prison.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.Menu;

public class MenuListener extends BaseListener {

    public MenuListener(SuperiorPrisonPlugin loader) {
        super(loader);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onInventoryClick(InventoryClickEvent event) {
        Menu menu = loader.getManager().getMenuManager().getMenu(event.getInventory());
        if (menu == null)
            return;
        menu.onClick(event);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onInventoryClose(InventoryCloseEvent event) {
        Menu menu = loader.getManager().getMenuManager().getMenu(event.getInventory());
        if (menu == null)
            return;
        loader.getManager().getMenuManager().removeMenu(menu);
    }
}
