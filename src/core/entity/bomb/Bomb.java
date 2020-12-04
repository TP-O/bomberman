package core.entity.bomb;

import core.entity.Animation;
import core.entity.Entity;
import core.entity.explosion.ExplosiveStrategy;
import core.entity.explosion.children.ExplosionA;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.BombController;
import app.controller.GameController;

public abstract class Bomb extends Entity implements BombingStrategy
{
    protected int timer = 1000;

    protected long createdTime = -1;

    protected BombController bomb;

    protected Animation animation;

    protected BufferedImage currentImage;

    protected ArrayList<BufferedImage> images;

    protected ExplosiveStrategy explosiveStrategy;

    public Bomb(GameController game)
    {
        super(game);

        loadBombImage();

        this.game = game;
        this.x -= width / 2;
        width = 32;
        height = 32;
        bomb = new BombController();
        animation = new Animation(200, images);
        explosiveStrategy = new ExplosionA(game);
    }

    public int getTimer() {
        return this.timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void setExplosiveStrategy(ExplosiveStrategy explosionStrategy)
    {
        this.explosiveStrategy = explosionStrategy;
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

    @Override
    public void placeBomb(float x, float y)
    {
        this.x = x;
        this.y = y;

        createdTime = System.currentTimeMillis();
        bomb.createBomb(this);
    }

    public void tick()
    {
        long now = System.currentTimeMillis();

        if (createdTime != -1 && now - createdTime >= timer) {
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

    protected abstract void createExplosion();
}
