package app.controller;

import core.game.Map;
import core.game.Game;

public class MapController
{
    private Map map;
    
    public MapController(Game game)
    {
        this.map = new Map(game);
    }

    public void load(String mapName)
    {
        map.loadMap("/maps/" + mapName + ".txt");
    }

    public Map getMap()
    {
        return map;
    }
}
