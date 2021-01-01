package components.tiles;

import asset.Asset;

public class Floor02 extends Tile
{
    @Override
    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(179, 199, 138, 138);
    }
}
