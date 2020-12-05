package core.entity.character.builder;

import app.controller.GameController;
import core.entity.character.Character;
import core.entity.character.player.children.*;
import helper.Helper;

public class PlayerBuilder implements CharacterBuilder
{
    private float x;

    private float y;

    private int width;

    private int height;

    private int health;

    private int damage;

    private float speed;

    private String type;

    private GameController game;

    public PlayerBuilder()
    {
        setDefaultValue();
    }

    @Override
    public CharacterBuilder type(String type)
    {
        this.type = type;

        return this;
    }

    @Override
    public CharacterBuilder setX(float x)
    {
        this.x = x;

        return this;
    }

    @Override
    public CharacterBuilder setY(float y)
    {
        this.y = y;

        return this;
    }

    @Override
    public CharacterBuilder setWidth(int width)
    {
        this.width = width >= 0 ? width : 64;

        return null;
    }

    @Override
    public CharacterBuilder setHeight(int height)
    {
        this.height = height >= 0 ? height : 64;
        
        return this;
    }

    @Override
    public CharacterBuilder setHealth(int health)
    {
        this.health = health >= 0 ? health : 100;
        
        return this;
    }

    @Override
    public CharacterBuilder setDamge(int damge)
    {
        this.damage = damge >= 0 ? damge : 1;
        
        return this;
    }

    @Override
    public CharacterBuilder setSpeed(float speed)
    {
        this.speed = speed >= 0 ? speed : 1.0f;
        
        return this;
    }

    @Override
    public CharacterBuilder setGame(GameController game)
    {
        this.game = game;

        return this;
    }

    @Override
    public Character build()
    {
        Character player;

        switch (type) {
            case "Kid":
                player = new Kid(game, x, y, width, height, health, damage, speed);
                break;
        
            case "Monk":
                player = new Monk(game, x, y, width, height, health, damage, speed);
                break;

            case "Shadow":
                player = new Shadow(game, x, y, width, height, health, damage, speed);
                break;

            case "Kirito":
                player = new Kirito(game, x, y, width, height, health, damage, speed);
                break;

            case "Satoshi":
                player = new Satoshi(game, x, y, width, height, health, damage, speed);
                break;

            case "Goku":
                player = new Goku(game, x, y, width, height, health, damage, speed);
                break;

            default:
                throw new Error("Can not find player: " + type);
        }

        setDefaultValue();

        return player;
    }

    private void setDefaultValue()
    {
        x = Helper.config("Player.X");
        y = Helper.config("Player.Y");
        width = Helper.config("Player.Width");
        height = Helper.config("Player.Height");
        health = Helper.config("Player.Health");
        damage = Helper.config("Player.Damage");
        speed = Helper.config("Player.Speed");
    }
}
