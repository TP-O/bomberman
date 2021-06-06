package core;

import javax.swing.JFrame;

import app.cache.GameCache;
import modules.Provider;
import modules.camera.Camera;
import modules.keyboard.Keyboard;
import modules.mouse.Mouse;
import routes.RouterRegistration;

import java.awt.Canvas;

import config.AppConfig;
import config.GameConfig;
import asset.Asset;

public class Handler {

    private Map map;

    private Game game;

    private Provider provider;

    private static Handler instance;

    private Handler() {
        game = new Game();
    }

    public static Handler getInstance() {
        if (instance == null) {
            instance = new Handler();
        }

        return instance;
    }

    public Map getMap() {
        return map;
    }

    public JFrame getFrame() {
        return game.getWindow().getFrame();
    }

    public Canvas getCanvas() {
        return game.getWindow().getCanvas();
    }

    public Keyboard getKeyboard() {
        return (Keyboard) provider.modules.get("keyboard");
    }

    public Mouse getMouse() {
        return (Mouse) provider.modules.get("mouse");
    }

    public Camera getCamera() {
        return (Camera) provider.modules.get("camera");
    }

    public void prepareData() {
        // First data
        GameCache.push("phase", 0);
        GameCache.push("selected-player", "Satoshi");
    }

    public void bootstrap() {
        // Initialize image, sound,...
        Asset.init();

        // Display the window
        game.setWindow(new Window(AppConfig.NAME, GameConfig.WIDTH, GameConfig.HEIGHT));
        game.getWindow().display();

        // Register services
        provider = new Provider(this);
        provider.register();

        // Load map
        map = new Map(this);

        // Set first data
        prepareData();

        // Register router
        RouterRegistration routerRegistration = new RouterRegistration();
        routerRegistration.register();
    }

    public void launch() {
        bootstrap();
        game.start();
    }
}
