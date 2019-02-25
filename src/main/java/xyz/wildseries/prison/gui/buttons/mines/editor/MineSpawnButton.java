package xyz.wildseries.prison.gui.buttons.mines.editor;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.mines.MineButton;
import xyz.wildseries.prison.gui.menus.types.mines.MineEditor;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.StringUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class MineSpawnButton extends MineButton  {

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
