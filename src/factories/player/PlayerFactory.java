package factories.player;

import components.entities.dynamics.characters.player.Player;

public interface PlayerFactory {
    public Player createPlayer(float x, float y);
}
