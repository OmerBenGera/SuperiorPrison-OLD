package com.bgsoftware.superiorprison.managers;

import lombok.Getter;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.configuration.ConfigFile;

import java.io.File;

@Getter
public class FileManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private ConfigFile settingsYaml;
    private ConfigFile ranksYaml;
    private ConfigFile minesYaml;

    public FileManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @Override
    public void load() {
        File dataFolder = loader.getDataFolder();
        File playersFolder = new File(dataFolder, "players");

        if (!dataFolder.exists())
            dataFolder.mkdirs();
        if (!playersFolder.exists())
            playersFolder.mkdirs();

        settingsYaml = new ConfigFile("settings.yml", loader.getDataFolder());
        ranksYaml = new ConfigFile("ranks.yml", loader.getDataFolder());
        minesYaml = new ConfigFile("mines.yml", loader.getDataFolder());
    }

    @Override
    public void save() {
        ranksYaml.save();
        minesYaml.save();
    }
}
