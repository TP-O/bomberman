package app.cache;

import java.util.HashMap;
import java.util.Map;

public class GameCache {

    private static Map<String, Object> data = new HashMap<String, Object>();

    public static Object get(String key) {
        return data.get(key);
    }

    public static void push(String key, Object value) {
        data.put(key, value);
    }

    public static void remove(String key) {
        data.remove(key);
    }
}
