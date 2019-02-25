package com.bgsoftware.superiorprison.gui.buttons.ranks;

import com.bgsoftware.superiorprison.gui.menus.types.ranks.RanksMenu;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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
