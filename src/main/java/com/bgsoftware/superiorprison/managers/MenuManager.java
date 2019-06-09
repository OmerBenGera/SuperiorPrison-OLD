package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.gui.menus.Menu;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

public final class MenuManager {

    private Set<Menu> menus = new HashSet<>();

    public MenuManager() {

    }

    public void save() {
        for (Menu menu : menus)
            menu.close();
    }

    public void registerMenu(Menu menu) {
        menus.add(menu);
    }

    public void removeMenu(Menu menu) {
        menus.remove(menu);
    }

    public Menu getMenu(Inventory inventory) {
        for (Menu menu : menus)
            if (menu.getInventory().equals(inventory))
                return menu;
        return null;
    }

    public Set<Menu> getMenus() {
        return menus;
    }
}
