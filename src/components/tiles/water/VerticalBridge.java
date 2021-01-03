package components.tiles.water;

import asset.Asset;
import components.tiles.Tile;

public class VerticalBridge extends Tile
{
    public VerticalBridge()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(338, 506, 136, 144);
    }
}
