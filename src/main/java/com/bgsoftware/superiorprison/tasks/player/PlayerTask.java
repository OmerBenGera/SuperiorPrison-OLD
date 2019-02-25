package com.bgsoftware.superiorprison.tasks.player;

import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.tasks.Task;
import lombok.Getter;

@Getter
public abstract class PlayerTask extends Task {

    protected Prisoner prisoner;

    public PlayerTask(Prisoner prisoner) {
        super();
        this.prisoner = prisoner;

        prisoner.getTasks().add(this);
    }

    @Override
    public void end() {
        super.end();
        prisoner.getTasks().remove(this);
    }
}
