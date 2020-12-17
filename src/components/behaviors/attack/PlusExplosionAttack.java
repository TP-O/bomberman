package components.behaviors.attack;

import java.util.ArrayList;
import java.util.List;

import app.cache.EntityCache;
import components.behaviors.collide.CollisionBehavior;
import components.behaviors.collide.TileCollision;
import components.entities.Entity;
import components.entities.statics.explosions.Explosion;

public class PlusExplosionAttack implements AttackBehavior
{
    private int range;

    private int scale;

    private Entity attacker;

    private Explosion explosion;

    private CollisionBehavior collision;

    private List<Explosion> explosions;

    public PlusExplosionAttack(Entity attacker, Explosion explosion, int range)
    {
        this.attacker = attacker;
        this.explosion = explosion;
        this.range = range;

        scale = 2;
        collision = new TileCollision(null);
        explosions = new ArrayList<Explosion>();
    }

    @Override
    public void attack()
    {
        float x = calculateXOfExplosion(attacker.getX(),
                attacker.getWidth() * scale, attacker.getWidth() * scale);
        float y = calculateYOfExplosion(attacker.getY(),
                attacker.getHeight() * scale, attacker.getHeight() * scale);

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
            handle(x, y - attacker.getWidth() * scale * i);

            if (collision.collideBottom()) {
                break;
            }

            explosions.add((Explosion) explosion.clone());
        }
    }

    private void createBottomExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x, y + attacker.getWidth() * scale * i);

            if (collision.collideTop()) {
                break;
            }

            explosions.add((Explosion) explosion.clone());
        }
    }

    private void createLeftExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x - attacker.getWidth() * scale * i, y);

            if (collision.collideRight()) {
                break;
            }
            
            explosions.add((Explosion) explosion.clone());
        }
    }

    private void createRightExplosion(float x, float y)
    {
        for (int i = 1; i <= range; i++) {
            handle(x + attacker.getWidth() * scale * i, y);

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
        explosion.setWidth(attacker.getWidth() * scale);
        explosion.setHeight(attacker.getWidth() * scale);

        collision.setTarget(explosion);
    }
}
