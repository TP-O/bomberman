package app.controller;

import core.game.Map;

public class MapController
{
    private Map map;
    
    public MapController(GameController gameController)
    {
        this.map = new Map(gameController);
        gameController.setMapController(this);
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
