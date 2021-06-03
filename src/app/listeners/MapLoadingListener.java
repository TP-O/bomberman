package app.listeners;

import core.Handler;

public class MapLoadingListener implements Listener {

    private int phase;

    public MapLoadingListener(int phase) {
        this.phase = phase;
    }

    @Override
    public void handle() {
        Handler.getInstance().getMap().loadMap(phase);
    }
}
