package app.models;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import helper.Helper;

public abstract class Model<T> {

    protected String table = "Unknown";

    protected T data = null;

    protected List<T> listData = new ArrayList<T>();

    public Model() {
        set();
    }

    public T get() {
        return data;
    }

    public List<T> all() {
        return listData;
    }

    @SuppressWarnings("unchecked")
    public Model<T> wherePhase(int phase) {
        JSONArray result = (JSONArray) (Helper.readJsonArray(table)).get(phase);

        result.forEach(r -> {
            parseObject((JSONObject) r);
        });

        return this;
    }

    protected abstract void set();

    protected abstract void parseObject(JSONObject object);
}
