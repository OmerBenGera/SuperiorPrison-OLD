package xyz.wildseries.prison.gui.buttons.ranks.editor.commands;

import org.bukkit.event.inventory.InventoryClickEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.buttons.ranks.RankButton;
import xyz.wildseries.prison.gui.menus.ListMenu;
import xyz.wildseries.prison.gui.menus.ranks.RankCommandsEditor;
import xyz.wildseries.prison.objects.Command;
import xyz.wildseries.prison.tasks.player.edit.commands.CommandEditTask;
import xyz.wildseries.prison.utils.ItemUtils;
import xyz.wildseries.prison.utils.XMaterial;

public class CommandButton extends RankButton {

    private Command command;

    public CommandButton(RankCommandsEditor menu, Command command) {
        super(menu, menu.getRank(), ItemUtils.build(XMaterial.PAPER, "§e§l" + command.toString(), "", "§aLeft-Click to Edit", "§cRight-Click to Remove"));
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
                new CommandEditTask(SuperiorPrisonPlugin.getInstance().getManager().getPlayerManager().getPrisoner(menu.getPlayer()), rank, command).start();
                break;
        }
    }
}
