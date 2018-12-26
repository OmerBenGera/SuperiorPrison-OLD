package xyz.wildseries.prison;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class Locale {

    private static Map<String, Locale> localeMap = new HashMap<>();

    private String message;

    private Locale(String identifier){
        localeMap.put(identifier, this);
    }

    public String getMessage(Object... objects){
        if(message != null && !message.equals("")) {
            String msg = message;

            for (int i = 0; i < objects.length; i++)
                msg = msg.replace("{" + i + "}", objects[i].toString());

            return msg;
        }

        return null;
    }

    public void send(CommandSender sender, Object... objects){
        String message = getMessage(objects);
        if(message != null && sender != null)
            sender.sendMessage(message);
    }

    private void setMessage(String message){
        this.message = message;
    }

    public static void reload(){
        SuperiorPrisonPlugin.log("Loading messages started...");
        long startTime = System.currentTimeMillis();
        int messagesAmount = 0;
        File file = new File(SuperiorPrisonPlugin.getPlugin().getDataFolder(), "lang.yml");

        if(!file.exists())
            SuperiorPrisonPlugin.getPlugin().saveResource("lang.yml", false);

        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        for(String identifier : localeMap.keySet()){
            localeMap.get(identifier).setMessage(ChatColor.translateAlternateColorCodes('&', cfg.getString(identifier, "")));
            messagesAmount++;
        }

        SuperiorPrisonPlugin.log(" - Found " + messagesAmount + " messages in lang.yml.");
        SuperiorPrisonPlugin.log("Loading messages done (Took " + (System.currentTimeMillis() - startTime) + "ms)");
    }

}