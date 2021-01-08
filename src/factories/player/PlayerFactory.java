package factories.player;

import components.entities.dynamics.character.player.Player;

public interface PlayerFactory
{
    public Player createPlayer(float x, float y);
}
