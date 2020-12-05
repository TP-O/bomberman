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

public abstract class Bomb extends Entity implements BombingStrategy, Cloneable
{
    protected int timer = 1000;

    protected long createdTime = 0;

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

        bomb = new BombController();
        animation = new Animation(200, images);

        // Set default position, width and height
        x -= width / 2;
        width = 32;
        height = 32;

        // Set default explosion of the bomb
        explosiveStrategy = new ExplosionA(game);
    }

    @Override
    public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
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

    // Find x to make the explosion wrap the bomb
    protected float calculateXOfExplosion(int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    // Find y to make the explosion wrap the bomb
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

        // The bomb will be deleted if the time is up
        if (createdTime != 0 && now - createdTime >= timer) {
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
