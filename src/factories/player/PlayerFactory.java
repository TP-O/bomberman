package factories.player;

import core.Handler;
import components.entities.dynamic.character.player.Player;
import components.entities.dynamic.character.player.children.*;

public class PlayerFactory
{
    public Player createPlayer(Handler handler, String type, float x, float y)
    {
        Player player = null;

        switch (type) {
            case "Goku":
                player = new Goku(handler, x, y);
                break;

            case "Kid":
                player = new Kid(handler, x, y);
                break;

            case "Kirito":
                player = new Kirito(handler, x, y);
                break;

            case "Monk":
                player = new Monk(handler, x, y);
                break;

            case "Satoshi":
                player = new Satoshi(handler, x, y);
                break;

            case "Shadow":
                player = new Shadow(handler, x, y);
                break;
        
            default:
                player = null;
        }

        return player;
    }
}
