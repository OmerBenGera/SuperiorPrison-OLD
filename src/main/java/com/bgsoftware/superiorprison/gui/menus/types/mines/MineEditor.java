package com.bgsoftware.superiorprison.gui.menus.types.mines;

import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.objects.mines.Mine;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.buttons.general.ReturnButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.editor.MineNameButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.editor.MinePermissionButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.editor.MineRegionButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.editor.MineSpawnButton;

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
