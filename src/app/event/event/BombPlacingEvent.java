package app.event.event;

import entity.bomb.Bomb;
import app.event.listener.BombPlacingListener;
import app.event.listener.Listener;

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
