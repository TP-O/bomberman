package core.tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Tile
{
    protected boolean solid;

    protected BufferedImage BImage;

    public static int totalTiles = 0;

    public static final int WIDTH = 64, HEIGHT = 64;

    public Tile(BufferedImage BImage)
    {
        totalTiles++;
        this.solid = false;
        this.BImage = BImage;
    }
    
    public Tile(BufferedImage BImage, boolean solid)
    {
        totalTiles++;
        this.solid = solid;
        this.BImage = BImage;
    }

    public boolean isSolid()
    {
        return solid;
    }

    public void tick()
    {
        //
    }

    public void render(Graphics graphics, int x, int y)
    {
        graphics.drawImage(BImage, x, y, WIDTH, HEIGHT, null);
    }
}
