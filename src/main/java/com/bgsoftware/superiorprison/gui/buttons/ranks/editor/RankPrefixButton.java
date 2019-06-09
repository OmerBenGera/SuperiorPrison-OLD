package com.bgsoftware.superiorprison.gui.buttons.ranks.editor;

import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.tasks.player.edit.ranks.RankPrefixEditTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public class RankPrefixButton extends RankButton {

    public RankPrefixButton(RankEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(Material.NAME_TAG, 0, "§e§lChange Prefix", "", "§7Value: §e" + menu.getRank().getPrefix(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RankPrefixEditTask(SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPrisoner(menu.getPlayer()), rank).start();
    }
}
