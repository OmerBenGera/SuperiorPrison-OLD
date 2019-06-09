package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.utils.StringUtils;

public class MineSpawnButton extends MineButton {

    public MineSpawnButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(Material.COMPASS , 0, ""));
        updateItem();
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        mine.setSpawn(menu.getPlayer().getLocation());
    }

    @Override
    public void updateItem() {
        setItem(ItemUtils.build(Material.COMPASS, 0, "§e§lChange Spawn", "", "§7Value: §e" + StringUtils.locationToString(mine.getSpawn()), "", "§aClick to Edit"));
    }

}
