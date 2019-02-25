package xyz.wildseries.prison.gui.buttons.mines.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.mines.MineButton;
import xyz.wildseries.prison.gui.menus.types.mines.MineEditor;
import xyz.wildseries.prison.tasks.player.edit.mine.MineNameEditTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class MineNameButton extends MineButton {

    public MineNameButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(XMaterial.NAME_TAG, "§e§lChange Name", "", "§7Value: §e" + menu.getMine().getName(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new MineNameEditTask(SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), mine).start();
    }
}
