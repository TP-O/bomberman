package components.tiles.horizontal;

import asset.Asset;
import components.tiles.Tile;

public class Horizontal01 extends Tile {

    public Horizontal01(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(963, 193, 138, 137);
    }
}
