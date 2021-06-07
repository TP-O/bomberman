package app.models;

import org.json.simple.JSONObject;

public class MapModel extends Model<String> {

    @Override
    protected void set() {
        table = "res/data/map.json";
    }

    @Override
    protected void parseObject(JSONObject object) {
        data = (String) object.get("map");
    }
}
