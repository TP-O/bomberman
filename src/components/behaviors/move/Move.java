package components.behaviors.move;

import java.awt.image.BufferedImage;

import components.behaviors.animate.Animation;
import components.behaviors.collide.TileCollision;
import components.entities.dynamics.DynamicEntity;

public abstract class Move implements MoveBehavior
{
    protected boolean collied;

    protected DynamicEntity entity;

    private TileCollision collision;

    private BufferedImage currentFrame;

    protected Animation animationUp, animationDown, animationLeft, animationRight, animationStand;

    public Move(DynamicEntity entity)
    {
        this.entity = entity;

        collision = new TileCollision(entity);

        animationUp = new Animation(200, entity.getUpFrames());
        animationDown = new Animation(200, entity.getDownFrames());
        animationLeft = new Animation(200, entity.getLeftFrames());
        animationRight = new Animation(200, entity.getRightFrames());
        animationStand = new Animation(200, entity.getStandFrames());
    }

    @Override
    public BufferedImage getCurrentFrame()
    {
        return currentFrame;
    }

    public void moveUp()
    {
        if (!collision.collideTop()) {
            collied = false;

            float y = entity.getY();
            entity.setY(y - entity.getSpeed());
        }
        else {
            collied = true;
        }

        currentFrame = animationUp.getCurrentFrame();
        animationUp.tick();
    }

    public void moveDown()
    {
        if (!collision.collideBottom()) {
            collied = false;

            float y = entity.getY();
            entity.setY(y + entity.getSpeed());
        }
        else {
            collied = true;
        }
        
        currentFrame = animationDown.getCurrentFrame();
        animationDown.tick();
    }

    public void moveLeft()
    {
        if (!collision.collideLeft()) {
            collied = false;

            float x = entity.getX();
            entity.setX(x - entity.getSpeed());
        }
        else {
            collied = true;
        }

        currentFrame = animationLeft.getCurrentFrame();
        animationLeft.tick();
    }

    public void moveRight()
    {
        if (!collision.collideRight()) {
            collied = false;

            float x = entity.getX();
            entity.setX(x + entity.getSpeed());
        }
        else {
            collied = true;
        }

        currentFrame = animationRight.getCurrentFrame();
        animationRight.tick();
    }

    public void stand()
    {
        currentFrame = animationStand.getCurrentFrame();
        animationStand.tick();
    }
}
