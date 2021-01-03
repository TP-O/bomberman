package app.models;

import org.json.simple.JSONObject;

import components.entities.statics.traps.Trap;
import factories.trap.TrapFactory;

public class TrapModel extends Model<Trap>
{
    private TrapFactory factory = new TrapFactory();

    @Override
    protected void set()
    {
        table = "res/data/trap.json";
    }

    @Override
    protected void parseObject(JSONObject obstacle)
    {
        listData.add(factory.createTrap((String) obstacle.get("type"),
                Float.parseFloat(String.valueOf((double) obstacle.get("x"))),
                Float.parseFloat(String.valueOf((double) obstacle.get("y")))));
    }
}
