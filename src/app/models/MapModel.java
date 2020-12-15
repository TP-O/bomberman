package app.models;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import helper.Helper;

public class MapModel implements Model<String>
{   
    private String data;

    private String file = "res/data/map.json";

    @Override
    public String get()
    {
        return data;
    }

    @Override
    public MapModel whereType(String type)
    {
        throw new Error("Unsupport this method");
    }

    @Override
    @SuppressWarnings("unchecked")
    public MapModel wherePhase(int phase)
    {
        JSONArray result = (JSONArray) (Helper.readJsonArray(file)).get(phase - 1);

        result.forEach(r -> {
            parseMapObject((JSONObject) r);
        });

        return this;
    }

    private void parseMapObject(JSONObject map)
    {
        data = (String) map.get("map");
    }
}
