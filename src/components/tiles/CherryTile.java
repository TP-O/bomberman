package components.tiles;

import asset.Asset;

public class CherryTile extends Tile
{
    public CherryTile()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(306, 119, 49, 58);
    }
}
