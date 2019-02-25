package com.bgsoftware.superiorprison.configuration;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

@Getter
@SuppressWarnings("all")
public class ConfigFile {

    private static SuperiorPrisonPlugin loader = SuperiorPrisonPlugin.getInstance();
    private String name;

    private File file;
    private File folder;

    private YamlConfiguration bukkitConfig;

    public ConfigFile(String name, File folder) {
        this.name = name;
        this.folder = folder;

        create();
    }

    private void create() {
        file = new File(folder, name);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            loader.saveResource(name, false);
        }

        bukkitConfig = new YamlConfiguration();
        try {
            bukkitConfig.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            bukkitConfig.save(file);
            bukkitConfig.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            bukkitConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
