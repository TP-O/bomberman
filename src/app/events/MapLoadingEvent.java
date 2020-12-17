package app.events;

import app.listeners.Listener;
import app.listeners.MapLoadingListener;
import core.Handler;

public class MapLoadingEvent implements Event
{
    private Listener listener;

    public MapLoadingEvent(Handler handler, int phase)
    {
        listener = new MapLoadingListener(handler, phase);
    }

    @Override
    public void emit()
    {
        listener.handle();
    }    
}
