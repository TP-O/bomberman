package app.event.listener;

import core.main.Handler;

public class MapLoadingListener implements Listener
{
    private Handler handler;

    private int phase;

    public MapLoadingListener(Handler handler, int phase)
    {
        this.handler = handler;
        this.phase = phase;
    }

    @Override
    public void handle()
    {
        handler.getMap().loadMap(phase);
    }    
}
