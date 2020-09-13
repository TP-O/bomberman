package core.service;

import core.game.Game;
import core.service.camera.*;
import core.service.keyboard.*;

public class ServiceSubcriber
{
    private Game game;

    public CameraMan cameraMan;

    public KeyManager keyManager;

    public ServiceSubcriber(Game game)
    {
        this.game = game;
        register();
    }

    public void register()
    {
        keyManager = new KeyListenerService(game).register().getService();
        cameraMan = new RecordingService(game).register().getService();
    }
}
