package xyz.wildseries.prison.utils;

import java.util.HashMap;
import java.util.Map;

public class PlaceholdersUtils {

    public static String[] applyPlaceholders(String[] message, String placeholders) {
        Map<String, String> deserialized = deserializePlaceholders(placeholders);

        String[] replaced = new String[message.length];

        for (int i = 0; i < message.length; i++)
            for (String holder : deserialized.keySet())
                replaced[i] = message[i].replace("%" + holder, deserialized.get(holder));

        return replaced;
    }

    private static Map<String, String> deserializePlaceholders(String placeholders) {
        Map<String, String> map = new HashMap<>();

        String[] split = placeholders.split(",");

        for (String s : split) {
            String[] holder = s.split(":", 2);
            map.put(holder[0], holder[1]);
        }

        return map;
    }

}
