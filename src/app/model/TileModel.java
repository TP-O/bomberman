package app.model;

import java.util.ArrayList;

import core.tile.*;

public class TileModel
{
    private static ArrayList<Tile> data = new ArrayList<Tile>();

    public static Tile get(int id)
    {
        return data.get(id);
    }

    public static void add(int id, Tile tile)
    {
        data.add(id, tile);
    }

    public static void loadData()
    {
        add(0, new GrassTile());
        add(1, new RockTile());
        add(2, new TreeTile());
        add(3, new MushroomTile());
        add(4, new CherryTile());
        add(5, new MapleTile());
    }
}
