package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.GameController;
import core.entity.character.Character;
import core.main.Map;

public class GameView extends View
{
    private Map map;

    private Character player;

    private ArrayList<Character> monsters;

    public GameView(GameController game, Map map, Character player, ArrayList<Character> monsters)
    {
        super(game);
        this.game = game;
        this.map = map;
        this.player = player;
        this.monsters = monsters;
    }

    public void tick()
    {
        map.tick();
        player.tick();
        monsters.forEach(monster -> monster.tick());

        // Make the camera record the player
        game.getCameraService().focusOn(player);
    }

    public void render(Graphics graphics)
    {
        map.render(graphics);
        player.render(graphics);
        monsters.forEach(monster -> monster.render(graphics));
    }
}
