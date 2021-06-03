package components.tiles.water;

import asset.Asset;
import components.tiles.Tile;

public class Water extends Tile {

    public Water(int x, int y) {
        super(x, y, true);
    }

    protected void loadTileImage() {
        BImage = Asset.get("tile01").crop(655, 512, 137, 138);
    }
}
