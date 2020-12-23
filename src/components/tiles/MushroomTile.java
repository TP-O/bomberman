package components.tiles;

import asset.Asset;

public class MushroomTile extends Tile
{
    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(312, 15, 34, 33);
    }
}
