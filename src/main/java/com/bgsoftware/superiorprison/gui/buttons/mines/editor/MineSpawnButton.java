package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.utils.StringUtils;

public class MineSpawnButton extends MineButton {

    public MineSpawnButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(XMaterial.COMPASS , ""));
        updateItem();
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        mine.setSpawn(menu.getPlayer().getLocation());
    }

    @Override
    public void updateItem() {
        setItem(ItemUtils.build(XMaterial.COMPASS, "§e§lChange Spawn", "", "§7Value: §e" + StringUtils.locationToString(mine.getSpawn()), "", "§aClick to Edit"));
    }

}
