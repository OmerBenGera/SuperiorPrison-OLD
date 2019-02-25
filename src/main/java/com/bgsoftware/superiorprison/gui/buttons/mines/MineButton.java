package com.bgsoftware.superiorprison.gui.buttons.mines;

import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;
import com.bgsoftware.superiorprison.objects.mines.Mine;

@Getter
public abstract class MineButton extends Button {

    protected Mine mine;

    public MineButton(Menu menu, Mine mine, ItemStack item) {
        super(menu, item);
        this.mine = mine;
    }

}
