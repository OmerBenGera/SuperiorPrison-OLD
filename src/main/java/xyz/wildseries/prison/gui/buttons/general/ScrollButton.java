package xyz.wildseries.prison.gui.buttons.general;

import lombok.Getter;
import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.gui.buttons.Button;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

@Getter
public class ScrollButton extends Button {

    private ScrollAction action;

    public ScrollButton(ListMenu menu, ScrollAction action) {
        super(menu, ItemUtils.build(XMaterial.YELLOW_STAINED_GLASS_PANE, action.getDisplay()));
        this.action = action;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        ((ListMenu) menu).scroll(action.getModifier());
    }

    @Getter
    public enum ScrollAction {

        LEFT("§e§l<", -1),
        RIGHT("§e§l>", 1);

        private String display;
        private int modifier;

        ScrollAction(String display, int modifier) {
            this.display = display;
            this.modifier = modifier;
        }

    }

}
