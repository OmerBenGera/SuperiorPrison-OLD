package xyz.wildseries.prison.managers;

import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.listeners.MenuListener;
import xyz.wildseries.prison.listeners.PlayerListener;

public class ListenerManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    public ListenerManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        new MenuListener(loader);
        new PlayerListener(loader);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
