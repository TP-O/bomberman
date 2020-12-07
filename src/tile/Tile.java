package tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Tile
{
    protected boolean solid;

    protected BufferedImage BImage;

    public static final int WIDTH = 64, HEIGHT = 64;

    public Tile()
    {
        solid = false;

        loadTileImage();
    }
    
    public Tile(boolean solid)
    {
        this.solid = solid;

        loadTileImage();
    }

    public boolean isSolid()
    {
        return solid;
    }

    public void render(Graphics graphics, int x, int y)
    {
        graphics.drawImage(BImage, x, y, WIDTH, HEIGHT, null);
    }

    protected abstract void loadTileImage();
}
