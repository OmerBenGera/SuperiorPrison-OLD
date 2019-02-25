package xyz.wildseries.prison.tasks.player.edit.mine;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.types.mines.MineEditor;
import xyz.wildseries.prison.managers.MineManager;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.mines.Mine;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.tasks.player.PlayerTask;
import xyz.wildseries.prison.tasks.types.ChatTask;

public class MineNameEditTask extends PlayerTask implements ChatTask {

    private Mine mine;

    public MineNameEditTask(Prisoner prisoner, Mine mine) {
        super(prisoner);

        this.mine = mine;
    }

    @Override
    public void update() {

    }

    @Override
    public void start() {
        super.start();
        Message.INPUT_ENTER.send(prisoner, "input:a new name");
    }

    @Override
    public void end() {
        super.end();

        if (!prisoner.isOnline())
            return;

        new MineEditor(prisoner.getPlayer(), mine).open();
    }

    @Override
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        MineManager manager = SuperiorPrisonPlugin.getInstance().getManager().getMineManager();

        event.setCancelled(true);

        if (event.getMessage().equals("CANCEL")) {
            Message.INPUT_CANCELED.send(prisoner);
            end();
            return;
        }

        if (manager.getMine(event.getMessage()) != null) {
            Message.INPUT_INVALID.send(prisoner, "reason:this name is already taken");
            return;
        }

        mine.setName(event.getMessage());

        end();
    }
}
