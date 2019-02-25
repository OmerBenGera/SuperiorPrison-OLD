package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.gui.buttons.mines.MineButton;
import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.tasks.player.edit.mine.RegionTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public class MineRegionButton extends MineButton {

    public MineRegionButton(MineEditor menu) {
        super(menu, menu.getMine(), ItemUtils.build(XMaterial.GOLDEN_AXE, "§e§lChange Region", "", "§7Value: §e" + menu.getMine().getRegion().toString(), "", "§aClick to Edit"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new RegionTask(mine.getRegion(), SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer())).start();
    }

}
