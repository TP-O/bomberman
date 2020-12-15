package app.events;

import app.listeners.ExplosionListener;
import app.listeners.Listener;
import components.entities.fixed.bomb.Bomb;
import components.entities.fixed.explosion.Explosion;

public class ExplosionEvent implements Event
{
    private Listener listener;

    public ExplosionEvent(Explosion explosion, Bomb bomb, int width, int height, int range)
    {
        listener = new ExplosionListener(explosion, bomb, width, height, range);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }
}
