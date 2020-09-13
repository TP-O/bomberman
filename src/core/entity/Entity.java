package core.entity;

public abstract class Entity
{
    protected float x, y;

    protected int width, height;

    public Entity(float inX, float inY, int inWidth, int inHeight)
    {
        x = inX;
        y = inY;
        width = inWidth;
        height = inHeight;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
