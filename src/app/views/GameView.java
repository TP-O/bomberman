package app.views;

import java.awt.Graphics;

import app.cache.EntityCache;
import app.cache.GameCache;
import components.entities.dynamics.character.player.Player;
import core.Handler;
import core.Router;

public class GameView extends View
{
    private Handler handler;

    private String[] entities;

    public GameView()
    {
        super();

        handler = Handler.getInstance();

        entities = new String[] {
            "trap",
            "obstacle",
            "block",
            "bomb",
            "item",
            "explosion",
            // "monster",
            "player"
        };
    }

    @Override
    public void buildUI()
    {
        //
    }

    @Override
    public void tick()
    {
        handler.getMap().tick();

        // Update entities
        for (String entity: entities) {
            EntityCache.get(entity).forEach(e -> {
                if (!e.isDeleted()) {
                    e.tick();
                }
            });
        }

        // Make the camera record the player
        handler.getCamera().focusOn((Player) EntityCache.get("player").get(0));

        // Remove deleted entities
        for (String entity: entities) {
            EntityCache.get(entity).removeIf(e -> e.isDeleted());
        }

        // New phase
        if (EntityCache.size("monster") == 0) {
            // Clear cahce
            for (String entity: entities) {
                EntityCache.remove(entity);
            }

            GameCache.push("phase", (int) GameCache.get("phase") + 1);

            // Next phase
            Router.getInstance().redirect("Game", true);
        }
    }

    @Override
    public void render(Graphics graphics)
    {
        handler.getMap().render(graphics);

        // Render entities
        for (String entity: entities) {
            EntityCache.get(entity).forEach(p -> {
                if (!p.isDeleted()) {
                    p.render(graphics);
                }
            });
        }
    }
}
