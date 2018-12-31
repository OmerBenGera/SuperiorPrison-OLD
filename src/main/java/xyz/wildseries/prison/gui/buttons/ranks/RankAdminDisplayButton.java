package xyz.wildseries.prison.gui.buttons.ranks;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.gui.menus.ranks.RankEditor;
import xyz.wildseries.prison.objects.ranks.Rank;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class RankAdminDisplayButton extends RankButton {

    public RankAdminDisplayButton(Menu menu, Rank rank) {
        super(menu, rank, ItemUtils.build(XMaterial.BOOK, "§7§nRank:§e " + rank.getName(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case RIGHT:
                rank.remove();
                if (menu instanceof ListMenu)
                    ((ListMenu) menu).update();
                break;
            case LEFT:
                new RankEditor(menu.getPlayer(), rank).open();
                break;
        }
    }
}
