package com.bgsoftware.superiorprison.gui.buttons.general;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;

public abstract class ReturnButton extends Button {

    public ReturnButton(Menu menu) {
        super(menu, ItemUtils.build(XMaterial.LIGHT_BLUE_STAINED_GLASS_PANE, "§9§lGo Back"));
    }

}
