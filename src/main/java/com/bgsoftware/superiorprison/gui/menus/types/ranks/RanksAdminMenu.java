package com.bgsoftware.superiorprison.gui.menus.types.ranks;

import com.bgsoftware.superiorprison.gui.buttons.ranks.CreateRankButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.RankAdminDisplayButton;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.objects.ranks.Rank;

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

        for (Rank rank : SuperiorPrisonPlugin.getPlugin().getRankManager().listRanks())
            list.add(new RankAdminDisplayButton(this, rank));

        list.add(new CreateRankButton(this));

        return list;
    }

}
