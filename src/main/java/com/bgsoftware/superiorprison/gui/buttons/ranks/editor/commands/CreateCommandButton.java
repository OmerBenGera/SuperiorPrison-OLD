package com.bgsoftware.superiorprison.gui.buttons.ranks.editor.commands;

import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.tasks.player.edit.commands.CommandCreateTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import com.bgsoftware.superiorprison.utils.XMaterial;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankCommandsEditor;

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
