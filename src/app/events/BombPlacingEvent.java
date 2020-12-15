package app.events;

import app.listeners.BombPlacingListener;
import app.listeners.Listener;
import components.entities.fixed.bomb.Bomb;

public class BombPlacingEvent implements Event
{
    private Listener listener;

    public BombPlacingEvent(Bomb bomb, float x, float y)
    {
        listener = new BombPlacingListener(bomb, x, y);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }
}
