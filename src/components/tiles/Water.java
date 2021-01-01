package components.tiles;

import asset.Asset;

public class Water extends Tile
{
    public Water()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(655, 512, 137, 138);
    }
}
