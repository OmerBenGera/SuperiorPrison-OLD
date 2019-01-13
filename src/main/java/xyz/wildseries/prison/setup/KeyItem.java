package xyz.wildseries.prison.setup;

import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public enum KeyItem {

    REGION_TOOL(ItemUtils.build(XMaterial.GOLDEN_AXE, "§6Region Tool")),
    BTN_CONFIRM(ItemUtils.build(XMaterial.GREEN_STAINED_GLASS_PANE, "§aConfirm")),
    BTN_CANCEL(ItemUtils.build(XMaterial.RED_STAINED_GLASS_PANE, "§cCancel"));

    private ItemStack item;

    KeyItem(ItemStack item) {
        this.item = item;
    }

    public boolean isSimilar(ItemStack item) {
        return this.item.isSimilar(item);
    }

    public ItemStack getItem() {
        return item.clone();
    }

    public static KeyItem idenfiy(ItemStack item) {
        for (KeyItem key : values())
            if (key.isSimilar(item))
                return key;
        return null;
    }
}
