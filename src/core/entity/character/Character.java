package core.entity.character;

import app.controller.GameController;
import core.entity.Animation;
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

    protected int padding = 25;

    protected int margin = 5;

    protected boolean collied = false;

    protected BufferedImage currentFrame;

    protected Animation animationUp, animationDown, animationLeft, animationRight, animationStand;

    protected ArrayList<BufferedImage> up, down, left, right, stand;

    public Character(GameController game, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(game, x, y, width, height);
        this.speed = speed;
        this.damage = damage;
        this.health = health;
        this.game = game;

        loadCharacterImage();

        // Init animation
        animationUp = new Animation(200, up);
        animationDown = new Animation(200, down);
        animationLeft = new Animation(200, left);
        animationRight = new Animation(200, right);
        animationStand = new Animation(200, stand);
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

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public boolean isCollied(int x, int y)
    {
        return game
            .getMap()
            .getMap()
            .getTiles(x, y)
            .isSolid();
    }

    protected void moveUp(float distance)
    {
        boolean upperLeftCornerCollied = isCollied(Helper.getXOfTile(x + padding),
                Helper.getYOfTile(y + padding - margin));
        boolean upperRightCornerCollied = isCollied(Helper.getXOfTile(x + width - padding),
                Helper.getYOfTile(y + padding - margin));

        if (!upperLeftCornerCollied && !upperRightCornerCollied) {
            y -= distance;
            collied = false;
        }
        else {
            collied = true;
        }

        currentFrame = animationUp.getCurrentFrame();
    }

    public void moveDown(float distance)
    {
        boolean lowerLeftCornerCollied = isCollied(Helper.getXOfTile(x + padding),
                Helper.getYOfTile(y + height - padding + margin));
        boolean lowerRightCornerCollied = isCollied(Helper.getXOfTile(x + width - padding),
                Helper.getYOfTile(y + height - padding + margin));

        if (!lowerLeftCornerCollied && !lowerRightCornerCollied) {
            y += distance;
            collied = false;
        }
        else {
            collied = true;
        }

        currentFrame = animationDown.getCurrentFrame();
    }

    public void moveLeft(float distance)
    {
        boolean upperLeftCornerCollied = isCollied(Helper.getXOfTile(x + padding- margin),
                Helper.getYOfTile(y + padding));
        boolean lowerLeftCornerCollied = isCollied(Helper.getXOfTile(x + padding - margin),
                Helper.getYOfTile(y + height - padding));

        if (!upperLeftCornerCollied && !lowerLeftCornerCollied) {
            x -= distance;
            collied = false;
        }
        else {
            collied = true;
        }

        currentFrame = animationLeft.getCurrentFrame();
    }

    public void moveRight(float distance)
    {
        boolean upperRightCornerCollied = isCollied(Helper.getXOfTile(x + width - padding + margin),
                Helper.getYOfTile(y + padding));
        boolean lowerRightCornerCollied = isCollied(Helper.getXOfTile(x + width - padding + margin),
                Helper.getYOfTile(y + height - padding));

        if (!upperRightCornerCollied && !lowerRightCornerCollied) {
            x += distance;
            collied = false;
        }
        else {
            collied = true;
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
            (int) (x - game.getCameraService().getXOffset()),
            (int) (y - game.getCameraService().getYOffset()),
            width, height, null);

        graphics.drawRect((int) (x - game.getCameraService().getXOffset()),
            (int) (y - game.getCameraService().getYOffset()),
            width, height);
    }

    // Load character images
    abstract protected void loadCharacterImage();
}
