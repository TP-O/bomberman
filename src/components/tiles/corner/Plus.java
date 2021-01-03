package components.tiles.corner;

import asset.Asset;
import components.tiles.Tile;

public class Plus extends Tile
{
    public Plus()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(804, 351, 138, 137);
    }
}
