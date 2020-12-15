package app.listeners;

import java.util.ArrayList;

import app.cache.Cache;
import app.cache.ExplosionCache;
import core.Handler;
import components.entities.fixed.bomb.Bomb;
import components.entities.fixed.explosion.Explosion;
import helper.Helper;

public class PlusExplosionListener implements Listener
{
    private Handler handler;

    private Explosion explosion;

    private Cache<Explosion> cache;

    private Bomb bomb;

    private int width;

    private int height;

    private int range;

    public PlusExplosionListener(Handler handler, Explosion explosion, Bomb bomb, int width, int height, int range)
    {
        this.handler = handler;
        this.explosion = explosion;
        this.cache = new ExplosionCache();
        this.bomb = bomb;
        this.width = width;
        this.height = height;
        this.range = range;
    }

    @Override
    public void handle()
    {
        ArrayList<Explosion> explosions = new ArrayList<Explosion>();

        float x = calculateXOfExplosion(bomb.getX(), bomb.getWidth(), width);
        float y = calculateYOfExplosion(bomb.getY(), bomb.getHeight(), height);

        createCenterExplosion(explosions, x, y);
        createTopExplosion(explosions, x, y);
        createBottomExplosion(explosions, x, y);
        createLeftExplosion(explosions, x, y);
        createRightExplosion(explosions, x, y);

        cache.insert(explosions);
    }

    private float calculateXOfExplosion(float x, int width, int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    private float calculateYOfExplosion(float y, int height, int explosionHeight)
    {
        return y - (explosionHeight / 2) + (height / 2);
    }

    private void createCenterExplosion(ArrayList<Explosion> explosions, float x, float y)
    {
        createOneExplosion(explosions, x, y);
    }

    private void createTopExplosion(ArrayList<Explosion> explosions, float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            if (isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y - height * i + height))
                    || isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y - height * i + height))
            ) {
                break;
            }
            
            createOneExplosion(explosions, x, y - height * i);
        }
    }

    private void createBottomExplosion(ArrayList<Explosion> explosions, float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            if (isCollied(Helper.getXOfTile(x + width), Helper.getYOfTile(y + height * i))
                    || isCollied(Helper.getXOfTile(x), Helper.getYOfTile(y + height * i))
            ) {
                break;
            }

            createOneExplosion(explosions, x, y + height * i);
        }
    }

    private void createLeftExplosion(ArrayList<Explosion> explosions, float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            if (isCollied(Helper.getXOfTile(x - width * (i -1)), Helper.getYOfTile(y))
                    || isCollied(Helper.getXOfTile(x - width * (i - 1)), Helper.getYOfTile(y + height))
            ) {
                break;
            }

            createOneExplosion(explosions, x - width * i, y);
        }
    }

    private void createRightExplosion(ArrayList<Explosion> explosions, float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            if (isCollied(Helper.getXOfTile(x + width * i), Helper.getYOfTile(y))
                    || isCollied(Helper.getXOfTile(x + width * i), Helper.getYOfTile(y + height))
            ) {
                break;
            }

            createOneExplosion(explosions, x + width * i, y);
        }
    }

    private void createOneExplosion(ArrayList<Explosion> explosions, float x, float y)
    {
        explosion.setX(x);
        explosion.setY(y);
        explosion.setWidth(width);
        explosion.setHeight(height);

        explosions.add((Explosion) explosion.clone());
    }

    private boolean isCollied(int x, int y)
    {
        return handler
            .getMap()
            .getTiles(x, y)
            .isSolid();
    }
}
