package core.state;

import java.awt.Graphics;

import core.entity.characters.Characters;
import core.entity.characters.CharactersBuilder;
import core.game.Game;
import core.game.Map;

public class GameState extends State
{
    private Characters player;

    private Map map;

    public GameState(Game game)
    {
        super(game);

        player = new CharactersBuilder("Player")
            .setGame(game)
            .setX(35)
            .setY(35)
            .build();

        map = new Map(game, "/map01.txt");
    }

    public void tick()
    {
        player.tick();
        map.tick();

        // make the camera record the player
        game.getCamera().recordEntity(player);
    }

    public void render(Graphics graphics)
    {
        map.render(graphics);
        player.render(graphics);
    }
}
