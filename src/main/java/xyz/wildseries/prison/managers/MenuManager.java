package xyz.wildseries.prison.managers;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.Menu;

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
