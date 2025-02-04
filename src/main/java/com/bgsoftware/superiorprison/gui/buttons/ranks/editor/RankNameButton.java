package com.bgsoftware.superiorprison.gui.buttons.ranks.editor;

import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.tasks.player.edit.ranks.RankNameEditTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public class RankNameButton extends RankButton {

    public RankNameButton(RankEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(Material.NAME_TAG, 0, "§e§lChange Name", "", "§7Value: §e" + menu.getRank().getName(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RankNameEditTask(SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPrisoner(menu.getPlayer()), rank).start();
    }
}
