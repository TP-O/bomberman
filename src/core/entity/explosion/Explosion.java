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
    protected int damage;

    protected Animation animation;

    protected ArrayList<BufferedImage> stand;

    protected BufferedImage currentFrame;

    public Explosion(GameController game, float x, float y, int width, int height)
    {
        super(game, x, y, width, height);

        loadExplosionImage();
        
        this.game = game;
        animation = new Animation(50, stand);
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamge(int damage)
    {
        this.damage = damage;
    }

    public void tick()
    {
        if (animation.getIndex() == stand.size() - 1) {
            ExplosionController.trash.add(this);
        }
        else {
            animation.tick();
            currentFrame = animation.getCurrentFrame();
        }
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame, (int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()), width, height, null);

        
        graphics.drawRect((int) (x - game.getCameraService().getXOffset()),
                (int) (y - game.getCameraService().getYOffset()), width, height);
    }

    protected abstract void loadExplosionImage();
}
