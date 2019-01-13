package xyz.wildseries.prison.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.managers.PlayerManager;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.tasks.TaskFlag;

public class TaskListener extends BaseListener {

    public TaskListener(SuperiorPrisonPlugin loader) {
        super(loader);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Prisoner prisoner = getManager().getPrisoner(player);

        if (prisoner.hasTask(TaskFlag.CANCEL_INVENTORY))
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {
        Player player = event.getPlayer();
        Prisoner prisoner = getManager().getPrisoner(player);

        if (prisoner.hasTask(TaskFlag.CANCEL_DROPS))
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        Prisoner prisoner = getManager().getPrisoner(player);

        if (prisoner.hasTask(TaskFlag.CANCEL_DROPS))
            event.setCancelled(true);
    }

    private PlayerManager getManager() {
        return loader.getManager().getPlayerManager();
    }

}
