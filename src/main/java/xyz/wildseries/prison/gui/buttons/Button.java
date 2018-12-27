package xyz.wildseries.prison.gui.buttons;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.gui.menus.Menu;

@Getter
public abstract class Button {

    protected Menu menu;

    @Setter protected ItemStack item;

    public Button(Menu menu, ItemStack item) {
        this.menu = menu;
        this.item = item;
    }

    public abstract void onClick(InventoryClickEvent event);

    public void updateItem() {
    }
}
