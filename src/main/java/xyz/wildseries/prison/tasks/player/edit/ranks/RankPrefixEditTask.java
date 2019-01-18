package xyz.wildseries.prison.tasks.player.edit.ranks;

import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.types.ranks.RankEditor;
import xyz.wildseries.prison.managers.RankManager;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.ranks.Rank;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.tasks.player.PlayerTask;
import xyz.wildseries.prison.tasks.types.ChatTask;

public class RankPrefixEditTask extends PlayerTask implements ChatTask {

    private Rank rank;

    public RankPrefixEditTask(Prisoner prisoner, Rank rank) {
        super(prisoner);
        this.rank = rank;
    }

    @Override
    public void start() {
        super.start();
        Message.INPUT_ENTER.send(prisoner, "input:a new prefix");
    }

    @Override
    public void end() {
        super.end();

        if (!prisoner.isOnline())
            return;

        new RankEditor(prisoner.getPlayer(), rank).open();
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

        rank.setPrefix(ChatColor.translateAlternateColorCodes('&', event.getMessage()));

        end();
    }

    @Override
    public void update() {

    }

}
