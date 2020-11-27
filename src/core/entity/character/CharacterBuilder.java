package core.entity.character;

import app.controller.GameController;
import core.entity.character.player.*;
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
        this.x = Helper.config("Character.X");
        this.y = Helper.config("Character.Y");
        this.width = Helper.config("Character.Width");
        this.height = Helper.config("Character.Height");
        this.health = Helper.config("Character.Health");
        this.damge  = Helper.config("Character.Damage");
        this.speed = Helper.config("Character.Speed");
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
        else if (type == "Monk") {
            return new Monk(gameController, x, y, width, height, health, damge, speed);
        }
        else if (type == "Shadow") {
            return new Shadow(gameController, x, y, width, height, health, damge, speed);
        } 
        else if (type == "Kirito") {
            return new Kirito(gameController, x, y, width, height, health, damge, speed);
        }
        else if (type == "Goku") {
            return new Goku(gameController, x, y, width, height, health, damge, speed);      
        }
        else if (type == "Satoshi") {
            return new Satoshi(gameController, x, y, width, height, health, damge, speed);     
        }
        else {
            throw new Error("Can not find type: " + type);
        }
    }
}
