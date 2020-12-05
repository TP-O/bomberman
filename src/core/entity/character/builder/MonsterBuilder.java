package core.entity.character.builder;

import app.controller.GameController;
import core.entity.character.Character;
import core.entity.character.monster.children.*;
import helper.Helper;

public class MonsterBuilder implements CharacterBuilder
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

    public MonsterBuilder()
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
        Character monster;

        switch (type) {
            case "AlolanPersian":
                monster = new AlolanPersian(game, x, y, width, height, health, damage, speed);
                break;
        
            case "ShinyZygarde":
                monster = new ShinyEmboar(game, x, y, width, height, health, damage, speed);
                break;

            case "Scorbunny":
                monster = new Scorbunny(game, x, y, width, height, health, damage, speed);
                break;

            case "Bulbasaur":
                monster = new Bulbasaur(game, x, y, width, height, health, damage, speed);
                break;

            case "Emboar":
                monster = new Emboar(game, x, y, width, height, health, damage, speed);
                break;

            case "ShinyEmboar":
                monster = new ShinyEmboar(game, x, y, width, height, health, damage, speed);
                break;

            default:
                throw new Error("Can not find monster: " + type);
        }

        setDefaultValue();

        return monster;
    }

    private void setDefaultValue()
    {
        x = Helper.config("Monster.X");
        y = Helper.config("Monster.Y");
        width = Helper.config("Monster.Width");
        height = Helper.config("Monster.Height");
        health = Helper.config("Monster.Health");
        damage = Helper.config("Monster.Damage");
        speed = Helper.config("Monster.Speed");
    }
}
