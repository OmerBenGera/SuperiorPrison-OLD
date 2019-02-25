package com.bgsoftware.superiorprison.gui.menus.types.mines;

import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import org.bukkit.entity.Player;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.CreateMineButton;
import com.bgsoftware.superiorprison.gui.buttons.mines.MineAdminDisplayButton;
import com.bgsoftware.superiorprison.objects.mines.Mine;

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
