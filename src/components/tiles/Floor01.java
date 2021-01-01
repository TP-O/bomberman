package components.tiles;

import asset.Asset;

public class Floor01 extends Tile
{
    @Override
    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(23, 197, 138, 138);
    }
}
