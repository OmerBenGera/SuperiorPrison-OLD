package xyz.wildseries.prison.managers;

import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.types.ranks.RanksCommand;

public class CommandManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    public CommandManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        new RanksCommand(loader);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
