package components.tiles.horizontal;

import asset.Asset;
import components.tiles.Tile;

public class Horizontal02 extends Tile {

    public Horizontal02(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(24, 354, 138, 137);
    }
}
