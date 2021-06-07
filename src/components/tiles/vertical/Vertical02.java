package components.tiles.vertical;

import asset.Asset;
import components.tiles.Tile;

public class Vertical02 extends Tile {

    public Vertical02(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(179, 506, 138, 137);
    }
}
