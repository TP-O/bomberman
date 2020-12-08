package entity;

import core.main.Handler;

public abstract class Entity
{
    protected float x, y;

    protected int width, height;

    protected Handler handler;

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

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width > 0 ? width : 64;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height > 0 ? height : 64;
    }

    public Entity(Handler handler)
    {
        this.handler = handler;
    }

    protected abstract void loadInfo();

    protected abstract void loadImages();

    protected abstract void loadAnimation();
}
