package xyz.wildseries.prison.gui.buttons.mines;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.types.mines.MinesAdminMenu;
import xyz.wildseries.prison.objects.mines.Mine;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class CreateMineButton extends Button {

    public CreateMineButton(MinesAdminMenu menu) {
        super(menu, ItemUtils.build(XMaterial.GOLD_INGOT, "§6§l+"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        new Mine();

        ((MinesAdminMenu) menu).update();
        ((MinesAdminMenu) menu).scrollToEnd();
    }

}
