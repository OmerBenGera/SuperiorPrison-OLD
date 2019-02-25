package com.bgsoftware.superiorprison.gui.buttons.ranks;

import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;

public class RankAdminDisplayButton extends RankButton {

    public RankAdminDisplayButton(Menu menu, Rank rank) {
        super(menu, rank, ItemUtils.build(XMaterial.BOOK, "§7§nRank:§e " + rank.getName(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case RIGHT:
                rank.remove();
                if (menu instanceof ListMenu)
                    ((ListMenu) menu).update();
                break;
            case LEFT:
                new RankEditor(menu.getPlayer(), rank).open();
                break;
        }
    }
}
