package app.model;

import java.util.ArrayList;

import entity.character.factory.AbstractMonster;
import entity.character.monster.Monster;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import core.main.Handler;

public class MonsterModel extends Model<ArrayList<Monster>>
{
    public MonsterModel(Handler handler)
    {
        this.handler = handler;

        data = new ArrayList<Monster>();
        path = "res/data/monster.json";
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
        AbstractMonster monsterFactory = new AbstractMonster();

        data.add((Monster) monsterFactory.createCharacter(handler,
                (String) monster.get("type"),
                Float.parseFloat(String.valueOf((double) monster.get("x"))),
                Float.parseFloat(String.valueOf((double) monster.get("y"))),
                Integer.parseInt(String.valueOf((long) monster.get("width"))),
                Integer.parseInt(String.valueOf((long) monster.get("height"))),
                Integer.parseInt(String.valueOf((long) monster.get("health"))),
                Integer.parseInt(String.valueOf((long) monster.get("damage"))),
                Float.parseFloat(String.valueOf((double) monster.get("speed")))));
    }
}
