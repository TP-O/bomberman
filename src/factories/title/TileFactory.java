package factories.title;

import components.tiles.*;

public class TileFactory
{
    public Tile createTile(int id)
    {
        Tile tile = null;

        switch (id) {
            case 0:
                tile = new Wall();
                break;

            case 1:
                tile = new WaterWall();
                break;

            case 2:
                tile = new Flourescent();
                break;

            case 3:
                tile = new Water();
                break;

            case 4:
                tile = new Drain();
                break;

            case 5:
                tile = new Floor01();
                break;

            case 6:
                tile = new Floor02();
                break;

            case 7:
                tile = new Floor03();
                break;

            default:
                tile = null;
        }

        return tile;
    }
}
