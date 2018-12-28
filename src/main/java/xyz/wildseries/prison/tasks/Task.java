package xyz.wildseries.prison.tasks;

import lombok.Getter;
import xyz.wildseries.prison.SuperiorPrisonPlugin;

@Getter
public abstract class Task {

    protected TaskState state;

    public Task() {
        state = TaskState.PRE_PROCESS;

        SuperiorPrisonPlugin.getInstance().getManager().getTaskManager().getTasks().add(this);
    }

    public void start() {
        state = TaskState.PROCESSING;
    }

    public void end() {
        state = TaskState.POST_PROCESS;
    }

    public abstract void update();

}
