package components.tiles.water;

import asset.Asset;
import components.tiles.Tile;

public class VerticalBridge extends Tile {

    public VerticalBridge(int x, int y) {
        super(x, y);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(338, 506, 136, 144);
    }
}
