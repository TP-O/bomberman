package core.entity.character;

import app.controller.GameController;
import core.asset.Animation;
import core.entity.Entity;
import helper.Helper;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Character extends Entity
{
    protected int health;

    protected int damage;

    protected float speed;

    protected int margin = 4;

    protected GameController gameController;

    protected float xMove, yMove;

    protected Animation aniDown, aniUp, aniLeft, aniRight, aniStand;

    protected ArrayList<BufferedImage> up, down, left, right, stand;

    public Character(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(x, y, width, height);
        this.speed = speed;
        this.damage = damage;
        this.health = health;
        this.gameController = gameController;

        loadCharacterImage();
        aniUp = new Animation(500, up);
        aniDown = new Animation(500, down);
        aniLeft = new Animation(500, left);
        aniRight = new Animation(500, right);
        aniStand = new Animation(500, stand);
    }

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

    public void render(Graphics graphics)
    {
        graphics.drawImage(getCurrentAnimationFrame(),
            (int) (x - gameController.getCameraService().getXOffset()),
            (int) (y - gameController.getCameraService().getYOffset()),
            width, height, null);
    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (xMove < 0) {
            return aniLeft.getCurrentFrame();
        }
        else if (xMove > 0) {
            return aniRight.getCurrentFrame();
        }
        else if (yMove < 0) {
            return aniUp.getCurrentFrame();
        }
        else if (yMove > 0) {
            return aniDown.getCurrentFrame();
        }
        else {
            return aniStand.getCurrentFrame();
        }
    }

    abstract public void tick();

    abstract protected void loadCharacterImage();
}
