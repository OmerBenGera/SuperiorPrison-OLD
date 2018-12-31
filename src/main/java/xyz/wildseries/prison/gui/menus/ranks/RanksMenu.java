package xyz.wildseries.prison.gui.menus.ranks;

import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.ranks.RankDisplayButton;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.objects.ranks.Rank;

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

        Rank rank = SuperiorPrisonPlugin.getInstance().getManager().getRankManager().getDefaultRank();

        while (rank != null) {
            list.add(new RankDisplayButton(this, SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(player), rank));
            rank = rank.getNext();
        }

        return list;
    }

}
