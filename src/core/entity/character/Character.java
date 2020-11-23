package core.entity.character;

import core.entity.Entity;
import helper.Helper;

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

    protected int margin = 4;

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

    protected void moveUp(float distance)
    {
        boolean upperLeftCornerCollied = isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y - margin));
        boolean upperRightCornerCollied = isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y - margin));

        if (!upperLeftCornerCollied && !upperRightCornerCollied) {
            y -= distance;
        }
    }

    public void moveDown(float distance)
    {
        boolean lowerLeftCornerCollied = isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y + height + margin));
        boolean lowerRightCornerCollied = isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y + height + margin));

        if (!lowerLeftCornerCollied && !lowerRightCornerCollied) {
            y += distance;
        }
    }

    public void moveLeft(float distance)
    {
        boolean upperLeftCornerCollied = isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y));
        boolean lowerLeftCornerCollied = isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y + height));

        if (!upperLeftCornerCollied && !lowerLeftCornerCollied) {
            x -= distance;
        }
    }

    public void moveRight(float distance)
    {
        boolean upperRightCornerCollied = isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y));
        boolean lowerRightCornerCollied = isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y + height));

        if (!upperRightCornerCollied && !lowerRightCornerCollied) {
            x += distance;
        }
    }
}
