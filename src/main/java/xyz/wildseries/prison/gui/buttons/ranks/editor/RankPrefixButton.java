package xyz.wildseries.prison.gui.buttons.ranks.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.ranks.RankButton;
import xyz.wildseries.prison.gui.menus.types.ranks.RankEditor;
import xyz.wildseries.prison.tasks.player.edit.ranks.RankPrefixEditTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

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
