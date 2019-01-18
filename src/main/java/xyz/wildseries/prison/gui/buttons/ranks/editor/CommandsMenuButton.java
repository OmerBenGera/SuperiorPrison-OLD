package xyz.wildseries.prison.gui.buttons.ranks.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.ranks.RankButton;
import xyz.wildseries.prison.gui.menus.types.ranks.RankCommandsEditor;
import xyz.wildseries.prison.gui.menus.types.ranks.RankEditor;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

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
