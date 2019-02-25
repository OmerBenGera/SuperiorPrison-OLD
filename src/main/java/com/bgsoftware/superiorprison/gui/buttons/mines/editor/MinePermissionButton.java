package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.tasks.player.edit.mine.MinePermissionEditTask;

public class MinePermissionButton extends MineButton {

    public MinePermissionButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(XMaterial.IRON_BARS, "§e§lPermission", "", "§7Value: §e" + (menu.getMine().getPermission() == null ? "none" : menu.getMine().getPermission()), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new MinePermissionEditTask(SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), mine).start();
    }
}
