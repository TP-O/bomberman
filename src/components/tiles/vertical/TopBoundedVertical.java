package components.tiles.vertical;

import asset.Asset;
import components.tiles.Tile;

public class TopBoundedVertical extends Tile
{
    public TopBoundedVertical()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(650, 350, 138, 137);
    }
}
