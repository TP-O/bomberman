package components.tiles;

import asset.Asset;

public class TreeTile extends Tile
{
    public TreeTile()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(9, 23, 56, 64);
    }
}
