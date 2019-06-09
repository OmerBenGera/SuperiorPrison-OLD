package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.tasks.player.edit.mine.MinePermissionEditTask;

public class MinePermissionButton extends MineButton {

    public MinePermissionButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(Material.IRON_FENCE, 0, "§e§lPermission", "", "§7Value: §e" + (menu.getMine().getPermission() == null ? "none" : menu.getMine().getPermission()), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new MinePermissionEditTask(SuperiorPrisonPlugin.getPlugin().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), mine).start();
    }
}
