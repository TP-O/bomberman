package core;

import java.awt.image.BufferStrategy;

import java.awt.Graphics;

import config.AppConfig;
import config.GameConfig;

public class Game implements Runnable {

    public final String NAME;

    public final int WIDTH;

    public final int HEIGHT;

    private boolean running;

    private Window window;

    private Thread thread;

    private Router router;

    private Graphics graphics;

    private BufferStrategy bs;

    public Game() {
        NAME = AppConfig.NAME;
        WIDTH = GameConfig.WIDTH;
        HEIGHT = GameConfig.HEIGHT;

        router = Router.getInstance();
    }

    public Window getWindow() {
        return window;
    }

    public void setWindow(Window window) {
        this.window = window;
    }

    public synchronized void start() {
        if (running) {
            return;
        } else {
            running = true;
        }

        // Start the game
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        } else {
            running = false;
        }

        try {
            // Stop the game
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tick() {
        router.tick();
    }

    public void render() {
        bs = window.getCanvas().getBufferStrategy();

        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }

        graphics = bs.getDrawGraphics();

        // Clear screen
        graphics.clearRect(0, 0, WIDTH, HEIGHT);

        // Render image
        router.render(graphics);

        bs.show();
        graphics.dispose();
    }

    // Run the game
    public void run() {
        // Update times per seconds
        int fps = GameConfig.FPS;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        // Update and render every second - 60 times
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            lastTime = now;

            if (delta >= 1) {
                tick();
                delta--;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            render();
        }
    }
}
