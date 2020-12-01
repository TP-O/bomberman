package core.entity.explosion;

import core.entity.Animation;
import core.entity.Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.ExplosionController;

public abstract class Explosion extends Entity
{
    protected int timer;

    protected int damage;

    protected long createdTime;

    protected Animation animation;

    protected ArrayList<BufferedImage> stand;

    protected BufferedImage currentFrame;

    public Explosion(float x, float y, int width, int height, int timer, int damage)
    {
        super(x, y, width, height);

        loadExplosionImage();
        
        this.timer = timer;
        this.damage = damage;
        createdTime = System.currentTimeMillis();
        animation = new Animation(100, stand);
    }

    public int getDamage()
    {
        return damage;
    }

    public void tick()
    {
        long now = System.currentTimeMillis();

        if (now - createdTime >= timer) {
            // Throw the bomb in the trash
            ExplosionController.trash.add(this);
        }

        animation.tick();

        currentFrame = animation.getCurrentFrame();
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame, (int) x, (int) y, width, height, null);
    }

    // Load bomb images
    protected abstract void loadExplosionImage();
}
