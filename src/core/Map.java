package core;

import java.awt.Graphics;

import app.models.MapModel;
import app.models.Model;
import components.tiles.Tile;
import helper.Helper;
import config.AppConfig;
import config.GameConfig;
import factories.title.BasicTileFactory;
import factories.title.TileFactory;

public class Map {

    private int width;

    private int height;

    private Tile[][] tiles;

    private Handler handler;

    private TileFactory factory;

    public Map(Handler handler) {
        this.handler = handler;

        factory = new BasicTileFactory();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public Tile getTile(int x, int y) {
        return x < 0 || y < 0 || x >= width || y >= height ? tiles[0][0] : tiles[x][y];
    }

    public void tick() {
        //
    }

    public void render(Graphics graphics) {
        int xStart = (int) Math.max(0, handler.getCamera().getXOffset() / Tile.WIDTH);
        int xEnd = (int) Math.min(width, (handler.getCamera().getXOffset() + GameConfig.WIDTH) / Tile.WIDTH + 1);

        int yStart = (int) Math.max(0, handler.getCamera().getYOffset() / Tile.HEIGHT);
        int yEnd = (int) Math.min(height, (handler.getCamera().getYOffset() + GameConfig.HEIGHT) / Tile.HEIGHT + 1);

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                tiles[x][y].render(graphics,
                        // The tiles move rely on camera's coordinates
                        (int) (x * Tile.WIDTH - handler.getCamera().getXOffset()),
                        (int) (y * Tile.HEIGHT - handler.getCamera().getYOffset()));
            }
        }
    }

    public void loadMap(int phase) {
        Model<String> mapModel = new MapModel();

        String mapName = mapModel.wherePhase(phase).get();

        String mapString = Helper.loadFileAsString(AppConfig.MAP_DIR + mapName);

        String[] tokens = mapString.split("\\s+");
        width = Integer.parseInt(tokens[0]);
        height = Integer.parseInt(tokens[1]);

        tiles = new Tile[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int id = Integer.parseInt(tokens[x + y + (width - 1) * y + 2]);

                tiles[x][y] = factory.createTile(id, x, y);
            }
        }
    }
}
