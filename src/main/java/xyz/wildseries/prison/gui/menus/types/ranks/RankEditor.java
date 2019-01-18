package xyz.wildseries.prison.gui.menus.types.ranks;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.general.ReturnButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.CommandsMenuButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.RankNameButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.RankPrefixButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.RankPriceButton;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.objects.ranks.Rank;

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

        setButton(10, new RankPriceButton(this));
        setButton(16, new CommandsMenuButton(this));
        setButton(21, new RankNameButton(this));
        setButton(23, new RankPrefixButton(this));
    }

}
