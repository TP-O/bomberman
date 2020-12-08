package app.model;

import java.util.ArrayList;

import entity.character.factory.CharacterFactory;
import entity.character.factory.MonsterFactory;
import entity.character.monster.Monster;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import core.main.Handler;

public class MonsterModel extends Model<ArrayList<Monster>>
{
    private CharacterFactory factory;

    public MonsterModel(Handler handler)
    {
        this.handler = handler;

        path = "res/data/monster.json";
        factory = new MonsterFactory();
        data = new ArrayList<Monster>();
    }

    @SuppressWarnings("unchecked")
    public MonsterModel where(int phase)
    {
        JSONArray result = read(phase);

        result.forEach(r -> {
            parseMonsterObject((JSONObject) r);
        });

        return this;
    }

    private void parseMonsterObject(JSONObject monster)
    {
        data.add((Monster) factory.createCharacter(handler,
                (String) monster.get("type"),
                Float.parseFloat(String.valueOf((double) monster.get("x"))),
                Float.parseFloat(String.valueOf((double) monster.get("y")))));
    }
}
