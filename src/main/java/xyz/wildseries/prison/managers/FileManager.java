package xyz.wildseries.prison.managers;

import lombok.Getter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.configuration.ConfigFile;

import java.io.File;

@Getter
public class FileManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private ConfigFile ranksYaml;

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

        ranksYaml = new ConfigFile("ranks.yml", loader.getDataFolder());
    }

    @Override
    public void save() {
        ranksYaml.save();
    }
}
