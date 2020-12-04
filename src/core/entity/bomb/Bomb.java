package core.entity.bomb;

import core.entity.Animation;
import core.entity.Entity;
import core.entity.explosion.ExplosiveStrategy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.BombController;
import app.controller.GameController;

public abstract class Bomb extends Entity
{
    protected int timer = 1000;

    protected long createdTime;

    protected BombController bomb;

    protected Animation animation;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    protected ExplosiveStrategy explosiveStrategy;

    public Bomb(GameController game, float x, float y)
    {
        super(game, x, y, 32, 32);

        loadBombImage();
        loadExplosion();

        this.game = game;
        this.x -= width / 2;
        bomb = new BombController();
        animation = new Animation(200, images);
        createdTime = System.currentTimeMillis();
    }

    public int getTimer() {
        return this.timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    protected float calculateXOfExplosion(int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    protected float calculateYOfExplosion(int explosionHeight, boolean isCenter)
    {
        return isCenter
                ? y - (explosionHeight / 2) + (height / 2)
                : y - explosionHeight + height;
    }

    public void setExplosion(ExplosiveStrategy explosionStrategy)
    {
        this.explosiveStrategy = explosionStrategy;
    }

    public void tick()
    {
        long now = System.currentTimeMillis();

        if (now - createdTime >= timer) {
            createExplosion();
            // Throw the bomb in the trash
            BombController.trash.add(this);
        }
        else {
            animation.tick();
            currentImage = animation.getCurrentFrame();
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentImage,
                (int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()),
                width, height, null);
    }

    protected abstract void loadBombImage();

    protected abstract void loadExplosion();

    protected abstract void createExplosion();
}
