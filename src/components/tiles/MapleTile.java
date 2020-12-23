package components.tiles;

import asset.Asset;

public class MapleTile extends Tile
{
    public MapleTile()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(167, 81, 47, 58);
    }
}
