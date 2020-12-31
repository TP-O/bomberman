package components.actions.attack.nonstop;

import java.util.ArrayList;
import java.util.List;

import app.cache.EntityCache;
import components.actions.attack.Attack;
import components.actions.attack.AttackDecorator;
import components.collision.Collision;
import components.collision.TileCollision;
import components.entities.statics.explosions.Explosion;

public class PlusExplosionCreating extends AttackDecorator
{
    private int range;

    private int scale;

    private Explosion explosion;

    private Collision collision;

    private List<Explosion> explosions;

    public PlusExplosionCreating(Attack attack,  Explosion explosion, int range)
    {
        super(attack);

        this.range = range;
        this.explosion = explosion;

        scale = 2;
        collision = new TileCollision(null);
        explosions = new ArrayList<Explosion>();
    }

    @Override
    public void decorate()
    {
        float x = calculateXOfExplosion(getAttacker().getX(),
                getAttacker().getWidth() * scale, getAttacker().getWidth() * scale);
        float y = calculateYOfExplosion(getAttacker().getY(),
                getAttacker().getHeight() * scale, getAttacker().getHeight() * scale);

        explosions.clear();

        createCenterExplosion(x, y);
        createTopExplosion(x, y);
        createBottomExplosion(x, y);
        createLeftExplosion(x, y);
        createRightExplosion(x, y);

        EntityCache.get("explosion").addAll(explosions);
    }

    private float calculateXOfExplosion(float x, int width, int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    private float calculateYOfExplosion(float y, int height, int explosionHeight)
    {
        return y - (explosionHeight / 2) + (height / 2);
    }

    private void createCenterExplosion(float x, float y)
    {
        handle(x, y);

        explosions.add((Explosion) explosion.clone());
    }

    private void createTopExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x, y - getAttacker().getWidth() * scale * i);

            if (collision.collideBottom()) {
                break;
            }

            explosions.add((Explosion) explosion.clone());
        }
    }

    private void createBottomExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x, y + getAttacker().getWidth() * scale * i);

            if (collision.collideTop()) {
                break;
            }

            explosions.add((Explosion) explosion.clone());
        }
    }

    private void createLeftExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x - getAttacker().getWidth() * scale * i, y);

            if (collision.collideRight()) {
                break;
            }

            explosions.add((Explosion) explosion.clone());
        }
    }

    private void createRightExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x + getAttacker().getWidth() * scale * i, y);

            if (collision.collideLeft()) {
                break;
            }

            explosions.add((Explosion) explosion.clone());
        }
    }

    // Set value for explosion
    private void handle(float x, float y)
    {
        explosion.setX(x);
        explosion.setY(y);
        explosion.setWidth(getAttacker().getWidth() * scale);
        explosion.setHeight(getAttacker().getWidth() * scale);

        collision.setTarget(explosion);
    }
}
