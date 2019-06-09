package com.bgsoftware.superiorprison.gui.menus.types.ranks;

import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.RankDisplayButton;

import java.util.ArrayList;
import java.util.List;

public class RanksMenu extends ListMenu {

    public RanksMenu(Player player) {
        super(player, "§e§lRanks", new ArrayList<>());

        listItems = getListItems();

        update();

        for (int i = 27; i < 36; i++)
            MenuItem.WHITE_BORDER.set(inventory, i);

        setButton(31, new ExitButton(this));

    }

    @Override
    public void update() {
        listItems = getListItems();

        super.update();
    }

    private List<Button> getListItems() {
        List<Button> list = new ArrayList<>();

        Rank rank = SuperiorPrisonPlugin.getPlugin().getRankManager().getDefaultRank();

        while (rank != null) {
            list.add(new RankDisplayButton(this, SuperiorPrisonPlugin.getPlugin().getPlayerManager().getPrisoner(player), rank));
            rank = rank.getNext();
        }

        return list;
    }

}
