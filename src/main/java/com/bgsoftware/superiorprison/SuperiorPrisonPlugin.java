package com.bgsoftware.superiorprison;

import com.bgsoftware.superiorprison.managers.Manager;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class SuperiorPrisonPlugin extends JavaPlugin {

    private static SuperiorPrisonPlugin instance;
    private static Economy economy;

    private Manager manager;

    @Override
    public void onEnable() {
        instance = this;

        setupEconomy();

        manager = new Manager(this);
        manager.load();
    }

    @Override
    public void onDisable() {
        manager.save();
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

    public Manager getManager() {
        return manager;
    }
}
