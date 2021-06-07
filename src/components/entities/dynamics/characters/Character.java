package components.entities.dynamics.characters;

import components.actions.display.Display;
import components.actions.display.DisplayAction;
import components.actions.display.nonstop.HealthDisplay;
import components.entities.dynamics.DynamicEntity;

import java.awt.Graphics;

public abstract class Character extends DynamicEntity {

    protected Display display;

    @Override
    protected void initializeActions() {
        super.initializeActions();

        display = new DisplayAction(this);
        display = new HealthDisplay(display);
    }

    @Override
    public void render(Graphics graphics) {
        super.render(graphics);

        // Display character's status: health...
        display.display(graphics);
    }
}
