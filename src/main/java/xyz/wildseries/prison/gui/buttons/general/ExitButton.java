package xyz.wildseries.prison.gui.buttons.general;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class ExitButton extends Button {

    public ExitButton(Menu menu) {
        super(menu, ItemUtils.build(XMaterial.RED_STAINED_GLASS_PANE, "§c§lExit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
    }
}
