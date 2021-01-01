package components.tiles;

import asset.Asset;

public class Floor03 extends Tile
{
    @Override
    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(336, 197, 138, 138);
    }
}
