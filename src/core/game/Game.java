package core.game;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import core.asset.Asset;

import app.controller.StateController;

import core.service.camera.*;
import core.service.keyboard.*;
import core.service.ServiceSubcriber;

public class Game implements Runnable
{
    private String title;

    private int width;

    private int height;

    private boolean running = false;

    private Display display;

    private BufferStrategy bs;

    private Graphics graphics;

    private Thread thread;

    // State controller
    private StateController stateController;

    // Subcriber
    private ServiceSubcriber subcriber;

    // Key listener
    private KeyManager keyManager;

    // Cameraman
    private CameraMan camera;

    public Game(String inTitle, int inWidth, int inHeight)
    {
        title = inTitle;
        width = inWidth;
        height = inHeight;

        // Create the window
        display = new Display(title, width, height);
    }

    public synchronized void start()
    {
        if (running) return;
        running = true;

        // Start the game
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if (!running) return;
        running = false;
        
        try {
            // Stop the game
            thread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void init()
    {
        // Initialize image, sound,...
        Asset.init();

        // Display the window
        display.display();

        // Register services
        subcriber = new ServiceSubcriber(this);
        subcriber.register();

        // Camera Service
        camera = subcriber.cameraMan;

        // Key manager Service
        keyManager = subcriber.keyManager;

        // Initialize state controller
        stateController = new StateController(this);
        stateController.setState("GameState");
    }

    public void tick()
    {
        if (stateController.getState() != null) {
            stateController.tick();
        }
        else {
            System.out.println("Can not detect game's state!");
            System.exit(1);
        }
    }

    public void render()
    {
        bs = display.getCanvas().getBufferStrategy();

        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bs.getDrawGraphics();
        
        // Clear screen
        graphics.clearRect(0, 0, width, height);

        // Render image
        if (stateController.getState() != null) {
            stateController.render(graphics);
        }
        else {
            System.out.println("Can not detect game's state!");
            System.exit(1);
        }

        bs.show();
        graphics.dispose();
    }


    // Run the game
    public void run()
    {
        init();

        // Update times per seconds
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        // Update and render every second - 60 times
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            lastTime = now;

            if (delta >= 1) {
                tick();
                delta--;
            }

            try {
                Thread.sleep(2);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            render();
        }
    }

    // Setters and Getters
    public Display getDisplay()
    {
        return display;
    }

    public KeyManager getKeyManager()
    {
        return keyManager;
    }

    public CameraMan getCamera()
    {
        return camera;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }
}
