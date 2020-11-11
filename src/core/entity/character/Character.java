package core.entity.character;

import core.entity.Entity;
import java.awt.Graphics;
import core.game.Game;
import java.awt.image.BufferedImage;

public abstract class Character extends Entity
{
    protected Game game;

    protected int health;

    protected int damage;

    protected float speed;

    protected BufferedImage BImage;

    public Character(Game game, float x, float y, int width, int height, int health, int damage, float speed, BufferedImage BIimage)
    {
        super(x, y, width, height);
        this.BImage = BIimage;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.game = game;
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
}
