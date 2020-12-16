package core;

import javax.swing.JFrame;

import modules.Provider;
import modules.camera.Camera;
import modules.keyboard.Keyboard;
import modules.mouse.Mouse;

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

    public Keyboard getKeyboard()
    {
        return (Keyboard) game.provider.modules.get("keyboard");
    }

    public Mouse getMouse()
    {
        return (Mouse) game.provider.modules.get("mouse");
    }

    public Camera getCamera()
    {
        return (Camera) game.provider.modules.get("camera");
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
        game.provider = new Provider(this);
        game.provider.register();

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
