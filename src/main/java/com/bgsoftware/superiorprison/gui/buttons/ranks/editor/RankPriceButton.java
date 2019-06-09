package com.bgsoftware.superiorprison.gui.buttons.ranks.editor;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.tasks.player.edit.ranks.RankPriceEditTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RankPriceButton extends RankButton {

    public RankPriceButton(RankEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(Material.PAPER, 0, "§e§lChange Price", "", "§7Value: §e$" + menu.getRank().getPrice(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RankPriceEditTask(SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPrisoner(menu.getPlayer()), rank).start();
    }
}
