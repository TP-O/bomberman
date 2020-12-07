package core.main;

import javax.swing.JFrame;

import app.model.TileModel;
import app.plugin.PluginProvider;
import app.plugin.camera.Camera;
import app.plugin.keyboard.KeyBoard;
import app.plugin.mouse.Mouse;

import java.awt.Canvas;

import config.AppConfig;
import config.GameConfig;
import asset.Asset;
import router.RouterRegistration;

public class Handler
{
    private Game game;

    public Map getMap()
    {
        return game.map;
    }

    public JFrame getFrame()
    {
        return game.window.getFrame();
    }

    public Canvas getCanvas()
    {
        return game.window.getCanvas();
    }

    public KeyBoard getKeyBoard()
    {
        return game.provider.keyBoard;
    }

    public Mouse getMouse()
    {
        return game.provider.mouse;
    }

    public Camera getCamera()
    {
        return game.provider.camera;
    }

    public Handler()
    {
        game = new Game();
    }

    public void bootstrap()
    {
        // Initialize image, sound,...
        Asset.loadImage();

        // Display the window
        game.window = new Window(AppConfig.NAME, GameConfig.WIDTH, GameConfig.HEIGHT);
        game.window.display();

        // Register services
        game.provider = new PluginProvider(this);
        game.provider.plug();

        // Load data
        TileModel.loadData();

        // Load map
        game.map = new Map(this);

        // Register router
        game.router = new RouterRegistration(this);
        game.router.register();
    }

    public void launch()
    {
        bootstrap();
        game.start();
    }
}
