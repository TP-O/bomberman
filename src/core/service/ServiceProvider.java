package core.service;

import core.game.Game;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;

public class ServiceProvider
{
    private Game game;

    public CameraService cameraService;

    public KeyService keyService;

    public ServiceProvider(Game game)
    {
        this.game = game;
    }

    public void register()
    {
        keyService = new KeyService();
        cameraService = new CameraService();

        keyService.register(game);
        cameraService.register(game);
    }
}
