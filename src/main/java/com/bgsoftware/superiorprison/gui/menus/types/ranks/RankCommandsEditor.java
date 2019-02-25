package com.bgsoftware.superiorprison.gui.menus.types.ranks;

import com.bgsoftware.superiorprison.gui.MenuItem;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.buttons.ranks.editor.commands.CommandButton;
import com.bgsoftware.superiorprison.gui.buttons.ranks.editor.commands.CreateCommandButton;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.objects.ranks.Command;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.buttons.general.ExitButton;
import com.bgsoftware.superiorprison.gui.buttons.general.ReturnButton;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RankCommandsEditor extends ListMenu {

    private Rank rank;

    public RankCommandsEditor(Player player, Rank rank) {
        super(player, "§e§lCommands", new ArrayList<>());

        this.rank = rank;

        listItems = getListItems();

        update();

        for (int i = 27; i < 36; i++)
            MenuItem.WHITE_BORDER.set(inventory, i);

        setButton(30, new ReturnButton(this) {
            @Override
            public void onClick(InventoryClickEvent event) {
                close();
                new RankEditor(player, rank).open();
            }
        });
        setButton(32, new ExitButton(this));
    }

    @Override
    public void update() {
        listItems = getListItems();
        super.update();
    }

    private List<Button> getListItems() {
        List<Button> buttons = new ArrayList<>();

        for (Command command : rank.getCommands())
            buttons.add(new CommandButton(this, command));

        buttons.add(new CreateCommandButton(this));

        return buttons;
    }
}
