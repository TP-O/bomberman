package app.controllers;

import java.util.List;

import app.cache.*;
import app.events.MapLoadingEvent;
import app.models.*;
import app.views.GameView;
import app.views.View;
import core.Handler;
import components.entities.dynamic.character.monster.Monster;
import components.entities.dynamic.character.player.Player;
import helper.Helper;

public class GameController implements Controller
{
    private Handler handler;

    public static int phase = 1;

    public static String characterType = "Satoshi";

    public GameController(Handler handler)
    {
        this.handler = handler;
    }

    @Override
    public View createView()
    {
        // Load data
        PlayerModel playerModel = new PlayerModel(handler);
        MonsterModel monsterModel = new MonsterModel(handler);

        Player player = playerModel
                .whereType(characterType)
                .wherePhase(phase)
                .get();
        List<Monster> monsters = monsterModel
                .wherePhase(phase)
                .get();

        // Load cache
        BombCache bombCache = new BombCache();
        ExplosionCache explosionCache = new ExplosionCache();
        ItemCache itemCache = new ItemCache();
        MonsterCache monsterCache = new MonsterCache();
        PlayerCache playerCache = new PlayerCache();

        monsterCache.store(monsters);
        playerCache.insert(player);

        // Load map
        Helper.event(new MapLoadingEvent(handler, phase));

        // Init view
        View view = new GameView(handler, player,
                monsters, bombCache.get(), explosionCache.get(), itemCache.get());

        return view;
    }
}
