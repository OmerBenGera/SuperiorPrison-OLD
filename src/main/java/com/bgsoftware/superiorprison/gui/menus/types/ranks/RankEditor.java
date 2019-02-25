package com.bgsoftware.superiorprison.gui.menus.types.ranks;

import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.buttons.general.ReturnButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.editor.CommandsMenuButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.editor.RankNameButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.editor.RankPrefixButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.editor.RankPriceButton;
import com.bgsoftware.superiorprison.objects.ranks.Rank;

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
