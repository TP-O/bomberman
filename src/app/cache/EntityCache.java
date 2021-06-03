package app.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import components.entities.Entity;

public class EntityCache {

    private static Map<String, List<Entity>> data = new HashMap<String, List<Entity>>();

    public static List<Entity> get(String key) {
        if (data.get(key) == null) {
            data.put(key, new ArrayList<Entity>());
        }

        return data.get(key);
    }

    public static void push(String key, Entity value) {
        EntityCache.get(key).add(value);
    }

    public static void remove(String key) {
        data.remove(key);
    }

    public static int size(String key) {
        return data.get(key).size();
    }
}
