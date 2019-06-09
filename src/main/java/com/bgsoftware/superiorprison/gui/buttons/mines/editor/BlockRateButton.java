package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.types.mines.GeneratorEditor;
import com.bgsoftware.superiorprison.objects.mines.BlockRate;
import com.bgsoftware.superiorprison.tasks.player.edit.mine.GeneratorEditTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
@Getter
public class BlockRateButton extends Button {

    private BlockRate rate;

    public BlockRateButton(GeneratorEditor menu, BlockRate rate) {
        super(menu, ItemUtils.build(rate.getMaterial(), 0, "§6§nRate:§e " + rate.getRate(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));

        this.rate = rate;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case LEFT:
                event.getWhoClicked().closeInventory();
                new GeneratorEditTask(
                        SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner((Player)event.getWhoClicked()),
                        (GeneratorEditor) menu,
                        rate
                ).start();
                break;
            case RIGHT:
                ((GeneratorEditor) menu).getMine().getBlockGenerator().getRates().remove(rate);
                ((GeneratorEditor) menu).update();
                break;
        }
    }
}
