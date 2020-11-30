package core.tile;

import core.asset.Asset;

public class TreeTile extends Tile
{
    public TreeTile()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.obstacle.crop(9, 23, 56, 64);
    }
}
