package xyz.wildseries.prison.gui.menus;

import org.bukkit.entity.Player;
import xyz.wildseries.prison.gui.MenuItem;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.buttons.general.ExitButton;
import xyz.wildseries.prison.gui.buttons.general.ScrollButton;

import java.util.List;

public class ListMenu extends Menu {

    public List<Button> listItems;

    private int index;

    public ListMenu(Player player, String title, List<Button> listItems) {
        super(player, 4, title);
        this.listItems = listItems;
        index = 0;
    }

    public void scroll(int i) {
        index += i;

        update();
    }

    public void update() {

        // Validating the index
        if (index < 0)
            index = 0;
        if (index > getMaxIndex())
            index = getMaxIndex();

        // Clearing the current buttons
        for (int i = 9; i < 18; i++)
            setButton(i, null);

        // Setting the new buttons
        for (int i = 0; i < listItems.size(); i++) {
            Button button = listItems.get(i);
            int slot = i + 10 - index;

            if (slot < 9)
                continue;

            setButton(slot, button);

            if (slot >= 17)
                break;
        }

        // Setting the scroll buttons

        // Left Button
        if (index > 0)
            setButton(27, new ScrollButton(this, ScrollButton.ScrollAction.LEFT));
        else {
            setButton(27, null);
            MenuItem.WHITE_BORDER.set(inventory, 27);
        }

        // Right Button
        if (index < getMaxIndex())
            setButton(35, new ScrollButton(this, ScrollButton.ScrollAction.RIGHT));
        else {
            setButton(35, null);
            MenuItem.WHITE_BORDER.set(inventory, 35);
        }

    }

    public void scrollToEnd() {
        index = getMaxIndex();

        update();
    }

    protected int getMaxIndex() {
        if (listItems.size() <= 7)
            return 0;
        else
            return listItems.size() - 7;
    }

}
