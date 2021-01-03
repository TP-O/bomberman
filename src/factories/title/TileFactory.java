package factories.title;

import components.tiles.Tile;
import components.tiles.corner.*;
import components.tiles.wall.*;
import components.tiles.vertical.*;
import components.tiles.horizontal.*;
import components.tiles.floor.*;
import components.tiles.water.*;

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
                tile = new UnderwaterWall();
                break;

            case 2:
                tile = new Flourescent();
                break;

            case 3:
                tile = new Plus();
                break;

            case 4:
                tile = new UpperLeft();
                break;

            case 5:
                tile = new LowerLeft();
                break;

            case 6:
                tile = new Vertical01();
                break;

            case 7:
                tile = new Vertical02();
                break;

            case 8:
                tile = new BottomBoundedVertical();
                break;

            case 9:
                tile = new TopBoundedVertical();
                break;

            case 10:
                tile = new Horizontal01();
                break;

            case 11:
                tile = new Horizontal02();
                break;

            case 12:
                tile = new RightBoundedHorizontal();
                break;

            case 13:
                tile = new Floor01();
                break;

            case 14:
                tile = new Floor02();
                break;

            case 15:
                tile = new Floor03();
                break;

            case 16:
                tile = new Water();
                break;

            case 17:
                tile = new UnderwaterWall();
                break;

            case 18:
                tile = new Drain();
                break;

            case 19:
                tile = new VerticalBridge();
                break;

            case 29:
                tile = new HorizontalBridge();
                break;

            default:
                tile = null;
        }

        return tile;
    }
}
