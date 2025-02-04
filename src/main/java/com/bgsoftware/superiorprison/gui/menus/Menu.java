package com.bgsoftware.superiorprison.gui.menus;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    protected Player player;

    protected Inventory inventory;

    private Map<Integer, Button> buttons;

    public Menu(Player player, int rows, String title) {
        this.player = player;
        inventory = Bukkit.createInventory(null, rows * 9, title);
        buttons = new HashMap<>();

        SuperiorPrisonPlugin.getPlugin().getMenuManager().registerMenu(this);
    }

    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);

        Inventory inv = null;
        try {
            inv = (Inventory) event.getClass().getDeclaredMethod("getClickedInventory").invoke(event);
        } catch (Exception e) {
            try {
                inv = (Inventory) event.getClass().getDeclaredMethod("getInventory").invoke(event);
            } catch (Exception ignored) {}
        }

        if (inv == null || !inv.equals(inventory))
            return;

        Button button = buttons.get(event.getSlot());
        if (button == null)
            return;

        button.onClick(event);

        buttons.keySet().forEach(key -> {
            buttons.get(key).updateItem();
            inventory.setItem(key, buttons.get(key).getItem());
        });

    }

    public void open() {
        player.openInventory(inventory);
    }

    public void close() {
        player.closeInventory();
        SuperiorPrisonPlugin.getPlugin().getMenuManager().removeMenu(this);
    }

    public void setButton(int slot, Button button) {
        if (button == null) {
            buttons.remove(slot);
            inventory.setItem(slot, null);
        } else {
            buttons.put(slot, button);
            inventory.setItem(slot, button.getItem());
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Player getPlayer() {
        return player;
    }
}
