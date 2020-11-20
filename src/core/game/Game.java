package core.game;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import app.controller.MapController;
import app.controller.StateController;

import core.service.camera.CameraService;
import core.service.keyboard.KeyService;
import core.service.ServiceProvider;

public class Game implements Runnable
{
    private int width;

    private int height;

    private boolean running = false;

    private Window window;

    private BufferStrategy bs;

    private Graphics graphics;

    private Thread thread;

    // State controller
    private StateController stateController;

    // Provider
    private ServiceProvider provider;

    private MapController mapController;

    public Game(int inWidth, int inHeight)
    {
        width = inWidth;
        height = inHeight;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public Window getWindow()
    {
        return window;
    }

    public void setWindow(Window window)
    {
        this.window = window;
    }

    public ServiceProvider getProvider()
    {
        return provider;
    }

    public void setProvider(ServiceProvider serviceProvider)
    {
        this.provider = serviceProvider;
    }

    public KeyService getKeyService()
    {
        return provider.keyService;
    }

    public CameraService getCameraService()
    {
        return provider.cameraService;
    }

    public StateController getStateController()
    {
        return stateController;
    }

    public void setStateController(StateController stateController)
    {
        this.stateController = stateController;
    }

    public MapController getMapController()
    {
        return mapController;
    }

    public void setMapController(MapController mapController)
    {
        this.mapController = mapController;
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

    public void tick()
    {
        stateController.tick();
    }

    public void render()
    {
        bs = window.getCanvas().getBufferStrategy();

        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bs.getDrawGraphics();
        
        // Clear screen
        graphics.clearRect(0, 0, width, height);

        // Render image
        stateController.render(graphics);

        bs.show();
        graphics.dispose();
    }


    // Run the game
    public void run()
    {
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
}
