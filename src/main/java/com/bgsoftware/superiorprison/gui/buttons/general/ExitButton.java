package com.bgsoftware.superiorprison.gui.buttons.general;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ExitButton extends Button {

    public ExitButton(Menu menu) {
        super(menu, ItemUtils.build(XMaterial.RED_STAINED_GLASS_PANE, "§c§lExit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
    }
}
