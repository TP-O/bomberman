package app.events;

import app.listeners.Listener;
import app.listeners.PlusExplosionListener;
import core.Handler;
import components.entities.fixed.bomb.Bomb;
import components.entities.fixed.explosion.Explosion;

public class PlusExplosionEvent implements Event
{
    private Listener listener;

    public PlusExplosionEvent(Handler handler, Explosion explosion, Bomb bomb, int width, int height, int range)
    {
        listener = new PlusExplosionListener(handler, explosion, bomb, width, height, range);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }    
}
