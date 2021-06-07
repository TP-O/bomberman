package factories.title;

import components.tiles.Tile;
import components.tiles.corner.*;
import components.tiles.wall.*;
import components.tiles.vertical.*;
import components.tiles.horizontal.*;
import components.tiles.floor.*;
import components.tiles.water.*;

public class BasicTileFactory implements TileFactory {

    @Override
    public Tile createTile(int id, int x, int y) {
        Tile tile = null;

        switch (id) {
            case 0:
                tile = new Wall(x, y);
                break;

            case 1:
                tile = new UnderwaterWall(x, y);
                break;

            case 2:
                tile = new Flourescent(x, y);
                break;

            case 3:
                tile = new Plus(x, y);
                break;

            case 4:
                tile = new UpperLeft(x, y);
                break;

            case 5:
                tile = new LowerLeft(x, y);
                break;

            case 6:
                tile = new Vertical01(x, y);
                break;

            case 7:
                tile = new Vertical02(x, y);
                break;

            case 8:
                tile = new BottomBoundedVertical(x, y);
                break;

            case 9:
                tile = new TopBoundedVertical(x, y);
                break;

            case 10:
                tile = new Horizontal01(x, y);
                break;

            case 11:
                tile = new Horizontal02(x, y);
                break;

            case 12:
                tile = new RightBoundedHorizontal(x, y);
                break;

            case 13:
                tile = new Floor01(x, y);
                break;

            case 14:
                tile = new Floor02(x, y);
                break;

            case 15:
                tile = new Floor03(x, y);
                break;

            case 16:
                tile = new Water(x, y);
                break;

            case 17:
                tile = new UnderwaterWall(x, y);
                break;

            case 18:
                tile = new Drain(x, y);
                break;

            case 19:
                tile = new VerticalBridge(x, y);
                break;

            case 20:
                tile = new HorizontalBridge(x, y);
                break;

            default:
                tile = null;
        }

        return tile;
    }
}
