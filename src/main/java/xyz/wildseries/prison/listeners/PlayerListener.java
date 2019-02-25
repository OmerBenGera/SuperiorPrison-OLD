package xyz.wildseries.prison.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.*;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.managers.PlayerManager;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.objects.mines.Region;
import xyz.wildseries.prison.tasks.Task;
import xyz.wildseries.prison.tasks.player.edit.mine.RegionTask;
import xyz.wildseries.prison.tasks.types.ChatTask;
import xyz.wildseries.prison.tasks.types.InteractTask;
import xyz.wildseries.prison.tasks.types.ScrollTask;

public class PlayerListener extends BaseListener {

    public PlayerListener(SuperiorPrisonPlugin loader) {
        super(loader);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        new Prisoner(event.getUniqueId());
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        getManager().getPrisoner(event.getPlayer()).unload();
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        Prisoner prisoner = getManager().getPrisoner(event.getPlayer().getUniqueId());

        for (Task task : prisoner.getTasks())
            if (task instanceof ChatTask)
                ((ChatTask) task).onPlayerChat(event);
    }

    @EventHandler (ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Prisoner prisoner = getManager().getPrisoner(event.getPlayer());

        for (Task task : prisoner.getTasks())
            if (task instanceof InteractTask)
                ((InteractTask) task).onPlayerInteract(event);
    }

    @EventHandler (ignoreCancelled = true)
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        Prisoner prisoner = getManager().getPrisoner(event.getPlayer());

        for (Task task : prisoner.getTasks())
            if (task instanceof ScrollTask)
                ((ScrollTask) task).onPlayerItemHeld(event);
    }

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Prisoner prisoner = getManager().getPrisoner(event.getPlayer());

        event.setFormat(event.getFormat().replace("{PRISON_RANK}", (prisoner.getRank() == null ? "" : prisoner.getRank().getPrefix()) + "§r"));
    }

    private PlayerManager getManager() {
        return loader.getManager().getPlayerManager();
    }
}
