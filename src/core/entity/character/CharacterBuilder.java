package core.entity.character;

import app.controller.GameController;
import core.entity.character.player.Kid;
import helper.Helper;

public class CharacterBuilder
{
    private float x, y;

    private int width, height;

    private int health;

    private int damge;

    private float speed;

    private String type = "Kid";

    private GameController gameController;

    public CharacterBuilder()
    {
        this.x = Integer.parseInt(Helper.config("Character.X"));
        this.y = Integer.parseInt(Helper.config("Character.Y"));
        this.width = Integer.parseInt(Helper.config("Character.Width"));
        this.height = Integer.parseInt(Helper.config("Character.Height"));
        this.health = Integer.parseInt(Helper.config("Character.Health"));
        this.damge  = Integer.parseInt(Helper.config("Character.Damage"));
        this.speed = Float.parseFloat(Helper.config("Character.Speed"));
    }

    public CharacterBuilder setType(String type)
    {
        this.type = type;

        return this;
    }

    public CharacterBuilder setX(float x)
    {
        this.x = x;

        return this;
    }

    public CharacterBuilder setY(float y)
    {
        this.y = y;

        return this;
    }

    public CharacterBuilder setWidth(int width)
    {
        this.width = width;

        return this;
    }

    public CharacterBuilder setHeight(int height)
    {
        this.height = height;

        return this;
    }

    public CharacterBuilder setHealth(int health)
    {
        this.health = health;

        return this;
    }

    public CharacterBuilder setDamge(int damge)
    {
        this.damge = damge;

        return this;
    }

    public CharacterBuilder setSpeed(float speed)
    {
        this.speed = speed;

        return this;
    }

    public CharacterBuilder setGame(GameController gameController)
    {
        this.gameController = gameController;

        return this;
    }

    public Character build()
    {
        if (type == "Kid") {
            return new Kid(gameController, x, y, width, height, health, damge, speed);
        }
        else {
            throw new Error("Can not find type: " + type);
        }
    }
}
