package xyz.wildseries.prison.gui.buttons.mines.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.mines.MineButton;
import xyz.wildseries.prison.gui.menus.types.mines.MineEditor;
import xyz.wildseries.prison.tasks.player.edit.mine.MinePermissionEditTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

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
