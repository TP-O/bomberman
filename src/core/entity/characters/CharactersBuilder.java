package core.entity.characters;

import core.game.Game;

public class CharactersBuilder
{
    private float x = 0, y = 0;

    private int width = 64, height = 64;

    private int health = 100;

    private float speed = 3.0f;

    private Game game;

    private String type;

    public CharactersBuilder(String inType)
    {
        type = inType;
    }

    public CharactersBuilder setX(float inX)
    {
        x = inX;

        return this;
    }

    public CharactersBuilder setY(float inY)
    {
        y = inY;

        return this;
    }

    public CharactersBuilder setWidth(int inWidth)
    {
        width = inWidth;

        return this;
    }

    public CharactersBuilder setHeight(int inHeight)
    {
        height = inHeight;

        return this;
    }

    public CharactersBuilder setHealth(int inHealth)
    {
        health = inHealth;

        return this;
    }

    public CharactersBuilder setSpeed(float inSpeed)
    {
        speed = inSpeed;

        return this;
    }

    public CharactersBuilder setGame(Game inGame)
    {
        game = inGame;

        return this;
    }

    public Characters build()
    {
        if (type == "Player") {
            return new Player(game, x, y, width, height, health, speed);
        }
        
        return null;
    }
}
