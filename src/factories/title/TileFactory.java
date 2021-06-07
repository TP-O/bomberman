package factories.title;

import components.tiles.Tile;

public interface TileFactory {
    public Tile createTile(int id, int x, int y);
}
