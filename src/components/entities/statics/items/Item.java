package components.entities.statics.items;

import components.animation.StaticAnimation;
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
        animation = new StaticAnimation(this, 150);
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
            super.tick();
        }
    }

    public abstract void boost(Player player);
}
