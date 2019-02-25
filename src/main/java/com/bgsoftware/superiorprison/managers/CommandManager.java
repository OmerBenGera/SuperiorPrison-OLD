package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.commands.types.mines.MinesCommand;
import com.bgsoftware.superiorprison.commands.types.rankup.RankUpCommand;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.commands.types.ranks.RanksCommand;

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
