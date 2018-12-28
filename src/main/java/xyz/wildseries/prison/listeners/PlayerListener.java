package xyz.wildseries.prison.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.managers.PlayerManager;
import xyz.wildseries.prison.objects.Prisoner;
import xyz.wildseries.prison.tasks.Task;
import xyz.wildseries.prison.tasks.types.ChatTask;

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

    private PlayerManager getManager() {
        return loader.getManager().getPlayerManager();
    }
}
