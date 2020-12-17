package components.entities.fixed.item;

import components.actions.animate.Animation;
import components.entities.dynamic.character.player.Player;
import components.entities.fixed.FixedEntity;

import java.awt.Graphics;

import core.Handler;

public abstract class Item extends FixedEntity
{
    protected Item item;

    protected int timer;

    protected long createdTime;

    public Item(Handler handler)
    {
        super(handler);

        margin = 0;
        padding = 0;

        setEntityParameters();

        loadAllFrames();
        initializeAnimation();
    }

    public void setCreatedTime(long time)
    {
        createdTime = time;
    }

    @Override
    protected void initializeAnimation()
    {
        animation = new Animation(200, frames);
    }

    public void boost(Player entity)
    {
        deleted = true;
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
            animation.tick();
            currentFrame = animation.getCurrentFrame();
        }
    }
    
    @Override
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame,
                (int) (x),
                (int) (y),
                width, height, null);
    }
}
