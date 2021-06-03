package components.tiles.wall;

import asset.Asset;
import components.tiles.Tile;

public class Flourescent extends Tile {

    public Flourescent(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(336, 47, 138, 138);
    }
}
