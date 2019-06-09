package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.configuration.ConfigFile;

import java.io.File;

public final class FileManager {

    private ConfigFile settingsYaml;
    private ConfigFile ranksYaml;
    private ConfigFile minesYaml;

    public FileManager(SuperiorPrisonPlugin plugin) {
        File dataFolder = plugin.getDataFolder();
        File playersFolder = new File(dataFolder, "players");

        if (!dataFolder.exists())
            dataFolder.mkdirs();
        if (!playersFolder.exists())
            playersFolder.mkdirs();

        settingsYaml = new ConfigFile("settings.yml", plugin.getDataFolder());
        ranksYaml = new ConfigFile("ranks.yml", plugin.getDataFolder());
        minesYaml = new ConfigFile("mines.yml", plugin.getDataFolder());
    }

    public void save() {
        ranksYaml.save();
        minesYaml.save();
    }

    public ConfigFile getSettingsYaml() {
        return settingsYaml;
    }

    public ConfigFile getRanksYaml() {
        return ranksYaml;
    }

    public ConfigFile getMinesYaml() {
        return minesYaml;
    }
}
