package xyz.wildseries.prison.gui.buttons.ranks;

import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.player.Rank;

@Getter
public abstract class RankButton extends Button {

    protected Rank rank;

    public RankButton(Menu menu, Rank rank, ItemStack item) {
        super(menu, item);
        this.rank = rank;
    }
}
