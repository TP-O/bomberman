package components.tiles;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Tile {

    protected int x;

    protected int y;

    protected boolean solid;

    protected BufferedImage BImage;

    public static final int WIDTH = 64, HEIGHT = 64;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.solid = false;

        loadTileImage();
    }

    public Tile(int x, int y, boolean solid) {
        this.x = x;
        this.y = y;
        this.solid = solid;

        loadTileImage();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSolid() {
        return solid;
    }

    public void render(Graphics graphics, int x, int y) {
        graphics.drawImage(BImage, x, y, WIDTH, HEIGHT, null);
    }

    protected abstract void loadTileImage();
}
