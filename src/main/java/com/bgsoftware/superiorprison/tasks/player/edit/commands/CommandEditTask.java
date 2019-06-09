package com.bgsoftware.superiorprison.tasks.player.edit.commands;

import com.bgsoftware.superiorprison.managers.RankManager;
import com.bgsoftware.superiorprison.setup.Message;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankCommandsEditor;
import com.bgsoftware.superiorprison.objects.ranks.Command;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.tasks.player.PlayerTask;
import com.bgsoftware.superiorprison.tasks.types.ChatTask;

public class CommandEditTask extends PlayerTask implements ChatTask {

    private Rank rank;
    private Command command;

    public CommandEditTask(Prisoner prisoner, Rank rank, Command command) {
        super(prisoner);
        this.rank = rank;
        this.command = command;
    }

    @Override
    public void start() {
        super.start();
        Message.INPUT_ENTER.send(prisoner, "input:a new command");
    }

    @Override
    public void end() {
        super.end();

        if (!prisoner.isOnline())
            return;

        new RankCommandsEditor(prisoner.getPlayer(), rank).open();
    }

    @Override
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        RankManager rankManager = SuperiorPrisonPlugin.getPlugin().getManager().getRankManager();

        event.setCancelled(true);

        if (event.getMessage().equals("CANCEL")) {
            Message.INPUT_CANCELED.send(prisoner);
            end();
            return;
        }

        command.setCommand(event.getMessage());

        end();
    }

    @Override
    public void update() {

    }

}
