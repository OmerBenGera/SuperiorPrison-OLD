package com.bgsoftware.superiorprison.tasks.types;

import org.bukkit.event.player.AsyncPlayerChatEvent;

public interface ChatTask {

    void onPlayerChat(AsyncPlayerChatEvent event);

}
