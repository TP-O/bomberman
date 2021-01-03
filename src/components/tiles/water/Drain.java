package components.tiles.water;

import asset.Asset;
import components.tiles.Tile;

public class Drain extends Tile
{
    public Drain()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(649, 195, 138, 138);
    }
}
