package components.tiles;

import asset.Asset;

public class WaterWall extends Tile
{
    public WaterWall()
    {
        super(true);
    }

    @Override
    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(496, 196, 138, 138);
    }
}
