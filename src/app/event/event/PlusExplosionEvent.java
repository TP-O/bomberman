package app.event.event;

import app.event.listener.Listener;
import app.event.listener.PlusExplosionListener;
import core.main.Handler;
import entity.bomb.Bomb;
import entity.explosion.Explosion;

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
