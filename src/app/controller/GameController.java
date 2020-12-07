package app.controller;

import java.util.ArrayList;

import app.event.event.MapLoadingEvent;
import app.model.*;
import app.view.GameView;
import app.view.View;
import core.main.Handler;
import entity.character.monster.Monster;
import entity.character.player.Player;
import helper.Helper;

public class GameController extends Controller
{
    public static int phase = 1;

    public static String characterType = "Satoshi";

    public static ArrayList<Monster> currentMonsters;

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

        Player player = playerModel.where(phase, characterType).get();
        ArrayList<Monster> monsters = monsterModel.where(phase).get();
        currentMonsters = monsters;

        // Load map
        Helper.event(new MapLoadingEvent(handler, phase));

        // Init view
        View view = new GameView(handler, player,
                monsters, BombModel.all(), ExplosionModel.all());

        return view;
    }
}
