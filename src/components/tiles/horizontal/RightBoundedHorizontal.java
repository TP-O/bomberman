package components.tiles.horizontal;

import asset.Asset;
import components.tiles.Tile;

public class RightBoundedHorizontal extends Tile
{
    public RightBoundedHorizontal()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(179, 354, 138, 137);
    }
}
