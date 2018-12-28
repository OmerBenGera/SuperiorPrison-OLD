package xyz.wildseries.prison.gui.menus.ranks;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.general.ReturnButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.RankNameButton;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.player.Rank;

@Getter
public class RankEditor extends Menu {

    private Rank rank;

    public RankEditor(Player player, Rank rank) {
        super(player, 5, "§e§lRank Editor");

        this.rank = rank;

        for (int i = 36; i < 45; i++)
            MenuItem.WHITE_BORDER.set(inventory, i);

        setButton(39, new ReturnButton(this) {
            @Override
            public void onClick(InventoryClickEvent event) {
                new RanksAdminMenu(player).open();
            }
        });
        setButton(41, new ExitButton(this));

        setButton(21, new RankNameButton(this));
    }

}
