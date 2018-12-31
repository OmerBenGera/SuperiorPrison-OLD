package xyz.wildseries.prison.managers;

import lombok.Getter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;
import xyz.wildseries.prison.objects.mines.Mine;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MineManager implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private List<Mine> mines;

    public MineManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @Override
    public void load() {
        mines = new ArrayList<>();
    }

    @Override
    public void save() {

    }
}
