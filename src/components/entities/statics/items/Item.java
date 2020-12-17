package components.entities.statics.items;

import components.behaviors.animate.Animation;
import components.entities.dynamics.character.player.Player;
import components.entities.statics.StaticEntity;

public abstract class Item extends StaticEntity
{
    protected int timer;

    protected long createdTime;

    public Item()
    {
        super();

        margin = 0;
        padding = 0;
        createdTime = System.currentTimeMillis();
    }

    @Override
    protected void initializeActions()
    {
        // Set animation
        animation = new Animation(150, frames);
    }

    @Override
    public void tick()
    {
        long now = System.currentTimeMillis();

        // The item will be deleted if the time is up
        if (now - createdTime >= timer) {
            deleted = true;
        }
        else {
            // Update frame
            animation.tick();
            currentFrame = animation.getCurrentFrame();
        }
    }

    public abstract void boost(Player player);
}
