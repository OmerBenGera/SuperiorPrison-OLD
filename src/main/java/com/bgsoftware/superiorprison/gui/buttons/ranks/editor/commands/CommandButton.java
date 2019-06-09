package com.bgsoftware.superiorprison.gui.buttons.ranks.editor.commands;

import com.bgsoftware.superiorprison.gui.buttons.ranks.RankButton;
import com.bgsoftware.superiorprison.objects.ranks.Command;
import com.bgsoftware.superiorprison.tasks.player.edit.commands.CommandEditTask;
import com.bgsoftware.superiorprison.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankCommandsEditor;

public class CommandButton extends RankButton {

    private Command command;

    public CommandButton(RankCommandsEditor menu, Command command) {
        super(menu, menu.getRank(), ItemUtils.build(Material.PAPER, 0, "§e§l" + command.toString(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));
        this.command = command;
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        switch (event.getClick()) {
            case RIGHT:
                rank.getCommands().remove(command);
                ((RankCommandsEditor) menu).update();
                break;
            case LEFT:
                menu.close();
                new CommandEditTask(SuperiorPrisonPlugin.getPlugin().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), rank, command).start();
                break;
        }
    }
}
