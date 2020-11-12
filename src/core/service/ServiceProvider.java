package core.service;

import app.controller.GameController;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;

public class ServiceProvider
{
    private GameController gameController;

    public CameraService cameraService;

    public KeyService keyService;

    public ServiceProvider(GameController gameController)
    {
        this.gameController = gameController;
    }

    public void register()
    {
        keyService = new KeyService();
        cameraService = new CameraService();

        keyService.register(gameController);
        cameraService.register(gameController);
    }
}
