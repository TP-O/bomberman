package app.listeners;

import app.cache.Cache;
import app.cache.ExplosionCache;
import components.entities.fixed.bomb.Bomb;
import components.entities.fixed.explosion.Explosion;

public class ExplosionListener implements Listener
{
    private Explosion explosion;

    private Cache<Explosion> cache;

    private Bomb bomb;

    private int width;

    private int height;

    private int range;

    public ExplosionListener(Explosion explosion, Bomb bomb, int width, int height, int range)
    {
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
        explosion.setX(calculateXOfExplosion(bomb.getX(), bomb.getWidth(), width * range));
        explosion.setY(calculateYOfExplosion(bomb.getY(), bomb.getHeight(), height * range));
        explosion.setWidth(width * range);
        explosion.setHeight(height * range);
            
        cache.insert((Explosion) explosion.clone());
    }

    private float calculateXOfExplosion(float x, int width, int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    private float calculateYOfExplosion(float y, int height, int explosionHeight)
    {
        return y - explosionHeight + height;
    }
}
