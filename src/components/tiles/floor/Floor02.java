package components.tiles.floor;

import asset.Asset;
import components.tiles.Tile;

public class Floor02 extends Tile {

    public Floor02(int x, int y) {
        super(x, y);
    }

    @Override
    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(179, 199, 138, 138);
    }
}
