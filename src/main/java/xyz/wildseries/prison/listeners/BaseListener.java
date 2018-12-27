package xyz.wildseries.prison.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

public abstract class BaseListener implements Listener {

    protected SuperiorPrisonPlugin loader;

    public BaseListener(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        Bukkit.getPluginManager().registerEvents(this, loader);
    }

}
