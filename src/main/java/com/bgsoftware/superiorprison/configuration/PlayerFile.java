package com.bgsoftware.superiorprison.configuration;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerFile extends YamlConfiguration {

    private File file;

    public PlayerFile(UUID uuid) {
        file = new File(SuperiorPrisonPlugin.getInstance().getDataFolder(), "players/" + uuid.toString() + ".yml");

        reload();
    }

    private void reload() {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            load(file);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            options().indent(2);
            save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getMap() {
        return new HashMap<String, Object>() {{
            ConfigurationSection section = getConfigurationSection("");
            for (String key : section.getKeys(false))
                put(key, section.get(key));
        }};
    }

    public void setMap(Map<String, Object> map) {
        for (String key : map.keySet())
            set(key, map.get(key));
    }

    public Object getOrDefault(String path, Object object) {
        Object found = get(path);
        return found == null ? object : found;
    }

}
