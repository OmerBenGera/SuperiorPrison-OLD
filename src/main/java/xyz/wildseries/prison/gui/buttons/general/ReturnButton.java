package xyz.wildseries.prison.gui.buttons.general;

import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public abstract class ReturnButton extends Button {

    public ReturnButton(Menu menu) {
        super(menu, ItemUtils.build(XMaterial.LIGHT_BLUE_STAINED_GLASS_PANE, "§9§lGo Back"));
    }

}
