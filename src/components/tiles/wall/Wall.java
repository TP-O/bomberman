package components.tiles.wall;

import asset.Asset;
import components.tiles.Tile;

public class Wall extends Tile
{
    public Wall()
    {
        super(true);
    }

    protected void loadTileImage()
    {
        BImage = Asset.get("tile01").crop(22, 47, 138, 138);
    }
}
