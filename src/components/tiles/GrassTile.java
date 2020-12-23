package components.tiles;

import asset.Asset;

public class GrassTile extends Tile
{
    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(0, 0, 25, 25);
    }
}
