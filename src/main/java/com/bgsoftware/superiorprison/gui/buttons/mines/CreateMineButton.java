package com.bgsoftware.superiorprison.gui.buttons.mines;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MinesAdminMenu;
import com.bgsoftware.superiorprison.objects.mines.Mine;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CreateMineButton extends Button {

    public CreateMineButton(MinesAdminMenu menu) {
        super(menu, ItemUtils.build(XMaterial.GOLD_INGOT, "§6§l+"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        new Mine();

        ((MinesAdminMenu) menu).update();
        ((MinesAdminMenu) menu).scrollToEnd();
    }

}
