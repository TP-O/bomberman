package components.entities.dynamics.character;

import components.behaviors.attack.AttackBehavior;
import components.behaviors.display.DisplayBehavior;
import components.behaviors.display.HealthDisplay;
import components.entities.dynamics.DynamicEntity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public abstract class Character extends DynamicEntity
{
    protected AttackBehavior attack;

    protected List<DisplayBehavior> displays;

    @Override
    protected void initializeActions()
    {
        displays = new ArrayList<DisplayBehavior>();

        // Push status displays
        displays.add(new HealthDisplay(this));
    }

    @Override
    public void render(Graphics graphics)
    {
        super.render(graphics);
        
        // Display character's status: health...
        displays.forEach(display -> display.display(graphics));
    }
}
