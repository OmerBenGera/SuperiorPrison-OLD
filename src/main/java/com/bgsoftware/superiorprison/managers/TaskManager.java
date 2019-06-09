package com.bgsoftware.superiorprison.managers;

import com.bgsoftware.superiorprison.tasks.Task;
import com.bgsoftware.superiorprison.tasks.TaskState;
import org.bukkit.scheduler.BukkitRunnable;
import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.HashSet;
import java.util.Set;

public final class TaskManager extends BukkitRunnable{

    private Set<Task> tasks = new HashSet<>();

    public TaskManager(SuperiorPrisonPlugin plugin) {
        runTaskTimer(plugin, 100, 20);
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

    public void save() {
        cancel();
    }

    public Set<Task> getTasks() {
        return tasks;
    }
}
