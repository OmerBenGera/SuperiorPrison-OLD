package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.commands.types.mines.MinesCommand;
import com.bgsoftware.superiorprison.commands.types.rankup.RankUpCommand;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.commands.types.ranks.RanksCommand;

public final class CommandManager {

    public CommandManager(SuperiorPrisonPlugin plugin) {
        new RanksCommand(plugin);
        new RankUpCommand(plugin);
        new MinesCommand(plugin);
    }
}
