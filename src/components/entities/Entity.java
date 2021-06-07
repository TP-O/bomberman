package components.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import core.Handler;

public abstract class Entity {

    protected float x;

    protected float y;

    protected int width;

    protected int height;

    protected int margin;

    protected int padding;

    protected int life;

    protected int health;

    protected int damage;

    protected float speed;

    protected boolean deleted;

    protected long attackedAt;

    protected long takedDamageAt;

    protected Handler handler;

    protected BufferedImage currentFrame;

    public Entity() {
        margin = 5;
        padding = 15;
        attackedAt = 0;
        takedDamageAt = 0;
        handler = Handler.getInstance();

        loadAllFrames();
        setEntityParameters();
        initializeActions();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getPadding() {
        return padding;
    }

    public int getMargin() {
        return margin;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHealth() {
        return health;
    }

    public int getLife() {
        return life;
    }

    public int getDamage() {
        return damage;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setX(float x) {
        this.x = x >= 0 ? x : 0;
    }

    public void setY(float y) {
        this.y = y >= 0 ? y : 0;
    }

    public void setWidth(int width) {
        this.width = width >= 1 ? width : 1;
    }

    public void setHeight(int height) {
        this.height = height >= 1 ? height : 1;
    }

    public void setLife(int life) {
        this.life = life >= 1 ? life : 1;
    }

    public void setHealth(int health) {
        long now = System.currentTimeMillis();

        if (now - takedDamageAt >= 1000 || takedDamageAt == 0) {
            this.health = health;

            if (this.health <= 0) {
                delete();
            } else if (this.health > life) {
                this.health = life;
            }

            takedDamageAt = now;
        }
    }

    public void setDamage(int damage) {
        this.damage = damage >= 1 ? damage : 1;
    }

    public void setSpeed(float speed) {
        this.speed = speed > 0 ? speed : 0.1f;
    }

    public void setCurrentFrame(BufferedImage frame) {
        currentFrame = frame;
    }

    public void delete() {
        deleted = true;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(currentFrame, (int) (x - handler.getCamera().getXOffset()),
                (int) (y - handler.getCamera().getYOffset()), width, height, null);

        graphics.drawRect((int) (x - handler.getCamera().getXOffset()), (int) (y - handler.getCamera().getYOffset()),
                width, height);
    }

    public abstract void tick();

    protected abstract void loadAllFrames();

    protected abstract void initializeActions();

    protected abstract void setEntityParameters();
}
