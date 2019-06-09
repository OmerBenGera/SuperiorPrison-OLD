package com.bgsoftware.superiorprison.tasks.player.edit.mine;

import com.bgsoftware.superiorprison.gui.menus.types.mines.GeneratorEditor;
import com.bgsoftware.superiorprison.objects.Prisoner;
import com.bgsoftware.superiorprison.objects.mines.BlockRate;
import com.bgsoftware.superiorprison.setup.Message;
import com.bgsoftware.superiorprison.tasks.player.PlayerTask;
import com.bgsoftware.superiorprison.tasks.types.ChatTask;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class GeneratorEditTask extends PlayerTask implements ChatTask {

    private GeneratorEditor generatorEditor;
    private BlockRate rate;

    public GeneratorEditTask(Prisoner prisoner, GeneratorEditor generatorEditor, BlockRate rate) {
        super(prisoner);
        this.generatorEditor = generatorEditor;
        this.rate = rate;
    }

    @Override
    public void start() {
        super.start();
        Message.INPUT_ENTER.send(prisoner, "input:a new percentage");
    }

    @Override
    public void update() {

    }

    @Override
    public void end() {
        super.end();

        if(!prisoner.isOnline())
            return;

        new GeneratorEditor(prisoner.getPlayer(), generatorEditor.getMine()).open();
    }

    @Override
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        event.setCancelled(true);

        if (event.getMessage().equals("CANCEL")) {
            Message.INPUT_CANCELED.send(prisoner);
            end();
            return;
        }

        double input = 101;

        try {
            input = Double.valueOf(event.getMessage());
        }catch(Exception ignored){}

        if (generatorEditor.getMine().getBlockGenerator().getSolidPercent(rate) + input > 100) {
            Message.INPUT_INVALID.send(prisoner, "reason:higher than 100");
            return;
        }

        rate.setRate(input);

        end();
    }
}
