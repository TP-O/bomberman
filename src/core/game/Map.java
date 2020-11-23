package core.game;

import java.awt.Graphics;
import helper.Helper;
import core.tile.Tile;
import app.controller.GameController;
import app.controller.TileController;

public class Map
{
    private int width, height;

    private int[][] tiles;

    private GameController gameController;

    public Map(GameController gameController)
    {
        this.gameController = gameController;
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
        int xStart = (int) Math.max(0, gameController.getCameraService().getXOffset() / Tile.WIDTH);
        int xEnd = (int) Math.min(width, (gameController.getCameraService().getXOffset() + gameController.getWidth()) / Tile.WIDTH + 1);
        int yStart = (int) Math.max(0, gameController.getCameraService().getYOffset() / Tile.HEIGHT);
        int yEnd = (int) Math.min(height, (gameController.getCameraService().getYOffset() + gameController.getHeight()) / Tile.HEIGHT + 1);

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                TileController.tiles.get(tiles[x][y]).render(graphics,
                    // The tiles move rely on camera's coordinates
                    (int) (x*Tile.WIDTH - gameController.getCameraService().getXOffset()),
                    (int) (y*Tile.HEIGHT - gameController.getCameraService().getYOffset()));
            }
        }   
    }

    public void loadMap(String path)
    {
        String mapString = Helper.loadFileAsString(path);
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
            ? TileController.tiles.get(0)
            : TileController.tiles.get(tiles[x][y]);
    }
}
