package app.controllers;

import java.util.List;

import app.cache.*;
import app.events.MapLoadingEvent;
import app.models.*;
import app.views.GameView;
import app.views.View;
import components.entities.dynamics.characters.monster.Monster;
import components.entities.dynamics.characters.player.Player;
import components.entities.statics.blocks.Block;
import components.entities.statics.obstacles.Obstacle;
import components.entities.statics.traps.Trap;
import helper.Helper;

public class GameController {

    public View playSolo() {
        // Init view
        View view = new GameView();
        view.reset();

        // Load data
        PlayerModel playerModel = new PlayerModel();
        MonsterModel monsterModel = new MonsterModel();
        ObstacleModel obstacleModel = new ObstacleModel();
        TrapModel trapModel = new TrapModel();
        BlockModel blockModel = new BlockModel();

        Player player = playerModel
                .wherePhase((int) GameCache.get("phase"))
                .get();
        EntityCache.push("player", player);

        List<Monster> monsters = monsterModel
                .wherePhase((int) GameCache.get("phase"))
                .all();
        List<Obstacle> obstacles = obstacleModel
                .wherePhase((int) GameCache.get("phase"))
                .all();
        List<Trap> traps = trapModel
                .wherePhase((int) GameCache.get("phase"))
                .all();
        List<Block> blocks = blockModel
                .wherePhase((int) GameCache.get("phase"))
                .all();

        // Save to cache
        EntityCache.push("player", player);
        EntityCache.get("monster").addAll(monsters);
        EntityCache.get("obstacle").addAll(obstacles);
        EntityCache.get("trap").addAll(traps);
        EntityCache.get("block").addAll(blocks);

        // Load map
        Helper.event(new MapLoadingEvent((int) GameCache.get("phase")));

        return view;
    }
}
