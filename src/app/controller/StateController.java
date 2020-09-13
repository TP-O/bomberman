package app.controller;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import core.game.Game;
import core.state.*;

public class StateController
{
    private Game game;

    private State currentState;

    private Map<String, State> states;

    public StateController(Game game)
    {
        this.game = game;

        states = new HashMap<String, State>();
        states.put("GameState", new GameState(game));
        states.put("MenuState", new MenuState(game));
        states.put("SettingState", new SettingState(game));
    }

    public void setState(String stateName)
    {
        currentState = states.get(stateName);
    }

    public State getState()
    {
        return currentState;
    }

    public void tick()
    {
        if (currentState != null) {
            currentState.tick();
        }
    }

    public void render(Graphics graphics)
    {
        if (currentState != null) {
            currentState.render(graphics);
        }
    }
}
