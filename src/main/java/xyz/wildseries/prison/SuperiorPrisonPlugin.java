package xyz.wildseries.prison;

import lombok.Getter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.wildseries.prison.managers.Manager;

import java.util.logging.Level;

@Getter
public class SuperiorPrisonPlugin extends JavaPlugin {

    @Getter private static SuperiorPrisonPlugin instance;
    @Getter private static Economy economy;

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

}
