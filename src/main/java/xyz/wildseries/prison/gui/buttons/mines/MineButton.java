package xyz.wildseries.prison.gui.buttons.mines;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.objects.mines.Mine;

@Getter
public abstract class MineButton extends Button {

    protected Mine mine;

    public MineButton(Menu menu, Mine mine, ItemStack item) {
        super(menu, item);
        this.mine = mine;
    }

}
