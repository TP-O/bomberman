package core.game;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import app.controller.MapController;
import app.controller.StateController;

import helper.Helper;
import core.service.ServiceProvider;

public class Game implements Runnable
{
    public int width;

    public int height;

    private boolean running = false;

    public Window window;

    private BufferStrategy bs;

    public Graphics graphics;

    public Thread thread;

    public ServiceProvider provider;

    public MapController mapController;

    public StateController stateController;

    public Game(int width, int height)
    {
        this.width = width;
        this.height = height;
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
        int fps = Helper.config("Game.FPS");
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
