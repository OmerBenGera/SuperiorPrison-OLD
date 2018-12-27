package xyz.wildseries.prison.gui;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

@Getter
public enum MenuItem {

    WHITE_BORDER(ItemUtils.build(XMaterial.WHITE_STAINED_GLASS_PANE, " "));

    private ItemStack item;

    MenuItem(ItemStack item) {
        this.item = item;
    }

    public void set(Inventory inventory, int slot) {
        inventory.setItem(slot, item.clone());
    }
}
