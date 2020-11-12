package app.controller;

import core.game.Game;
import core.asset.Asset;
import core.game.Window;
import helper.Helper;
import core.service.ServiceProvider;
import core.service.camera.CameraService;
import core.service.keyboard.KeyService;

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
        return game.getWidth();
    }

    public int getHeight()
    {
        return game.getHeight();
    }

    public Window getWindow()
    {
        return game.getWindow();
    }

    public void setWindow(Window window)
    {
        game.setWindow(window);
    }

    public ServiceProvider getProvider()
    {
        return game.getProvider();
    }

    public void setProvider(ServiceProvider serviceProvider)
    {
        game.setProvider(serviceProvider);
    }

    public KeyService getKeyService()
    {
        return game.getKeyService();
    }

    public CameraService getCameraService()
    {
        return game.getCameraService();
    }

    public StateController getStateController()
    {
        return game.getStateController();
    }

    public void setStateController(StateController stateController)
    {
        game.setStateController(stateController);
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

        // Initialize state controller
        setStateController(new StateController(this));
        getStateController().changeTo("GameState");
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
