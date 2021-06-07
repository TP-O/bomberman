package components.tiles.wall;

import asset.Asset;
import components.tiles.Tile;

public class UnderwaterWall extends Tile {

    public UnderwaterWall(int x, int y) {
        super(x, y, true);
    }

    @Override
    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(496, 196, 138, 138);
    }
}
