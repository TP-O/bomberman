package app.model;

import entity.character.factory.AbstractPlayer;
import entity.character.player.Player;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import core.main.Handler;

public class PlayerModel extends Model<Player>
{
    public PlayerModel(Handler handler)
    {   
        this.handler = handler;

        data = null;
        path = "res/data/player.json";
    }

    @SuppressWarnings("unchecked")
    public PlayerModel where(int phase, String type)
    {
        JSONArray result = read(phase);

        result.forEach(r -> {
            parsePlayerObject((JSONObject) r, type);
        });

        return this;
    }

    private void parsePlayerObject(JSONObject player, String type)
    {
        AbstractPlayer playerFactory = new AbstractPlayer();

        data = (Player) playerFactory.createCharacter(handler, type,
                Float.parseFloat(String.valueOf((double) player.get("x"))),
                Float.parseFloat(String.valueOf((double) player.get("y"))),
                64, 64, 100, 0, 3.0f);
    }
}
