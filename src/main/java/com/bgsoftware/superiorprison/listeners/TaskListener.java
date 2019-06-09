package com.bgsoftware.superiorprison.listeners;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.managers.PlayerManager;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.tasks.TaskFlag;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

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
        return loader.getPlayerManager();
    }

}
