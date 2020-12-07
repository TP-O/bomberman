package tile;

import asset.Asset;

public class MapleTile extends Tile
{
    public MapleTile()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.obstacle.crop(167, 81, 47, 58);
    }
}
