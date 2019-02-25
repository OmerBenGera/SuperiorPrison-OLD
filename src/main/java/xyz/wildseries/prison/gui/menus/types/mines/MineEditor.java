package xyz.wildseries.prison.gui.menus.types.mines;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.general.ReturnButton;
import xyz.wildseries.prison.gui.buttons.mines.editor.MineNameButton;
import xyz.wildseries.prison.gui.buttons.mines.editor.MinePermissionButton;
import xyz.wildseries.prison.gui.buttons.mines.editor.MineRegionButton;
import xyz.wildseries.prison.gui.buttons.mines.editor.MineSpawnButton;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.objects.mines.Mine;

@Getter
public class MineEditor extends Menu {

    private Mine mine;

    public MineEditor(Player player, Mine mine) {
        super(player, 5, "§e§lMine Editor");

        this.mine = mine;

        for (int i = 36; i < 45; i++)
            MenuItem.WHITE_BORDER.set(inventory, i);

        setButton(39, new ReturnButton(this) {
            @Override
            public void onClick(InventoryClickEvent event) {
                new MinesAdminMenu(player).open();
            }
        });
        setButton(41, new ExitButton(this));

        setButton(10, new MinePermissionButton(this));
        setButton(16, new MineRegionButton(this));
        setButton(21, new MineNameButton(this));
        setButton(23, new MineSpawnButton(this));
    }

}
