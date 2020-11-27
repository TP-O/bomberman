package app.controller;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import core.state.*;

public class StateController
{
    private GameController gameController;

    private State currentState;

    private Map<String, State> states;

    public StateController(GameController gameController)
    {
        this.gameController = gameController;
        this.bindAllState();
        this.currentState = states.get("GameState");
    }

    private void bindAllState()
    {
        states = new HashMap<String, State>();
        states.put("GameState", new GameState(gameController, new CharacterController()));
        states.put("MenuState", new MenuState(gameController));
        states.put("CharacterState", new CharacterState(gameController));
    }

    public void changeTo(String stateName)
    {
        currentState = states.get(stateName);
    }

    public State getState()
    {
        return currentState;
    }

    public void tick()
    {
        if (currentState == null) {
            throw new Error("Can not detect state");
        }
        currentState.tick();
    }

    public void render(Graphics graphics)
    {
        if (currentState == null) {
            throw new Error("Can not detect state");
        }
        currentState.render(graphics);
    }
}
