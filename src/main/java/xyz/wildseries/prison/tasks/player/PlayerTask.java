package xyz.wildseries.prison.tasks.player;

import lombok.Getter;
import xyz.wildseries.prison.player.Prisoner;
import xyz.wildseries.prison.tasks.Task;

@Getter
public abstract class PlayerTask extends Task  {

    protected Prisoner prisoner;

    public PlayerTask(Prisoner prisoner) {
        super();
        this.prisoner = prisoner;

        prisoner.getTasks().add(this);
    }

}
