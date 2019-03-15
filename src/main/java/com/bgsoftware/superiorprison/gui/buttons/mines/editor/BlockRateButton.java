package com.bgsoftware.superiorprison.gui.buttons.mines.editor;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.buttons.Button;
import com.bgsoftware.superiorprison.gui.menus.Menu;
import com.bgsoftware.superiorprison.gui.menus.types.mines.GeneratorEditor;
import com.bgsoftware.superiorprison.objects.mines.BlockRate;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import lombok.Getter;
import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
@Getter
public class BlockRateButton extends Button {

    private BlockRate rate;

    public BlockRateButton(GeneratorEditor menu, BlockRate rate) {
        super(menu, ItemUtils.build(rate.getMaterial(), "§6§nRate:§e " + rate.getRate(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));

        this.rate = rate;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case LEFT:
                new AnvilGUI(
                        SuperiorPrisonPlugin.getInstance(),
                        (Player) event.getWhoClicked(),
                        "Enter a new Percentage",
                        (player, reply) -> {

                            try {
                                double input = Double.valueOf(reply);

                                if (((GeneratorEditor) menu).getMine().getBlockGenerator().getSolidPercent(rate) + input > 100)
                                    return "Higher than 100";

                                rate.setRate(input);
                                new GeneratorEditor(player, ((GeneratorEditor) menu).getMine()).open();
                                return null;
                            } catch (Exception e) {
                                return "Invalid Number";
                            }
                        });
                break;
            case RIGHT:
                ((GeneratorEditor) menu).getMine().getBlockGenerator().getRates().remove(rate);
                ((GeneratorEditor) menu).update();
                break;
        }
    }
}
