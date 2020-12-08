package app.model;

import entity.character.factory.CharacterFactory;
import entity.character.factory.PlayerFactory;
import entity.character.player.Player;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import core.main.Handler;

public class PlayerModel extends Model<Player>
{
    private CharacterFactory factory;

    public PlayerModel(Handler handler)
    {   
        this.handler = handler;
        
        path = "res/data/player.json";
        factory = new PlayerFactory();
        data = null;
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
        data = (Player) factory.createCharacter(handler, type,
                Float.parseFloat(String.valueOf((double) player.get("x"))),
                Float.parseFloat(String.valueOf((double) player.get("y"))));
    }
}
