package com.bgsoftware.superiorprison.tasks.player.edit.mine;

import com.bgsoftware.superiorprison.gui.menus.types.mines.MineEditor;
import com.bgsoftware.superiorprison.managers.MineManager;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.mines.Mine;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.tasks.player.PlayerTask;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.tasks.types.ChatTask;

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
        MineManager manager = SuperiorPrisonPlugin.getPlugin().getManager().getMineManager();

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
