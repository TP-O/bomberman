package app.event.listener;

import java.util.ArrayList;

import app.model.ExplosionModel;
import entity.bomb.Bomb;
import entity.explosion.Explosion;

public class PlusExplosionListener implements Listener
{
    private Explosion explosion;

    private Bomb bomb;

    private int width;

    private int height;

    private int range;

    public PlusExplosionListener(Explosion explosion, Bomb bomb, int width, int height, int range)
    {
        this.explosion = explosion;
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
        float y = calculateYOfExplosion(bomb.getY(), bomb.getHeight(), height, true);

        try {
            explosion.setX(x);
            explosion.setY(y);
            explosion.setWidth(width);
            explosion.setHeight(height);

            explosions.add((Explosion) explosion.clone());

            for (int i = 1; i <= range; i++) {
                    explosion.setX(x - width * i);
                    explosion.setY(y);
                    explosion.setWidth(width);
                    explosion.setHeight(height);

                    explosions.add((Explosion) explosion.clone());

                    explosion.setX(x + width * i);
                    explosion.setY(y);
                    explosion.setWidth(width);
                    explosion.setHeight(height);

                    explosions.add((Explosion) explosion.clone());

                    explosion.setX(x);
                    explosion.setY(y - height * i);
                    explosion.setWidth(width);
                    explosion.setHeight(height);

                    explosions.add((Explosion) explosion.clone());

                    explosion.setX(x);
                    explosion.setY(y + height *i);
                    explosion.setWidth(width);
                    explosion.setHeight(height);

                    explosions.add((Explosion) explosion.clone());
            }

            ExplosionModel.insert(explosions);
        }
        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private float calculateXOfExplosion(float x, int width, int explosionWidth)
    {
        return x - (explosionWidth / 2) + (width / 2);
    }

    private float calculateYOfExplosion(float y, int height, int explosionHeight, boolean isCenter)
    {
        return isCenter
                ? y - (explosionHeight / 2) + (height / 2)
                : y - explosionHeight + height;
    } 
}
