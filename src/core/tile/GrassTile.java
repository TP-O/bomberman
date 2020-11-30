package core.tile;

import core.asset.Asset;

public class GrassTile extends Tile
{
    protected void loadTileImage()
    {
        BImage = Asset.obstacle.crop(0, 0, 25, 25);
    }
}
