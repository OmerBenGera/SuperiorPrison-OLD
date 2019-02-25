package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.tasks.Task;
import com.bgsoftware.superiorprison.tasks.TaskState;
import lombok.Getter;
import org.bukkit.scheduler.BukkitRunnable;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashSet;
import java.util.Set;

@Getter
public class TaskManager extends BukkitRunnable implements BaseManager {

    private SuperiorPrisonPlugin loader;

    private Set<Task> tasks;

    public TaskManager(SuperiorPrisonPlugin loader) {
        this.loader = loader;
    }

    @Override
    public void load() {
        tasks = new HashSet<>();

        runTaskTimer(loader, 100, 20);
    }

    @Override
    public void run() {
        Set<Task> remove = new HashSet<>();

        for (Task task : tasks) {
            if (task.getState() == TaskState.PROCESSING)
                task.update();

            if (task.getState() == TaskState.POST_PROCESS)
                remove.add(task);
        }

        tasks.removeAll(remove);
    }

    @Override
    public void save() {
        cancel();
    }
}
