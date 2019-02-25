package com.bgsoftware.superiorprison.listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

public abstract class BaseListener implements Listener {

    protected SuperiorPrisonPlugin loader;

    public BaseListener(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        Bukkit.getPluginManager().registerEvents(this, loader);
    }

}
