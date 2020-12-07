package app.event.listener;

import app.model.ExplosionModel;
import entity.bomb.Bomb;
import entity.explosion.Explosion;

public class ExplosionListener implements Listener
{
    private Explosion explosion;

    private Bomb bomb;

    private int width;

    private int height;

    public ExplosionListener(Explosion explosion, Bomb bomb, int width, int height)
    {
        this.explosion = explosion;
        this.bomb = bomb;
        this.width = width;
        this.height = height;
    }

    @Override
    public void handle()
    {
        try {
            explosion.setX(calculateXOfExplosion(bomb.getX(), bomb.getWidth(), width));
            explosion.setY(calculateYOfExplosion(bomb.getY(), bomb.getHeight(), height, false));
            explosion.setWidth(width);
            explosion.setHeight(height);
            
            ExplosionModel.insert((Explosion) explosion.clone());
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
