package xyz.wildseries.prison.gui.menus.ranks;

import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.ranks.CreateRankButton;
import xyz.wildseries.prison.gui.buttons.ranks.RankAdminDisplayButton;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.objects.ranks.Rank;

import java.util.ArrayList;
import java.util.List;

public class RanksAdminMenu extends ListMenu {

    public RanksAdminMenu(Player player) {
        super(player, "§e§lRanks", new ArrayList<>());
        listItems = getButtonList();

        for (int i = 27; i < 36; i++)
            MenuItem.WHITE_BORDER.set(inventory, i);

        setButton(31, new ExitButton(this));

        update();
    }

    @Override
    public void update() {
        listItems = getButtonList();

        super.update();
    }

    private List<Button> getButtonList() {
        List<Button> list = new ArrayList<>();

        for (Rank rank : SuperiorPrisonPlugin.getInstance().getManager().getRankManager().listRanks())
            list.add(new RankAdminDisplayButton(this, rank));

        list.add(new CreateRankButton(this));

        return list;
    }

}
