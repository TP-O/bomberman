package core.entity.explosion;

import core.entity.Animation;
import core.entity.Entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import app.controller.ExplosionController;
import app.controller.GameController;

public abstract class Explosion extends Entity
{
    protected int timer;

    protected int damage;

    protected long createdTime;

    protected Animation animation;

    protected ArrayList<BufferedImage> stand;

    protected BufferedImage currentFrame;

    public Explosion(GameController game, float x, float y, int width, int height, int timer, int damage)
    {
        super(game, x, y, width, height);

        loadExplosionImage();
        
        this.game = game;
        this.timer = timer;
        this.damage = damage;
        createdTime = System.currentTimeMillis();
        animation = new Animation(50, stand);
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
        graphics.drawImage(currentFrame, (int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()), width, height, null);

        
        graphics.drawRect((int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()), width, height);
    }

    // Load bomb images
    protected abstract void loadExplosionImage();
}
