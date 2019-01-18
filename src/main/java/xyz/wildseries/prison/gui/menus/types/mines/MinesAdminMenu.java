package xyz.wildseries.prison.gui.menus.types.mines;

import org.bukkit.entity.Player;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.mines.CreateMineButton;
import xyz.wildseries.prison.gui.buttons.mines.MineAdminDisplayButton;
import xyz.wildseries.prison.gui.buttons.ranks.CreateRankButton;
import xyz.wildseries.prison.gui.buttons.ranks.RankAdminDisplayButton;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.objects.mines.Mine;
import xyz.wildseries.prison.objects.ranks.Rank;

import java.util.ArrayList;
import java.util.List;

public class MinesAdminMenu extends ListMenu {

    public MinesAdminMenu(Player player) {
        super(player, "§e§lMines", new ArrayList<>());

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

        for (Mine mine : SuperiorPrisonPlugin.getInstance().getManager().getMineManager().getMines())
            list.add(new MineAdminDisplayButton(this, mine));

        list.add(new CreateMineButton(this));

        return list;
    }

}
