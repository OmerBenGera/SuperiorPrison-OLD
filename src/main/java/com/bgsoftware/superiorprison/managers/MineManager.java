package com.bgsoftware.superiorprison.managers;

import org.bukkit.configuration.file.FileConfiguration;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;
import com.bgsoftware.superiorprison.configuration.ConfigFile;
import com.bgsoftware.superiorprison.objects.mines.Mine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class MineManager {

    private SuperiorPrisonPlugin plugin;

    private List<Mine> mines = new ArrayList<>();

    public MineManager(SuperiorPrisonPlugin plugin) {
        this.plugin = plugin;

        FileConfiguration config = plugin.getFileManager().getMinesYaml().getBukkitConfig();
        for (Map<?, ?> map : config.getMapList("mines"))
            new Mine((Map<String, Object>) map);
    }

    public void save() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Mine mine : mines)
            list.add(mine.serialize());

        ConfigFile file = plugin.getFileManager().getMinesYaml();

        file.getBukkitConfig().set("mines", list);
    }

    public Mine getMine(String name) {
        for (Mine mine : mines) {
            if (mine.getName().equals(name))
                return mine;
        }
        return null;
    }

    public List<Mine> getMines() {
        return mines;
    }
}
