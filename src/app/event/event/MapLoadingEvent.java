package app.event.event;

import app.event.listener.Listener;
import app.event.listener.MapLoadingListener;
import core.main.Handler;

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
