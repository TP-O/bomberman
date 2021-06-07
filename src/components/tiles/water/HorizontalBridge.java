package components.tiles.water;

import asset.Asset;
import components.tiles.Tile;

public class HorizontalBridge extends Tile {

    public HorizontalBridge(int x, int y) {
        super(x, y);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(496, 495, 144, 118);
    }
}
