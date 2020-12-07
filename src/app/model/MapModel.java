package app.model;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MapModel extends Model<String>
{   
    public MapModel()
    {
        data = null;
        path = "res/data/map.json";
    }

    @SuppressWarnings("unchecked")
    public MapModel where(int phase)
    {
        JSONArray result = read(phase);

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
