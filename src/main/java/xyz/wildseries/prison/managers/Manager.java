package xyz.wildseries.prison.managers;

import lombok.Getter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

@Getter
public class Manager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private FileManager fileManager;
    private PlayerManager playerManager;
    private CommandManager commandManager;
    private ListenerManager listenerManager;
    private RankManager rankManager;
    private MenuManager menuManager;
    private TaskManager taskManager;

    public Manager(SuperiorPrisonPlugin loader) {
        this.loader = loader;

        fileManager = new FileManager(loader);
        playerManager = new PlayerManager(loader);
        commandManager = new CommandManager(loader);
        listenerManager = new ListenerManager(loader);
        rankManager = new RankManager(loader);
        menuManager = new MenuManager(loader);
        taskManager = new TaskManager(loader);
    }

    @Override
    public void load() {
        fileManager.load();
        playerManager.load();
        rankManager.load();
        menuManager.load();
        taskManager.load();
    }

    @Override
    public void save() {
        taskManager.save();
        rankManager.save();
        menuManager.save();
        playerManager.save();
        fileManager.save();
    }

    public void reload() {
        save();
        load();
    }
}
