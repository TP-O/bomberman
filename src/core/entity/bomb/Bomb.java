package core.entity.bomb;

import core.entity.Animation;
import core.entity.Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.BombController;
import app.controller.ExplosionController;
import app.controller.GameController;

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

    public Bomb(GameController game, float x, float y)
    {
        super(game, x, y, 0, 0);

        loadSize();
        loadBombImage();

        this.game = game;
        createdTime = System.currentTimeMillis();
        animation = new Animation(200, stand);
        explosion = new ExplosionController();
        bomb = new BombController();
    }

    protected float calculateExplosionX(int explosionWidth)
    {
        return x - width*((int) (explosionWidth / (2*width)));
    }

    protected float calculateExplosionY(int explosionHeight, boolean isCenter)
    {
        return isCenter
                ? y - height*((int) (explosionHeight / (2*height)))
                : y - height*2*((int) (explosionHeight / (2*height)));
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
                (int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()),
                width, height, null);
    }

    protected abstract void loadSize();

    protected abstract void loadBombImage();

    protected abstract void createExplosion();
}
