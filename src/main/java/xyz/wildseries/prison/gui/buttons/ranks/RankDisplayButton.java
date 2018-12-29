package xyz.wildseries.prison.gui.buttons.ranks;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.gui.menus.Menu;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.Rank;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class RankDisplayButton extends RankButton {

    private Prisoner prisoner;

    public RankDisplayButton(Menu menu, Prisoner prisoner, Rank rank) {
        super(menu, rank, getItem(prisoner, rank));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        if (prisoner.getNextRank().equals(rank)); // TODO rankup
    }

    private static ItemStack getItem(Prisoner prisoner, Rank rank) {
        boolean unlocked = !(prisoner.getRank() == null || !prisoner.getRank().isHigherThan(rank));

        XMaterial material = unlocked ? XMaterial.LIME_DYE : XMaterial.GRAY_DYE;
        String[] lore;

        if (unlocked)
            lore = new String[] {
                    "",
                    "§aUnlocked"
            };
        else
            lore = new String[] {
                    "",
                    "§7Price: §e$" + rank.getPrice(),
                    "",
                    prisoner.getNextRank().equals(rank) ? "§9Click to Rank-Up" : "§cLocked"
            };

        return ItemUtils.build(material, "§e§l" + rank.getName(), lore);
    }
}
