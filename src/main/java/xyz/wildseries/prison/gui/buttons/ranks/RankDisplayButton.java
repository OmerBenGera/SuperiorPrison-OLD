package xyz.wildseries.prison.gui.buttons.ranks;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import xyz.wildseries.prison.gui.menus.ranks.RanksMenu;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.ranks.Rank;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class RankDisplayButton extends RankButton {

    private Prisoner prisoner;

    public RankDisplayButton(RanksMenu menu, Prisoner prisoner, Rank rank) {
        super(menu, rank, getItem(prisoner, rank));
        this.prisoner = prisoner;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        if (prisoner.getNextRank().equals(rank)) {
            if (prisoner.hasEnoughMoney(rank.getPrice()))
                prisoner.rankup();
            else
                Message.RANKUP_NOT_ENOUGH_MONEY.send(prisoner);
        }

        ((RanksMenu) menu).update();
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
                    prisoner.getNextRank().equals(rank) ? (prisoner.hasEnoughMoney(rank.getPrice()) ? "§9Click to Rank-Up" : "§cYou Don't Have Enough Money to Rank-Up") : "§cLocked"
            };

        return ItemUtils.build(material, "§e§l" + rank.getName(), lore);
    }
}
