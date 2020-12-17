package app.models;

import components.entities.dynamic.character.player.Player;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import core.Handler;
import factories.player.PlayerFactory;
import helper.Helper;

public class PlayerModel implements Model<Player>
{
    private Handler handler;

    private Player data;

    private PlayerFactory factory = new PlayerFactory();

    private String file = "res/data/player.json";

    private String type = "Satoshi";

    public PlayerModel(Handler handler)
    {   
        this.handler = handler;
    }

    @Override
    public Player get()
    {
        return data;
    }

    @Override
    public PlayerModel whereType(String type)
    {
        this.type = type;

        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PlayerModel wherePhase(int phase)
    {
        JSONArray result = (JSONArray) (Helper.readJsonArray(file)).get(phase - 1);

        result.forEach(r -> {
            parsePlayerObject((JSONObject) r, type);
        });

        return this;
    }

    private void parsePlayerObject(JSONObject player, String type)
    {
        data = factory.createPlayer(handler, type,
                Float.parseFloat(String.valueOf((double) player.get("x"))),
                Float.parseFloat(String.valueOf((double) player.get("y"))));
    }
}
