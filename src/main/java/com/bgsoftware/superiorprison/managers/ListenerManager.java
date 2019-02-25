package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.listeners.MenuListener;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.listeners.PlayerListener;
import com.bgsoftware.superiorprison.listeners.TaskListener;

public class ListenerManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    public ListenerManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        new MenuListener(loader);
        new PlayerListener(loader);
        new TaskListener(loader);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
