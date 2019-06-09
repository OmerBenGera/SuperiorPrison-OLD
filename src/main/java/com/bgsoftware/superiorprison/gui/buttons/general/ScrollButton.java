package com.bgsoftware.superiorprison.gui.buttons.general;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.ListMenu;
import com.bgsoftware.superiorprison.utils.ItemUtils;

public class ScrollButton extends Button {

    private ScrollAction action;

    public ScrollButton(ListMenu menu, ScrollAction action) {
        super(menu, ItemUtils.build(Material.STAINED_GLASS_PANE, 4, action.getDisplay()));
        this.action = action;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        ((ListMenu) menu).scroll(action.getModifier());
    }

    public ScrollAction getAction() {
        return action;
    }

    public enum ScrollAction {

        LEFT("§e§l<", -1),
        RIGHT("§e§l>", 1);

        private String display;
        private int modifier;

        ScrollAction(String display, int modifier) {
            this.display = display;
            this.modifier = modifier;
        }

        public String getDisplay() {
            return display;
        }

        public int getModifier() {
            return modifier;
        }
    }

}
