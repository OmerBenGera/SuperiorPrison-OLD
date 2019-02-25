package com.bgsoftware.superiorprison.gui.buttons.mines;

import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MinesAdminMenu;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.objects.mines.Mine;

public class MineAdminDisplayButton extends MineButton {

    public MineAdminDisplayButton(MinesAdminMenu menu, Mine mine) {
        super(menu, mine, ItemUtils.build(XMaterial.IRON_INGOT, "§7§nMine:§e " + mine.getName(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case RIGHT:
                mine.remove();
                ((ListMenu) menu).update();
                break;
            case LEFT:
                new MineEditor(menu.getPlayer(), mine).open();
                break;
        }
    }
}
