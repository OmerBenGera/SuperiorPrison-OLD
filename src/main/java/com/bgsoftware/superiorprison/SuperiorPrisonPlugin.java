package com.bgsoftware.superiorprison;

import com.bgsoftware.superiorprison.listeners.MenusListener;
import com.bgsoftware.superiorprison.listeners.PlayersListener;
import com.bgsoftware.superiorprison.listeners.TasksListener;
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

        getServer().getPluginManager().registerEvents(new MenusListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayersListener(this), this);
        getServer().getPluginManager().registerEvents(new TasksListener(this), this);

        fileManager = new FileManager(this);
        rankManager = new RankManager(this);
        mineManager = new MineManager(this);
        menuManager = new MenuManager();
        taskManager = new TaskManager(this);
        playerManager = new PlayerManager(this);

        new CommandManager(this);
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
