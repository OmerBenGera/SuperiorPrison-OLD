package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.tasks.player.edit.mine.MineNameEditTask;

public class MineNameButton extends MineButton {

    public MineNameButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(Material.NAME_TAG, 0, "§e§lChange Name", "", "§7Value: §e" + menu.getMine().getName(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new MineNameEditTask(SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPrisoner(menu.getPlayer()), mine).start();
    }
}
