package com.bgsoftware.superiorprison;

import com.bgsoftware.superiorprison.listeners.MenuListener;
import com.bgsoftware.superiorprison.listeners.PlayerListener;
import com.bgsoftware.superiorprison.listeners.TaskListener;
import com.bgsoftware.superiorprison.managers.CommandManager;
import com.bgsoftware.superiorprison.managers.FileManager;
import com.bgsoftware.superiorprison.managers.MenuManager;
import com.bgsoftware.superiorprison.managers.MineManager;
import com.bgsoftware.superiorprison.managers.PlayerManager;
import com.bgsoftware.superiorprison.managers.RankManager;
import com.bgsoftware.superiorprison.managers.TaskManager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class SuperiorPrisonPlugin extends JavaPlugin {

    private static SuperiorPrisonPlugin instance;
    private static Economy economy;

    private FileManager fileManager;
    private CommandManager commandManager;
    private RankManager rankManager;
    private MineManager mineManager;
    private MenuManager menuManager;
    private TaskManager taskManager;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;

        if(setupEconomy()){
            setEnabled(false);
            return;
        }

        new MenuListener(this);
        new PlayerListener(this);
        new TaskListener(this);

        fileManager = new FileManager(this);
        commandManager = new CommandManager(this);
        rankManager = new RankManager(this);
        mineManager = new MineManager(this);
        menuManager = new MenuManager(this);
        taskManager = new TaskManager(this);
        playerManager = new PlayerManager(this);
    }

    @Override
    public void onDisable() {
        taskManager.save();
        mineManager.save();
        rankManager.save();
        menuManager.save();
        playerManager.save();
        fileManager.save();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static SuperiorPrisonPlugin getPlugin() {
        return instance;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public RankManager getRankManager() {
        return rankManager;
    }

    public MineManager getMineManager() {
        return mineManager;
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }

    public TaskManager getTaskManager() {
        return taskManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
