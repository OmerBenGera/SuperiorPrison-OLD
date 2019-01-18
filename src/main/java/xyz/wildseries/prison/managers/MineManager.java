package xyz.wildseries.prison.managers;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.configuration.ConfigFile;
import xyz.wildseries.prison.objects.mines.Mine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
public class MineManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private List<Mine> mines;

    public MineManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void load() {
        mines = new ArrayList<>();

        FileConfiguration config = loader.getManager().getFileManager().getMinesYaml().getBukkitConfig();
        for (Map<?, ?> map : config.getMapList("mines"))
            new Mine((Map<String, Object>) map);

    }

    @Override
    public void save() {
        List<Map<String, Object>> list = new ArrayList<>();

        for (Mine mine : mines)
            list.add(mine.serialize());

        ConfigFile file = loader.getManager().getFileManager().getMinesYaml();

        file.getBukkitConfig().set("mines", list);
    }
}
