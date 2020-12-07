package core.main;

import java.awt.Graphics;
import tile.Tile;
import helper.Helper;
import app.model.MapModel;
import app.model.TileModel;
import config.AppConfig;
import config.GameConfig;

public class Map
{
    private int width, height;

    private int[][] tiles;

    private Handler handler;

    public Map(Handler handler)
    {
        this.handler = handler;
    }    

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void tick()
    {
        //
    }

    public void render(Graphics graphics)
    {
        int xStart = (int) Math.max(0, handler.getCamera().getXOffset() / Tile.WIDTH);
        int xEnd = (int) Math.min(width,
                (handler.getCamera().getXOffset() + GameConfig.WIDTH) / Tile.WIDTH + 1);

        int yStart = (int) Math.max(0, handler.getCamera().getYOffset() / Tile.HEIGHT);
        int yEnd = (int) Math.min(height,
                (handler.getCamera().getYOffset() + GameConfig.HEIGHT) / Tile.HEIGHT + 1);

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                TileModel.get(tiles[x][y]).render(graphics,
                    // The tiles move rely on camera's coordinates
                    (int) (x*Tile.WIDTH - handler.getCamera().getXOffset()),
                    (int) (y*Tile.HEIGHT - handler.getCamera().getYOffset()));
            }
        }
    }

    public void loadMap(int phase)
    {
        MapModel mapModel = new MapModel();

        String mapName = mapModel.where(phase).get();
        
        String mapString = Helper.loadFileAsString(AppConfig.MAP_DIR + mapName);

        String[] tokens = mapString.split("\\s+");

        width = Integer.parseInt(tokens[0]);
        height = Integer.parseInt(tokens[1]);
        tiles = new int[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Integer.parseInt(tokens[x + y + (width - 1)*y + 2]);
            }
        }   
    }

    public Tile getTiles(int x, int y)
    {
        return x < 0 || y < 0 || x >= width || y >= height
            ? TileModel.get(0)
            : TileModel.get(tiles[x][y]);
    }
}
