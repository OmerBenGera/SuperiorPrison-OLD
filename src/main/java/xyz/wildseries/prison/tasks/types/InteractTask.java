package xyz.wildseries.prison.tasks.types;

import org.bukkit.event.player.PlayerInteractEvent;

public interface InteractTask {

    void onPlayerInteract(PlayerInteractEvent event);

}
