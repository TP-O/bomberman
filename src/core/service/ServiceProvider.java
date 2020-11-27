package core.service;

import app.controller.GameController;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;
import core.service.mouse.MouseService;

public class ServiceProvider
{
    private GameController gameController;

    public CameraService cameraService;

    public KeyService keyService;

    public MouseService mouseService;

    public ServiceProvider(GameController gameController)
    {
        this.gameController = gameController;
    }

    public void register()
    {
        keyService = new KeyService();
        cameraService = new CameraService();
        mouseService = new MouseService();

        keyService.register(gameController);
        cameraService.register(gameController);
        mouseService.register(gameController);
    }
}
