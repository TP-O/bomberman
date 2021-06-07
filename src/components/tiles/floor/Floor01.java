package components.tiles.floor;

import asset.Asset;
import components.tiles.Tile;

public class Floor01 extends Tile {

    public Floor01(int x, int y) {
        super(x, y);
    }

    @Override
    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(23, 197, 138, 138);
    }
}
