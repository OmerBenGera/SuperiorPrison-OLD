package com.bgsoftware.superiorprison.gui.buttons.mines;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MinesAdminMenu;
import com.bgsoftware.superiorprison.objects.mines.Mine;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CreateMineButton extends Button {

    public CreateMineButton(MinesAdminMenu menu) {
        super(menu, ItemUtils.build(Material.GOLD_INGOT, 0, "§6§l+"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        new Mine();

        ((MinesAdminMenu) menu).update();
        ((MinesAdminMenu) menu).scrollToEnd();
    }

}
