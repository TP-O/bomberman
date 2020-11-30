package core.tile;

import core.asset.Asset;

public class MushroomTile extends Tile
{
    protected void loadTileImage()
    {
        BImage = Asset.obstacle.crop(312, 15, 34, 33);
    }
}
