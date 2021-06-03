package asset;

import java.util.HashMap;
import java.util.Map;

public class AssetMap {

    private Map<String, String> bind = new HashMap<String, String>();

    public AssetMap(String... data) {
        for (String d : data) {
            String[] parts = d.split("@");
            bind.put(parts[0], parts[1]);
        }
    }

    public String get(String key) {
        return bind.get(key);
    }
}
