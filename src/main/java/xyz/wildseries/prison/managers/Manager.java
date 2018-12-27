package xyz.wildseries.prison.managers;

import xyz.wildseries.prison.SuperiorPrisonPlugin;

public class Manager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    public Manager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    public void reload() {
        save();
        load();
    }
}
