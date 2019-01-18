package xyz.wildseries.prison.gui.buttons.ranks.editor.commands;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.ranks.RankButton;
import xyz.wildseries.prison.gui.menus.types.ranks.RankCommandsEditor;
import xyz.wildseries.prison.tasks.player.edit.commands.CommandCreateTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class CreateCommandButton extends RankButton {

    public CreateCommandButton(RankCommandsEditor menu) {
        super(menu, menu.getRank(), ItemUtils.build(XMaterial.FEATHER, "§6§l+"));
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        menu.close();
        new CommandCreateTask(SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), rank).start();
    }
}
