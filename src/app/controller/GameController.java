package app.controller;

import core.game.Game;
import core.asset.Asset;
import core.game.Window;
import helper.Helper;
import core.service.ServiceProvider;

public class GameController
{
    private Game game;

    private String name;

    public GameController(int width, int height)
    {
        this.name = Helper.config("App.Name");
        this.game = new Game(width, height);
    }

    public Game getGame()
    {
        return game;
    }

    public void bootstrap()
    {
        // Initialize image, sound,...
        Asset.init();

        // Display the window
        game.setWindow(new Window(name, game.getWidth(), game.getHeight()));
        game.getWindow().display();

        // Register services
        game.setProvider(new ServiceProvider(game));
        game.getProvider().register();

        // Initialize state controller
        game.setStateController(new StateController(game));
        game.getStateController().changeTo("GameState");
    }

    public void launch()
    {
        bootstrap();
        game.start();
    }
}
