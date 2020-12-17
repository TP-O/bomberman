package app.models;

import org.json.simple.JSONObject;

import components.entities.dynamics.character.monster.Monster;
import factories.monster.MonsterFactory;

public class MonsterModel extends Model<Monster>
{
    private MonsterFactory factory = new MonsterFactory();

    @Override
    protected void set()
    {
        table = "res/data/monster.json";
    }

    @Override
    protected void parseObject(JSONObject monster)
    {
        listData.add(factory.createMonster((String) monster.get("type"),
                Float.parseFloat(String.valueOf((double) monster.get("x"))),
                Float.parseFloat(String.valueOf((double) monster.get("y")))));
    }
}
