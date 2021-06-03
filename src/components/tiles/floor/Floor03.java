package components.tiles.floor;

import asset.Asset;
import components.tiles.Tile;

public class Floor03 extends Tile {

    public Floor03(int x, int y) {
        super(x, y);
    }

    @Override
    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(336, 197, 138, 138);
    }
}
