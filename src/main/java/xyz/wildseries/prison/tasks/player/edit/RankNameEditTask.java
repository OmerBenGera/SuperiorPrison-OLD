package xyz.wildseries.prison.tasks.player.edit;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.ranks.RankEditor;
import xyz.wildseries.prison.managers.RankManager;
import xyz.wildseries.prison.player.Prisoner;
import xyz.wildseries.prison.player.Rank;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.tasks.player.PlayerTask;
import xyz.wildseries.prison.tasks.types.ChatTask;

public class RankNameEditTask extends PlayerTask implements ChatTask {

    private Rank rank;

    public RankNameEditTask(Prisoner prisoner, Rank rank) {
        super(prisoner);
        this.rank = rank;
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

        new RankEditor(prisoner.getPlayer(), rank);
    }

    @Override
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        RankManager rankManager = SuperiorPrisonPlugin.getInstance().getManager().getRankManager();

        event.setCancelled(true);

        if (event.getMessage().equals("CANCEL")) {
            Message.INPUT_CANCELED.send(prisoner);
            return;
        }

        if (rankManager.getRank(event.getMessage()) != null) {
            Message.INPUT_INVALID.send(prisoner, "reason:this name is already taken");
            return;
        }

        rank.setId(event.getMessage());

        end();
    }

    @Override
    public void update() {

    }

}
