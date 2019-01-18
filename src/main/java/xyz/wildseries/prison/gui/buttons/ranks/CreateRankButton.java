package xyz.wildseries.prison.gui.buttons.ranks;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.types.ranks.RanksAdminMenu;
import xyz.wildseries.prison.objects.ranks.Rank;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class CreateRankButton extends Button {

    public CreateRankButton(RanksAdminMenu menu) {
        super(menu, ItemUtils.build(XMaterial.WRITABLE_BOOK, "§6§l+"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        new Rank();

        ((RanksAdminMenu) menu).update();
        ((RanksAdminMenu) menu).scrollToEnd();
    }
}
