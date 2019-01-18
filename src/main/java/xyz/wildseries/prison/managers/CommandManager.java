package xyz.wildseries.prison.managers;

import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.commands.types.mines.MinesCommand;
import xyz.wildseries.prison.commands.types.rankup.RankUpCommand;
import xyz.wildseries.prison.commands.types.ranks.RanksCommand;

public class CommandManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    public CommandManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        new RanksCommand(loader);
        new RankUpCommand(loader);
        new MinesCommand(loader);
    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
