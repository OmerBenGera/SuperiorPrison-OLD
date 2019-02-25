package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.gui.menus.Menu;
import lombok.Getter;
import org.bukkit.inventory.Inventory;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashSet;
import java.util.Set;

@Getter
public class MenuManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private Set<Menu> menus;

    public MenuManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @Override
    public void load() {
        menus = new HashSet<>();
    }

    @Override
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

}
