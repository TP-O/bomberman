package app.controllers;

import java.util.List;

import app.cache.*;
import app.events.MapLoadingEvent;
import app.models.*;
import app.views.GameView;
import app.views.View;
import components.entities.dynamics.character.monster.Monster;
import components.entities.dynamics.character.player.Player;
import helper.Helper;

public class GameController
{
    public View playSolo()
    {
        // Load data
        PlayerModel playerModel = new PlayerModel();
        MonsterModel monsterModel = new MonsterModel();

        Player player = playerModel
                .wherePhase((int) GameCache.get("phase"))
                .get();
        List<Monster> monsters = monsterModel
                .wherePhase((int) GameCache.get("phase"))
                .all();

        // Save to cache
        EntityCache.push("player", player);
        EntityCache.get("monster").addAll(monsters);

        // Load map
        Helper.event(new MapLoadingEvent((int) GameCache.get("phase")));

        // Init view
        View view = new GameView();

        return view;
    }
}
