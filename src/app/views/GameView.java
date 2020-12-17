package app.views;

import java.awt.Graphics;
import java.util.List;

import app.controllers.GameController;
import components.entities.fixed.bomb.Bomb;
import components.entities.dynamic.character.monster.Monster;
import components.entities.dynamic.character.player.Player;
import components.entities.fixed.explosion.Explosion;
import components.entities.fixed.item.Item;
import core.Handler;
import core.Router;

public class GameView implements View
{
    private Handler handler;

    private Player player;

    private List<Monster> monsters;

    private List<Bomb> bombs;

    private List<Explosion> explosions;

    private List<Item> items;

    public GameView(Handler handler, Player player, List<Monster> monsters,
            List<Bomb> bombs, List<Explosion> explosions, List<Item> items)
    {
        this.handler = handler;
        this.player = player;
        this.monsters = monsters;
        this.bombs = bombs;
        this.explosions = explosions;
        this.items = items;
    }

    @Override
    public void build()
    {
        //
    }

    @Override
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

        items.forEach(item -> {
            if (!item.isDeleted()) {
                item.tick();
            }
        });

        // Make the camera record the player
        handler.getCamera().focusOn(player);

        // Clear
        monsters.removeIf(monster -> monster.isDeleted());
        bombs.removeIf(bomb -> bomb.isDeleted());
        explosions.removeIf(explosion -> explosion.isDeleted());
        items.removeIf(item -> item.isDeleted());

        // New phase
        if (monsters.size() == 0) {
            GameController.phase++;
            Router.redirect("Game");
        }
    }

    @Override
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

        items.forEach(item -> {
            if (!item.isDeleted()) {
                item.render(graphics);
            }
        });
    }
}
