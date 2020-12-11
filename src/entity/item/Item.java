package entity.item;

import entity.Entity;
import entity.Animation;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import core.main.Handler;

public abstract class Item extends Entity
{
    public static final int PICK_UP = -1;

    protected int timer;

    protected long createdTime;
    
    protected boolean deleted;  

    protected int count;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    protected Animation animation;

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setCreatedTime(long time)
    {
        createdTime = time;
    }

    public Item(Handler handler)
    {
        super(handler);
       
        count = 1;
        loadItemImage();
        loadDefaultValues();

        animation = new Animation(150, images);
    }

    public void tick()
    {
        animation.tick();
        currentImage = animation.getCurrentFrame();
    }
    
    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage,
                (int) (x - handler.getCamera().getXOffset()),
                (int) (y - handler.getCamera().getYOffset()),
                width, height, null);
    }
    
    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    protected abstract void loadItemImage();

    protected abstract void loadDefaultValues();
}