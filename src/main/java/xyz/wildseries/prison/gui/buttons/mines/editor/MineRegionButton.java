package xyz.wildseries.prison.gui.buttons.mines.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.mines.MineButton;
import xyz.wildseries.prison.gui.menus.types.mines.MineEditor;
import xyz.wildseries.prison.tasks.player.edit.mine.RegionTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

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
