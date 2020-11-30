package core.service;

import app.controller.GameController;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;
import core.service.mouse.MouseService;

public class ServiceProvider
{
    private GameController game;

    public CameraService cameraService;

    public KeyService keyService;

    public MouseService mouseService;

    public ServiceProvider(GameController game)
    {
        this.game = game;
    }

    public void register()
    {
        keyService = new KeyService();
        cameraService = new CameraService();
        mouseService = new MouseService();

        keyService.register(game);
        cameraService.register(game);
        mouseService.register(game);
    }
}
