package app.event.event;

import entity.bomb.Bomb;
import entity.explosion.Explosion;
import app.event.listener.ExplosionListener;
import app.event.listener.Listener;

public class ExplosionEvent implements Event
{
    private Listener listener;

    public ExplosionEvent(Explosion explosion, Bomb bomb, int width, int height)
    {
        listener = new ExplosionListener(explosion, bomb, width, height);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }
}