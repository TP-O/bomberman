package core.tile;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public abstract class Tile
{
    protected int id;

    protected BufferedImage BImage;

    public boolean solid;

    public static Tile[] tiles = new Tile[255];

    public static final int WIDTH = 64, HEIGHT = 64;

    // Init tiles
    private static Tile grassTile = new GrassTile(0);
    private static Tile rockTile = new RockTile(1);
    private static Tile treeTile = new TreeTile(2);

    public Tile(BufferedImage inBImage, int id)
    {
        BImage = inBImage;
        solid = false;
        tiles[id] = this;
    }
    
    public Tile(BufferedImage inBImage, int id, boolean isSolid)
    {
        BImage = inBImage;
        solid = isSolid;
        tiles[id] = this;
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
