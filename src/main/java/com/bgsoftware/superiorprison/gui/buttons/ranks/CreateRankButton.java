package com.bgsoftware.superiorprison.gui.buttons.ranks;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RanksAdminMenu;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.utils.ItemUtils;

public class CreateRankButton extends Button {

    public CreateRankButton(RanksAdminMenu menu) {
        super(menu, ItemUtils.build(Material.WRITTEN_BOOK, 0, "§6§l+"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        new Rank();

        ((RanksAdminMenu) menu).update();
        ((RanksAdminMenu) menu).scrollToEnd();
    }
}
