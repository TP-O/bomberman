package components.tiles.corner;

import asset.Asset;
import components.tiles.Tile;

public class UpperLeft extends Tile {

    public UpperLeft(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(963, 350, 138, 137);
    }
}
