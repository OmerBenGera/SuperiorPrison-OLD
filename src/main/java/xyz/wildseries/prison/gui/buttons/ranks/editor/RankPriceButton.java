package xyz.wildseries.prison.gui.buttons.ranks.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.ranks.RankButton;
import xyz.wildseries.prison.gui.menus.ranks.RankEditor;
import xyz.wildseries.prison.tasks.player.edit.ranks.RankPriceEditTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class RankPriceButton extends RankButton {

    public RankPriceButton(RankEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(XMaterial.PAPER, "§e§lChange Price", "", "§7Value: §e$" + menu.getRank().getPrice(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RankPriceEditTask(SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), rank).start();
    }
}
