package com.bgsoftware.superiorprison.tasks.player.edit.ranks;

import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.managers.RankManager;
import com.bgsoftware.superiorprison.setup.Message;
import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.tasks.player.PlayerTask;
import com.bgsoftware.superiorprison.tasks.types.ChatTask;

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
