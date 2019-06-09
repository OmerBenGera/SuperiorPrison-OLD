package com.bgsoftware.superiorprison.gui.buttons.general;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ExitButton extends Button {

    public ExitButton(Menu menu) {
        super(menu, ItemUtils.build(Material.STAINED_GLASS_PANE, 14, "§c§lExit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
    }
}
