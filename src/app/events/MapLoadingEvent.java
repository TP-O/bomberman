package app.events;

import app.listeners.Listener;
import app.listeners.MapLoadingListener;

public class MapLoadingEvent implements Event {

    private Listener listener;

    public MapLoadingEvent(int phase) {
        listener = new MapLoadingListener(phase);
    }

    @Override
    public void emit() {
        listener.handle();
    }
}
