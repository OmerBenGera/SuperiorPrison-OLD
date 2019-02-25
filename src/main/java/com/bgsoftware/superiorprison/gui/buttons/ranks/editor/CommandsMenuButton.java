package com.bgsoftware.superiorprison.gui.buttons.ranks.editor;

import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankCommandsEditor;

public class CommandsMenuButton extends RankButton {

    public CommandsMenuButton(RankEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(XMaterial.COMMAND_BLOCK, "§e§lEdit Commands"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RankCommandsEditor(menu.getPlayer(), rank).open();
    }
}
