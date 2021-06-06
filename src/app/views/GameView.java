package app.views;

import java.awt.Graphics;
import java.util.ArrayList;

import app.cache.EntityCache;
import app.cache.GameCache;
import components.entities.dynamics.characters.player.Player;
import components.ui.Element;
import components.ui.button.PauseButton;
import core.Handler;
import core.Router;

public class GameView extends View {

    private Handler handler;

    private String[] entities;

    public GameView() {
        super();

        handler = Handler.getInstance();
        entities = new String[] {
            "trap",
            "obstacle",
            "block",
            "bomb",
            "item",
            "explosion",
            "monster",
            "otherMonster",
            "player",
        };
    }

    @Override
    public void buildUI() {
        elements = new ArrayList<Element>();
        elements.add(new PauseButton(11, 1, 5, 0, 0, 5));
    }

    @Override
    public void reset() {
        for (String entity: entities) {
            EntityCache.get(entity).clear();
        }
    }

    @Override
    public void tick() {
        handler.getMap().tick();

        elements.forEach(element -> element.tick());

        // Update entities
        for (String entity : entities) {
            EntityCache.get(entity).forEach(e -> {
                if (!e.isDeleted()) {
                    e.tick();
                }
            });
        }

        // Make the camera record the player
        handler.getCamera().focusOn((Player) EntityCache.get("player").get(0));

        // Remove deleted entities
        for (String entity : entities) {
            EntityCache.get(entity).removeIf(e -> e.isDeleted());
        }

        // New phase
        if (EntityCache.size("monster") == 0) {
            // Clear cahce
            for (String entity : entities) {
                EntityCache.remove(entity);
            }
            GameCache.push("phase", (int) GameCache.get("phase") + 1);
            // Next phase
            Router.getInstance().redirect("Game", true);
        }
    }

    @Override
    public void render(Graphics graphics) {
        handler.getMap().render(graphics);
        elements.forEach(element -> element.render(graphics));

        // Render entities
        for (String entity : entities) {
            EntityCache.get(entity).forEach(p -> {
                if (!p.isDeleted()) {
                    p.render(graphics);
                }
            });
        }
    }
}
