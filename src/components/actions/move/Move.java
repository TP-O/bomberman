package components.actions.move;

import core.Map;

import java.awt.image.BufferedImage;

import components.actions.collide.TileCollision;
import components.actions.animate.Animation;
import components.entities.Entity;

public abstract class Move
{
    private Entity entity;

    private TileCollision collision;

    private BufferedImage currentImage;

    protected float speed;

    protected boolean collied;

    protected Animation animationUp, animationDown, animationLeft, animationRight, animationStand;

    public BufferedImage getCurrentImage()
    {
        return currentImage;
    }

    public Move(Map map, Entity entity, float speed)
    {
        this.entity = entity;
        this.speed = speed;

        collision = new TileCollision(entity, map);
    }

    public void moveUp()
    {
        if (!collision.collideTop()) {
            collied = false;

            float y = entity.getY();
            entity.setY(y - speed);
        }
        else {
            collied = true;
        }

        currentImage = animationUp.getCurrentFrame();
        animationUp.tick();
    }

    public void moveDown()
    {
        if (!collision.collideBottom()) {
            collied = false;

            float y = entity.getY();
            entity.setY(y + speed);
        }
        else {
            collied = true;
        }
        
        currentImage = animationDown.getCurrentFrame();
        animationDown.tick();
    }

    public void moveLeft()
    {
        if (!collision.collideLeft()) {
            collied = false;

            float x = entity.getX();
            entity.setX(x - speed);
        }
        else {
            collied = true;
        }

        currentImage = animationLeft.getCurrentFrame();
        animationLeft.tick();
    }

    public void moveRight()
    {
        if (!collision.collideRight()) {
            collied = false;

            float x = entity.getX();
            entity.setX(x + speed);
        }
        else {
            collied = true;
        }

        currentImage = animationRight.getCurrentFrame();
        animationRight.tick();
    }

    public void stand()
    {
        currentImage = animationStand.getCurrentFrame();
        animationStand.tick();
    }

    public void setAnimationUp(Animation animation)
    {
        animationUp = animation;
    }

    public void setAnimationDown(Animation animation)
    {
        animationDown = animation;
    }

    public void setAnimationLeft(Animation animation)
    {
        animationLeft = animation;
    }

    public void setAnimationRight(Animation animation)
    {
        animationRight = animation;
    }

    public void setAnimationStand(Animation animation)
    {
        animationStand = animation;
    }

    public abstract void move();
}
