package com.bgsoftware.superiorprison.tasks.player.edit.ranks;

import com.bgsoftware.superiorprison.gui.menus.types.ranks.RankEditor;
import com.bgsoftware.superiorprison.managers.RankManager;
import com.bgsoftware.superiorprison.setup.Message;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.ranks.Rank;
import com.bgsoftware.superiorprison.tasks.player.PlayerTask;
import com.bgsoftware.superiorprison.tasks.types.ChatTask;

public class RankPriceEditTask extends PlayerTask implements ChatTask {

    private Rank rank;

    public RankPriceEditTask(Prisoner prisoner, Rank rank) {
        super(prisoner);
        this.rank = rank;
    }

    @Override
    public void start() {
        super.start();
        Message.INPUT_ENTER.send(prisoner, "input:a new price");
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
        RankManager rankManager = SuperiorPrisonPlugin.getPlugin().getRankManager();

        event.setCancelled(true);

        if (event.getMessage().equals("CANCEL")) {
            Message.INPUT_CANCELED.send(prisoner);
            end();
            return;
        }

        double price;

        try {
            price = Double.valueOf(event.getMessage());
        } catch (Exception e) {
            Message.INPUT_INVALID.send(prisoner, "reason:invalid number");
            return;
        }

        if (price < 0) {
            Message.INPUT_INVALID.send(prisoner, "reason:price can't be lower than 0");
            return;
        }

        rank.setPrice(price);

        end();
    }

    @Override
    public void update() {

    }

}
