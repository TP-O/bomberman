package app.controller;

import java.util.ArrayList;

import core.tile.*;

public class TileController
{
    public static ArrayList<Tile> tiles;

    public static void init()
    {        
        tiles = new ArrayList<Tile>();

        tiles.add(Tile.totalTiles, new GrassTile());
        tiles.add(Tile.totalTiles, new RockTile());
        tiles.add(Tile.totalTiles, new TreeTile());
        tiles.add(Tile.totalTiles, new MushroomTile());
        tiles.add(Tile.totalTiles, new CherryTile());
        tiles.add(Tile.totalTiles, new MapleTile());
    }
}
