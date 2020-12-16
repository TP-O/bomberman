package components.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import components.actions.animate.Animation;
import core.Handler;

public abstract class Entity
{
    protected float x;

    protected float y;

    protected int width;

    protected int height;

    protected boolean deleted;

    protected Handler handler;

    protected Animation animation;
    
    protected BufferedImage currentFrame;

    protected List<BufferedImage> frames;

    protected int margin = 5;

    protected int padding = 25;

    public Entity(Handler handler)
    {
        this.handler = handler;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public int getPadding()
    {
        return padding;
    }

    public int getMargin()
    {
        return margin;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public int getHealth()
    {
        throw new Error("Unsupport this method");
    }

    public void setHealth(int health)
    {
        throw new Error("Unsupport this method");
    }

    public int getMaxHealth()
    {
        throw new Error("Unsupport this method");
    }

    public void setMaxHealth(int health)
    {
        throw new Error("Unsupport this method");
    }

    public int getDamage()
    {
        throw new Error("Unsupport this method");
    }

    public void setDamage(int damage)
    {
        throw new Error("Unsupport this method");
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame,
                (int) (x - handler.getCamera().getXOffset()),
                (int) (y - handler.getCamera().getYOffset()),
                width, height, null);
    }

    public abstract void tick();

    protected abstract void loadAllFrames();

    protected abstract void initializeAnimation();

    protected abstract void setEntityParameters();
}
