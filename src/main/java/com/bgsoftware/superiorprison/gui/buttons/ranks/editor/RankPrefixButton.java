package com.bgsoftware.superiorprison.gui.buttons.ranks.editor;

import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.tasks.player.edit.ranks.RankPrefixEditTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public class RankPrefixButton extends RankButton {

    public RankPrefixButton(RankEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(XMaterial.NAME_TAG, "§e§lChange Prefix", "", "§7Value: §e" + menu.getRank().getPrefix(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RankPrefixEditTask(SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), rank).start();
    }
}
