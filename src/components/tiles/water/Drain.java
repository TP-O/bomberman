package components.tiles.water;

import asset.Asset;
import components.tiles.Tile;

public class Drain extends Tile {

    public Drain(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(649, 195, 138, 138);
    }
}
