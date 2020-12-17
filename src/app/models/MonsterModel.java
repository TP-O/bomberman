package app.models;

import java.util.ArrayList;
import java.util.List;

import components.entities.dynamic.character.monster.Monster;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import core.Handler;
import factories.monster.MonsterFactory;
import helper.Helper;

public class MonsterModel implements Model<List<Monster>>
{
    private Handler handler;

    private List<Monster> data = new ArrayList<Monster>();

    private MonsterFactory factory = new MonsterFactory();

    private String file = "res/data/monster.json";

    public MonsterModel(Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public List<Monster> get()
    {
        return data;
    }

    @Override
    public MonsterModel whereType(String type)
    {
        throw new Error("Unsupport this method");
    }

    @Override
    @SuppressWarnings("unchecked")
    public MonsterModel wherePhase(int phase)
    {
        JSONArray result = (JSONArray) (Helper.readJsonArray(file)).get(phase - 1);

        result.forEach(r -> {
            parseMonsterObject((JSONObject) r);
        });

        return this;
    }

    private void parseMonsterObject(JSONObject monster)
    {
        data.add(factory.createMonster(handler,
                (String) monster.get("type"),
                Float.parseFloat(String.valueOf((double) monster.get("x"))),
                Float.parseFloat(String.valueOf((double) monster.get("y")))));
    }
}
