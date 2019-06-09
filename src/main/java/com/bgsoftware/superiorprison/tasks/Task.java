package com.bgsoftware.superiorprison.tasks;

import com.bgsoftware.superiorprison.SuperiorPrisonPlugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Task {

    protected TaskState state;

    protected Set<TaskFlag> flags;

    public Task() {
        state = TaskState.PRE_PROCESS;
        flags = new HashSet<>();

        SuperiorPrisonPlugin.getPlugin().getTaskManager().getTasks().add(this);
    }

    protected void addFlags(TaskFlag... flags) {
        this.flags.addAll(Arrays.asList(flags));
    }

    public boolean hasFlag(TaskFlag flag) {
        return flags.contains(flag);
    }

    public void start() {
        state = TaskState.PROCESSING;
    }

    public void end() {
        state = TaskState.POST_PROCESS;
    }

    public abstract void update();

    public TaskState getState() {
        return state;
    }
}
