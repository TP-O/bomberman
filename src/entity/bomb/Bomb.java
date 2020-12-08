package entity.bomb;

import entity.Animation;
import entity.Entity;
import entity.explosion.Explosion;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import core.main.Handler;

public abstract class Bomb extends Entity implements Cloneable
{
    protected int timer;

    protected boolean deleted;

    protected long createdTime;

    protected Explosion explosion;

    protected Animation animation;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    public void setCreatedTime(long time)
    {
        createdTime = time;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public Bomb(Handler handler)
    {
        super(handler);

        loadInfo();
        loadImages();
        loadAnimation();
    }

    @Override
    protected void loadAnimation()
    {
        animation = new Animation(200, images);
    }

    @Override
    public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
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
}
