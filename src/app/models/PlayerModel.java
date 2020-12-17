package app.models;

import org.json.simple.JSONObject;

import components.entities.dynamics.character.player.Player;
import factories.player.PlayerFactory;

public class PlayerModel extends Model<Player>
{
    private PlayerFactory factory = new PlayerFactory();

    @Override
    protected void set()
    {
        table = "res/data/player.json";
    }

    @Override
    protected void parseObject(JSONObject player)
    {
        data = factory.createPlayer(
                Float.parseFloat(String.valueOf((double) player.get("x"))),
                Float.parseFloat(String.valueOf((double) player.get("y"))));
    }
}
