package com.bgsoftware.superiorprison.gui.buttons.ranks;

import org.bukkit.inventory.ItemStack;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.objects.ranks.Rank;

public abstract class RankButton extends Button {

    protected Rank rank;

    public RankButton(Menu menu, Rank rank, ItemStack item) {
        super(menu, item);
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }
}
