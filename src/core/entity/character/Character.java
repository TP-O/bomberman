package core.entity.character;

import app.controller.GameController;
import core.game.Animation;
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

    protected BufferedImage currentFrame;

    protected Animation animationUp, animationDown, animationLeft, animationRight, animationStand;

    protected ArrayList<BufferedImage> up, down, left, right, stand;

    public Character(GameController gameController, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(x, y, width, height);
        this.speed = speed;
        this.damage = damage;
        this.health = health;
        this.gameController = gameController;

        loadCharacterImage();

        // Init animation
        animationUp = new Animation(250, up);
        animationDown = new Animation(250, down);
        animationLeft = new Animation(250, left);
        animationRight = new Animation(250, right);
        animationStand = new Animation(250, stand);
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

        currentFrame = animationUp.getCurrentFrame();
    }

    public void moveDown(float distance)
    {
        boolean lowerLeftCornerCollied = isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y + height + margin));
        boolean lowerRightCornerCollied = isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y + height + margin));

        if (!lowerLeftCornerCollied && !lowerRightCornerCollied) {
            y += distance;
        }

        currentFrame = animationDown.getCurrentFrame();
    }

    public void moveLeft(float distance)
    {
        boolean upperLeftCornerCollied = isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y));
        boolean lowerLeftCornerCollied = isCollied(Helper.getXOfTile(x - margin), Helper.getYOfTile(y + height));

        if (!upperLeftCornerCollied && !lowerLeftCornerCollied) {
            x -= distance;
        }

        currentFrame = animationLeft.getCurrentFrame();
    }

    public void moveRight(float distance)
    {
        boolean upperRightCornerCollied = isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y));
        boolean lowerRightCornerCollied = isCollied(Helper.getXOfTile(x + width + margin), Helper.getYOfTile(y + height));

        if (!upperRightCornerCollied && !lowerRightCornerCollied) {
            x += distance;
        }

        currentFrame = animationRight.getCurrentFrame();
    }

    public void tick()
    {
        // Update animation
        animationUp.tick();
        animationDown.tick(); 
        animationLeft.tick();
        animationRight.tick();
        animationStand.tick();

        currentFrame = animationStand.getCurrentFrame();
    }

    public void render(Graphics graphics)
    {
        graphics.drawImage(currentFrame,
            (int) (x - gameController.getCameraService().getXOffset()),
            (int) (y - gameController.getCameraService().getYOffset()),
            width, height, null);
    }

    // Load character images
    abstract protected void loadCharacterImage();
}
