package app.models;

import java.util.ArrayList;

import components.tiles.*;

public class TileModel
{
    private static ArrayList<Tile> data = new ArrayList<Tile>();

    public static Tile get(int id)
    {
        return data.get(id);
    }

    public static void loadData()
    {
        data.add(0, new GrassTile());
        data.add(1, new RockTile());
        data.add(2, new TreeTile());
        data.add(3, new MushroomTile());
        data.add(4, new CherryTile());
        data.add(5, new MapleTile());
    }
}
