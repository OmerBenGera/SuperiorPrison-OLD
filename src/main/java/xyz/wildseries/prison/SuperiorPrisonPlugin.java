package xyz.wildseries.prison;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.wildseries.prison.managers.Manager;

import java.util.logging.Level;

@Getter
public class SuperiorPrisonPlugin extends JavaPlugin {

    @Getter private static SuperiorPrisonPlugin instance;

    private Manager manager;

    @Override
    public void onEnable() {
        instance = this;

        manager = new Manager();
        manager.load();
    }

    @Override
    public void onDisable() {
        manager.save();
    }
}
