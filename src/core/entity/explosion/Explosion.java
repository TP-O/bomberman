package core.entity.explosion;

import core.entity.Animation;
import core.entity.Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.ExplosionController;
import app.controller.GameController;

public abstract class Explosion extends Entity implements ExplosiveStrategy, Cloneable
{
    protected int damage;

    protected Animation animation;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    protected ExplosionController explosion;

    public Explosion(GameController game)
    {
        super(game);

        loadExplosionImage();
        
        this.game = game;
        animation = new Animation(50, images);
        explosion = new ExplosionController();
    }

    public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamge(int damage)
    {
        this.damage = damage;
    }

    @Override
    public void createExplosion(float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        // Reset images
        animation.setIndex(0);
        
        // Add this explosion to data
        explosion.createExplosion(this);
    }

    public void tick()
    {
        // The explosion will be deleted if all of images are rendered
        if (animation.getIndex() == images.size() - 1) {
            ExplosionController.trash.add(this);
        }
        else {
            animation.tick();
            currentImage = animation.getCurrentFrame();
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage, (int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()), width, height, null);
    }

    protected abstract void loadExplosionImage();
}
