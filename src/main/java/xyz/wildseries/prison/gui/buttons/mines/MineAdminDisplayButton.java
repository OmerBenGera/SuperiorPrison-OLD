package xyz.wildseries.prison.gui.buttons.mines;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.gui.menus.types.mines.MineEditor;
import xyz.wildseries.prison.gui.menus.types.mines.MinesAdminMenu;
import xyz.wildseries.prison.objects.mines.Mine;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class MineAdminDisplayButton extends MineButton {

    public MineAdminDisplayButton(MinesAdminMenu menu, Mine mine) {
        super(menu, mine, ItemUtils.build(XMaterial.IRON_INGOT, "§7§nMine:§e " + mine.getName(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case RIGHT:
                mine.remove();
                ((ListMenu) menu).update();
                break;
            case LEFT:
                new MineEditor(menu.getPlayer(), mine).open();
                break;
        }
    }
}
