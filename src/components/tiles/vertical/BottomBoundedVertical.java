package components.tiles.vertical;

import asset.Asset;
import components.tiles.Tile;

public class BottomBoundedVertical extends Tile {

    public BottomBoundedVertical(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(496, 351, 138, 137);
    }
}
