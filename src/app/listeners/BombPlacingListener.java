package app.listeners;

import app.cache.BombCache;
import app.cache.Cache;
import components.entities.fixed.bomb.Bomb;

public class BombPlacingListener implements Listener
{
    private Bomb bomb;

    private Cache<Bomb> cache;

    private float x;

    private float y;

    public BombPlacingListener(Bomb bomb, float x, float y)
    {
        this.bomb = bomb;
        this.cache = new BombCache();
        this.x = x;
        this.y = y;
    }

    @Override
    public void handle()
    {
        bomb.setX(x);
        bomb.setY(y);
        bomb.setCreatedTime(System.currentTimeMillis());

        try {
            cache.insert((Bomb) bomb.clone());
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
