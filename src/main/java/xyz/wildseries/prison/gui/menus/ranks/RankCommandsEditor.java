package xyz.wildseries.prison.gui.menus.ranks;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.general.ReturnButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.commands.CommandButton;
import xyz.wildseries.prison.gui.buttons.ranks.editor.commands.CreateCommandButton;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.objects.Command;
import xyz.wildseries.prison.objects.Rank;

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
