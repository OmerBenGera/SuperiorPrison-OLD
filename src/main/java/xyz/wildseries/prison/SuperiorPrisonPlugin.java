package xyz.wildseries.prison;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

@Getter
public class SuperiorPrisonPlugin extends JavaPlugin {

    @Getter private static SuperiorPrisonPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        new TestCommand(this);
    }

    public static void log(String message){
        plugin.getLogger().log(Level.INFO, message);
    }

}
