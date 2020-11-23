package core.entity.character;

import core.entity.Entity;
import java.awt.Graphics;
import app.controller.GameController;
import java.awt.image.BufferedImage;

public abstract class Character extends Entity
{
    protected GameController gameController;

    protected int health;

    protected int damage;

    protected float speed;

    protected BufferedImage BImage;

    public Character(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed, BufferedImage BIimage)
    {
        super(x, y, width, height);
        this.BImage = BIimage;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.gameController = gameController;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    public boolean isCollied(int x, int y)
    {
        return gameController
            .getMapController()
            .getMap()
            .getTiles(x, y)
            .isSolid();
    }
}
