package entity.character;

import entity.Animation;
import entity.Entity;
import helper.Helper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import core.main.Handler;

public abstract class Character extends Entity implements Movable
{
    protected int health;

    protected int damage;

    protected float speed;

    protected int margin = 5;

    protected int padding = 25;

    protected boolean collied = false;

    protected static long attackedTime = 0;

    protected BufferedImage currentFrame;

    protected ArrayList<BufferedImage> up, down, left, right, stand;

    protected Animation animationUp, animationDown, animationLeft, animationRight, animationStand;

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getDamage()
    {
        return damage;
    }

    public void setDamage(int damage)
    {
        this.damage = damage;
    }

    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        this.speed = speed;
    }

    protected boolean isCollied(int x, int y)
    {
        return handler
            .getMap()
            .getTiles(x, y)
            .isSolid();
    }

    public Character(Handler handler, float x, float y, int width, int height, int health, int damage, float speed)
    {
        super(handler, x, y, width, height);

        this.speed = speed;
        this.damage = damage;
        this.health = health;

        loadCharacterImage();

        // Init animation
        animationUp = new Animation(200, up);
        animationDown = new Animation(200, down);
        animationLeft = new Animation(200, left);
        animationRight = new Animation(200, right);
        animationStand = new Animation(200, stand);
    }

    @Override
    public void moveUp(float distance)
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

    @Override
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

    @Override
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

    @Override
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

    protected void displayHealthStatus(Graphics graphics)
    {   
        // Render the box
        graphics.setColor(Color.WHITE);
        graphics.drawRect((int) (x - handler.getCamera().getXOffset() - 1),
                (int) (y - handler.getCamera().getYOffset() - 21), width + 1, 6);
        
        // Render the health
        graphics.setColor(Color.RED);
        graphics.fillRect((int) (x - handler.getCamera().getXOffset()),
                (int) (y - handler.getCamera().getYOffset() - 20), (int) (width*(health / 100.0)), 5);
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
            (int) (x - handler.getCamera().getXOffset()),
            (int) (y - handler.getCamera().getYOffset()),
            width, height, null);
        
        displayHealthStatus(graphics);
    }

    abstract protected void loadCharacterImage();
}