package com.bgsoftware.superiorprison.gui.buttons.general;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;

public abstract class ReturnButton extends Button {

    public ReturnButton(Menu menu) {
        super(menu, ItemUtils.build(Material.STAINED_GLASS_PANE, 3,"§9§lGo Back"));
    }

}
