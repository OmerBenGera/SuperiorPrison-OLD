package xyz.wildseries.prison.tasks.player.edit.ranks;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.gui.menus.ranks.RankEditor;
import xyz.wildseries.prison.managers.RankManager;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.Rank;
import xyz.wildseries.prison.setup.Message;
import xyz.wildseries.prison.tasks.player.PlayerTask;
import xyz.wildseries.prison.tasks.types.ChatTask;

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
        RankManager rankManager = SuperiorPrisonPlugin.getInstance().getManager().getRankManager();

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
