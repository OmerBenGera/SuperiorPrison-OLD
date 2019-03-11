package com.bgsoftware.superiorprison.gui.menus.types.mines;

import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.buttons.general.ReturnButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.editor.BlockRateButton;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.objects.mines.BlockRate;
import com.bgsoftware.superiorprison.objects.mines.Mine;
import com.bgsoftware.superiorprison.utils.XMaterial;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

@Getter
public class GeneratorEditor extends ListMenu {

    private Mine mine;

    public GeneratorEditor(Player player, Mine mine) {
        super(player, "§e§lGenerator Editor", new ArrayList<>());
        this.mine = mine;

        for (int i = 27; i < 36; i++)
            MenuItem.WHITE_BORDER.set(inventory, i);

        setButton(30, new ReturnButton(this) {
            @Override
            public void onClick(InventoryClickEvent event) {
                close();
                new MineEditor(player, mine).open();
            }
        });
        setButton(32, new ExitButton(this));

        update();
    }

    @Override
    public void update() {
        listItems = new ArrayList<>();
        mine.getBlockGenerator().getRates().forEach(rate -> listItems.add(new BlockRateButton(this, rate)));

        super.update();
    }

    @Override
    public void onClick(InventoryClickEvent event) {

        if (event.getCurrentItem() != null && !event.getClickedInventory().equals(event.getInventory())) {
            mine.getBlockGenerator().getRates().add(new BlockRate(XMaterial.valueOf(event.getCurrentItem()), 0));
            update();
        }

        super.onClick(event);
    }
}
