package core.game;

import java.awt.Graphics;
import helper.Helper;
import core.tile.Tile;

public class Map
{
    private int width, height;

    private int[][] tiles;

    private Game game;

    public Map(Game game)
    {
        this.game = game;
    }    

    public void tick()
    {
        //
    }

    public void render(Graphics graphics)
    {
        int xStart = (int) Math.max(0, game.getCameraService().getXOffset() / Tile.WIDTH);
        int xEnd = (int) Math.min(width, (game.getCameraService().getXOffset() + game.getWidth()) / Tile.WIDTH + 1);
        int yStart = (int) Math.max(0, game.getCameraService().getYOffset() / Tile.HEIGHT);
        int yEnd = (int) Math.min(height, (game.getCameraService().getYOffset() + game.getHeight()) / Tile.HEIGHT + 1);

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                Tile.tiles[tiles[x][y]].render(graphics,
                    // The tiles move rely on camera's coordinates
                    (int) (x*Tile.WIDTH - game.getCameraService().getXOffset()),
                    (int) (y*Tile.HEIGHT - game.getCameraService().getYOffset()));
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
}
