package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.BombController;
import app.controller.CharacterController;
import app.controller.ExplosionController;
import app.controller.GameController;
import core.entity.bomb.Bomb;
import core.entity.character.Character;
import core.entity.explosion.Explosion;
import core.main.Map;

public class GameView extends View
{
    private Map map;

    private Character player;

    private ArrayList<Character> monsters;

    private ArrayList<Bomb> bombs;

    private ArrayList<Explosion> explosions;

    public GameView(GameController game, Map map, Character player, ArrayList<Character> monsters,
            ArrayList<Bomb> bombs, ArrayList<Explosion> explosions)
    {
        super(game);
        this.game = game;
        this.map = map;
        this.player = player;
        this.monsters = monsters;
        this.bombs = bombs;
        this.explosions = explosions;
    }

    public void tick()
    {
        map.tick();
        player.tick();
        monsters.forEach(monster -> monster.tick());
        bombs.forEach(bomb -> bomb.tick());
        explosions.forEach(explosion -> explosion.tick());

        // Clear the trash
        monsters.removeAll(CharacterController.trash);
        bombs.removeAll(BombController.trash);
        explosions.removeAll(ExplosionController.trash);

        // Reset the trash
        BombController.trash.clear();
        ExplosionController.trash.clear();

        // Make the camera record the player
        game.getCameraService().focusOn(player);
    }

    public void render(Graphics graphics)
    {
        map.render(graphics);
        player.render(graphics);
        monsters.forEach(monster -> monster.render(graphics));
        bombs.forEach(bomb -> bomb.render(graphics));
        explosions.forEach(explosion -> explosion.render(graphics));
    }
}
