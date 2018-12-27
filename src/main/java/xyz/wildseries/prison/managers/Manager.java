package xyz.wildseries.prison.managers;

import lombok.Getter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

@Getter
public class Manager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private FileManager fileManager;
    private CommandManager commandManager;
    private RankManager rankManager;

    public Manager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        fileManager = new FileManager(loader);
        commandManager = new CommandManager(loader);
        rankManager = new RankManager(loader);
    }

    @Override
    public void load() {
        fileManager.load();
    }

    @Override
    public void save() {
        rankManager.save();
        fileManager.save();
    }

    public void reload() {
        save();
        load();
    }
}
