package xyz.wildseries.prison.gui.buttons.general;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class ReturnButton extends Button {

    private Menu previous;

    public ReturnButton(Menu menu, Menu previous) {
        super(menu, ItemUtils.build(XMaterial.LIGHT_BLUE_STAINED_GLASS_PANE, "§9§lGo Back"));
        this.previous = previous;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        previous.open();
    }
}
