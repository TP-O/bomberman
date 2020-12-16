package factories.title;

import components.tiles.*;

public class TileFactory
{
    public Tile createTile(int id)
    {
        Tile tile = null;

        switch (id) {
            case 0:
                tile = new GrassTile();
                break;

            case 1:
                tile = new RockTile();
                break;
        
            case 2:
                tile = new TreeTile();
                break;
        
            case 3:
                tile = new MushroomTile();
                break;
        
            case 4:
                tile = new CherryTile();
                break;
        
            case 5:
                tile = new MapleTile();
                break;
        
            default:
                tile = null;
        }

        return tile;
    }
}
