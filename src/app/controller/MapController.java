package app.controller;

import core.main.Map;

public class MapController
{
    private Map map;
    
    public MapController(GameController game)
    {
        map = new Map(game);
        game.setMap(this);
    }

    public int getWidth()
    {
        return map.getWidth();
    }

    public int getHeight()
    {
        return map.getHeight();
    }

    public void load(String mapName)
    {
        map.loadMap(mapName + ".txt");
    }

    public Map getMap()
    {
        return map;
    }
}
