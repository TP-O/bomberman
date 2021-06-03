package factories.player;

import app.cache.GameCache;
import components.entities.dynamics.characters.player.Player;
import components.entities.dynamics.characters.player.children.*;

public class BasicPlayerFactory implements PlayerFactory {

    @Override
    public Player createPlayer(float x, float y) {
        Player player = null;

        switch ((String) GameCache.get("selected-player")) {
            case "Goku":
                player = new Goku(x, y);
                break;

            case "Kid":
                player = new Kid(x, y);
                break;

            case "Kirito":
                player = new Kirito(x, y);
                break;

            case "Monk":
                player = new Monk(x, y);
                break;

            case "Satoshi":
                player = new Satoshi(x, y);
                break;

            case "Shadow":
                player = new Shadow(x, y);
                break;

            default:
                player = new Goku(x, y);
        }

        return player;
    }
}
