package xyz.wildseries.prison.tasks.player.edit.commands;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.ranks.RankCommandsEditor;
import xyz.wildseries.prison.managers.RankManager;
import xyz.wildseries.prison.objects.Command;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.Rank;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.tasks.player.PlayerTask;
import xyz.wildseries.prison.tasks.types.ChatTask;

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
        RankManager rankManager = SuperiorPrisonPlugin.getInstance().getManager().getRankManager();

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
