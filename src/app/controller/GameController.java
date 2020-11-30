package app.controller;

import app.model.TileModel;
import core.asset.Asset;
import core.main.Game;
import core.main.Window;
import helper.Helper;
import router.RouterRegistration;
import core.service.ServiceProvider;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;
import core.service.mouse.MouseService;

public class GameController
{
    private Game game;

    private String name;

    private RouterRegistration router;

    public GameController(int width, int height)
    {
        name = Helper.config("App.Name");
        game = new Game(width, height);
        router = new RouterRegistration(this);
    }

    public int getWidth()
    {
        return game.width;
    }

    public int getHeight()
    {
        return game.height;
    }

    public Window getWindow()
    {
        return game.window;
    }

    public void setWindow(Window window)
    {
        game.window = window;
    }

    public ServiceProvider getProvider()
    {
        return game.provider;
    }

    public void setProvider(ServiceProvider serviceProvider)
    {
        game.provider = serviceProvider;
    }

    public KeyService getKeyService()
    {
        return game.provider.keyService;
    }

    public MouseService getMouseService()
    {
        return game.provider.mouseService;
    }

    public CameraService getCameraService()
    {
        return game.provider.cameraService;
    }

    public MapController getMap()
    {
        return game.map;
    }

    public void setMap(MapController map)
    {
        game.map = map;
    }

    public void bootstrap()
    {
        // Initialize image, sound,...
        Asset.loadImage();

        // Display the window
        setWindow(new Window(name, getWidth(), getHeight()));
        getWindow().display();

        // Register services
        setProvider(new ServiceProvider(this));
        getProvider().register();

        // Initialize tiles
        TileModel.loadData();

        // Register router
        router.register();
    }

    public void start()
    {
        game.start();
    }

    public void launch()
    {
        bootstrap();
        start();
    }
}
