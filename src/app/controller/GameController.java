package app.controller;

import core.game.Game;

public class GameController
{
    private Game game;

    public GameController(String title, int width, int height)
    {
        game = new Game(title, width, height);
    }

    public void launch()
    {
        game.start();
    }
}
