package components.tiles;

import asset.Asset;

public class RockTile extends Tile
{
    public RockTile()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.obstacle.crop(153, 31, 38, 38);
    }
}
