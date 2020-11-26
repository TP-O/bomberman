package app.controller;

import core.game.Game;
import core.asset.Asset;
import core.game.Window;
import helper.Helper;
import core.service.ServiceProvider;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;
import core.service.mouse.MouseService;

public class GameController
{
    private Game game;

    private String name;

    public GameController(int width, int height)
    {
        this.name = Helper.config("App.Name");
        this.game = new Game(width, height);
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

    public StateController getStateController()
    {
        return game.stateController;
    }

    public void setStateController(StateController stateController)
    {
        game.stateController = stateController;
    }

    public MapController getMapController()
    {
        return game.mapController;
    }

    public void setMapController(MapController mapController)
    {
        game.mapController = mapController;
    }

    public void bootstrap()
    {
        // Initialize image, sound,...
        Asset.init();

        // Display the window
        setWindow(new Window(name, getWidth(), getHeight()));
        getWindow().display();

        // Register services
        setProvider(new ServiceProvider(this));
        getProvider().register();

        // Initialize tiles
        TileController.init();

        // Initialize state controller
        setStateController(new StateController(this));
        getStateController().changeTo("MenuState");
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
