package entity.explosion;

import entity.Animation;
import entity.Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import core.main.Handler;

public abstract class Explosion extends Entity implements Cloneable
{
    protected int damage;

    protected boolean deleted;

    protected Animation animation;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    public int getDamage()
    {
        return damage;
    }

    public void setDamge(int damage)
    {
        this.damage = damage;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public Explosion(Handler handler)
    {
        super(handler);

        loadExplosionImage();
        loadDefaultValues();
        
        animation = new Animation(50, images);
    }

    @Override
    public Object clone() throws CloneNotSupportedException 
    { 
        animation.setIndex(0);
        
        return super.clone(); 
    }

    public void tick()
    {
        // The explosion will be deleted if all of images are rendered
        if (animation.getIndex() == images.size() - 1) {
            deleted = true;
        }
        else {
            animation.tick();
            currentImage = animation.getCurrentFrame();
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage,
                (int) (x - handler.getCamera().getXOffset()),
                (int) (y - handler.getCamera().getYOffset()),
                width, height, null);
    }

    protected abstract void loadExplosionImage();

    protected abstract void loadDefaultValues();
}
