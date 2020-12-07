package app.view;

import java.awt.Graphics;
import java.util.ArrayList;

import app.controller.GameController;
import entity.bomb.Bomb;
import entity.character.monster.Monster;
import entity.character.player.Player;
import entity.explosion.Explosion;
import core.main.Handler;
import core.main.Router;

public class GameView extends View
{
    private Player player;

    private ArrayList<Monster> monsters;

    private ArrayList<Bomb> bombs;

    private ArrayList<Explosion> explosions;

    public GameView(Handler handler, Player player, ArrayList<Monster> monsters,
            ArrayList<Bomb> bombs, ArrayList<Explosion> explosions)
    {
        this.handler = handler;
        this.player = player;
        this.monsters = monsters;
        this.bombs = bombs;
        this.explosions = explosions;
    }

    public void tick()
    {
        handler.getMap().tick();

        player.tick();

        monsters.forEach(monster -> {
            if (!monster.isDeleted()) {
                monster.tick();
            }
        });
        
        bombs.forEach(bomb -> {
            if (!bomb.isDeleted()) {
                bomb.tick();
            }
        });

        explosions.forEach(explosion -> {
            if (!explosion.isDeleted()) {
                explosion.tick();
            }
        });

        // Make the camera record the player
        handler.getCamera().focusOn(player);

        // Clear
        monsters.removeIf(monster -> monster.isDeleted());
        bombs.removeIf(bomb -> bomb.isDeleted());
        explosions.removeIf(explosion -> explosion.isDeleted());

        // New phase
        if (monsters.size() == 0) {
            GameController.phase++;
            Router.redirect("Game");
        }
    }

    public void render(Graphics graphics)
    {
        handler.getMap().render(graphics);

        player.render(graphics);

        monsters.forEach(monster -> {
            if (!monster.isDeleted()) {
                monster.render(graphics);
            }
        });

        bombs.forEach(bomb -> {
            if (!bomb.isDeleted()) {
                bomb.render(graphics);
            }
        });

        explosions.forEach(explosion -> {
            if (!explosion.isDeleted()) {
                explosion.render(graphics);
            }
        });
    }
}
