package core.entity.bomb;

import core.entity.Animation;
import core.entity.Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.BombController;
import app.controller.ExplosionController;

public abstract class Bomb extends Entity
{
    protected int timer;

    protected int range;

    protected int damage;

    protected long createdTime;

    protected Animation animation;

    protected BufferedImage currentFrame;

    protected ArrayList<BufferedImage> stand;

    protected BombController bomb;

    protected ExplosionController explosion;

    public Bomb(float x, float y, int width, int height)
    {
        super(x, y, width, height);

        loadBombImage();

        createdTime = System.currentTimeMillis();
        animation = new Animation(200, stand);
        explosion = new ExplosionController();
        bomb = new BombController();
    }

    public void tick()
    {
        long now = System.currentTimeMillis();

        if (now - createdTime >= timer) {
            createExplosion();
            // Throw the bomb in the trash
            BombController.trash.add(this);
        }

        animation.tick();

        currentFrame = animation.getCurrentFrame();
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame,
                (int) (x - width/2),
                (int) (y - height/2),
                width, height, null);
    }

    protected abstract void loadBombImage();

    protected abstract void createExplosion();
}
